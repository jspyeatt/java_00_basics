package com.javatutorial;

public class LoopExample {
    public static void main(String[] args) {
        int year = 0;
        double balance = 1000.0;
        double interestRate = 0.05;
        while (balance < 1200.0) {
            System.out.println("year = " + year + " balance = " + balance);
            balance = balance + (balance * interestRate);
            year++;
        }
        System.out.println("Final number of years = " + year + " final balance = " + balance);

        int fibo1 = 0;   // second most recent fibonacci number
        int fibo2 = 1;   // most recent fibonacci number
        while (true) {
            int newValue = fibo1 + fibo2;     // calculate the new fibonacci value
            fibo1 = fibo2;                    // assign the most recent number in the
            // sequence to the second most recent number
            fibo2 = newValue;                 // assign the most recent number the new value

            System.out.println("fibo1 = " + fibo1 + " fibo2 = " + fibo2);

            // if our new value is greater than 50, exit the loop
            if (fibo2 > 50) {
                break;
            }
        }

        for (int i = 0; i < 30; i++) {
            if (i % 3 != 0) {
                continue;
            }
            System.out.println(i + " is divisible by 3");
        }
    }
}
