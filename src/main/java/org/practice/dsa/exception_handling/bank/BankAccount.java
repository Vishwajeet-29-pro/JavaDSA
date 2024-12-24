package org.practice.dsa.exception_handling.bank;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance){
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial Balance cannot be negative.");
        }
        this.balance = initialBalance;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println("Deposited. "+amount);
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdraw amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundException("Insufficient Fund. Available Balance: "+balance);
        }
        balance -= amount;
        System.out.println("Withdrew: "+amount);
    }

    public double getBalance(){
        return balance;
    }
}
