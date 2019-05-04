package com.bruno;

import com.bruno.matchers.Matcher;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Application {

    private static Language LANGUAGE = Language.GERMAN;
    private static Matcher MATCHER = Matcher.SHUFFLED;
    private static int LIMIT = 30;

    private static String WORD = "eeilb";

    public static void main(String args[]) throws IOException, URISyntaxException {
        System.out.println("Input word: " + WORD);

        List<String> matches = new WordMatcher(LANGUAGE, MATCHER)
                .setLimit(LIMIT)
                .getMatches(WORD);

        if (matches.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            System.out.println("Matches found:");
            matches.forEach(System.out::println);
        }
    }
}
