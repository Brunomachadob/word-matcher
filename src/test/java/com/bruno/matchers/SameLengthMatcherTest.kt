package com.bruno.matchers

import org.junit.Test

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat

class SameLengthMatcherTest {

    private val matcher = SameLengthMatcher("abc")

    @Test
    fun abc_matches() {
        assertThat(matcher.test("abc"), `is`(true))
    }

    @Test
    fun ab_does_not_match() {
        assertThat(matcher.test("ab"), `is`(false))
    }
}
