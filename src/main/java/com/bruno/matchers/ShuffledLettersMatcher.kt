package com.bruno.matchers

import java.util.HashSet
import java.util.function.Predicate
import java.util.stream.IntStream

class ShuffledLettersMatcher(word: String) : SameLengthMatcher(word), Predicate<String> {

    private val possibilities: MutableSet<String> = HashSet()

    init {
        permuteString("", word)
    }

    override fun test(word: String): Boolean {
        return super.test(word) && this.possibilities.contains(word)
    }

    private fun permuteString(beginningString: String, endingString: String) {
        if (endingString.length <= 1) {
            this.possibilities.add(beginningString + endingString)
        } else {
            IntStream.range(0, endingString.length).forEach { i ->
                val newString = endingString.substring(0, i) + endingString.substring(i + 1)
                permuteString(beginningString + endingString[i], newString)
            }
        }
    }
}
