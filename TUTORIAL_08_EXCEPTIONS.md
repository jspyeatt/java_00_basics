# Exceptions
Sometimes things can go wrong. Things can go wrong for a variety of reasons.
The two most common are: 1) There is an error on the programming logic (a bug)
2) The user of the program entered bad data or the system got into a state
that was unexpected. We will talk about software bugs in a later section.
In this section we will discuss user errors and bad state.

Examples of user error and system state problems:
1. Required information wasn't provided. Example, user forgot to enter their
   phone number.
1. Information is not formatted correctly. Example, email address is missing the
@ sign.
1. Information doesn't make sense. Entered a birthday which is in the future.
1. Unable to connect to a database
1. Unable to reach a network resource (ex. a printer)

There are a variety of ways programming languages have for addressing these
issues. In Java a common way is through something called an Exception.

When an exception is thrown the program immediately stops executing the section
of the program where the problem occurred and jumps to a point in the program
where the exception can be addressed.

It is generally good practice to do what is called defensive-programming.
Basically what that entails is to try to write your code so it cannot get into
bad states. Another phrase you will hear is "garbage-in, garbage-out". We try
to avoid "garbage-in" so we never get a "garbage-out".

## Checked versus Unchecked Exceptions
If you have a checked exception, the Java language mandates that you write
some type of code that knows what to do when one of these exceptions are thrown.

An unchecked exception acts the same way if it is thrown, but the language 
doesn't mandate that you write code to handle it.

## A Checked Exception Example
Let's say we are writing a really simple banking application. For a checking
account you are only allowed to do three things: 1) Check your balance, 2)
Add money to the account 3) Withdrawl money from the account.

Let's create a new package in our tutorial and create some classes.

1. Hit Alt+1 until the Project View appears.
1. Right-click on the com.javatutorial folder and select New->Package. 
1. Enter the name `banking`. This will create a new java package in your 
   source code. We will talk about packaging a little bit later in the tutorials.
1. Right-click on the 'banking' folder and select New->Java Class
1. Enter the name `Account`.
1. Paste the following into your Account.java file.

```java
package com.javatutorial.banking;

public class Account {
    String accountName;
    double balance;

    public Account(String name, double initialAmount) {
        accountName = name;
        balance = initialAmount;
    }

    public void printCurrentBalance() {
        System.out.println("The account: " + accountName + " currently has " + balance + " dollars in it.");
    }

    /**
     * Deposit into the account.
     *
     * @param amount amount to deposit.
     * @return new account balance.
     */
    public double deposit(double amount) {

        // add the amount deposited to the balance, then return the new balance.
        balance += amount;
        return balance;
    }

    /**
     * Withdrawl from the account.
     * @param amount
     * @return
     */
    public double withdrawl(double amount) {

        // subtract the amount to be withdrawn and return the new balance.
        balance -= amount;
        return balance;
    }

    public static void main(String[] args) {
        Account acct1 = new Account("Fred's", 1000.0);
        Account acct2 = new Account("Steve's", 2000.0);

        acct1.printCurrentBalance();
        acct2.printCurrentBalance();
        acct1.deposit(100.0);
        acct2.withdrawl(50.0);
        acct1.printCurrentBalance();
        acct2.printCurrentBalance();

    }
}
```
1. And hit Shift+Cntl+F10 to run your program. You should see something that
   looks like this:
```
The account: Fred's currently has 1000.0 dollars in it.
The account: Steve's currently has 2000.0 dollars in it.
The account: Fred's currently has 1100.0 dollars in it.
The account: Steve's currently has 1950.0 dollars in it.
```
Now let's make a few modifications to the main() method.

```java
    public static void main(String[] args) {
        Account acct1 = new Account("Fred's", 1000.0);
        Account acct2 = new Account("Steve's", 2000.0);

        acct1.printCurrentBalance();
        acct2.printCurrentBalance();

        acct1.deposit(100.0);
        acct2.withdrawl(50.0);
        acct1.printCurrentBalance();
        acct2.printCurrentBalance();

        acct2.withdrawl(4000.0);
        // whoa. What does it mean to deposit a negative amount?
        acct1.deposit(-200.0);
        acct1.printCurrentBalance();
        acct2.printCurrentBalance();
    }
```
You will see that I tried to deposit -200 and withdrawl 4000.00. That ain't allowed!
So we want to protect against that. This is where exceptions come in.

For the first case we are just going to throw an unchecked exception if they
try to deposit a negative number. We are going to use an unchecked exception
that comes with the language.

Replace your deposit() method with this:
```java
    public double deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("You cannot deposit a negative number. " + amount);
        }
        // add the amount deposited to the balance, then return the new balance.
        balance += amount;
        return balance;
    }
```
You will see a new construct `throw`. Throw is basically how the program
throws up its hands and states that it cannot continue. You will also
notice the `new IllegalArgumentException()`. Exceptions are classes, to 
instantiate a class you use the `new` keyword just like any other class.

If we run the Account main() again by hitting Shift+Cntl+F10 you will now see
the following output.

