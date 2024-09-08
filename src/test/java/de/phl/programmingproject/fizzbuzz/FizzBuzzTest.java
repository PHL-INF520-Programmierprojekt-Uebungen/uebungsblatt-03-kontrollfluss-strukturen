package de.phl.programmingproject.fizzbuzz;

import de.phl.programmingproject.TestBase;
import de.phl.programmingproject.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the 'FizzBuzz' exercise in {@link FizzBuzz}.
 */
public class FizzBuzzTest extends TestBase {

    @Test
    void test_fizzbuzz(){
        String expected = "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz";
        TestUtils.assertSystemOutMatchesRegex(() -> FizzBuzz.main(null),
                "(?s)"+expected.replaceAll(" ", ".*"),
                String.format("The output of 'FizzBuzz' is not correct. It must contain '%s'", expected));
    }
}
