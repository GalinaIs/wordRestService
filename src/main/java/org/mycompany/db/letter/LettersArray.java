package org.mycompany.db.letter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LettersArray {
    private final char[] letters;

    public LettersArray(char[] letters) {
        this.letters = letters;
    }

    public LettersArray(List<Character> characters) {
        this.letters = new char[characters.size()];
        int i = 0;
        for (Character character : characters) {
            letters[i++] = character;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LettersArray that = (LettersArray) o;
        if (letters.length != that.letters.length) {
            return false;
        }
        Map<Character, Integer> lettersThatWithFrequency = getMapFromCharArray(that.letters);
        for (Character letter : letters) {
            Integer frequency = lettersThatWithFrequency.get(letter);
            if (frequency == null) {
                return false;
            }
            if (frequency == 1) {
                lettersThatWithFrequency.remove(letter);
            } else {
                lettersThatWithFrequency.put(letter, --frequency);
            }
        }
        return lettersThatWithFrequency.isEmpty();
    }

    @Override
    public int hashCode() {
        int sum = 0;
        for (char letter : letters) {
            sum += letter;
        }
        return sum;
    }

    @Override
    public String toString() {
        return "LettersArray{" +
                "letters=" + Arrays.toString(letters) +
                '}';
    }

    private static Map<Character, Integer> getMapFromCharArray(char[] letters) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character letter : letters) {
            if (map.computeIfPresent(letter, (k, v) -> v++) == null) {
                map.put(letter, 1);
            }
        }
        return map;
    }
}