```
The account: Fred's currently has 1000.0 dollars in it.
Exception in thread "main" The account: Steve's currently has 2000.0 dollars in it.
The account: Fred's currently has 1100.0 dollars in it.
The account: Steve's currently has 1950.0 dollars in it.
java.lang.IllegalArgumentException: You cannot deposit a negative number. -200.0
	at com.javatutorial.banking.Account.deposit(Account.java:24)
	at com.javatutorial.banking.Account.main(Account.java:56)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
```
Note that you now see the line "You cannot deposit a negative number. -200.0". This is the
message we specified when we threw the exception. All of the text below that is what is
called a stack trace. This points you through the calling stack that lead to the exception
being thrown. In the code this indicates that the exception was thrown at line 24 in the
Account.java file.

So what about the case when someone tries to withdraw more money than is in the account
(the insufficient funds scenario). Let's write a checked exception for this, which, as mentioned
earlier, forces the programmer to handle this problem.

1. Hit Alt+1 to make the project window appear.
1. Right-click on the banking folder and select New->Java Class. Enter the name
InsufficientFundsException.
1. In the file enter the following:
```java
package com.javatutorial.banking;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(double balance, double withdrawlAmount) {
        super("You tried to withdrawl " + withdrawlAmount + " from an account that only has " + balance);
    }
}
```
The only really new things in this code are the `extends Exception` and the `super`. Those
actually have to do with something called inheritance which we will discuss later.

Now that we've got our exception class written we can add it to the code.

Replace your withdraw() method in Account.java with the following:
```java
    public double withdrawl(double amount) {
        if (amount > balance) {
            throw new InsufficientFundsException(balance, amount);
        }
        // subtract the amount to be withdrawn and return the new balance.
        balance -= amount;
        return balance;
    }
```
As soon as you do this you will notice a red line appearing under the line  
`throw new InsfficientFundsException(balance, amount);`. That's because 
InsufficientFundsException is a checked exception. That means that the programming
language forces you to be able to react when this condition occurs.

There are two things you can do in java: a try/catch block, or pass the exception
back to the calling program.

### try/catch
A try/catch block essentially says "try to execute this block of code. If you're
not successful, catch the exception and do something." So in our case let's just
say we want to log the mistake and leave the balance unchanged.

Replace your withdraw() method with this:
```
    public double withdrawl(double amount) {
        try {
            if (amount > balance) {
                throw new InsufficientFundsException(balance, amount);
            }
            // subtract the amount to be withdrawn and return the new balance.
            balance -= amount;
        } catch (InsufficientFundsException e) {
            System.err.println(e.getMessage());
        }
        return balance;
    }
```
Now when you hit Shift+Cntl+F10 your output will include an error line
`You tried to withdrawl 4000.0 from an account that only has 1950.0`.

### Pass the exception to the calling function
Instead of handling the exception in a try/catch block you can do the programming
equivalent of passing-the-buck. In otherwords, you alert the program that called
the withdraw() method that this exception could occur and it better do something
to address it. So replace your withdraw() method with this.

```java
    public double withdrawl(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(balance, amount);
        }
        // subtract the amount to be withdrawn and return the new balance.
        balance -= amount;
        return balance;
    }
```
Notice we've removed the try/catch block from our previous version of withdraw()
and added the `throws InsufficientFundsException` to the method definition. This
is our pass-the-buck solution. Essentially telling a programmer, if you call this
method in your code, you need to handle this type of exception. So the calling
program, in our case, main(), needs to handle this. So the final, complete solution
for our garbage-in/garbage-out with exceptions looks like this:

Account.java
```java
package com.javatutorial.banking;

public class Account {
    String accountName;
    double balance;

    public Account(String name, double initialAmount) {
        accountName = name;
        balance = initialAmount;
    }

    public void printCurrentBalance() {
        System.out.println("The account: " + accountName + " currently has " + balance + " dollars in it.");
    }

    /**
     * Deposit into the account.
     *
     * @param amount amount to deposit.
     * @return new account balance.
     */
    public double deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("You cannot deposit a negative number. " + amount);
        }
        // add the amount deposited to the balance, then return the new balance.
        balance += amount;
        return balance;
    }

    /**
     * Withdrawl from the account.
     * @param amount
     * @return
     */
    public double withdrawl(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(balance, amount);
        }
        // subtract the amount to be withdrawn and return the new balance.
        balance -= amount;
        return balance;
    }

    public static void main(String[] args) throws InsufficientFundsException {
        Account acct1 = new Account("Fred's", 1000.0);
        Account acct2 = new Account("Steve's", 2000.0);

        acct1.printCurrentBalance();
        acct2.printCurrentBalance();

        acct1.deposit(100.0);
        try {
            acct2.withdrawl(50.0);
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }
        acct1.printCurrentBalance();
        acct2.printCurrentBalance();

        // whoa. What does it mean to deposit a negative amount?

        acct2.withdrawl(4000.0);
        acct1.deposit(-200.0);
        acct1.printCurrentBalance();
        acct2.printCurrentBalance();
    }
}

```
In the [next section](TUTORIAL_09_DEBUGGING.md) we will go over debugging with IntelliJ.