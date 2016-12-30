# Classes and Objects
In this section we are making our first of two big leaps forward
in programming. Up until now we've been working with the most primitive
elements of the language (variables) and how to affect execution
(conditionals and looping). Now we are going to change directions 
a bit and start working with how to logically model things in a program.
This is a big section, so hang in there.

Java is what's called an object-oriented (OO) language. In OO languages
you can create software elements that contain attributes and behaviors
similar to real world things. In OO languages these software elements are
called Classes and instances of these classes are called Objects. You've 
already done a little work with Objects earlier when we worked with `String`s.

Classes typically represent things that can be described as nouns. For
example, I could create a class called Dog and this class could have
the attributes: color, weight, breed, male and name.

## Creating a Class
In IntelliJ, to create a Dog class do the following:

1. Hit Alt+1 to make certain the Project Window is visible.
1. Right click on the com.javatutorial folder and select New -> Java Class.
1. Enter the word Dog and click OK. You should now have a file that looks
   like this:
   
```java
package com.javatutorial;

public class Dog {
}
```
This is the most basic class you can create. It doesn't do anything yet. Let's 
add the attributes we described earlier.

```java
package com.javatutorial;

// declare the class Dog
public class Dog {
    // In this section we've declared attributes for a dog.
    String color;
    String breed;
    String name;
    int weight;
    boolean male;
}
```
## Creating an Instance of a Class
So now that we've declared what a Dog's attributes are, how do we create
instances of the Dog class?

```java
// create an instance of a dog.
Dog dogA = new Dog();
// now assign values to the attributes of the dog.
dogA.color = "brown";
dogA.breed = "lab";
dogA.name = "Spock";
dogA.weight = 100;
dogA.male = true;

// create another instance of a dog;
Dog dogB = new Dog();
dogB.color = "white";
dogB.breed = "spaniel";
dogB.name = "Snoopy";
dogB.weight = 20;
dogB.male = false;
```
Now I've created two instances of `Dog`. That seems like a lot of lines of
code just to create a dog. Fortunately most OO languages have the notion of
constructors. Constructors allow you to define how you want to create instances
of classes. Here is a new version of the Dog class with a useful constructor.

```java
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
}
```

Now if I want to create instances of the same dogs I did earlier I can
do it in 2 lines of code instead of the 12 it took before.

```java
Dog dogA = new Dog("brown", "lab", "Spock", 100, true);
Dog dogB = new Dog("white", "spaniel", "Snoopy", 20, false);
```

## methods
As I mentioned earlier, Classes and Objects model things and as such are typically
nouns. But things are only half the story. Things have behavior and actions. These 
are usually associated with verbs. And in OO are represented in methods.

Methods give action to objects. Methods in Java have four components:

1. a name
1. a list of arguments
1. an optional return type
1. the method body. What gets executed.

The structure of a method looks something like this:

*return type* **methodName**(argument1, argument2 ...) {
}

So if we wanted to write a `bark` method it might look something like this:
```java
public void bark() {
    if (weight > 50) {
        System.out.println(name + " says WOOF!!!");
    } else {
        System.out.println(name + " says yip");
    }
}
```
At this point I'm going to finish off our Dog class below. Copy this code
into your Dog class, then click on Shift+Cntl+F10.

```java
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
```
If you run this program you should see the output is.
```
Spock says WOOF!!!
Snoopy says yip
```

Methods are really where OO languages get their power. It is possible
to model very complex behavior in methods that work for the caller without
the caller having to know the details how work gets accomplished.

Remember earlier I said methods can have arguments and optional return
types. Our `bark()` method had neither. We passed in no arguments and its
return type was `void` indicating it didn't return a value. But let's look
at some methods that do take arguments.

Let's say I have a class that represents a wheel. For now let's just say
this wheel has a radius (attribute). Let's also say we can roll the wheel
at a certain RPM, we can roll it at that RPM for a certain amount of
 time and we can drop it from a height.

So if I can roll the wheel at a certain RPM, and I know its radius I should
be able to calculate it's speed. And if I know what height I am dropping
the wheel from I should be able to figure out when it will hit the ground.
So what might this wheel and its roll and drop methods look like in a class.

