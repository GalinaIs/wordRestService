package org.mycompany.db.combination;

import org.mycompany.db.letter.LettersArray;
import org.paukov.combinatorics3.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationUtils {
    private static final int MAX_LENGTH = 23;

    private CombinationUtils() {
        throw new AssertionError("No instance!");
    }

    static List<LettersArray> getCombinations(List<Character> letters, int k) {
        return Generator.combination(letters)
                .simple(k)
                .stream()
                .map(LettersArray::new)
                .collect(Collectors.toList());
    }

    public static List<LettersArray> getAllCombinations(String word) {
        List<LettersArray> combinations = new ArrayList<>();
        if (word.length() > MAX_LENGTH) {
            word = word.substring(0, MAX_LENGTH);
        }
        List<Character> letters = word.chars()// Convert to an IntStream
                .mapToObj(i -> (char) i) // Convert int to char, which gets boxed to Character
                .collect(Collectors.toList());
        for (int i = 1; i <= word.length(); i++) {
            combinations.addAll(getCombinations(letters, i));
        }
        return combinations;
    }
}