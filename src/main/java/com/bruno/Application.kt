package com.bruno

import com.bruno.matchers.Matcher

object Application {

    private val LANGUAGE = Language.GERMAN
    private val MATCHER = Matcher.MISSING
    private const val LIMIT = Long.MAX_VALUE

    private const val WORD = "T_________en"

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
