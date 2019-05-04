package com.bruno.matchers;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class MatcherFactoryTest {

    private static MatcherFactory matcherFactory;

    @BeforeClass
    public static void setup() {
        matcherFactory = MatcherFactory.getInstance();
    }

    @Test
    public void missing_letter_matcher() {
        assertThat(
            matcherFactory.getMatcher(Matcher.MISSING, "any"),
            is(instanceOf(MissingLettersMatcher.class))
        );
    }

    @Test
    public void same_length_letter_matcher() {
        assertThat(
                matcherFactory.getMatcher(Matcher.LENGTH, "any"),
                is(instanceOf(SameLengthMatcher.class))
        );
    }

    @Test
    public void shuffled_letter_matcher() {
        assertThat(
                matcherFactory.getMatcher(Matcher.SHUFFLED, "any"),
                is(instanceOf(ShuffledLettersMatcher.class))
        );
    }
}
