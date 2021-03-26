package org.mycompany.db.letter;

import org.junit.Test;

import static org.junit.Assert.*;

public class LettersArrayTest {
    @Test
    public void testEquals() {
        LettersArray lettersArray = new LettersArray("опыт".toCharArray());
        assertEquals(lettersArray, new LettersArray("пыто".toCharArray()));
        assertEquals(lettersArray, new LettersArray("ытоп".toCharArray()));
        assertEquals(lettersArray, new LettersArray("топы".toCharArray()));
        assertEquals(lettersArray, new LettersArray("поты".toCharArray()));
        assertEquals(lettersArray, new LettersArray("отып".toCharArray()));
    }

    @Test
    public void testNotEquals() {
        LettersArray lettersArray = new LettersArray("опыт".toCharArray());
        assertNotEquals(lettersArray, new LettersArray("пыт".toCharArray()));
        assertNotEquals(lettersArray, new LettersArray("ыооп".toCharArray()));
        assertNotEquals(lettersArray, new LettersArray("тошы".toCharArray()));
        assertNotEquals(lettersArray, new LettersArray("потый".toCharArray()));
    }
}