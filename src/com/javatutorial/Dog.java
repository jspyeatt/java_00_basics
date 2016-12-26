package com.javatutorial;

// declare the class Dog
public class Dog {
    // In this section we've declared attributes for a dog.
    String color;
    String breed;
    String name;
    int weight;
    boolean male;

    /**
     * This is the main constructor to create a dog.
     *
     * It takes 5 arguments. When the constructor is executed
     * you will have a dog instance with all of its attributes
     * populated.
     * @param c color of the dog
     * @param b breed of the dog
     * @param n the dog's name
     * @param w the dog's weight in pounds
     * @param m set to true if it is a male dog.
     */
    public Dog(String c, String b, String n, int w, boolean m) {
        color = c;
        breed = b;
        name = n;
        weight = w;
        male = m;
    }
    public void bark() {
        // if it's a big dog, make a big sound.
        if (weight > 50) {
            System.out.println(name + " says WOOF!!!");
        // otherwise make a small sound.
        } else {
            System.out.println(name + " says yip");
        }
    }
    public static void main(String[] args) {
        // create two instances of Dog
        Dog dogA = new Dog("brown", "lab", "Spock", 100, true);
        Dog dogB = new Dog("white", "spaniel", "Snoopy", 20, false);

        // have each dog bark
        dogA.bark();
        dogB.bark();
    }
}
