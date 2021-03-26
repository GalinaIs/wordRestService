package org.mycompany.db;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MapWordDictionaryTest {
    @Test
    public void getAllWordsFromWord() {
        WordDictionary mapWordDictionary = new MapWordDictionary();
        mapWordDictionary.save("С", "опеределение С");
        mapWordDictionary.save("Г", "опеределение Г");
        mapWordDictionary.save("СГ", "опеределение СГ");
        mapWordDictionary.save("ГС", "опеределение ГС");
        mapWordDictionary.save("123", "опеределение 123");

        List<String> allWordsFromWord = mapWordDictionary.getAllWordsFromWord("сег");
        Assert.assertEquals(4, allWordsFromWord.size());
        Assert.assertTrue(allWordsFromWord.contains("С"));
        Assert.assertTrue(allWordsFromWord.contains("Г"));
        Assert.assertTrue(allWordsFromWord.contains("СГ"));
        Assert.assertTrue(allWordsFromWord.contains("ГС"));
    }
}