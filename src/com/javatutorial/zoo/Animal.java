package com.javatutorial.zoo;

/**
 * This is our base Animal class. All our other animal classes with be extended
 * from this class.
 *
 * This particular class is also 'abstract'. That means that this class cannot
 * directly be instantiated. In other words you cannot create a specific
 * instance of Animal like this.
 * <pre>
 *     Animal a = new Animal("Fred", 4, false);
 * </pre>
 * An abstract class can be thought of as a template to be used by the subclasses.
 */
public abstract class Animal {
    int numberOfLegs;
    boolean hasFur;
    String name;

    public Animal(String n, int legs, boolean fur) {
        this.name = n;
        this.numberOfLegs = legs;
        this.hasFur = fur;
    }

    public void printSummary() {
        System.out.println(name + " has " + numberOfLegs + " legs and " + ((hasFur) ? "fur" : "no fur"));
    }

    /**
     * This is called an abstract method. Note that it has no {} braces. When you see an abstract
     * method that indicates to the developer that if he wants to extend the Animal subclass he
     * MUST implement a makeNoise() method.
     */
    public abstract void makeNoise();
}
