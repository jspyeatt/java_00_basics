package com.javatutorial.zoo;

public class Chicken extends Animal {
    public Chicken(String n) {
        super(n, 2, false);
    }
    @Override
    public void makeNoise() {
        System.out.println("Cluck");
    }
}
