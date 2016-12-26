package com.javatutorial;

import java.util.ArrayList;

public class DebuggingExample {
    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<String>();
        data.add("Mickey");
        data.add("Minnie");
        data.add("pluto");
        data.add("Donald");
        data.add("Goofy");

        for (String name: data) {
            if (name.equals("Goofy") || name.equals("Pluto")) {
                System.out.println(name + " is a dog.");
            } else {
                System.out.println(name + " is not a dog.");
            }
        }
    }
}
