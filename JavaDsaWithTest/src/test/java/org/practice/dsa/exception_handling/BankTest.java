package org.practice.dsa.exception_handling;

import org.junit.jupiter.api.Test;
import org.practice.dsa.exception_handling.bank.BankAccount;
import org.practice.dsa.exception_handling.bank.InvalidAmountException;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @Test
    void testCreateAccountWithNegativeInitialBalance() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount(-100);
        });
        assertEquals("Initial Balance cannot be negative.", thrown.getMessage());
    }

    @Test
    void testCreateAccount() {
        BankAccount account = new BankAccount(500);
        assertEquals(500, account.getBalance());
    }

    @Test
    void testDepositNegativeAmountToAccount() {
        BankAccount account = new BankAccount(500);
        InvalidAmountException thrown = assertThrows(InvalidAmountException.class, () -> {
            account.deposit(-200);
        });
        assertEquals("Deposit amount must be positive.", thrown.getMessage());
    }

    @Test
    void testSuccessOnDepositAmount() {
        BankAccount account = new BankAccount(500);
        assertDoesNotThrow(()-> account.deposit(500));
        assertEquals(1000, account.getBalance());
    }
}
