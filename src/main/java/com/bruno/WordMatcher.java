package com.bruno;

import com.bruno.matchers.Matcher;
import com.bruno.matchers.MatcherFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordMatcher {

    private Language language;
    private Matcher matcher;

    private int limit = 30;

    public WordMatcher(Language language, Matcher matcher) {
        this.language = language;
        this.matcher = matcher;
    }

    public WordMatcher setLimit(int limit) {
        this.limit = limit;

        return this;
    }

    public Stream<String> streamMatches(String word) throws URISyntaxException, IOException {
        Predicate<String> predicate = MatcherFactory.getInstance().getMatcher(this.matcher, word);

        URI fileURI = Application.class
                .getClassLoader()
                .getResource(this.language.getPath()).toURI();

        return Files
                .lines(Paths.get(fileURI))
                .parallel()
                .filter(predicate)
                .map(String::toLowerCase)
                .distinct()
                .limit(this.limit);
    }

    public List<String> getMatches(String word) throws URISyntaxException, IOException {
        return streamMatches(word).collect(Collectors.toList());
    }
}
