package com.bruno.matchers;

import java.util.function.Predicate;

public class MatcherFactory {

    private static MatcherFactory INSTANCE;

    private MatcherFactory() {}

    public static MatcherFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MatcherFactory();
        }

        return INSTANCE;
    }

    public Predicate<String> getMatcher(Matcher matcher, String word) {
        switch (matcher) {
            case SHUFFLED:
                return withShuffledLetters(word);

            case MISSING:
                return withMissingLetters(word);

            case LENGTH:
                return withSameSize(word);

            default:
                throw new IllegalArgumentException("Invalid matcher: " + matcher.name());
        }
    }

    public Predicate<String> withMissingLetters(String word) {
        return new MissingLettersMatcher(word);
    }

    public Predicate<String> withShuffledLetters(String word) {
        return new ShuffledLettersMatcher(word);
    }

    public Predicate<String> withSameSize(String word) {
        return new SameLengthMatcher(word);
    }
}
