package org.mycompany.db.searcher;

import java.util.Collection;
import java.util.Set;

public interface WordsSearcherFromDictionary {
    void addWordInDictionary(String word);

    void addAllWordsInDictionary(Collection<String> words);

    Set<String> getAllWordsFromDictionary(String word);
}
