package org.mycompany.db.letter;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mycompany.db.letter.LetterUtils.canGetOneWordFromAnother;

public class LetterUtilsTest {
    @Test
    public void testExactlyFalse() {
        assertTrue(canGetOneWordFromAnother("2".toCharArray(), "123".toCharArray(), false));
    }

    @Test
    public void testExactlyTrue() {
        assertFalse(canGetOneWordFromAnother("2".toCharArray(), "123".toCharArray(), true));
    }

    @Test
    public void testArrayWithTheSameChar() {
        assertTrue(canGetOneWordFromAnother("231".toCharArray(), "123".toCharArray(), true));
        assertTrue(canGetOneWordFromAnother("231".toCharArray(), "123".toCharArray(), false));
    }
}