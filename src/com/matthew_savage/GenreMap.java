package com.matthew_savage;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class GenreMap {

    private static Map<String, String> genreMap = new HashMap<>();

    public static Map<String, String> getGenreMap() {
        return genreMap;
    }

    public static void createGenreString() {
        genreMap.put("genre0.include","instr(genre_tags, 'Action') > 0");
        genreMap.put("genre0.exclude","instr(genre_tags, 'Action') = 0");
        genreMap.put("genre1.include","instr(genre_tags, 'Adult') > 0");
        genreMap.put("genre1.exclude","instr(genre_tags, 'Adult') = 0");
        genreMap.put("genre2.include","instr(genre_tags, 'Adventure') > 0");
        genreMap.put("genre2.exclude","instr(genre_tags, 'Adventure') = 0");
        genreMap.put("genre3.include","instr(genre_tags, 'Comedy') > 0");
        genreMap.put("genre3.exclude","instr(genre_tags, 'Comedy') = 0");
        genreMap.put("genre4.include","instr(genre_tags, 'Cooking') > 0");
        genreMap.put("genre4.exclude","instr(genre_tags, 'Cooking') = 0");
        genreMap.put("genre5.include","instr(genre_tags, 'Doujinshi') > 0");
        genreMap.put("genre5.exclude","instr(genre_tags, 'Doujinshi') = 0");
        genreMap.put("genre6.include","instr(genre_tags, 'Drama') > 0");
        genreMap.put("genre6.exclude","instr(genre_tags, 'Drama') = 0");
        genreMap.put("genre7.include","instr(genre_tags, 'Ecchi') > 0");
        genreMap.put("genre7.exclude","instr(genre_tags, 'Ecchi') = 0");
        genreMap.put("genre8.include","instr(genre_tags, 'Fantasy') > 0");
        genreMap.put("genre8.exclude","instr(genre_tags, 'Fantasy') = 0");
        genreMap.put("genre9.include","instr(genre_tags, 'Gender bender') > 0");
        genreMap.put("genre9.exclude","instr(genre_tags, 'Gender bender') = 0");
        genreMap.put("genre10.include","instr(genre_tags, 'Harem') > 0");
        genreMap.put("genre10.exclude","instr(genre_tags, 'Harem') = 0");
        genreMap.put("genre11.include","instr(genre_tags, 'Historical') > 0");
        genreMap.put("genre11.exclude","instr(genre_tags, 'Historical') = 0");
        genreMap.put("genre12.include","instr(genre_tags, 'Horror') > 0");
        genreMap.put("genre12.exclude","instr(genre_tags, 'Horror') = 0");
        genreMap.put("genre13.include","instr(genre_tags, 'Josei') > 0");
        genreMap.put("genre13.exclude","instr(genre_tags, 'Josei') = 0");
        genreMap.put("genre14.include","instr(genre_tags, 'Manhua') > 0");
        genreMap.put("genre14.exclude","instr(genre_tags, 'Manhua') = 0");
        genreMap.put("genre15.include","instr(genre_tags, 'Manhwa') > 0");
        genreMap.put("genre15.exclude","instr(genre_tags, 'Manhwa') = 0");
        genreMap.put("genre16.include","instr(genre_tags, 'Martial arts') > 0");
        genreMap.put("genre16.exclude","instr(genre_tags, 'Martial arts') = 0");
        genreMap.put("genre17.include","instr(genre_tags, 'Mature') > 0");
        genreMap.put("genre17.exclude","instr(genre_tags, 'Mature') = 0");
        genreMap.put("genre18.include","instr(genre_tags, 'Mecha') > 0");
        genreMap.put("genre18.exclude","instr(genre_tags, 'Mecha') = 0");
        genreMap.put("genre19.include","instr(genre_tags, 'Medical') > 0");
        genreMap.put("genre19.exclude","instr(genre_tags, 'Medical') = 0");
        genreMap.put("genre20.include","instr(genre_tags, 'Mystery') > 0");
        genreMap.put("genre20.exclude","instr(genre_tags, 'Mystery') = 0");
        genreMap.put("genre21.include","instr(genre_tags, 'One shot') > 0");
        genreMap.put("genre21.exclude","instr(genre_tags, 'One shot') = 0");
        genreMap.put("genre22.include","instr(genre_tags, 'Psychological') > 0");
        genreMap.put("genre22.exclude","instr(genre_tags, 'Psychological') = 0");
        genreMap.put("genre23.include","instr(genre_tags, 'Romance') > 0");
        genreMap.put("genre23.exclude","instr(genre_tags, 'Romance') = 0");
        genreMap.put("genre24.include","instr(genre_tags, 'School life') > 0");
        genreMap.put("genre24.exclude","instr(genre_tags, 'School life') = 0");
        genreMap.put("genre25.include","instr(genre_tags, 'Sci fi') > 0");
        genreMap.put("genre25.exclude","instr(genre_tags, 'Sci fi') = 0");
        genreMap.put("genre26.include","instr(genre_tags, 'Seinen') > 0");
        genreMap.put("genre26.exclude","instr(genre_tags, 'Seinen') = 0");
        genreMap.put("genre27.include","instr(genre_tags, 'Shoujo') > 0");
        genreMap.put("genre27.exclude","instr(genre_tags, 'Shoujo') = 0");
        genreMap.put("genre28.include","instr(genre_tags, 'Shoujo ai') > 0");
        genreMap.put("genre28.exclude","instr(genre_tags, 'Shoujo ai') = 0");
        genreMap.put("genre29.include","instr(genre_tags, 'Shounen') > 0");
        genreMap.put("genre29.exclude","instr(genre_tags, 'Shounen') = 0");
        genreMap.put("genre30.include","instr(genre_tags, 'Shounen ai') > 0");
        genreMap.put("genre30.exclude","instr(genre_tags, 'Shounen ai') = 0");
        genreMap.put("genre31.include","instr(genre_tags, 'Slice of life') > 0");
        genreMap.put("genre31.exclude","instr(genre_tags, 'Slice of life') = 0");
        genreMap.put("genre32.include","instr(genre_tags, 'Smut') > 0");
        genreMap.put("genre32.exclude","instr(genre_tags, 'Smut') = 0");
        genreMap.put("genre33.include","instr(genre_tags, 'Sports') > 0");
        genreMap.put("genre33.exclude","instr(genre_tags, 'Sports') = 0");
        genreMap.put("genre34.include","instr(genre_tags, 'Supernatural') > 0");
        genreMap.put("genre34.exclude","instr(genre_tags, 'Supernatural') = 0");
        genreMap.put("genre35.include","instr(genre_tags, 'Tragedy') > 0");
        genreMap.put("genre35.exclude","instr(genre_tags, 'Tragedy') = 0");
        genreMap.put("genre36.include","instr(genre_tags, 'Webtoons') > 0");
        genreMap.put("genre36.exclude","instr(genre_tags, 'Webtoons') = 0");
        genreMap.put("genre37.include","instr(genre_tags, 'Yaoi') > 0");
        genreMap.put("genre37.exclude","instr(genre_tags, 'Yaoi') = 0");
        genreMap.put("genre38.include","instr(genre_tags, 'Yuri') > 0");
        genreMap.put("genre38.exclude","instr(genre_tags, 'Yuri') = 0");
    }
}


