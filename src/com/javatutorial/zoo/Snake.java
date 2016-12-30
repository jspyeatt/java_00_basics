package com.javatutorial.zoo;

public class Snake extends Animal {
    public Snake(String n) {
        super(n, 0, false);
    }
    @Override
    public void makeNoise() {
        System.out.println("ssssssssssss");
    }
}
