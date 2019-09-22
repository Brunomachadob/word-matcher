package com.bruno.matchers

import java.util.function.Predicate

open class SameLengthMatcher(private val word: String) : Predicate<String> {

    override fun test(word: String): Boolean {
        return this.word.length == word.length
    }
}

