package com.bruno

import com.bruno.matchers.Matcher
import com.bruno.matchers.getMatcher

import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors

class WordMatcher(private val language: Language, private val matcher: Matcher) {

    private var limit = 30

    fun setLimit(limit: Int): WordMatcher {
        this.limit = limit

        return this
    }

    fun getMatches(word: String): List<String> {
        val predicate = getMatcher(this.matcher, word)

        val fileURI = Application::class.java
                .classLoader
                .getResource(this.language.path)!!.toURI()

        return Files
                .lines(Paths.get(fileURI))
                .parallel()
                .filter(predicate)
                .map<String> { it.toLowerCase() }
                .distinct()
                .limit(this.limit.toLong())
                .collect(Collectors.toList())
    }
}
