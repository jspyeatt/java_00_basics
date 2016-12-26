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
