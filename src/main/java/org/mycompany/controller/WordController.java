package org.mycompany.controller;

import org.mycompany.db.WordDictionary;
import org.mycompany.db.exception.WordDictionaryException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WordController {
    private final WordDictionary wordDictionary;

    public WordController(WordDictionary wordDictionary) {
        this.wordDictionary = wordDictionary;
    }

    @GetMapping("/getDescription")
    public String getDescription(@RequestParam String word) throws WordDictionaryException {
        return wordDictionary.getDefinition(word);
    }

    @GetMapping("/getAllWords")
    public List<String> getAllWords(@RequestParam String word) throws WordDictionaryException {
        return wordDictionary.getAllWordsFromWord(word);
    }
}
