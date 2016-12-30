package com.javatutorial.breakoutsolution;

import java.awt.*;

public class Scoreboard {
    private int x;
    private int y;
    private int currentScore = 0;
    private Gameboard board;

    public Scoreboard(Gameboard board) {
        this.board = board;
    }
    public void reset() {
        currentScore = 0;
    }
    public void increment(Brick brick) {
        currentScore += brick.getPoints();
    }

    void paint(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Verdana", Font.BOLD, 20));
        g.drawString(String.valueOf(currentScore), 10, board.getHeight() - 30);
    }
}
