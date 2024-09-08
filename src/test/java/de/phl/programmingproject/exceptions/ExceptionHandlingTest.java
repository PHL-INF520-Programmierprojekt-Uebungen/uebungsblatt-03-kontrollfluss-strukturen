package de.phl.programmingproject.exceptions;

import de.phl.programmingproject.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the exercise 'Exception Handling'.
 */
public class ExceptionHandlingTest {

    private static final String MARKDOWN_FILENAME = "exception_handling.md";
    @Test
    void exception_handling_markdown_file_exists_in_root_directory() {
        // check that the file 'exception_handling.md' exists in the root directory of the project
        // (i.e. in the root or  'src' directory)
        assertTrue(TestUtils.fileExistsInRootOrSrcDirectory(MARKDOWN_FILENAME), "The file '"+MARKDOWN_FILENAME+"' does not exist in the root (or './src') directory of the project.");
    }

    @Test
    void task_1_output_correctly_identified(){
        TestUtils.assertFileContentMatchesRegex(MARKDOWN_FILENAME,
                "Done with division\n" +
                        "End of program\n" +
                        "Result is: 50",
                "The expected output of the program is not included in your answer.");
    }
}
