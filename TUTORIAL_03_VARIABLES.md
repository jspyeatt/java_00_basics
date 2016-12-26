# Variables
The most basic programming construct in any programming language is called
a variable. Quite simply a variable is a piece of memory you can store information.
Types of information you might store in variables includes:

* Number of runs in an inning
* The balance in a checking account
* A person's name
* The date and time of an appointment

A variable has a name and it can optionally be assigned a value.

## Variable Types
In Java you also have to state what type of data a variable can store. This is because
Java is what is called a typed-language. That means that your variables have to
be given a type. Other languages such as Python or Javascript do not require you
to define the data type.

The syntax for defining variables in Java look like this:

*type variableName;*

The most common variable types you will use in your program are:

```
int        means integer, can store whole number values between 
           -2147483648 and 2147483647.
long       a long integer, can store whole number values between
           -9223372036854775808 and 9223372036854775807
float      means floating point, or decimal number. So unlike int and long
           this can store numerical values that aren't whole numbers.
           The range is ±3.40282347E+38 with about 6 digits of significance.
double     is a double precision floating point number. Its range of values 
           is approximately ±1.79769313486231570E+308 with 15 digits of significance.
boolean    can be the value true or false. That's it.
String     represents a series of characters.
```

So if you define a variable to be of type `int` that means you can't put
a floating point value, string or anything other in that variable other than
a whole number.

So that explains the data type piece. What about the variable name?

## Variable Names
In programming you try to give variables useful names. Each language has restrictions
regarding what characters you can use when naming variables.

In Java variable names can contain the following:
* any letter 'a' through 'z' both lower and upper case
* any number 0 through 9. Though the variable name cannot begin with a number.
* the underscore character '_'
* the dollar sign '$', but I don't recommend using this.

Here are some examples of variable names you might use:

```java
firstName
age
child_number_1
```
It should be noted that java is a case-sensitive language. What that means is that
the variable names `lastName` and `lastname` are different variables and would be
represented in different memory locations. Generally you don't want to declare variables
with names this similar. It makes things confusing.

Many languages use a naming convention regarding variable names. These aren't rules,
just conventions. For Java we typically use what is called camel case for variable
names. Camel case variable names begin with lower case character and use an upper
case character when separating words in the name. Some examples of this would be:

```java
firstName
daysUntilChristmas
numberOfInnings
checkingAccountBalance
```

So declaring variables could look like this:

```java
int numberofHomeRuns;
String firstName;
float checkingAccountBalance;
```
When you declare a variable what you've basically done is tell the program
to reserve a block of memory big enough to hold a value and I will be referencing
it by a name. At this point, the variable is considered declared, but if you try
to reference the value it contains it is considered undefined.

If you have several variables of the same type, you can declare them in one
declaration, separating each variable by a `,`. But this form isn't used very often.
```java
float checkingAccountBalance, savingsAccountBalance, interestRate;
```
Variables that just have names with no values are pretty useless. So now we want to
assign values to them.

```java
weightInPounds = 145;
```
In the above code we are assigning the value 145 to the variable `weightInPounds`. Note
the `;` at the end.

You can also declare and define a variable in one step.
```java
String city = "Madison";
```
Let's go into more detail about some of these variable types:

## int, long
As stated earlier, `int` and `long` can only contain whole numbers within a certain range.
So let's assign a few of them values and see what we can do with them.

```java
int a = 5;
int b = 3;
int c = 2340;  // notice that you can't include commas when assigning a value.
int d = -32;   // assigning a negative number
int e = 45;
int result;    // declaring a variable without assigning a value. at this point the value
               // for the variable is considered undefined
```

The only things you can really do with any number is basic math operations. So let's demonstrate a 
few of them.

### Addition
```java

int i = 36;           // assigning the value 34 to i
int j = 21;
int k = 15;
int m = i + j;       // add up the values stored in i and j and put the result in m.
long n;
long o;
int p = 3.1415;      // THIS WILL NOT WORK. You cannot assign a decimal value to an int type.

j = 18;              // throw the current value of j out and replace it with 18
n = i + j + k;       // sum up the values of i, j and k and put them in the variable n
o = k + 20;          // add 20 plus whatever k contains and put the results in o.
                     // note that we are doing math on ints k and 20, but putting the result
                     // in o which was defined as a long. This is perfectly fine. However
                     // trying to assign a long to an int isn't allowed because of the loss
                     // of precision.
i = i + 7;           // add the value contained in i and 7, put the result back in i.
```

