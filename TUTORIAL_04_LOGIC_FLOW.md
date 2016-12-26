# Conditional Logic
In life here are times when you want to perform some
tasks only under certain circumstances. Some examples:

* Start your car if you have the key
* Withdraw money from your checking account only if there is enough to cover the withdrawal.
* Send out Happy Birthday wishes to a friend only on their birthday

In programming, as in life there are times when we want to conditionally do similar things.

## Boolean Logic
Remember from our previous section a boolean value is either true or false. Boolean logic
entails evaluating expressions to true or false then executing some code based on the results.

In any programming language there are ways to evaluate expressions for truthness or falseness.
You can also do things like saying 'are all of these conditions met.'.

So here are some examples.

```
int i = 10;
int j = 15;
int k = 0;
boolean result;

result = (i > k);      // essentially asks the question 'is i greater than k'. true
result = (j <= i);     // is j less than or equal to i. false
result = (k == i);     // is k equal to i. false.    Note the use of double == sign
result = (k != i);     // is k not equal to i. true.
```

You can also group conditional statements to do things like check for two different
conditions being true or either of two conditions are true. You do this with the 
logical and `&&` or the logical or `||`.


```
condition       | evaluates to
----------------|-------------
true && true    | true
true && false   | false
true || false   | true
false || false  | false
```

## if statement
So the `if` statement allow you to say "execute this block of code if this condition
evaluates to true".

The format of the if statement is as follows:
```
if (condition) {
   // execute all of the statements between the curly brackets if the
   // condition is true
}
```
The `if` construct also has the notion of executing some code if the condition
is not met. This is called the `else` clause and looks like this.

```
if (condition) {
   // execute these steps if the condition is true
} else {
   // if the condition is false, execute these steps.
}
```

Finally you can add as many `else if` statements as you like.
```
if (condition1) {
    // executes if condition1 is true
} else if (condition2) {
    // executes if condition1 is false and condition2 is true
} else if (condition3) {
    // executes if condition1 and condition2 are false and condition3 is true
} else {
    // executes if condition1, condition2 and condition3 are all false
}
```

So what would some Java code look like that uses the `if` statements.

```
float checkingAccountBalance = 500.00;
float amountToWithdraw = 123.00;

// first make certain the amount you are trying to withdraw is greater than 0.
if (amountToWithdraw < 0) {
    System.out.println("I'm sorry. You cannot withdraw a negative amount.");

    // check to make certain there is enough money in the account to cover
    // the withdrawal.
} else if (checkingAccountBalance > amountToWithdraw) {
    checkingAccountBalance = checkingAccountBalance - amountToWithdraw;
    System.out.println(amountToWithdraw + " has been withdrawn.");
    System.out.println("New checking account balance = " + checkingAccountBalance);
    
    // else warn them that there are insufficient funds.
} else {
    System.out.println("Insufficient funds.");
}
```

## Let's run an example
In IntelliJ do the following:

1. If your Project Window isn't appearing on the left side of IntelliJ hit Alt+1
1. Expand the folders in the Project Window so you can see src / com.javatutorial.
1. Right-click on the com.javatutorial folder and select New -> Java Class
1. A window will pop up. Enter the name ConditionalExample and Click OK.
1. Replace the entire contents of the ConditionalExample file with this.

```java
package com.javatutorial;

public class ConditionalExample {
    public static void main(String[] args) {
        int age = 18;
        boolean male = true;

        // if over the age of 17 and male
        if (male && age > 17) {
            System.out.println("You are an adult man.");
            
        // if male and both age greater that 12 AND age less than 18
        } else if (male && (age > 12 && age < 18)) {
            System.out.println("You are a teenage boy.");
            
        // if male and both age less than or equal to 12 AND age greater than 1
        } else if (male && (age <= 12 && age > 1)) {
            System.out.println("You are a young boy.");
            
        // if male and age less than or equal to 1
        } else if (male && age <= 1) {
            System.out.println("You are an infant boy");
            
        // if it isn't a male, it's a female.
        } else if (male == false) {
            System.out.println("You are female.");
        }
    }
}
```  
1. Now hit Shift+Cntl+F10 to run your program. Your output should be something like this
```
"c:\Program Files\Java\jdk1.8.0_112\bin\java" javatutorial.ConditionalExample
You are an adult man.

Process finished with exit code 0
```
1. Change the values for `age` and `male`, click on Shift+Cntl+F10 and see how
your output changes.

In the [next section](TUTORIAL_05_LOOPING.md) we will go over looping.
