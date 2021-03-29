package org.mycompany.db;

import org.junit.Assert;
import org.junit.Test;
import org.mycompany.db.searcher.WordsSearcherFromDictionary;
import org.mycompany.db.searcher.WordsSearcherFromDictionaryBaseOnCombination;

import java.util.List;
import java.util.Set;

public class MapWordDictionaryTest {
    @Test
    public void getAllWordsFromWord() {
        WordsSearcherFromDictionary searcher = new WordsSearcherFromDictionaryBaseOnCombination();
        WordDictionary mapWordDictionary = new MapWordDictionary(searcher);
        mapWordDictionary.save("С", "опеределение С");
        mapWordDictionary.save("Г", "опеределение Г");
        mapWordDictionary.save("СГ", "опеределение СГ");
        mapWordDictionary.save("ГС", "опеределение ГС");
        mapWordDictionary.save("123", "опеределение 123");

        Set<String> allWordsFromWord = mapWordDictionary.getAllWordsFromWord("СЕГ");
        Assert.assertEquals(4, allWordsFromWord.size());
        Assert.assertTrue(allWordsFromWord.contains("С"));
        Assert.assertTrue(allWordsFromWord.contains("Г"));
        Assert.assertTrue(allWordsFromWord.contains("СГ"));
        Assert.assertTrue(allWordsFromWord.contains("ГС"));
    }
}