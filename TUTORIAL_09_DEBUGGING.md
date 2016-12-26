# Debugging with IntelliJ
Anyone who tells you their programs don't have errors have never written a useful
program. There are countless things that can go wrong. Some are so spectactular
they make the news. Errors happen. The nice thing about IDEs like IntelliJ is they
give you tools to help find them.

When you run a program under normal circumstances it is going to start and run
straight through to completion. But IDEs like IntelliJ have something called
an interactive debugger. These allow you to run your program one line at a time
and investigate variable values.

Let's run through a simple example.

## Debugging Example
1. Hit Alt+1 to make your Project Window appear.
1. Right-click on the folder com.javatutorial, select New->Java Class and enter the name
   DebuggingExample.
1. Paste in the following code.
```java
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
```
When you hit Shift+Cntl+F10 the output is:
```
Mickey is not a dog.
Minnie is not a dog.
pluto is not a dog.
Donald is not a dog.
Goofy is a dog.
```
But that's not right. Pluto is a dog. Let's set up the IDE to run this program
with the interactive debugger.

### Interactive Debugging
The most common debugging tool you have is the breakpoint. A breakpoint
tells the debugger when you get to this line suspend execution of the
program and wait there.

To set a breakpoint all you need to do is left-click just to the right of
the line number you are interested in. When a breakpoint is set correctly
you will see a small red circle next to the line number.
![Setting Breakpoint](https://github.com/jspyeatt/something/DEBUG_01.png "Setting breakpoint")

So we just set a breakpoint at the line `if (name.equals("Goofy") || name.equals("Pluto")) {`.
Now to run the program in debug mode, in the top nav click on Run->Debug DebuggingExample.
When you do this you will notice that the program stops at the line in question and is 
highlighted in blue ![Setting Breakpoint](https://github.com/jspyeatt/something/DEBUG_02.png "Suspended").

The program is now suspended. In the lower right window you will notice the `data` and `name` variables
appear. If you click on the `data` variable in that window it will expand and show you more information.

I've also highlighted some control buttons you will probably use. 
1. Clicking on the green arrow will resume running the program from the point it was suspended. It will
   continue to run until the program ends or until it reaches another breakpoint.
1. The second circled button will execute the next line of the program and suspend again.
1. The third circled button will step into a method if one is there. In this case it would step
   into the equals() method.

Hit the green arrow until the name = "pluto" appears in the lower right window.
![Setting Breakpoint](https://github.com/jspyeatt/something/DEBUG_03.png "Suspended").

Now while in the lower right window if you right-click and select Evaluate Expression a window
will pop up. This allows you to write small snippets of java code and it will be evaluated
with the variables defined in your running program. So enter the text you see in the picture
![Evaluate](https://github.com/jspyeatt/something/DEBUG_04.png "Evaluate"). Then click on
evaluate. You will see the result is `false`. But why? The reason is because "Pluto" does
not equal "pluto". Change the evaluation to `name.equals("Pluto")` and the result should be
true ![Evaluate](https://github.com/jspyeatt/something/DEBUG_05.png "Evaluate").

That's all we are going to do for now regarding debugging.