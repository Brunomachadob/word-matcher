package com.bruno.matchers

import java.util.HashSet
import java.util.function.Predicate
import java.util.stream.IntStream

class ShuffledLettersMatcher(word: String) : Predicate<String> {

    private val sameLengthMatcher: Predicate<String> = withSameSize(word)
    private val possibilities: MutableSet<String>

    init {
        this.possibilities = HashSet()

        permuteString("", word)

        println("Permutations: " + this.possibilities.size)
    }

    override fun test(word: String): Boolean {
        return sameLengthMatcher.test(word) && this.possibilities.contains(word)
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
