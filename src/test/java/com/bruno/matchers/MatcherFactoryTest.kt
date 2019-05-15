package com.bruno.matchers

import org.junit.Test

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertThat

class MatcherFactoryTest {

    @Test
    fun missing_letter_matcher() {
        assertThat(
                getMatcher(Matcher.MISSING, "any"),
                `is`(instanceOf(MissingLettersMatcher::class.java))
        )
    }

    @Test
    fun same_length_letter_matcher() {
        assertThat(
                getMatcher(Matcher.LENGTH, "any"),
                `is`(instanceOf(SameLengthMatcher::class.java))
        )
    }

    @Test
    fun shuffled_letter_matcher() {
        assertThat(
                getMatcher(Matcher.SHUFFLED, "any"),
                `is`(instanceOf(ShuffledLettersMatcher::class.java))
        )
    }
}
