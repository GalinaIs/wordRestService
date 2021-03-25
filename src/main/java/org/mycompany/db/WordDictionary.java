package org.mycompany.db;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class WordDictionary {
    Map<String, String> dictionary = new ConcurrentHashMap<>();

    public void save(String word, String definition) {
        dictionary.put(word, definition);
    }

    public void get(String word) {
        dictionary.get(word);
    }

    public void saveAll(Map<String, String> map) {
        dictionary.putAll(map);
    }
}
