package org.mycompany.db.letter;

import java.util.Arrays;
import java.util.List;

import static org.mycompany.db.letter.LetterUtils.canGetOneWordFromAnother;

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
        return canGetOneWordFromAnother(that.letters, letters, true);
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
}