Perform the following steps:
1. Hit Alt+1 to expose the Project Window
1. Right click on com.javatutorial and select New -> Java Class. Type in Wheel
1. Paste in the code below then hit Shift+Cntl+F10.

```java
package com.javatutorial;

// declaring our Wheel class
public class Wheel {
    // the only attribute we are setting is the radius.
    double radiusInMeters;

    /**
     * Create a wheel with a certain radius
     * @param r radius in meters
     */
    public Wheel(double r) {
        radiusInMeters = r;
    }

    @Override
    public String toString() {
        return "Wheel[" + radiusInMeters + "]";
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || (o instanceof Wheel) == false) {
            return false;
        }
        Wheel b = (Wheel) o;
        return radiusInMeters == b.radiusInMeters;
    }
    /**
     * Calculate the speed in meters per second if you roll the wheel at a certain RPM
     * @param rpm revolutions per minute
     * @return speed in meters per second.
     */
    public double getSpeedInMPS(int rpm) {

        // this is 2 * pi * radius * rpm then we divid by 60 to get rate in seconds instead of minutes.
        double speed = (2.0 * 3.141592 * radiusInMeters) * rpm / 60.0;
        return speed;
    }

    /**
     * Get the distance the wheel travels given an RPM and how long to roll
     * @param rpm revolutions per minute
     * @param timeInSecs amount of time to roll
     * @return distance in meters
     */
    public double getDistanceTraveled(int rpm, int timeInSecs) {

        // note we are just calling our speed function then multiplying it by our duration.
        return getSpeedInMPS(rpm) * timeInSecs;
    }

    /**
     * Calculate how long a wheel will drop until it hits the ground given a height of the drop and assuming
     * no friction.
     *
     * @param heightInMeters height we will drop from.
     * @return time in seconds until it hits the ground.
     */
    public double drop(double heightInMeters) {
        // putting the word final in here means it is a constant. In this case, the acceleration of gravity.
        final double gravity = 9.8;

        // Math.sqrt is the square root function. This comes with the java language.
        return Math.sqrt(2.0 * heightInMeters/gravity);
    }

    public static void main(String[] args) {
        Wheel w1 = new Wheel(100);
        Wheel w2 = new Wheel(15);
        System.out.println("At 50 rpm wheel 1 goes " + w1.getSpeedInMPS(50) + " at wheel 2 goes " + w2.getSpeedInMPS(50));

        System.out.println("Wheel 1 at 70 rpm for 8 seconds goes this far " + w1.getDistanceTraveled(70,8));
        System.out.println("Wheel 2 at 200 rpm for 12 seconds goes this far " + w2.getDistanceTraveled(200, 12));

        System.out.println("Dropping a wheel from 500 meters takes this long to hit the ground " + w1.drop(500));
    }
}

```
When you run this you should see output that looks like this.
```
At 50 rpm wheel 1 goes 523.5986666666666 at wheel 2 goes 78.5398
Wheel 1 at 70 rpm for 8 seconds goes this far 5864.305066666667
Wheel 2 at 200 rpm for 12 seconds goes this far 3769.9103999999998
Dropping a wheel from 500 meters takes this long to hit the ground 10.101525445522107
```
## Some Special Methods
There are a few special methods in Java that are quite handy/necessary.
### toString()
For every single class you create you can create a toString() method. This
method tells the system how to convert an instance of a class to a string
for viewing. For example, you will note in our Wheel class you will see the code
```java
public String toString() {
   return "Wheel[" + radiusInMeters + "]";
}
```
So if you every run a 
```java
Wheel wheel = new Wheel(50);
System.out.println("Here's my wheel " + wheel);
```
The output in this case would be
```
Here's my wheel Wheel[50]
```
toString() is really useful when writing object information to logs
or when debugging your code. And it's important to control that output
as well. For example, let's say you have a User class for your e-commerce
system. A user might have a name, an email address, an account id and a
password. Well you might want to write the toString() method to print
out only the name and email address and not print the password or account
number.

