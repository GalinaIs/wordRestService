package org.mycompany.db;

import org.mycompany.db.exception.WordDictionaryException;

import java.util.Map;
import java.util.Set;

public interface WordDictionary {
    void save(String word, String definition);

    String getDefinition(String word) throws WordDictionaryException;

    void saveAll(Map<String, String> map);

    Set<String> getAllWordsFromWord(String word);
}
