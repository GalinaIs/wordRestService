package org.mycompany.db.letter;

import java.util.HashMap;
import java.util.Map;

public class LetterUtils {
    public static boolean canGetOneWordFromAnother(char[] oneWordLetters, char[] anotherWordLetters, boolean exactly) {
        Map<Character, Integer> lettersThatWithFrequency = getMapFromCharArray(anotherWordLetters);
        for (Character letter : oneWordLetters) {
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
        return !exactly || lettersThatWithFrequency.isEmpty();
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
