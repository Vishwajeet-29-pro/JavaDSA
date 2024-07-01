package org.practice.dsa.exception_handling.bank;

public class InvalidAmountException extends Exception {
    public InvalidAmountException(String message){
        super(message);
    }
}
