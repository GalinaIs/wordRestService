package org.mycompany.controller;

import org.junit.jupiter.api.Test;
import org.mycompany.db.WordDictionary;
import org.mycompany.db.exception.WordDictionaryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WordController.class)
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private WordDictionary service;

    @Test
    public void shouldReturnDefinitionWord() throws Exception {
        String word = "word";
        String definition = "definition";
        when(service.getDefinition(word)).thenReturn(definition);

        this.mockMvc.perform(get("/getDescription").param(word, word))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(definition)));
    }

    @Test
    public void shouldReturnError() throws Exception {
        String word = "word";
        String exceptionMessage = "Exception message";
        when(service.getDefinition(word)).thenThrow(new WordDictionaryException(exceptionMessage));

        this.mockMvc.perform(get("/getDescription").param(word, word))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(exceptionMessage)));
    }
}