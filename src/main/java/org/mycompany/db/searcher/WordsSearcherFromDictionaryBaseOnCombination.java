package org.mycompany.db.searcher;

import org.mycompany.db.letter.LettersArray;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.mycompany.db.combination.CombinationUtils.getAllShortWordsFromDictionaryByCombinations;
import static org.mycompany.db.letter.LetterUtils.canGetOneWordFromAnother;

@Component
public class WordsSearcherFromDictionaryBaseOnCombination implements WordsSearcherFromDictionary {
    private static final int LONG_STRING_LENGTH = 15;

    private final Map<LettersArray, List<String>> lettersWithListString = new ConcurrentHashMap<>();
    private final List<String> longWords = new CopyOnWriteArrayList<>();

    @Override
    public void addWordInDictionary(String word) {
        if (word.length() <= LONG_STRING_LENGTH) {
            addShortWord(word);
        } else {
            addLongWord(word);
        }
    }

    @Override
    public void addAllWordsInDictionary(Collection<String> words) {
        words.forEach(this::addWordInDictionary);
    }

    private void addShortWord(String word) {
        LettersArray lettersArray = new LettersArray(word.toCharArray());
        List<String> strings = lettersWithListString.computeIfAbsent(lettersArray, k -> new CopyOnWriteArrayList<>());
        strings.add(word);
    }

    private void addLongWord(String word) {
        longWords.add(word);
    }

    @Override
    public Set<String> getAllWordsFromDictionary(String word) {
        long begin = System.currentTimeMillis();
        Set<String> allWords = getAllShortWordsFromDictionaryByCombinations(word, Math.min(word.length(), LONG_STRING_LENGTH), lettersWithListString);
        System.out.println("combination: " + (System.currentTimeMillis() - begin) / 1000);
        begin = System.currentTimeMillis();
        if (word.length() > LONG_STRING_LENGTH) {
            allWords.addAll(getAllLongWordsFromDictionary(word));
        }
        System.out.println("longWords: " + (System.currentTimeMillis() - begin) / 1000);
        return allWords;
    }

    private Set<String> getAllLongWordsFromDictionary(String word) {
        Set<String> allLongWords = new HashSet<>();
        for (String longWord : longWords) {
            if (word.length() >= longWord.length() && canGetOneWordFromAnother(longWord.toCharArray(), word.toCharArray(), false)) {
                allLongWords.add(longWord);
            }
        }
        return allLongWords;
    }
}
