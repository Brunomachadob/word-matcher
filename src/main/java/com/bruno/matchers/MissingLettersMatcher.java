package com.bruno.matchers;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class MissingLettersMatcher implements Predicate<String> {

    private final Predicate<String> sameLengthMatcher;
    private final Pattern wordPattern;


    public MissingLettersMatcher(String word) {
        this.sameLengthMatcher = MatcherFactory.getInstance().withSameSize(word);

        String replaced = word.replaceAll("\\_", "\\.");
        this.wordPattern = Pattern.compile(replaced, Pattern.CASE_INSENSITIVE);
    }

    public boolean test(String word) {
        return this.sameLengthMatcher.test(word) && this.wordPattern.matcher(word).find();
    }
}
