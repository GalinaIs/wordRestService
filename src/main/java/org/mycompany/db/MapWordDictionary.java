package org.mycompany.db;

import org.mycompany.db.exception.WordDictionaryException;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MapWordDictionary implements WordDictionary {
    Map<String, String> dictionary = new ConcurrentHashMap<>();

    public void save(String word, String definition) {
        dictionary.put(word, definition);
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
    }
}
