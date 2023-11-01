package de.phl.programmingproject.pizza;

import de.phl.programmingproject.TestUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test class for the 'Pizza Disaster' exercise.
 */
public class PizzaDisasterTest {

    private final static String MARKDOWN_FILENAME = "pizza_disaster.md";
    @Test
    void pizza_disaster_markdown_file_exists_in_root_directory() {
        // check that the file 'pizza_disaster.md' exists in the root directory of the project
        // (i.e. in the root or  'src' directory)
        assertTrue(TestUtils.fileExistsInRootOrSrcDirectory(MARKDOWN_FILENAME), String.format("The file '%s' does not exist in the root (or './src') directory of the project.", MARKDOWN_FILENAME));
    }

    /**
     * Gets the content of the 'pizza_disaster.md' file from the root or src directory.
     * @return
     */
    private String getPizzaDisasterMarkdownContent(){
        // load the 'pizza_disaster.md' file from the source directory
        if(!TestUtils.fileExistsInRootOrSrcDirectory(MARKDOWN_FILENAME)){
            fail(String.format("The file '%s' does not exist in the root (or './src') directory of the project.", MARKDOWN_FILENAME));
        }
        Path p1 = Paths.get(TestUtils.WORKING_DIRECTORY, MARKDOWN_FILENAME);
        Path p2 = Paths.get(TestUtils.WORKING_DIRECTORY, "./src/"+MARKDOWN_FILENAME);
        Path path = Files.exists(p1) ? p1 : p2;
        // load content of the file
        String txt;
        try {
            txt = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return txt;
    }

    /**
     * Tests that the exception message of the original (incorrect) program is included in the answer.
     */
    @Test
    void task_1_exception_correctly_identified(){
        String txt = getPizzaDisasterMarkdownContent();
        assertTrue(txt.contains("An error occurred: Error cooking pizza: Dough ingredients are not mixed properly"),
                "The error message of the exceptions that the original program throws is not included in your answer.");
    }

    /**
     * Tests that the output of the corrected program is included in the answer.
     */
    @Test
    void task_5_corrected_output_identified(){
        String txt = TestUtils.getFileContentForFileInRootOrSrcDirectory(MARKDOWN_FILENAME);
        String[] lines = txt.split("\n");
        Pattern pattern = Pattern.compile("Pizza\\{dough\\=.*Dough.*\\, ingredient7\\='tomato sauce', ingredient8\\='cheese', temperature\\=425\\}");
        assertTrue(txt.contains("Pizza is done"), "Your answer does not contain the output of the corrected program.");
        for (String line : lines) {
            if(pattern.matcher(line).find()){
                return;
            }
        }
        fail("Your answer does not contain the output of the corrected program.");
    }
}
