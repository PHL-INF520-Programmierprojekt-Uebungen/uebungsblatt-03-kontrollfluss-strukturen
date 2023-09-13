package de.phl.programmingproject.fizzbuzz;

import de.phl.programmingproject.TestBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the 'FizzBuzz' exercise in {@link FizzBuzz}.
 */
public class FizzBuzzTest extends TestBase {

    @Test
    void test_fizzbuzz(){
        this.redirectSystemOut();
        FizzBuzz.main(null);
        String output = this.getSystemOut() ;
        String expected = "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz";
        assertTrue(output.replaceAll("\n", "").replaceAll(" ","").contains(expected.replaceAll(" ", "")),
                String.format("The output of 'FizzBuzz' must contain '%s', but was \n%s",
                        expected, output));
        this.resetSystemOut();
    }
}
