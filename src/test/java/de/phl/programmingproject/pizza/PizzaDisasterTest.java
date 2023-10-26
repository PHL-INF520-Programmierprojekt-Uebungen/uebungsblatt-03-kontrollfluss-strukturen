package de.phl.programmingproject.pizza;

import de.phl.programmingproject.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    @Test
    void task_1_output_correctly_identified(){
        // load the 'pizza_disaster.md' file from the source directory
        String fileName = "pizza_disaster.md";
        if(!TestUtils.fileExistsInRootOrSrcDirectory(fileName)){
            fail(String.format("The file '%s' does not exist in the root (or './src') directory of the project.", fileName));
        }
        Path p1 =
        // load content of the file
        return new String(Files.readAllBytes(Paths.get()), StandardCharsets.UTF_8);


        String txt = "";
        assertTrue(txt.contains("An error occurred: Error cooking pizza: Dough ingredients are not mixed properly"));
    }
}
