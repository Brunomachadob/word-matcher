package com.bruno.matchers

import java.util.function.Predicate

class SameLengthMatcher(private val word: String) : Predicate<String> {

    override fun test(word: String): Boolean {
        return this.word.length == word.length
    }
}

