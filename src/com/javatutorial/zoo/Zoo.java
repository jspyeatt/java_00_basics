package com.javatutorial.zoo;
public class Zoo {
    public static void main(String[] args) {
        // first thing to notice is that a1, a2 and a3 are defined as Animal variables
        // yet the constructors are for Dog, Chicken and Snake. We can do this because
        // Dog, for example 'is-a' Animal. We couldn't do the reverse and say
        //    Dog d1 = Animal("Snoopy", 4, true); because an Animal isn't necessarily
        // a dog.
        Animal a1 = new Dog("Snoopy");
        Animal a2 = new Chicken("Foghorn Leghorn");
        Animal a3 = new Snake("Ka");

        // notice each of these makeNoise() and printSummary() calls look the same, but their outcomes
        // are different.
        a1.makeNoise();
        a2.makeNoise();
        a3.makeNoise();
        a1.printSummary();
        a2.printSummary();
        a3.printSummary();
    }
}
