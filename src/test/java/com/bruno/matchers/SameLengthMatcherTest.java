package com.bruno.matchers;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SameLengthMatcherTest {

    private static SameLengthMatcher matcher;

    @BeforeClass
    public static void setup() {
        matcher = new SameLengthMatcher("abc");
    }

    @Test
    public void abc_matches() {
        assertThat(matcher.test("abc"), is(true));
    }

    @Test
    public void ab_does_not_match() {
        assertThat(matcher.test("ab"), is(false));
    }
}
