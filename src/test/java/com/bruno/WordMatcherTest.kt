package com.bruno

import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers.hasItems
import org.hamcrest.CoreMatchers.equalTo

import com.bruno.matchers.Matcher
import org.junit.Test

class WordMatcherTest {

    private val wordMatcher = WordMatcher(Language.GERMAN, Matcher.MISSING)

    @Test
    @Throws(Exception::class)
    fun should_find_words() {
        assertThat(
                wordMatcher.getMatches("L_eb_"),
                equalTo(listOf("liebe", "liebt"))
        )
    }

    @Test
    @Throws(Exception::class)
    fun should_find_first_word() {
        assertThat(
                wordMatcher.setLimit(1).getMatches("L_eb_"),
                equalTo(listOf("liebe"))
        )
    }
}
