package com.javatutorial.breakoutsolution;

import java.awt.*;

/**
 * Represents a brick with position, size, color and points assigned to it.
 *
 */
public class Brick {

    /**
     * Size of a brick in pixels.
     */
    static final int WIDTH = 80;
    static final int HEIGHT = 20;
    static final int SEPARATION = 2;

    /**
     * how many points is this brick worth.
     */
    private int points;

    /**
     * current position of the upper-left point of the brick.
     */
    int x;
    int y;

    /**
     * brick's color
     */
    private Color color;

    /**
     * Builds a brick.
     *
     * @param c color the brick should be
     * @param points how many points is it worth.
     * @param x position of the brick's left side.
     * @param y position of the brick's top.
     */
    public Brick(Color c, int points, int x, int y) {
        color = c;
        this.x = x;
        this.y = y;
        this.points = points;
    }

    /**
     * Gets how many points this brick is worth.
     * @return
     */
    public int getPoints() {
        return points;
    }

    /**
     * Paint the brick
     *
     * @param g
     */
    void paint(Graphics2D g) {
        g.setColor(color);
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, WIDTH, HEIGHT);
    }

    /**
     * Get the rectangle boundary of the brick. Used to determine collisions with ball.
     * @return
     */
    Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
}
