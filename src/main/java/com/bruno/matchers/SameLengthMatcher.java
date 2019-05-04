package com.bruno.matchers;

import java.util.function.Predicate;

public class SameLengthMatcher implements Predicate<String> {

    private final String word;

    public SameLengthMatcher(String word) {
        this.word = word;
    }

    public boolean test(String word) {
        return this.word.length() == word.length();
    }
}

