package com.bruno.matchers;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ShuffledLettersMatcherTest {

    private static ShuffledLettersMatcher matcher;

    @BeforeClass
    public static void setup() {
        matcher = new ShuffledLettersMatcher("abc");
    }

    @Test
    public void abc_matches() {
        assertThat(matcher.test("abc"), is(true));
    }

    @Test
    public void acb_matches() {
        assertThat(matcher.test("acb"), is(true));
    }

    @Test
    public void cab_matches() {
        assertThat(matcher.test("cab"), is(true));
    }

    @Test
    public void bac_matches() {
        assertThat(matcher.test("bac"), is(true));
    }

    @Test
    public void cba_matches() {
        assertThat(matcher.test("cba"), is(true));
    }

    @Test
    public void bca_matches() {
        assertThat(matcher.test("bca"), is(true));
    }

    @Test
    public void abd_does_not_match() {
        assertThat(matcher.test("abd"), is(false));
    }
}
