package com.javatutorial;

import java.util.ArrayList;

public class CollectionsExample {
    public static void main(String[] args) {
        ArrayList<String> listOfJedi = new ArrayList<String>();

        // Add to the list of Jedi
        listOfJedi.add("Yoda");
        listOfJedi.add("Mace Windoo");
        listOfJedi.add("Luke Skywalker");
        listOfJedi.add("Anikin Skywalker");
        listOfJedi.add("Qui-Gon Jinn");
        listOfJedi.add("Obi-Wan Kenobi");

        // print them out using the for loop shortcut
        System.out.println("All Jedi ---------");
        for (String jedi: listOfJedi) {
            System.out.println("Jedi " + jedi);
        }

        // If I want to remove Anikin because he went to the dark side I can do it
        // one of two ways: 1) Since I KNOW he was the fourth added to the list
        // I could do a listOfJedi.remove(3);
        // Or I could reference him by name.
        listOfJedi.remove("Anikin Skywalker");

        // be careful when using the second method, this way relies on an accurate
        // definition of the equals() method described earlier.
        System.out.println("Good Jedi ---------");
        for (String jedi: listOfJedi) {
            System.out.println("Jedi " + jedi);
        }
    }
}
