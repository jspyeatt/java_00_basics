package com.javatutorial.banking;

public class Account {
    String accountName;
    double balance;

    public Account(String name, double initialAmount) {
        accountName = name;
        balance = initialAmount;
    }

    public void printCurrentBalance() {
        System.out.println("The account: " + accountName + " currently has " + balance + " dollars in it.");
    }

    /**
     * Deposit into the account.
     *
     * @param amount amount to deposit.
     * @return new account balance.
     */
    public double deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("You cannot deposit a negative number. " + amount);
        }
        // add the amount deposited to the balance, then return the new balance.
        balance += amount;
        return balance;
    }

    /**
     * Withdrawl from the account.
     * @param amount
     * @return
     */
    public double withdrawl(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(balance, amount);
        }
        // subtract the amount to be withdrawn and return the new balance.
        balance -= amount;
        return balance;
    }

    public static void main(String[] args) throws InsufficientFundsException {
        Account acct1 = new Account("Fred's", 1000.0);
        Account acct2 = new Account("Steve's", 2000.0);

        acct1.printCurrentBalance();
        acct2.printCurrentBalance();

        acct1.deposit(100.0);
        try {
            acct2.withdrawl(50.0);
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }
        acct1.printCurrentBalance();
        acct2.printCurrentBalance();

        // whoa. What does it mean to deposit a negative amount?

        acct2.withdrawl(4000.0);
        acct1.deposit(-200.0);
        acct1.printCurrentBalance();
        acct2.printCurrentBalance();
    }
}
