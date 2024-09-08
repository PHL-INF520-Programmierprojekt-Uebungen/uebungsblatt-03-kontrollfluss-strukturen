package de.phl.programmingproject.exceptions;

import de.phl.programmingproject.TestBase;
import de.phl.programmingproject.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the 'Bank Account Exception' exercise in {@link de.phl.programmingproject.exceptions.BankAccount}.
 */
public class BankAccountTest extends TestBase {

    @Test
    void task_1_deposit_with_negative_amount_throws_IllegalArgumentException() {
        BankAccount account = new BankAccount(100);
        // assert that the 'deposit' method throws an 'IllegalArgumentException' is thrown for negative arguments
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-1));
    }

    @Test
    void task_1_withdraw_with_negative_amount_throws_IllegalArgumentException() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-1));
    }


    @Test
    void task_1_InsufficientFundException_implemented() {
        try {
            Class<Exception> insufficientFundExceptionExists = (Class<Exception>) Class.forName("de.phl.programmingproject.exceptions.InsufficientFundsException");
        } catch (ClassNotFoundException e) {
            fail(String.format("class '%s' not implemented in the '%s' package", "InsufficientFundsException", "de.phl.programmingproject.exceptions"));
        }
    }
    @Test
    void task_3_main_method_handles_exception_for_deposit_with_negative_arguments(){
        String out = TestUtils.runActionAndGetSystemOut(() -> BankAccount.main(null));
        assertTrue(out.contains("java.lang.IllegalArgumentException: Amount to deposit must be positive!"), "The 'IllegalArgumentException' thrown by the 'deposit' method is not handled correctly.");
    }

    @Test
    void task_4_main_method_updates_balance_after_deposit_500(){
        String out = TestUtils.runActionAndGetSystemOut(() -> BankAccount.main(null));
        assertTrue(out.contains("1500"), "The balance after depositing 500 is not printed correctly.");
    }

    @Test
    void task_5_main_method_handles_exception_for_withdraw_with_negative_arguments(){
        String out = TestUtils.runActionAndGetSystemOut(() -> BankAccount.main(null));
        assertTrue(out.contains("java.lang.IllegalArgumentException: Amount to withdraw must be positive!"), "The 'IllegalArgumentException' thrown by the 'withdraw' method is not handled correctly.");
    }

    @Test
    void task_6_main_method_handles_InsufficientFundsException_for_withdraw_with_too_high_amount(){
        String out = TestUtils.runActionAndGetSystemOut(() -> BankAccount.main(null));
        assertTrue(out.contains("de.phl.programmingproject.exceptions.InsufficientFundsException: Insufficient funds for withdrawal!"), "The 'InsufficientFundsException' thrown by the 'withdraw' method is not handled correctly.");
    }

    @Test
    void task_7_main_method_updates_balance_after_withdraw_500(){
        String out = TestUtils.runActionAndGetSystemOut(() -> BankAccount.main(null));
        assertTrue(out.contains("500"), "The balance after depositing 500 is not printed correctly.");
    }

}