### Subtraction
Not surprisingly, you use the - sign to do subtraction.
```java
int i = 32;
int j = 3;
int r;

r = j - i;      // r should contain the value -29
```

### Multiplication
To multiple values you use the `*` character.

```java
int i = 3;
int j = 7;
int k;
k = i * j;      // k should contain the value 21
```

### Division
Division is done with the `/` character. It should be noted that you have to be careful
not to try to divide by zero. If your code tries to do that the system will throw something
called an exception. We will talk about that more later.

```java
int i = 45;
int j = 9;
int k = i / j;
```

#### Integer Division
Remember, that `int` and `long` can only contain whole numbers. This means that when doing 
division between whole numbers it is going to do integer division.
```java
int i = 21;
int j = 23;
int k = 24;
int r;

r = i / 3     // the value in r will be 7
r = j / 3     // the value in r will ALSO be 7 because the fractional part is truncated.
r = i / 50;   // the value in r will be 0
```
If you need to preserve the decimal portion of any division operations you need to use
`float` or `double`.
### Modulus
Modulus is the more formal name for 'give me the remainder'. The character to use for modulus
is `%`.

```java
int r;

r = 17 % 5;      // r will now contain the value 2. That's because 17 divided by 5 is 15.
                 // and 17 - 15 is 2.
r = 12 % 4;      // r now contains the value 0 because there is no remainer. 
```

## float and double
The math operations for float and double looks exactly the same as it does for int and
float with the exception that you don't have to worry about integer division.

```java
float h = 22.20;
float i = 1.0;
float j = 2.5;
float r;

r = 13.7 + 6.4;
r = h - i;
r = h * j;
r = h / 2;         // note, here we are dividing a float by an int. This is perfectly legal
                   // because the JVM will convert the int to a float in this case.
```

### Math Shortcuts
Math is a very common theme in programming. And certain operations are performed so often
the language gives you shortcuts to perform them.

```java
int counter = 0;
int total = 0;

counter++;           // does the equivalent of   counter = counter + 1;
total += 7;          // does the equivalent of   total = total + 7;
counter--;           // does the equivalent of   counter = counter - 1;
total -= 3;          // does the equivalent of   total = total - 3;
```

## boolean
Boolean is the simplest data type in the language. It can only be one of two values:
`true` or `false`.

```java
boolean male = false;
boolean citizen = true;
```

## String
A string is just a series of characters. Do define or assign strings you need to start
and end them with double quotes.

```java
String firstName = "Ted";
String lastName = "Williams";
String fullName;
```
One thing you can do with strings is concatonate them.

```java
fullName = lastName + ", " firstName;   // The fullName will now contain the string "Williams, Ted"
```
### String Operations
int, long, float, double and boolean are call primative data types. String by contrast is technically
a Class in Java. We will go into much more details about classes in a subsequent tutorial. For now
I'm just going to show you some cool things you can do with Strings.

```java
String longVal = "there is no maximum String length.";
String shortVal = "Hank Aaron";
String resultStr;
int resultInt;
int resultBool;

resultStr = shortVal.toLowerCase();  // resultStr now equals  hank aaron
resultStr = shortVal.toUpperCase();  // resultStr now equals  HANK AARON
resultStr = longVal.replace("no", "virtually no");  // resultStr now equals   there is virtually no maximum String length.
resultStr = longVal.substring(9); // returns the remaining portion of the string
                                  // beginning at position 9. the resultStr value will
                                  // be    no maximum String length.
```

## Let's run an example
In IntelliJ do the following:

1. If your Project Window isn't appearing on the left side of IntelliJ hit Alt+1
1. Expand the folders in the Project Window so you can see src / com.javatutorial.
1. Right-click on the com.javatutorial folder and select New -> Java Class
1. A window will pop up. Enter the name VariableExample and Click OK. This will
   create a new Java file that looks like this:
   ```java
   package com.javatutorial;

   public class VariableExample {
   }
   ```
