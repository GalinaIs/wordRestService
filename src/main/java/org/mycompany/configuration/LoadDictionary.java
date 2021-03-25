package org.mycompany.configuration;

import org.mycompany.db.WordDictionary;
import org.mycompany.parser.FileToMapWordDefinitionParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class LoadDictionary {
    private final WordDictionary wordDictionary;
    private final FileToMapWordDefinitionParser parser;
    private final String fileName;

    public LoadDictionary(WordDictionary wordDictionary, FileToMapWordDefinitionParser parser, @Value("${dictionaryInitFileName}") String fileName) {
        this.wordDictionary = wordDictionary;
        this.parser = parser;
        this.fileName = fileName;
    }

    @Bean
    CommandLineRunner initWorldDictionary() {
        return args -> {
            Map<String, String> map = parser.parse(fileName);
            wordDictionary.saveAll(map);
        };
    }
}