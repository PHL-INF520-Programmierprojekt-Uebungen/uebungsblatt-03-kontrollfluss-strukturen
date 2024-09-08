package de.phl.programmingproject.math;

import de.phl.programmingproject.TestBase;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the 'Sum of Digits' exercise in {@link MathHelper#calculateSumOfDigits(int)} and {@link MathHelper#calculateReverseSumOfDigits(int)}
 */
public class SumOfDigitsTest extends TestBase {
    static MathHelper mathHelper = new MathHelper();

    @Test
    void task_1_sum_of_digits(){
        assertEquals(10, mathHelper.calculateSumOfDigits(1234));
        assertEquals(35, mathHelper.calculateSumOfDigits(867194));
    }

    @Test
    void task_2_sum_of_digits_for_867194_printed(){
        this.redirectSystemOut();
        MathHelper.main(null);
        assertTrue(this.getSystemOut().contains("35"),
                "The sum of all digits for '867194' was not printed to the console!");
        this.resetSystemOut();
    }

    @Test
    void task_3_reverse_sum_of_digits(){
        assertTrue(mathHelper.calculateReverseSumOfDigits(10).containsAll(Arrays.asList(514, 1234)),
                String.format("The potential numbers for the sum '10' must contain [514, 1234], but was %s",
                        mathHelper.calculateReverseSumOfDigits(10)));

        assertTrue(mathHelper.calculateReverseSumOfDigits(11).containsAll(Arrays.asList(515, 1235)),
                String.format("The potential numbers for the sum '11' must contain [515, 1235], but was %s",
                        mathHelper.calculateReverseSumOfDigits(11)));

        // check for the first 1000 numbers that the sum of digits is the same as the sum of digits for each reversed number.
        for(int i=0; i < 1000; i++){
            Set<Integer> potentialNumbers = mathHelper.calculateReverseSumOfDigits(i);
            for (Integer potentialNumber : potentialNumbers) {
                assertEquals(i, mathHelper.calculateSumOfDigits(potentialNumber.intValue()),
                        String.format("The reversed numbers for the sum '%d' must contain '%d'!",
                                i, potentialNumber));
            }
        }
    }
}
