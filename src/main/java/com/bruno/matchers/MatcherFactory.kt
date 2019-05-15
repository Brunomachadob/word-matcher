package com.bruno.matchers

import java.util.function.Predicate

fun getMatcher(matcher: Matcher, word: String): Predicate<String> {
    return when (matcher) {
        Matcher.SHUFFLED -> withShuffledLetters(word)

        Matcher.MISSING -> withMissingLetters(word)

        Matcher.LENGTH -> withSameSize(word)
    }
}

fun withMissingLetters(word: String): Predicate<String> {
    return MissingLettersMatcher(word)
}

fun withShuffledLetters(word: String): Predicate<String> {
    return ShuffledLettersMatcher(word)
}

fun withSameSize(word: String): Predicate<String> {
    return SameLengthMatcher(word)
}
