package org.mycompany.db.combination;

import org.mycompany.db.letter.LettersArray;
import org.paukov.combinatorics3.Generator;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationUtils {
    private static final int MAX_LENGTH = 18;

    private CombinationUtils() {
        throw new AssertionError("No instance!");
    }

    static Set<String> getCombinationsFromDictionary(List<Character> letters, int k, Map<LettersArray, List<String>> dictionary) {
        return Generator.combination(letters)
                .simple(k)
                .stream()
                .map(LettersArray::new)
                .map(dictionary::get)
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .collect(Collectors.toSet());
    }

    public static Set<String> getAllShortWordsFromDictionaryByCombinations(String word, int countCombination, Map<LettersArray, List<String>> dictionary) {
        Set<String> combinations = new HashSet<>();
        if (word.length() > MAX_LENGTH) {
            word = word.substring(0, MAX_LENGTH);
        }
        List<Character> letters = word.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toList());
        for (int i = 1; i <= countCombination; i++) {
            combinations.addAll(getCombinationsFromDictionary(letters, i, dictionary));
        }
        return combinations;
    }
}