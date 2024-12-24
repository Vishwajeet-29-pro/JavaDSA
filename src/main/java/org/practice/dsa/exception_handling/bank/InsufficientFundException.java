package org.practice.dsa.exception_handling.bank;

public class InsufficientFundException extends Exception{
    public InsufficientFundException(String message){
        super(message);
    }
}
