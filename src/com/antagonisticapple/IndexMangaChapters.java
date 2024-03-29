package com.antagonisticapple;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.ArrayList;

class IndexMangaChapters {

    static ArrayList<String> getChapterAddresses(String webAddress) throws Exception{
        ArrayList<String> linksList = new ArrayList<>();

        Document mangaChapters = Jsoup.connect(webAddress).get();

        for (Element list : mangaChapters.select(".chapter-list .row")) {
            linksList.add(list.select("span a").first().attr("abs:href"));
        }return linksList;
    }
}