1. Now replace the entire contents of that file with this.
   ```java
   package com.javatutorial;
   
   public class VariableExample {
       public static void main(String[] args) {
   
           System.out.println("Integer examples");
           int numberOfAtBats = 400;
           int numberOfGamesInASeason = 162;
           int numberOfGamesPlayed = 140;
           int numberOfHomeruns = 28;
           int intResult;
   
           // simple subtraction
           intResult = numberOfGamesInASeason - numberOfGamesPlayed;
           System.out.println("Number of games not played: " + intResult);
   
           // integer division
           intResult = numberOfAtBats / numberOfHomeruns;
           System.out.println("Hits a home run approximately every " + intResult + " at bats.");
           System.out.println("Percentage of season played using integer division: " + numberOfGamesPlayed / numberOfGamesInASeason);
   
           // increment the number of home runs by 3
           numberOfHomeruns += 3;
           intResult = numberOfAtBats / numberOfHomeruns;
           System.out.println("Now he hits home runs approximately every " + intResult + " at bats.");
   
           int quarter = 25, dime = 10, nickel = 5, penny = 1;
           int numberOfQuarters = 0, numberOfDimes = 0, numberOfNickels = 0, numberOfPennies = 0;
   
           /**
            * Making change for someone.
            */
           int total = 87;   // 87 cents
           System.out.println("Making change for " + total + " cents");
           numberOfQuarters = total / quarter;                    // figure out how many quarters
           total = total - (numberOfQuarters * quarter);          // subtract the total amount in quarters from the total
                                                                  // total should now have a value less than 25
           numberOfDimes = total / dime;                          // figure out how many dimes
           total = total - (numberOfDimes * dime);                // total should now have a value less than 10
           numberOfNickels = total / nickel;                      // figure out how many nickels
           numberOfPennies = total - (numberOfNickels * nickel);  // numberOfPennies should hold what's left
           
           System.out.println(numberOfQuarters + " quarters");
           System.out.println(numberOfDimes + " dimes");
           System.out.println(numberOfNickels + " nickels");
           System.out.println(numberOfPennies + " pennies");
   
           // Floating point examples
           System.out.println("------------------------------------------------");
           System.out.println("Floating point examples");
           double inningsPerGame = 9.0;
           double inningsPitched = 7.0;
           double runsAllowed = 4;         // perfectly legal to assign an int to a double, java will convert it.
           double walksAllowed = 3.0;
           double hitsAllowed = 9.0;
           double doubleResult;
   
           doubleResult = (inningsPitched / runsAllowed) * inningsPerGame;  // you can put parentheses around your operations
                                                                            // to guarantee the math is performed in the correct
                                                                            // order.
           System.out.println("ERA = " + doubleResult);
           doubleResult = (walksAllowed + hitsAllowed) / inningsPerGame;
           System.out.println("WHIP = " + doubleResult);
   
           // String examples
           System.out.println("------------------------------------------------");
           System.out.println("String examples");
           String longStr = "This is a pretty long string. I hope you are finding this useful.";
           String shortStr = "Shorter string";
   
           System.out.println("longStr = " + longStr);
           System.out.println("shortStr = " + shortStr);
           System.out.println("longStr.toLowerCase() = " + longStr.toLowerCase());
           System.out.println("shortStr.toUpperCase() = " + shortStr.toUpperCase());
           System.out.println("longStr.substring(10) = " + longStr.substring(10));
           System.out.println("longStr.substring(32,36) = " + longStr.substring(32,36));
           System.out.println("longStr.contains(find) = " + longStr.contains("find"));
       }
   }
   ```
1. Now just hit Cntl+Shirt+F10. IntelliJ will compile your file and run it. If you do things
   correctly your output will be something like this:
   ```bash
   "c:\Program Files\Java\jdk1.8.0_112\bin\java" -Didea.launcher.port=7541 "-Didea.launcher.bin.path=C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 2016.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_112\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_112\jre\lib\rt.jar;C:\Users\John\JohnsAppData\dev\javalessons\java_00_basics\out\production\java_00_basics;C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 2016.3\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain com.javatutorial.VariableExample
   Integer examples
   Number of games not played: 22
   Hits a home run approximately every 14 at bats.
   Percentage of season played using integer division: 0
   Now he hits home runs approximately every 12 at bats.
   Making change for 87 cents
   3 quarters
   1 dimes
   0 nickels
   2 pennies
   ------------------------------------------------
   Floating point examples
   ERA = 15.75
   WHIP = 1.3333333333333333
   ------------------------------------------------
   String examples
   longStr = This is a pretty long string. I hope you are finding this useful.
   shortStr = Shorter string
   longStr.toLowerCase() = this is a pretty long string. i hope you are finding this useful.
   shortStr.toUpperCase() = SHORTER STRING
   longStr.substring(10) = pretty long string. I hope you are finding this useful.
   longStr.substring(32,36) = hope
   longStr.contains(find) = true
   
   Process finished with exit code 0
   ```
In the [next section](TUTORIAL_04_LOGIC_FLOW.md) we will go over logic flow.