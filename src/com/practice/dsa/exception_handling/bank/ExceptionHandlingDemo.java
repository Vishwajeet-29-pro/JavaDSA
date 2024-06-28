package com.practice.dsa.exception_handling.bank;

public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);

        try {
            bankAccount.deposit(-500);
        } catch (InvalidAmountException e) {
            System.out.println("Exception: "+e.getMessage());
        }

        try {
            bankAccount.withdraw(2000);
        } catch (InsufficientFundException | InvalidAmountException e ) {
            System.out.println("Exception: "+e.getMessage());
        }

        try {
            bankAccount.deposit(500);
            System.out.println("New Balance: "+bankAccount.getBalance());
        } catch (InvalidAmountException e){
            System.out.println("Exception: "+e.getMessage());
        } finally {
            System.out.println("Deposit Transaction Completed.");
        }

        try {
            bankAccount.withdraw(500);
            System.out.println("New balance: "+bankAccount.getBalance());
        } catch (InsufficientFundException | InvalidAmountException e){
            System.out.println("Exception: "+e.getMessage());
        } finally {
            System.out.println("Withdraw Transaction completed.");
        }
    }
}
