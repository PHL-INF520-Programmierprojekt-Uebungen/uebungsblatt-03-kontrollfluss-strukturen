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
        TestUtils.assertFileExistsInRootOurSrcDirectory(MARKDOWN_FILENAME);
    }

    /**
     * Tests that the exception message of the original (incorrect) program is included in the answer.
     */
    @Test
    void task_1_exception_correctly_identified(){
        TestUtils.assertFileContentMatchesRegex(MARKDOWN_FILENAME,
                ".*Error cooking pizza: Dough ingredients are not mixed properly.*",
                "The error message of the exceptions that the original program throws is not included in your answer.",
                false);
    }

    /**
     * Tests that the output of the corrected program is included in the answer.
     */
    @Test
    void task_5_corrected_output_identified() {
        TestUtils.assertFileContentMatchesRegex(MARKDOWN_FILENAME,
                ".*Pizza is done.*",
                "Your answer does not contain the output of the corrected program.");
        TestUtils.assertFileContentMatchesRegex(MARKDOWN_FILENAME,
                ".*Pizza\\{dough\\=.*Dough.*\\, ingredient7\\='tomato sauce', ingredient8\\='cheese', temperature\\=425\\}.*",
                "Your answer does not contain the output of the corrected program.",
                false);
    }
}
