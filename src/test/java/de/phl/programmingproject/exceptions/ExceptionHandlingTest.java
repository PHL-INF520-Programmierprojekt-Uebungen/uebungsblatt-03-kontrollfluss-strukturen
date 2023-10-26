package de.phl.programmingproject.exceptions;

import de.phl.programmingproject.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the exercise 'Exception Handling'.
 */
public class ExceptionHandlingTest {

    @Test
    void exception_handling_markdown_file_exists_in_root_directory() {
        // check that the file 'exception_handling.md' exists in the root directory of the project
        // (i.e. in the root or  'src' directory)
        assertTrue(TestUtils.fileExistsInRootOrSrcDirectory("exception_handling.md"), "The file 'exception_handling.md' does not exist in the root (or './src') directory of the project.");
    }
}
