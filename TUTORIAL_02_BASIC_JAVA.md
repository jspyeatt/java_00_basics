# Very Basic Java
Java is what is called a compiled language. What that means is that 
before the java program can execute it must be converted from the
text format you write in to a format the computer's processors
can understand. This is done with something called a compiler.
In Java the compiler is called `javac`. When you run your program
in IntelliJ like we did in the previous section IntelliJ runs `javac` for
you.

Java, as mentioned earlier, runs on many different operating systems. In
fact you can compile Java programs on one operating system, Windows for 
example, and take the compiler-generated files, copy them to a Mac and
they can be run just fine.

The reason for this is Java programs run in something called a Java Virtual
Machine (JVM). The JVM acts as a buffer between to code `javac` compiled
and what the specific operating system can speak.

When it is time for your program to run in the JVM it expects a certain
piece of code to be available for it. It's a bit like knowing that to start
a car you need to turn the key in the ignition. The key to be turned in this
case is a bit of code called.

```java
public static void main(String[] args)
```
You see this little snippet in the simple example you ran in the previous
section.

```java
package com.javatutorial;

public class Main {

    public static void main(String[] args) {
        System.out.println("Congratulations!!! Your first program!");
        System.out.println("You should celebrate.");
    }
}
```
So when the JVM runs your program, called Main, the JVM looks for your
code `public static void main(String[] args)` to in essense turn the key and
start your program. Once it starts your program it will execute the line of code
`System.out.println("Congratulations....");` which prints out the text to your
console.

## Java Syntax
For the next few sections we are going to write a lot of code that prints
output to the console with the method `System.out.println()` but before we do
that I want to show a minimum amount of syntax.

### Curly Braces
Curly braces, `{` and `}` are used in Java to define the beginning and the end
of a block of code. You will notice one set of curly braces in our sample program
which defines the block of code in the `main` method.

### An Executable Line of Code and the Semi-Colon `;`
All executable lines of code in Java have to end with a `;`. For example in our
example program we have one executable line of code.

```java
System.out.println("Congratulations!!! ..");
```
In Java an executable line of code in Java can actually span multiple lines.
You usually do this for readability. For example, there is a method in the
`String` class called `substring()` which gives you a piece of an existing 
string and takes two arguments, where to start the substring and where to end it.
You could put this execution of code on multiple lines as long as the last piece
is the semi-colon.

```java
"This is my long string".substring(5,
                                   10);
```
### Comments
In time someone can probably figure out what any program is doing if you look
at the code long enough. But good programmers put comments in their code to help
others understand what the intent of the code is.

Comments in Java take one of two forms. The single-line form consists of two
slash characters `//`. When you put two slashs together like this, the compiler
will ignore any characters after the slashs.

The second form is the block form. Which begins with `/*` and ends with `*/`.
When you use the block form, the compiler will ignore all code between these symbols.

So if I were to put comments in our first example program it might look like this:
```java
public class Main {
    /*
     This is the place where my program starts.
     This is my block comment. Notice that it spans multiple lines.
     */
    public static void main(String[] args) {
        
        // print out the text to the console.
        System.out.println("Congratulations!!! Your first program!");
        System.out.println("You should celebrate.");
    }
}
```
In the [next section](TUTORIAL_03_VARIABLES.md) we will go over Java variables.