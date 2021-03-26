package org.mycompany.db;

import org.mycompany.db.exception.WordDictionaryException;

import java.util.List;
import java.util.Map;

public interface WordDictionary {
    void save(String word, String definition);

    String getDefinition(String word) throws WordDictionaryException;

    void saveAll(Map<String, String> map);

    List<String> getAllWordsFromWord(String word);
}
