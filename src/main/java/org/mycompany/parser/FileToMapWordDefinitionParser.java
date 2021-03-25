package org.mycompany.parser;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class FileToMapWordDefinitionParser {
    static final Pattern PATTERN = Pattern.compile("^([А-ЯЁ]+)([^А-ЯЁ1]*)([А-ЯЁ1].*)$");

    public Map<String, String> parse(String fileName) throws IOException {
        InputStream resource = new ClassPathResource(fileName).getInputStream();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource))) {
            return reader.lines()
                    .map(PATTERN::matcher)
                    .filter(Matcher::find)
                    .collect(Collectors.toMap(matcher -> matcher.group(1), matcher -> matcher.group(3).trim()));
        }
    }
}
