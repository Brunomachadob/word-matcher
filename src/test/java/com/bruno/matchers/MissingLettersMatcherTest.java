package com.bruno.matchers;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.BeforeClass;
import org.junit.Test;

public class MissingLettersMatcherTest {

    private static MissingLettersMatcher matcher;

    @BeforeClass
    public static void setup() {
        matcher = new MissingLettersMatcher("l_eb_");
    }

    @Test
    public void liebe_matches() {
        assertThat(matcher.test("liebe"), is(true));
    }

    @Test
    public void LIEBE_matches() {
        assertThat(matcher.test("LIEBE"), is(true));
    }

    @Test
    public void liebt_matches() {
        assertThat(matcher.test("liebt"), is(true));
    }

    @Test
    public void liabt_does_not_match() {
        assertThat(matcher.test("liabt"), is(false));
    }
}