### equals()
Sometimes you want to check to see if two objects are equal. With primatives
like int, float, long and double you would just use the `==` comparison to
check for equality. But those are primatives and comparing their values
is pretty straight forward. But what about objects. When are objects considered
equal? That depends. If we have a User class as described above is it enough
to say two instances of User are equal if their names match? Probably not.
You'd probably want to make certain all of the fields match. So our User class
with an equals() method would look something like this.

```java
public class User {
    String name;
    String email;
    String password;
    int accountId;
    
    @Override
    public boolean equals(Object o) {
        // we have to cast the o to a User instance.
        User b = (User) o;
        // if the names are equal, the email is equal and the account ids are the same
        if (name.equals(o.name) && email.equals(b.email) && accountId == b.accountId) {
            return true;
        }
        return false;
    }
}
```
So then to compare two Users our code might look like this:
```java
User u1 = new User("John", "john@example.com", "p@ssword", 123123);
User u2 = new User("Sam", "sam@example.com", "changeMe", "432432");
if (u1.equals(u2)) {
    System.out.println("Users are the same.");
} else {
    System.out.println("Users are different.");
}
```

**VERY IMPORTANT** Note that when comparing primatives for equality we use `==`
but when comparing objects for equality we use `equals()`

## Inheritance
The last thing we will discuss in this section is the notion of inheritance. Java, as mentioned
earlier is an object-oriented language. Inheritance allows you to create new objects by *inheriting*
attributes and behavior from other classes. We will use a lot of inheritance when we build the Breakout
game. For now we will just make a glancing blow over the topic.

Classes, as discussed earlier, have attributes. This is called the "has-a" relationship. A car "has-a" horn.
A game "has-a" ball. Inheritance has an "is-a" relationship. For example, a dog "is-a" animal. So is a snake.
So is a chicken. Let's show how to create an Animal class and then create a dog, snake and chicken sub-class.

1. Hit Alt+1 to bring up the Project window.
1. Right click on the com.javatutorial folder and select New->Package. Enter zoo.
1. Right click on the zoo folder and select New->Java Class. Enter Animal and paste the following
into the Animal.java file.

```java
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
```

Now let's extend the Animal class to create a Dog class.
1. Alt+1 to make certain the Project Window is open.
1. Right-click on the zoo folder and select New->Java Class. Enter Dog.
1. Now change the line:
```
public class Dog {
```
to this
```
public class Dog extends Animal {
```
When you do this you will notice that IntelliJ highlights the line in red indicating an error
exists. The error is because you've extended the Animal class but have not implemented the abstract
makeNoise() method. If you hover over the red line with your mouse and hit Cntl+I it will ask you
if you want to implement the abstract makeNoise() method. Click OK.

Your Dog.java file should now look like this:
```java
package com.javatutorial.zoo;

public class Dog extends Animal {

    @Override
    public void makeNoise() {
        
    }
}
```
You still have a red line appearing. That's because we haven't implemented a constructor
for the Dog class. Let's finish off the Dog class.
```java
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
```

Now let's create a Chicken class
1. Alt+1
1. Right-click on the zoo folder and select New->Java Class. Enter Chicken. And paste the following
in Chicken.java.
```java
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
```

Now let's create a Snake class
1. Alt+1
1. Right-click on the zoo folder and select New->Java Class. Enter Snake. And paste the following
in Snake.java.
```java
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
```

Finally let's create a Zoo class and run the Zoo program.
1. Alt+1
1. Right-click on the zoo folder. Select New-> Java Class. Enter Zoo and paste the following
into the Zoo.java file.
```java
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
```
Now let's run it.
1. Shift+Cntl+F10
The output will look like this:
```
Bark!
Cluck
ssssssssssss
Snoopy has 4 legs and fur
Foghorn Leghorn has 2 legs and no fur
Ka has 0 legs and no fur
```

We went over an **ENORMOUS** amount of stuff here. There's a lot more to learn
about classes. We will pick them up again later when we start working with the graphics
library for java.

In the [next section](TUTORIAL_07_COLLECTIONS.md) we will go over collections and arrays.