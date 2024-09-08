package de.phl.programmingproject.math;

import de.phl.programmingproject.TestBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the exercise 'Prime Number Sum' in {@link MathHelper#isPrime}
 */
public class PrimeNumberSumTest extends TestBase {

    static int[] primeNumbers = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71};

    @Test
    void task_1_is_prime_number() {
        MathHelper mathHelper = new MathHelper();
        for (int primeNumber : primeNumbers) {
            assertTrue(mathHelper.isPrime(primeNumber), String.format("%d is a prime number!", primeNumber));
        }
    }

    @Test
    void task_3_sum_of_first_twenty_prime_numbers_printed() {
        this.redirectSystemOut();
        MathHelper.main(null);
        assertTrue(this.getSystemOut().contains("639"));
        this.redirectSystemOut();
    }
}
