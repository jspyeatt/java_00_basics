# Creating a Java Project in IntelliJ

1. Start IntelliJ
1. Click on **Create New Project**  
   a) In Left Nav of window select **Java**  
   b) Check the box that says *Create project from template*  
   c) Select *Command Line App** and click on **Next**  
   d) In the New Project window give your project a name. (ex. Hello)
      and you can leave the package name to the default (com.javatutorial)
      for now. I'll explain packages much later.  
   e) Click on **Finish**

You should now have a fully configured Java program ready for execution.

## IntelliJ IDE
IntelliJ is what is called an IDE (Integrated Development Environment).
An IDE is basically a smart text editor that understands the grammer/syntax
of the language you are coding in. IDEs are really helpful because they can
help find some mistakes before you know your making them.

One thing that is different with IntelliJ is that there is no Save File option.
That is handled automatically for you.

All IDEs make extensive use of short cut key strokes and different ways to view
your project.

Here are some useful short-cut keys you might want to learn for IntelliJ.

```
Alt+1           pops up the Project View window
Alt+7           pops up the Structure View window for your project. Thing of the
                structure view as a Table Of Contents view of your source code.
Cntl+Z          Undo your more recent edits
Alt+Cntl+L      Reformat your code so indents are more readable.

```
A more complete list can be found [here](https://www.shortcutworld.com/en/win/IntelliJ.html).

## Modifying Your Program
After you've configured your new project will have a file called Main that looks something
like this.

```java
package com.javatutorial;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
```

Let's modify it a bit and run it.

Replace the line that reads:

```java
// write your code here
```

with

```java
System.out.println("Congratulations!!! Your first program!");
System.out.println("You should celebrate.");
```

After your modifications are complete your Main.java file will look something like this.
```java
package com.javatutorial;

public class Main {

    public static void main(String[] args) {
        System.out.println("Congratulations!!! Your first program!");
        System.out.println("You should celebrate.");
    }
}
```
## Run Your Program
Now that your program is written we'll run it. Perform the following steps.

1. In the top nav select the Run menu
1. In the Run menu select Run Main. This will convert the text in your Main.java file into 
   a format the computer can understand and then run your program. In a short time a terminal
   window will pop up and it will contain something like this.
   
```bash
"c:\Program Files\Java\jdk1.8.0_112\bin\java" ........ com.intellij.rt.execution.application.AppMain com.javatutorial.Main
Congratulations!!! Your first program!
You should celebrate.

Process finished with exit code 0
```

In the [next section](TUTORIAL_02_BASIC_JAVA.md) we will go over the very basics of Java and its syntax.
