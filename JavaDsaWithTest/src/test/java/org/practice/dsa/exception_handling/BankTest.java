package org.practice.dsa.exception_handling;

import org.junit.jupiter.api.Test;
import org.practice.dsa.exception_handling.bank.BankAccount;
import org.practice.dsa.exception_handling.bank.InsufficientFundException;
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

    @Test
    void testDepositZeroAmount() {
        BankAccount account = new BankAccount(500);
        InvalidAmountException thrown = assertThrows(InvalidAmountException.class, ()->{
            account.deposit(0);
        });
        assertEquals("Deposit amount must be positive.",thrown.getMessage());
    }

    @Test
    void testWithdrawNegativeAmount() {
        BankAccount account = new BankAccount(500);
        InvalidAmountException thrown = assertThrows(InvalidAmountException.class, () -> {
            account.withdraw(-20);
        });
        assertEquals("Withdraw amount must be positive", thrown.getMessage());
    }

    @Test
    void testWithdrawMoreThanBalance() {
        BankAccount account = new BankAccount(500);
        InsufficientFundException thrown = assertThrows(InsufficientFundException.class, ()->{
            account.withdraw(600);
        });
        assertEquals("Insufficient Fund. Available Balance: 500.0",thrown.getMessage());
    }

    @Test
    void testWithdrawZeroAmount() {
        BankAccount account = new BankAccount(500);
        InvalidAmountException thrown = assertThrows(InvalidAmountException.class, ()->{
            account.withdraw(0);
        });
        assertEquals("Withdraw amount must be positive", thrown.getMessage());
    }

    @Test
    void testSuccessfulAmount() {
        BankAccount account = new BankAccount(500);
        assertDoesNotThrow(() -> account.withdraw(300));
        assertEquals(200,account.getBalance());
    }
}
