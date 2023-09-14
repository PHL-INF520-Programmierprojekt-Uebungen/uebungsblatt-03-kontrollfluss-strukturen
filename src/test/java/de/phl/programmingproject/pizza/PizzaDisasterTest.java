package de.phl.programmingproject.pizza;

import de.phl.programmingproject.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for the 'Pizza Disaster' exercise.
 */
public class PizzaDisasterTest {
    @Test
    void pizza_disaster_markdown_file_exists_in_root_directory() {
        // check that the file 'pizza_disaster.md' exists in the root directory of the project
        // (i.e. in the root or  'src' directory)
        assertTrue(TestUtils.fileExistsInRootOrSrcDirectory("pizza_disaster.md"), "The file 'pizza_disaster.md' does not exist in the root (or './src') directory of the project.");
    }
}
