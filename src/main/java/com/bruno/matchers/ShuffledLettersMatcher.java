package com.bruno.matchers;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ShuffledLettersMatcher implements Predicate<String> {

    private final Predicate<String> sameLengthMatcher;
    private final Set<String> possibilities;

    public ShuffledLettersMatcher(String word) {
        this.sameLengthMatcher = MatcherFactory.getInstance().withSameSize(word);
        this.possibilities = new HashSet<>();

        permuteString("", word);

        System.out.println("Permutations: " + this.possibilities.size());
    }

    public boolean test(String word) {
        return sameLengthMatcher.test(word) && this.possibilities.contains(word);
    }

    private void permuteString(String beginningString, String endingString) {
        if (endingString.length() <= 1) {
            this.possibilities.add(beginningString + endingString);
        } else {
            IntStream.range(0, endingString.length()).forEach(i -> {
                String newString = endingString.substring(0, i) + endingString.substring(i + 1);
                permuteString(beginningString + endingString.charAt(i), newString);
            });
        }
    }
}
