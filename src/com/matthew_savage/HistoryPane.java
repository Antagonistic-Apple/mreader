package com.matthew_savage;

import java.sql.ResultSet;
import java.util.ArrayList;

public class HistoryPane {

    private static Database database = new Database();

    static ArrayList<MangaArrayList> retrieveStoredHistory() {
        return readFromDatabase();
    }

    private static ArrayList<MangaArrayList> resultSetToArray(ResultSet resultSet) throws Exception{
        ArrayList<MangaArrayList> historyList = new ArrayList<>();

        while (resultSet.next()) {
            historyList.add(new MangaArrayList(resultSet.getInt("entry_number"), resultSet.getInt("title_id"), resultSet.getString("title"), resultSet.getString("summary")));
        } return historyList;
    }

    private static void addTitleToHisotry() {

    }

    private static void checkIfExists() {

    }

    private static ArrayList<MangaArrayList> readFromDatabase() {
        database.openDb("main.db");
        try {
            return resultSetToArray(database.retrieveHistoryEntries());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            database.closeDb();
        } return null;
    }

    private static int fetchLastEntryNumber(ResultSet resultSet) throws Exception {
        resultSet.last();
        return resultSet.getInt("entry_number");
    }

    private void writeToDatabase(int entryNumber, int mangaId, String title, String summary) {
        database.openDb("main.db");
        database.storeHistoryEntries(entryNumber, mangaId, title, summary);
        database.closeDb();
    }

}