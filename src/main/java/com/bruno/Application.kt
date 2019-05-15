package com.bruno

import com.bruno.matchers.Matcher

object Application {

    private val LANGUAGE = Language.GERMAN
    private val MATCHER = Matcher.SHUFFLED
    private const val LIMIT = 30

    private const val WORD = "rüasbercht"

    @JvmStatic
    fun main(args: Array<String>) {
        println("Input word: $WORD")

        val matches = WordMatcher(LANGUAGE, MATCHER)
                .setLimit(LIMIT)
                .getMatches(WORD)

        if (matches.isEmpty()) {
            println("No matches found.")
        } else {
            println("Matches found:")
            matches.forEach { println(it) }
        }
    }
}
