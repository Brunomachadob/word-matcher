package com.bruno.matchers

import java.util.function.Predicate
import java.util.regex.Pattern

class MissingLettersMatcher(word: String) : Predicate<String> {

    private val sameLengthMatcher: Predicate<String> = withSameSize(word)
    private val wordPattern: Pattern

    init {
        val replaced = word.replace("\\_".toRegex(), "\\.")
        this.wordPattern = Pattern.compile(replaced, Pattern.CASE_INSENSITIVE)
    }

    override fun test(word: String): Boolean {
        return this.sameLengthMatcher.test(word) && this.wordPattern.matcher(word).find()
    }
}
