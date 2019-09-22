package com.bruno.matchers

import java.util.function.Predicate
import java.util.regex.Pattern

class MissingLettersMatcher(word: String) : SameLengthMatcher(word), Predicate<String> {

    private val wordPattern: Pattern = word.let {
        it.replace("\\_".toRegex(), "\\.")
    }.let {
        Pattern.compile(it, Pattern.CASE_INSENSITIVE)
    }

    override fun test(word: String): Boolean {
        return super.test(word) && this.wordPattern.matcher(word).find()
    }
}
