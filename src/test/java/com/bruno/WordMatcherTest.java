package com.bruno;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.hasItems;

import com.bruno.matchers.Matcher;
import org.junit.BeforeClass;
import org.junit.Test;

public class WordMatcherTest {

    private static WordMatcher wordMatcher;

    @BeforeClass
    public static void setup() {
        wordMatcher = new WordMatcher(Language.GERMAN, Matcher.MISSING);
    }

    @Test
    public void should_find_words() throws Exception {
        assertThat(
                wordMatcher.getMatches("L_eb_"),
                hasItems("liebe", "liebt")
        );
    }

    @Test
    public void should_find_first_word() throws Exception {
        assertThat(
                wordMatcher.setLimit(1).getMatches("L_eb_"),
                hasItems("liebe")
        );
    }
}
