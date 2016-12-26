package com.javatutorial;

public class ConditionalExample {
    public static void main(String[] args) {
        int age = 18;
        boolean male = true;

        // if over the age of 17 and male
        if (male && age > 17) {
            System.out.println("You are an adult man.");

        // if male and both age greater that 12 AND age less than 18
        } else if (male && (age > 12 && age < 18)) {
            System.out.println("You are a teenage boy.");

        // if male and both age less than or equal to 12 AND age greater than 1
        } else if (male && (age <= 12 && age > 1)) {
            System.out.println("You are a young boy.");

        // if male and age less than or equal to 1
        } else if (male && age <= 1) {
            System.out.println("You are an infant boy");

        // if it isn't a male, it's a female.
        } else if (male == false) {
            System.out.println("You are female.");
        }
    }
}
