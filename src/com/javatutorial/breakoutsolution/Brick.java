package com.javatutorial.breakoutsolution;

import java.awt.*;

/**
 * Created by John on 12/26/2016.
 */
public class Brick {
    static final int WIDTH = 80;
    static final int HEIGHT = 20;
    static final int SEPARATION = 2;
    private int points;
    int x;
    int y;
    private Color color;

    public Brick(Color c, int points, int x, int y) {
        color = c;
        this.x = x;
        this.y = y;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    void paint(Graphics2D g) {
        g.setColor(color);
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, WIDTH, HEIGHT);
    }
    Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
}
