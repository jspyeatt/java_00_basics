# Collections and Arrays
Collections and arrays are a way of grouping similar data values into
one variable name. We are going to talk mostly about collections in this
section with only a small amount about arrays.

What problems do collections solve? Let's consider a simple example. Let's say
you wanted to create a class called `Family`. A family has a surname, a father's
name, a mother's name and the names of the children. But how many children? I
suppose you could do it like this:

```java
public class Family {
    String surname;
    String fatherName;
    String motherName;
    String child1;
    String child2;
    String child3;
    String child4;
    String child5;
}
```
What if the family has no children? What if they have 6 children?

Collection provide an better solution. They allow you to create one
variable name: `children` and let you add and delete as you choose.

Collections come in three basic forms: Lists, Sets and Maps.

## Lists
The most common Collection type is a list. As you add elements to a list
it just keeps growing. There are several types of lists in basic Java.
The most common is the `ArrayList`. To define our children example above
we would substitute the child1..child5 definitions with this:

```java
ArrayList<String> children = new ArrayList<String>();
```
So the above statement is defining a variable `children` which is an ArrayList.
The <String> portion means that we can only store Strings in the list.

So to change the contents of the children list:

```java
// add elements to the list
children.add("Rick");
children.add("Randy");
children.add("Ron");

// get the second element of the list. NOTE: All arrays and lists in Java
// are 0-based. So the first element in a list is in position 0. The second
// element in a list is in position 1 and so on.
String secondChild = children.get(1);

children.isEmpty();   // would return true if the list is empty
children.size();      // number of elements in the list. In this case  3.
children.remove(2);   // remove the third element from the list. Rick and Randy
                      // are all that are left.
children.clear();     // empties the list.
```

Lists are incredibly useful. We will be using lists to store the bricks in
our Breakout game.

When you create this line you will see an error appear in IntelliJ. That's
because ArrayList is in something called a java package. To reference 
a class in a package you need to import the package. In IntelliJ you can 
import the package by hitting Alt+Enter. Alternatively you can go to the top
of the file and just under the `package com.javatutorial;` enter the line
```java
import java.util.*;
```
## Sets
A set is similar to a list except for one key difference. A set will never
store more than one instance of a particular value.

In the above list example if I did the following:
```java
children.add("Dave");
children.add("Dave");
children.add("Steve");
children.add("Dave");
```
The list will have 4 values in it. Three Daves and one Steve. children.size()
would return 4.

If I use a set instead:
```java
HashSet<String> kids = new HashSet<String>();
kids.add("Dave");
kids.add("Dave");
kids.add("Steve");
kids.add("Dave");
```
The set will only have 2 values in it. One Dave and one Steve. kids.size()
would return 2.

How does set know whether to add an element? It uses a combination of the 
`equals(Object o)` and `hashcode()`. If those aren't implemented correctly
your sets will be a mess.

## Maps
The final type of collection we will talk about is the map. A map is a collection
that stores its values as keys and values.

```java
DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); // ignore this for now

// define a map called datesOfInterest. The key to the map must be a String
// and the value for each element must be a Date.
HashMap<String, Date> datesOfInterest = new HashMap<String, Date>;

// add three elements to the map.
datesOfInterest.put("IndependenceDay", df.parse("1776-07-04"));
datesOfInterest.put("DayOfInfamy", df.parse("1941-12-07"));
datesOfInterest.put("Christmas", df.parse("2016-12-25"));
```
So now if I want to access values in the map I need to use the key to
get access to it. So to access the DayOfInfamy date I would have code
that looks similar to this:

```java
Date d = datesOfInterest.get("DayOfInfamy");
```

Maps and sets are really powerful tools, but we aren't going to be using
them in our Breakout game development.

## Looping
The Java language has a special looking construct that works well with
Lists, Sets and Arrays. It is a shortcut version of the `for` loop.

If you remember from the looping lesson earlier the `for` loop could look
something like this for a list or set if I want to print out the names 
of all of the Beatles.

```java
ArrayList<String> beatles = new ArrayList<String>();
beatles.add("John");
beatles.add("Paul");
beatles.add("George");
beatles.add("Ringo");

for (int i = 0; i < beatles.size(); i++) {
    System.out.println(beatles.get(i));
}
```
Since our variable is defined as a list we can use a short-cut version
of the `for` loop that looks like this:
```java
for (String name: beatles) {
    System.out.println(name);
}
```
Note: While you can add data to sets as well, the order the elements in the
set are returned to you may not be in the order you added them unless you 
use a particular type of set.

## Arrays
Arrays, are an artifact of early versions of Java. The construct is similar to
an ArrayList with 2 important differences: 1) You must know ahead of time how
big your array needs to be, 2) the syntax is slightly different.

```java
// declare a variable named arrayOfIntegers and allocate enough space to
// hold 10 values.
int arrayOfIntegers = new arrayOfIntegers[10];

// assign the value 5 to the third element in the array (remember 0-based)
arrayOfIntegers[2] = 5;
```

## Let's run an example
In IntelliJ do the following:

1. If your Project Window isn't appearing on the left side of IntelliJ hit Alt+1
1. Expand the folders in the Project Window so you can see src / com.javatutorial.
1. Right-click on the com.javatutorial folder and select New -> Java Class
1. A window will pop up. Enter the name CollectionsExample and Click OK.
1. Replace the entire contents of the CollectionsExample file with this.

```java
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
```

1. Now hit Shift+Cntl+F10 to run your program. Your output should be something like this

In the [next section](TUTORIAL_08_EXCEPTIONS.md) we will go over exceptions.