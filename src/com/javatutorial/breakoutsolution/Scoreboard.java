package com.javatutorial.breakoutsolution;

import java.awt.*;

/**
 * Models the scoreboard.
 */
public class Scoreboard {

    /**
     * Position of the top, left side of the scoreboard.
     */
    private int x = 10;
    private int y;

    /**
     * Current point total
     */
    private int currentScore = 0;
    private Gameboard board;

    public Scoreboard(Gameboard board) {
        this.board = board;
        y = board.getHeight() - 30;
    }
    public void reset() {
        currentScore = 0;
    }

    /**
     * Increment the point total by whatever the point of the brick is.
     *
     * @param brick
     */
    public void increment(Brick brick) {
        currentScore += brick.getPoints();
    }

    /**
     * Paint the scoreboard.
     * @param g
     */
    void paint(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Verdana", Font.BOLD, 20));
        g.drawString(String.valueOf(currentScore), x, y);
    }
}
