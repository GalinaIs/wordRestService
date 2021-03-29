package org.mycompany.db;

import org.mycompany.db.exception.WordDictionaryException;
import org.mycompany.db.searcher.WordsSearcherFromDictionary;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MapWordDictionary implements WordDictionary {
    private final Map<String, String> dictionary = new ConcurrentHashMap<>();
    private final WordsSearcherFromDictionary searcher;

    public MapWordDictionary(WordsSearcherFromDictionary searcher) {
        this.searcher = searcher;
    }

    public void save(String word, String definition) {
        dictionary.put(word, definition);
        searcher.addWordInDictionary(word);
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
        searcher.addAllWordsInDictionary(map.keySet());
    }

    @Override
    public Set<String> getAllWordsFromWord(String word) {
        return searcher.getAllWordsFromDictionary(word.toUpperCase());
    }
}
