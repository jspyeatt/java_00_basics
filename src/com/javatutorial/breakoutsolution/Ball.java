package com.javatutorial.breakoutsolution;

import java.awt.*;

/**
 * Represents a ball on the gameboard.
 */
public class Ball {

    // x position of the left side of the ball
    int x;
    // y position of the top of the ball
    int y;
    // radius of the ball in pixels.
    private int radius = 8;
    // how many pixels the ball moves in the x and y direction
    // each time the move() method is called.
    int dx;
    int dy;

    // total number of collisions with the paddle. We keep track of this
    // value so we can periodically change the dx/dy of the ball to give
    // the game some variability.
    private int totalPaddleCollisions;

    // we set this flag when the ball just collides with a brick. we do this
    // to make certain the ball only takes out one brick at a time.
    boolean justCollidedWithBrick = false;

    //color of the ball
    Color color = Color.WHITE;

    // the ball needs to know about the gameboard so it knows where the walls are.
    Gameboard board;

    /**
     * Create the ball and place it at a certain spot on the board.
     *
     * @param board the board the ball is put on.
     * @param startingX the initial position in the x direction
     * @param startingY the initial position in the y direction.
     */
    public Ball(Gameboard board, int startingX, int startingY) {
        x = startingX;
        y = startingY;
        this.board = board;
        reset();
    }

    /**
     * reset the parameters of the ball that can change over time.
     */
    void reset() {
        dx = 1;
        dy = 1;
        totalPaddleCollisions = 0;
    }

    /**
     * get the pixel location of the center of the ball in the x direction
     *
     * @return
     */
    int getCenterX() {
        return x + radius;
    }

    /**
     * get the pixel location of the center of the ball in the y direction
     * @return
     */
    int getCenterY() {
        return y + radius;
    }

    /**
     * get the left-most pixel of the ball
     * @return
     */
    int getLeftX() {
        return x;
    }

    /**
     * get the right-most pixel of the ball
     * @return
     */
    int getRightX() {
        return x + 2 * radius;
    }

    /**
     * get the top pixel of the ball
     * @return
     */
    int getTopY() {
        return y;
    }

    /**
     * get the bottom pixel of the ball.
     * @return
     */
    int getBottomY() {
        return y + 2 * radius;
    }

    /**
     * paint the ball on the board.
     * @param g
     */
    void paint(Graphics2D g) {
        g.setColor(color);
        g.fillOval(x, y, radius * 2, radius * 2);
    }

    /**
     * flip the velocity of the ball in the x direction.
     *
     * If it is currently heading left, flip it right and vice versa.
     */
    void flipXVelocity() {
        dx *= -1;
    }

    /**
     * flip the velocity of the ball in the y direction.
     *
     * If it is currently going down, make it go up, and vice versa.
     */
    void flipYVelocity() {
        dy *= -1;
    }

    /**
     * Positions the ball just above the paddle when it hits the paddle.
     *
     * We do this to prevent the ball from hitting the paddle on sequential
     * move() calls.
     * @param p
     */
    void moveAbovePaddle(Paddle p) {
        y = p.y - 2 * radius - 1;
    }

    /**
     * Moves the ball one position in time.
     */
    void move() {

        // increment the x and y values by the velocities.
        x += dx;
        y += dy;

        // if the ball just hit the left or right side of the
        // game board, flip the x direction
        if (getLeftX() < 0 || getRightX() > board.getWidth()) {
            justCollidedWithBrick = false;
            flipXVelocity();
        }

        // if the ball just hit the top, flip the velocity in the y direction
        if (getTopY() < 0) {
            justCollidedWithBrick = false;
            flipYVelocity();
        }

        // if the ball hit the bottom, the game is over. Set the velocity
        // of the ball to 0.
        if (getBottomY() >= board.getHeight()) {
            dx = 0;
            dy = 0;
            board.gameOver();
            board.stop();
        }
    }

    /**
     * Calculate the bounds of the ball.
     *
     * The reason we calculate the bounds is because it has a convenient
     * method called intersect() which will determines when two graphical
     * objects intersect each other. We will use this when figuring out
     * when the ball collides with a brick.
     * @return
     */
    Rectangle getBounds() {
        return new Rectangle(x, y, radius * 2, radius * 2);
    }

    /**
     * Calculates when and where the ball and paddle collide.
     *
     * We don't use the intersect() function here because we want to know
     * where on the paddle the ball hits it. We use this information to determine
     * whether to change the x direction or not.
     *
     * @param p
     * @return CollisionType.LEFT if the ball hit the left half of the paddle
     *         CollisionType.RIGHT if the ball hit the right half of the paddle
     *         CollisionType.NONE if there was no collision.
     */
    CollisionType collides(Paddle p) {

        // if the top of the paddle is above the bottom of the ball
        // and the bottom of the paddle is below the top of the ball
        if (p.getTopY() < getBottomY()
                && p.getBottomY() > getTopY()) {

            // if the left side of the paddle is to the left of the center of the ball
            // and the ball is to the left of the center of the paddle. Return LEFT
            if (p.getLeftX() < getCenterX() && p.getCenterX() >= getCenterX()) {
                justCollidedWithBrick = false;
                totalPaddleCollisions++;
                conditionallyChangeSpeed();
                return CollisionType.LEFT;
            }

            // if the right side of the paddle is to the right of the center of the ball
            // and the ball is to the right of the center of the paddle. Return RIGHT
            if (p.getCenterX() < getCenterX() && p.getRightX() > getCenterX()) {
                justCollidedWithBrick = false;
                totalPaddleCollisions++;
                conditionallyChangeSpeed();
                return CollisionType.RIGHT;
            }
        }

        // if you made it to here there was no collision
        return CollisionType.NONE;
    }

    /**
     * calling this will periodically change the velocity of the ball.
     *
     */
    private void conditionallyChangeSpeed() {

        // every 7th hit change dx and dx to 2 or -2.
        if (totalPaddleCollisions % 7 == 6) {
            dx = (dx < 0) ? -2 : 2;
        }

        // every 13th hit change dx and dy to 1 or -1.
        if (totalPaddleCollisions % 13 == 12) {
            dx = (dx < 0) ? -1 : 1;
        }
    }

    /**
     * Check to see if the ball collides with a brick.
     *
     * Notice that in this case we simplified the collision logic by use the
     * Rectangle class's intersect function.
     * @param b
     * @return
     */
    boolean collides(Brick b) {

        // only test for collision if we didn't just hit a brick.
        if (justCollidedWithBrick == false) {
            justCollidedWithBrick = getBounds().intersects(b.getBounds());
            return justCollidedWithBrick;
        }
        return false;
    }
}
