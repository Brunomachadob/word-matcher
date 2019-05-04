package com.bruno;

public enum Language {

    GERMAN("german.txt");

    private String path;

    Language(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
