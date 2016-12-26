package com.javatutorial.banking;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(double balance, double withdrawlAmount) {
        super("You tried to withdrawl " + withdrawlAmount + " from an account that only has " + balance);
    }
}
