package org.mycompany.db;

import org.mycompany.db.combination.CombinationUtils;
import org.mycompany.db.exception.WordDictionaryException;
import org.mycompany.db.letter.LettersArray;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class MapWordDictionary implements WordDictionary {
    private final Map<String, String> dictionary = new ConcurrentHashMap<>();
    private final Map<LettersArray, List<String>> lettersWithListString = new ConcurrentHashMap<>();

    public void save(String word, String definition) {
        dictionary.put(word, definition);
        putOneWord(word);
    }

    public String getDefinition(String word) throws WordDictionaryException {
        String definition = dictionary.get(word.toUpperCase());
        if (definition == null) {
            throw new WordDictionaryException("Definition of word '" + word + "' doesn't find");
        }
        return definition;
    }

    public void saveAll(Map<String, String> map) {
        dictionary.putAll(map);
        map.forEach((word, description) -> putOneWord(word));
    }

    @Override
    public List<String> getAllWordsFromWord(String word) {
        List<String> result = new ArrayList<>();
        List<LettersArray> allCombinations = CombinationUtils.getAllCombinations(word.toUpperCase());
        for (LettersArray combination : allCombinations) {
            List<String> strings = lettersWithListString.get(combination);
            if (strings != null) {
                result.addAll(strings);
            }
        }
        return result;
    }

    private void putOneWord(String word) {
        LettersArray lettersArray = new LettersArray(word.toCharArray());
        List<String> strings = lettersWithListString.computeIfAbsent(lettersArray, k -> new CopyOnWriteArrayList<>());
        strings.add(word);
    }
}
