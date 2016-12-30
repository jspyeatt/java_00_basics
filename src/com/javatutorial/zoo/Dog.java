package com.javatutorial.zoo;

public class Dog extends Animal {

    /**
     * This is the constructor for Dog.
     *
     * Notice 2 things:
     * <ol>
     *     <li>The constructor only takes one argument (name)</li>
     *     <li>It calls this constructor `super`. What's that? super indicates that it is going
     *     to call the constructor of its parent class. In this case, the Animal class. So this
     *     line of code is calling the Animal constructor and we are just passing in the number
     *     of legs and fur attribute for all dogs the same way.</li>
     * </ol>
     * @param name
     */
    public Dog(String name) {
        super(name, 4, true);
    }

    /**
     * Here is our implementation of the Animal class's abstract makeNoise() method. Now that
     * we have an actual implementation of makeNoise() it is called a concrete method.
     */
    @Override
    public void makeNoise() {
        System.out.println("Bark!");
    }
}