//    private static Map<String, Predicate<MangaListView>> genreMap = new HashMap<>();
//
////in this version the mangalistview class has a genre getter/setter, just swith over to mangaarraylist instead.
//
//    public static Map<String, Predicate<MangaListView>> getGenreMap() {
//        return genreMap;
//    }
//
//    public static void createGenreString() {
//        genreMap.put("genre0.include",m -> m.getGenres().contains("Action"));
//        genreMap.put("genre0.exclude",m -> !m.getGenres().contains("Action"));
//        genreMap.put("genre1.include",m -> m.getGenres().contains("Action"));
//        genreMap.put("genre1.exclude",m -> !m.getGenres().contains("Action"));
//        genreMap.put("genre2.include",m -> m.getGenres().contains("Action"));
//        genreMap.put("genre2.exclude",m -> !m.getGenres().contains("Action"));
//        genreMap.put("genre3.include",m -> m.getGenres().contains("Action"));
//        genreMap.put("genre3.exclude",m -> !m.getGenres().contains("Action"));
//        genreMap.put("genre4.include",m -> m.getGenres().contains("Action"));
//        genreMap.put("genre4.exclude",m -> !m.getGenres().contains("Action"));
//        genreMap.put("genre5.include",m -> m.getGenres().contains("Action"));
//        genreMap.put("genre5.exclude",m -> !m.getGenres().contains("Action"));
//        genreMap.put("genre6.include",m -> m.getGenres().contains("Action"));
//        genreMap.put("genre6.exclude",m -> !m.getGenres().contains("Drama"));
//        genreMap.put("genre7.include",m -> m.getGenres().contains("Ecchi"));
//        genreMap.put("genre7.exclude",m -> !m.getGenres().contains("Ecchi"));
//        genreMap.put("genre8.include",m -> m.getGenres().contains("Fantasy"));
//        genreMap.put("genre8.exclude",m -> !m.getGenres().contains("Fantasy"));
//        genreMap.put("genre9.include",m -> m.getGenres().contains("Gender bender"));
//        genreMap.put("genre9.exclude",m -> !m.getGenres().contains("Gender bender"));
//        genreMap.put("genre10.include",m -> m.getGenres().contains("Harem"));
//        genreMap.put("genre10.exclude",m -> !m.getGenres().contains("Harem"));
//        genreMap.put("genre11.include",m -> m.getGenres().contains("Historical"));
//        genreMap.put("genre11.exclude",m -> !m.getGenres().contains("Historical"));
//        genreMap.put("genre12.include",m -> m.getGenres().contains("Horror"));
//        genreMap.put("genre12.exclude",m -> !m.getGenres().contains("Horror"));
//        genreMap.put("genre13.include",m -> m.getGenres().contains("Josei"));
//        genreMap.put("genre13.exclude",m -> !m.getGenres().contains("Josei"));
//        genreMap.put("genre14.include",m -> m.getGenres().contains("Manhua"));
//        genreMap.put("genre14.exclude",m -> !m.getGenres().contains("Manhua"));
//        genreMap.put("genre15.include",m -> m.getGenres().contains("Manhwa"));
//        genreMap.put("genre15.exclude",m -> !m.getGenres().contains("Manhwa"));
//        genreMap.put("genre16.include",m -> m.getGenres().contains("Martial arts"));
//        genreMap.put("genre16.exclude",m -> !m.getGenres().contains("Martial arts"));
//        genreMap.put("genre17.include",m -> m.getGenres().contains("Mature"));
//        genreMap.put("genre17.exclude",m -> !m.getGenres().contains("Mature"));
//        genreMap.put("genre18.include",m -> m.getGenres().contains("Mecha"));
//        genreMap.put("genre18.exclude",m -> !m.getGenres().contains("Mecha"));
//        genreMap.put("genre19.include",m -> m.getGenres().contains("Medical"));
//        genreMap.put("genre19.exclude",m -> !m.getGenres().contains("Medical"));
//        genreMap.put("genre20.include",m -> m.getGenres().contains("Mystery"));
//        genreMap.put("genre20.exclude",m -> !m.getGenres().contains("Mystery"));
//        genreMap.put("genre21.include",m -> m.getGenres().contains("One shot"));
//        genreMap.put("genre21.exclude",m -> !m.getGenres().contains("One shot"));
//        genreMap.put("genre22.include",m -> m.getGenres().contains("Psychological"));
//        genreMap.put("genre22.exclude",m -> !m.getGenres().contains("Psychological"));
//        genreMap.put("genre23.include",m -> m.getGenres().contains("Romance"));
//        genreMap.put("genre23.exclude",m -> !m.getGenres().contains("Romance"));
//        genreMap.put("genre24.include",m -> m.getGenres().contains("School life"));
//        genreMap.put("genre24.exclude",m -> !m.getGenres().contains("School life"));
//        genreMap.put("genre25.include",m -> m.getGenres().contains("Sci fi"));
//        genreMap.put("genre25.exclude",m -> !m.getGenres().contains("Sci fi"));
//        genreMap.put("genre26.include",m -> m.getGenres().contains("Seinen"));
//        genreMap.put("genre26.exclude",m -> !m.getGenres().contains("Seinen"));
//        genreMap.put("genre27.include",m -> m.getGenres().contains("Shoujo"));
//        genreMap.put("genre27.exclude",m -> !m.getGenres().contains("Shoujo"));
//        genreMap.put("genre28.include",m -> m.getGenres().contains("Shoujo ai"));
//        genreMap.put("genre28.exclude",m -> !m.getGenres().contains("Shoujo ai"));
//        genreMap.put("genre29.include",m -> m.getGenres().contains("Shounen"));
//        genreMap.put("genre29.exclude",m -> !m.getGenres().contains("Shounen"));
//        genreMap.put("genre30.include",m -> m.getGenres().contains("Shounen ai"));
//        genreMap.put("genre30.exclude",m -> !m.getGenres().contains("Shounen ai"));
//        genreMap.put("genre31.include",m -> m.getGenres().contains("Slice of life"));
//        genreMap.put("genre31.exclude",m -> !m.getGenres().contains("Slice of life"));
//        genreMap.put("genre32.include",m -> m.getGenres().contains("Smut"));
//        genreMap.put("genre32.exclude",m -> !m.getGenres().contains("Smut"));
//        genreMap.put("genre33.include",m -> m.getGenres().contains("Sports"));
//        genreMap.put("genre33.exclude",m -> !m.getGenres().contains("Sports"));
//        genreMap.put("genre34.include",m -> m.getGenres().contains("Supernatural"));
//        genreMap.put("genre34.exclude",m -> !m.getGenres().contains("Supernatural"));
//        genreMap.put("genre35.include",m -> m.getGenres().contains("Tragedy"));
//        genreMap.put("genre35.exclude",m -> !m.getGenres().contains("Tragedy"));
//        genreMap.put("genre36.include",m -> m.getGenres().contains("Webtoons"));
//        genreMap.put("genre36.exclude",m -> !m.getGenres().contains("Webtoons"));
//        genreMap.put("genre37.include",m -> m.getGenres().contains("Yaoi"));
//        genreMap.put("genre37.exclude",m -> !m.getGenres().contains("Yaoi"));
//        genreMap.put("genre38.include",m -> m.getGenres().contains("Yuri"));
//        genreMap.put("genre38.exclude",m -> !m.getGenres().contains("Yuri"));