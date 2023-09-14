package de.phl.programmingproject.math;

import de.phl.programmingproject.TestBase;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the 'NumberGuesser' exercise in {@link de.phl.programmingproject.math.NumberGuesser
 */
public class NumberGuesserTest extends TestBase {
    @Test
    void number_guesser_source_code_contains_snippets(){
        String content;
        try {
            content = new String(Files.readAllBytes(new File("src/main/java/de/phl/programmingproject/math/NumberGuesser.java").toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        content = content.toLowerCase();
        assertTrue(content.contains("do {") || content.contains("do{"),
                "The 'do-while' loop is missing. Please use a 'do-while' loop to implement the guessing game.");
        assertTrue(content.contains("too high") || content.contains("zu hoch"), "The output 'too high'/'zu hoch' is missing. Please print 'too high'/'zu hoch' if the user's guess is too high.");
        assertTrue(content.contains("too low") || content.contains("zu niedrig"), "The output 'too low'/'zu niedrig' is missing. Please print 'too low'/'zu niedrig' if the user's guess is too low.");

    }

}
