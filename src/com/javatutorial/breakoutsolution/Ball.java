package com.javatutorial.breakoutsolution;

import java.awt.*;

/**
 * Created by John on 12/26/2016.
 */
public class Ball {
    int x;
    int y;
    private int radius = 8;
    int dx;
    int dy;
    private int totalPaddleCollisions;
    boolean justCollidedWithBrick = false;
    Color color = Color.WHITE;
    Gameboard board;

    public Ball(Gameboard board, int startingX, int startingY) {
        x = startingX;
        y = startingY;
        this.board = board;
        reset();
    }
    void reset() {
        dx = 1;
        dy = 1;
        totalPaddleCollisions = 0;
    }

    int getCenterX() {
        return x + radius;
    }
    int getCenterY() {
        return y + radius;
    }
    int getLeftX() {
        return x;
    }
    int getRightX() {
        return x + 2 * radius;
    }
    int getTopY() {
        return y;
    }
    int getBottomY() {
        return y + 2 * radius;
    }

    void paint(Graphics2D g) {
        g.setColor(color);
        g.fillOval(x, y, radius * 2, radius * 2);
    }

    void flipXVelocity() {
        dx *= -1;
    }

    void flipYVelocity() {
        dy *= -1;
    }
    void moveAbovePaddle(Paddle p) {
        y = p.y - 2 * radius - 1;
    }
    void move() {
        x += dx;
        y += dy;
        if (getLeftX() < 0 || getRightX() > board.getWidth()) {
            justCollidedWithBrick = false;
            flipXVelocity();
        }
        if (getTopY() < 0) {
            justCollidedWithBrick = false;
            flipYVelocity();
        }
        if (getBottomY() >= board.getHeight()) {
            dx = 0;
            dy = 0;
            board.gameOver();
            board.stop();
        }
    }

    Rectangle getBounds() {
        return new Rectangle(x, y, radius * 2, radius * 2);
    }

    int collides(Paddle p) {
        if (p.getTopY() < getBottomY()
                && p.getBottomY() > getTopY()) {
            if (p.getLeftX() < getCenterX() && p.getCenterX() >= getCenterX()) {
                justCollidedWithBrick = false;
                totalPaddleCollisions++;
                conditionallyChangeSpeed();
                return -1;
            }
            if (p.getCenterX() < getCenterX() && p.getRightX() > getCenterX()) {
                justCollidedWithBrick = false;
                totalPaddleCollisions++;
                conditionallyChangeSpeed();
                return 1;
            }
        }
        return 0;
    }

    private void conditionallyChangeSpeed() {
        if (totalPaddleCollisions % 7 == 6) {
            dx = (dx < 0) ? -2 : 2;
        }
        if (totalPaddleCollisions % 13 == 12) {
            dx = (dx < 0) ? -1 : 1;
        }
    }
    boolean collides(Brick b) {
        if (justCollidedWithBrick == false) {
            justCollidedWithBrick = getBounds().intersects(b.getBounds());
            return justCollidedWithBrick;
        }
        return false;
    }
}
