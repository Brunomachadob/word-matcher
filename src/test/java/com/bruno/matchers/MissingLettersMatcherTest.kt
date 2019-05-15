package com.bruno.matchers

import org.junit.Test

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat

class MissingLettersMatcherTest {

    private val matcher = MissingLettersMatcher("l_eb_")

    @Test
    fun liebe_matches() {
        assertThat(matcher.test("liebe"), `is`(true))
    }

    @Test
    fun LIEBE_matches() {
        assertThat(matcher.test("LIEBE"), `is`(true))
    }

    @Test
    fun liebt_matches() {
        assertThat(matcher.test("liebt"), `is`(true))
    }

    @Test
    fun liabt_does_not_match() {
        assertThat(matcher.test("liabt"), `is`(false))
    }
}
