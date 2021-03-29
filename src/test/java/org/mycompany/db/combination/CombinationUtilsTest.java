package org.mycompany.db.combination;

import org.junit.Assert;
import org.junit.Test;
import org.mycompany.db.letter.LettersArray;

import java.util.*;

public class CombinationUtilsTest {
    @Test
    public void test() {
        String word = "123";
        Map<LettersArray, List<String>> dictionary = getAllWords(word);
        Set<String> allCombinations = CombinationUtils.getAllShortWordsFromDictionaryByCombinations(word, word.length(), dictionary);
        Assert.assertEquals(7, allCombinations.size());
        Assert.assertTrue(allCombinations.contains("1"));
        Assert.assertTrue(allCombinations.contains("2"));
        Assert.assertTrue(allCombinations.contains("3"));
        Assert.assertTrue(allCombinations.contains("12"));
        Assert.assertTrue(allCombinations.contains("13"));
        Assert.assertTrue(allCombinations.contains("23"));
        Assert.assertTrue(allCombinations.contains("123"));
    }

    private Map<LettersArray, List<String>> getAllWords(String word) {
        Map<LettersArray, List<String>> dictionary = new HashMap<>();
        dictionary.put(new LettersArray("1".toCharArray()), Collections.singletonList("1"));
        dictionary.put(new LettersArray("2".toCharArray()), Collections.singletonList("2"));
        dictionary.put(new LettersArray("3".toCharArray()), Collections.singletonList("3"));
        dictionary.put(new LettersArray("12".toCharArray()), Collections.singletonList("12"));
        dictionary.put(new LettersArray("13".toCharArray()), Collections.singletonList("13"));
        dictionary.put(new LettersArray("23".toCharArray()), Collections.singletonList("23"));
        dictionary.put(new LettersArray("123".toCharArray()), Collections.singletonList("123"));
        return dictionary;
    }

    /**
     * Ожидаем, что при обработке длинной строки не будет выброшено исключение.
     */
    @Test
    public void test1() {
        String word = "аовфжаоккщшщзецшгафмтмтябаьлввввввввввкщцшзушкцузщкшцзщуаолаомоывапролорпавйцукенгшщзхзждлорпавычсмитьбдлонекуаптьлшгнекуцывсмилщгшорвапва";
        CombinationUtils.getAllShortWordsFromDictionaryByCombinations(word, 15, new HashMap<>());
    }
}