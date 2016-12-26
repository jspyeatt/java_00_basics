# Looping
Looping allows your code to run over and over again until a condition
is met. There are two primary ways Java provides for looping: the `for` loop
and the `while` loop. There is a third looping mechanism, the `do/while` loop,
but it is rarely used.

## for Loop
You normally use a `for` loop when you know ahead of time how many times you
want the block of code to execute.

A `for` loop has 4 parts and looks like this:
```java
for (int counter = 1; counter < 10; counter++) {
    // everything between the curly brackets will be executed.
    // until counter == 10
}
```
Let's look at each section of the code independently.

`int counter = 1;` This section initializes any values before the loop starts
executing. In this case, before the loop executes we are going to declare a
variable `counter` and give it an initial value of 1.

`counter < 10;` This defines the condition that, when met, terminates the execution
of the loop. This comparison takes place just before the next execution of the block
is suppose to begin.

`counter++` This is the code that is executed just after the block of code
is run, and before the check for the loop-terminating condition runs.

As an example, let's write a loop that adds all of the even numbers between
0 and 12.

```java
int total = 0;
System.out.println("Start looping");
for (int i = 0; i <= 12; i += 2) {
    total = total + i;
    System.out.println("i = " + i + " total = " + total);
}
System.out.println("Looping completed.");
```
The output of this code would look something like this:
```
Start looping
i = 0 total = 0
i = 2 total = 2
i = 4 total = 6
i = 6 total = 12
i = 8 total = 20
i = 10 total = 30
i = 12 total = 42;
Looping completed.
```

## while Loop
`while` loops are typically used when you aren't certain how many times you
need to execute the loop. The structure is also a bit easier to understand
than the `for` loop. All it has is a condition test and a block of code to
execute.
```java
int year = 0;
double balance = 1000.0;
double interestRate = 0.05;
while (balance < 1200.0) {
     System.out.println("year = " + year + " balance = " + balance);
     balance = balance + (balance * interestRate);
     year++;
}
System.out.println("Final number of years = " + year + " final balance = " + balance);
```

Let's do a quick example. If you start with $1000 in a bank account
that pays 5% interest per year, how many years will it take until your
account balance is greater than $1200.

```java
int year = 0;
double balance = 1000.0;
double interestRate = 0.05;
while (balance < 1200.0) {
    System.out.println("year = " + year + " balance = " + balance);
    balance = balance + (balance * interestRate);
}
```
The output from the above code would look something like this
```
year = 0 balance = 1000.0
year = 1 balance = 1050.0
year = 2 balance = 1102.5
year = 3 balance = 1157.625
Final number of years = 4 final balance = 1215.50625

```
## Miscellaneous, but Important
There are a few other things you need to learn about looping. The first
two are things you want to use. The third thing is something you usually
want to avoid.

### break
There are times when you would like to completely stop execution of
a loop while you are in the middle of it. You can do this with something called
a `break` statement.

If you remember from your middle school math classes, a Fibonacci series
is a series of number where the next number in the series is the sum of the
two previous numbers. Let's write a while loop that keeps running until
the fibonacci number is greater that 50. Let's use a `break` statement
to exit the loop.

```java
int fibo1 = 0;   // second most recent fibonacci number
int fibo2 = 1;   // most recent fibonacci number
while (true) {
    int newValue = fibo1 + fibo2;     // calculate the new fibonacci value
    fibo1 = fibo2;                    // assign the most recent number in the
                                      // sequence to the second most recent number
    fibo2 = newValue;                 // assign the most recent number the new value
    
    System.out.println("fibo1 = " + fibo1 + " fibo2 = " + fibo2);
    
    // if our new value is greater than 50, exit the loop
    if (fibo2 > 50) {
        break;
    }
}
```
The resulting output will look like this:
```
fibo1 = 1 fibo2 = 1
fibo1 = 1 fibo2 = 2
fibo1 = 2 fibo2 = 3
fibo1 = 3 fibo2 = 5
fibo1 = 5 fibo2 = 8
fibo1 = 8 fibo2 = 13
fibo1 = 13 fibo2 = 21
fibo1 = 21 fibo2 = 34
fibo1 = 34 fibo2 = 55
```

### continue
While `break` terminates a loop, `continue` will skip the remaining portion
of the execution block and go back to the top of the loop to start the next
execution.

In this example we want to print all integer values which are divisible by
3 that are less than 30. We will do this with a `for` loop.

```java
// loop until i is greater than or equal to 30
for (int i = 0; i < 30; i++) {
    
    // remember modulus? In this case we are essentially saying
    // when I divide i by three and there is a remainder that means
    // that i is NOT divisible by 3. So skip the remainder of the
    // execution block and start the next one.
    if (i % 3 != 0) {
        continue;
    }
    
    // if we made it to here, that means the value of i is divisible
    // by 3.
    System.out.println(i + " is divisible by 3");
}
```
The result will look like this:
```
0 is divisible by 3
3 is divisible by 3
6 is divisible by 3
9 is divisible by 3
12 is divisible by 3
15 is divisible by 3
18 is divisible by 3
21 is divisible by 3
24 is divisible by 3
27 is divisible by 3
```

### Infinite Loops
What happens if the condition you hope terminates your loop never happens?
Then you've got something called an infinite loop. As the name implies,
it is a loop that never terminates. There are times when you want something
to go on forever, most times you don't.

So let's look at a quick example.

```java
int i = 0;
while (i < 10) {
    System.out.println("i = " + i);
    i = i - 1;
}
```
Why does this loop go on forever? Because `i` is always less than
10. That's because instead of incrementing `i` after each execution we
are decrementing it. So the output would begin to look like this:
```
i = 0;
i = -1
i = -2
i = -3
.
.
```
In the [next section](TUTORIAL_06_CLASSES.md) we will go over classes.