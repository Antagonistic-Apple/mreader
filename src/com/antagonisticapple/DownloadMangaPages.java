package com.antagonisticapple;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

class DownloadMangaPages {

    DownloadMangaPages(ControllerMain controller) {
        this.controllerMain = controller;
    }

    private ControllerMain controllerMain;
    private Database database = new Database();


    void getChapterPages(int startingChapterNumber, String webAddress, int mangaId, boolean firstDownload) throws Exception{
        System.out.println("Methd getchapterpages has been called, mangaid is " + mangaId + " and startingchapnum is " + startingChapterNumber);
        int originalStartingChapter = startingChapterNumber;
        ArrayList<String> chapterLinks = IndexMangaChapters.getChapterAddresses(webAddress);
        int totalChapters = chapterLinks.size();
        System.out.println("chapterlinks size is " + totalChapters);
        updateTotalChapters(mangaId, totalChapters);
        int loopCount = totalChapters - startingChapterNumber;
        System.out.println("current loopcount is " + loopCount);


        if (checkSiteHtml(chapterLinks)) {
            ControllerMain.downloadThread.shutdown();
            controllerMain.errorShow();
        } else {
            System.out.println("else block running, first step in download");
            processChapterList(loopCount, chapterLinks, mangaId, startingChapterNumber, originalStartingChapter, firstDownload);
        }
    }

    private void updateTotalChapters(int mangaId, int totalChapters) {
        database.openDb(Values.DB_NAME_DOWNLOADING.getValue());
        database.modifyManga("downloading", mangaId,"total_chapters", totalChapters);
        database.closeDb();
    }

    private void updateLastChapDownloaded(int mangaId, int startingChapter) {
        database.openDb(Values.DB_NAME_DOWNLOADING.getValue());
        database.modifyManga("downloading", mangaId,"last_chapter_downloaded",startingChapter);
        database.closeDb();
    }

    private void insertIntoReading(int mangaId, boolean copy, boolean deleteSource, boolean repairManga, boolean deleteDest) {
        database.openDb(Values.DB_NAME_DOWNLOADING.getValue());
        database.openDb(Values.DB_NAME_MANGA.getValue());
        database.downloadDbAttach();

        if (repairManga) {
            database.modifyManga(Values.DB_ATTACHED_DOWNLOADING.getValue(), mangaId, "current_page", 0);
        }
        if (deleteDest){
            database.deleteManga(Values.DB_ATTACHED_READING.getValue(), mangaId);
        }
        if (copy) {
            database.moveManga(Values.DB_ATTACHED_DOWNLOADING.getValue(), Values.DB_ATTACHED_READING.getValue(), mangaId);
        }
        if (deleteSource){
            database.deleteManga(Values.DB_ATTACHED_DOWNLOADING.getValue(), mangaId);
        }
        database.downloadDbDetach();
        database.closeDb();
        database.closeDb();
    }

    private void processChapterList(int loopCount, ArrayList<String> chapterList, int mangaId, int startingChapterNumber, int originalStartingChapter, boolean firstDownload) throws Exception{
        System.out.println("proccesschapterlist method is now running, chapterlist has " + chapterList.size() + " items and loopcount is " + loopCount);
        int image = 0;

        while (loopCount > 0) {
            fetchChapterPages(chapterList.get(loopCount - 1), mangaId, startingChapterNumber, image);
            startingChapterNumber++;
            image = 0;
            loopCount--;
            updateLastChapDownloaded(mangaId, startingChapterNumber);

            if (startingChapterNumber == (originalStartingChapter + 1) && firstDownload) {
                System.out.println("insert into reading is happening!");
                insertIntoReading(mangaId, true, false, false, false);
            }
        }
        downloadCompleted(firstDownload, mangaId);
    }

    private void downloadCompleted(boolean firstDownload, int mangaId) {
        System.out.println("download complete");
        if (firstDownload) {
            System.out.println("if block has been executed!!");
            insertIntoReading(mangaId, true, true, false, true);
        } else {
            System.out.println("elseif block has been executed");
            insertIntoReading(mangaId, true, true, true, false);
        }
    }

    private boolean checkSiteHtml(ArrayList<String> chapterList) throws Exception {

        Document chapterOne = Jsoup.connect(chapterList.get(0)).get();
        return chapterOne.select(".vung-doc img").first() == null;
    }

    private void fetchChapterPages(String chapterUrl, int mangaId, int startingChapterNumber, int image) throws Exception {
        System.out.println("method fetchchapterpages is now downloading " + chapterUrl);
        Connection.Response response = Jsoup.connect("https://manganelo.com/change_content_s" + fetchVerificationUrl(chapterUrl)).method(Connection.Method.GET).execute();

        Document chapter = Jsoup.connect(chapterUrl).cookies(response.cookies()).get();
        for (Element pageUrl : chapter.select(".vung-doc img")) {
            createMangaFolder(mangaId, startingChapterNumber);
            saveImage(pageUrl, mangaId, startingChapterNumber, image);
            image++;
        }
    }

    private int fetchVerificationUrl(String chapterUrl) throws Exception{

        Document imageUrl = Jsoup.connect(chapterUrl).get();
        return verifyImageServer(imageUrl.select(".vung-doc img").first().attr("abs:src"));
    }

    private int verifyImageServer(String imageUrl) throws Exception{
        int serverNumber;

        HttpURLConnection testConnection = (HttpURLConnection) (new URL(imageUrl).openConnection());
        testConnection.setRequestMethod("HEAD");
        testConnection.connect();

        if (testConnection.getResponseCode() == 200) {
            serverNumber = 1;
        } else {
            serverNumber = 2;
        }
        return serverNumber;
    }

    private void createMangaFolder(int mangaId, int startingChapterNumber) throws Exception{
        Path to = Paths.get(Values.DIR_ROOT.getValue() + File.separator + Values.DIR_MANGA.getValue() + File.separator + mangaId + File.separator + startingChapterNumber);
        Files.createDirectories(to);
    }

    private void saveImage(Element pageUrl, int mangaId, int startingChapterNumber, int image)throws Exception{
        InputStream imageUrl = new URL(pageUrl.select("img").first().attr("abs:src")).openStream();
        Files.copy(imageUrl, Paths.get(Values.DIR_ROOT.getValue() + File.separator + Values.DIR_MANGA.getValue() + File.separator + mangaId + File.separator + startingChapterNumber + File.separator + String.format("%03d", image) + ".png"), StandardCopyOption.REPLACE_EXISTING);
    }
}