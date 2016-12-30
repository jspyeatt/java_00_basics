package com.javatutorial.breakoutsolution;

/**
 * Created by John on 12/26/2016.
 */
public class Scoreboard {
    private int x;
    private int y;
    private int currentScore = 0;

    public void reset() {
        currentScore = 0;
    }
    public void increment(Brick brick) {
        currentScore += brick.getPoints();
    }
}
