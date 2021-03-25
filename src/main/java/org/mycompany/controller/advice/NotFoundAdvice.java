package org.mycompany.controller.advice;

import org.mycompany.db.exception.WordDictionaryException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(WordDictionaryException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String definitionWordNotFoundHandler(WordDictionaryException ex) {
        return ex.getMessage();
    }
}
