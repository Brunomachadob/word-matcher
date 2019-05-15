package com.bruno.matchers

import org.junit.Test

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat

class ShuffledLettersMatcherTest {

    private val matcher = ShuffledLettersMatcher("abc")

    @Test
    fun abc_matches() {
        assertThat(matcher.test("abc"), `is`(true))
    }

    @Test
    fun acb_matches() {
        assertThat(matcher.test("acb"), `is`(true))
    }

    @Test
    fun cab_matches() {
        assertThat(matcher.test("cab"), `is`(true))
    }

    @Test
    fun bac_matches() {
        assertThat(matcher.test("bac"), `is`(true))
    }

    @Test
    fun cba_matches() {
        assertThat(matcher.test("cba"), `is`(true))
    }

    @Test
    fun bca_matches() {
        assertThat(matcher.test("bca"), `is`(true))
    }

    @Test
    fun abd_does_not_match() {
        assertThat(matcher.test("abd"), `is`(false))
    }
}
