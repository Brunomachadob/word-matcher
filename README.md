### Word Matcher

Project created to search for words that could match the given input.

At the moment we have two main match models:

- Shuffled: Based on a word that had it's letters shuffled, return a list of words that could be the desired word.
```
Input word: eeilb
Matches found:
beeil
liebe
```

- Missing: Based on a word that have missing letters, find the suitable matches
```
Input word: l_eb_
Matches found:
liebe
liebs
liebt
```
