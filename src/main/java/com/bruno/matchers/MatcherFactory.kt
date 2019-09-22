package com.bruno.matchers

fun getMatcher(matcher: Matcher, word: String) = when (matcher) {
    Matcher.SHUFFLED -> ShuffledLettersMatcher(word)
    Matcher.MISSING -> MissingLettersMatcher(word)
    Matcher.LENGTH -> SameLengthMatcher(word)
}

