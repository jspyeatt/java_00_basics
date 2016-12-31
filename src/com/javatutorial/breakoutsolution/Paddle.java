package com.javatutorial.breakoutsolution;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Models the paddle.
 *
 * The one truly unique thing about the paddle is that it must
 * move based on actions from the player. To do this the paddle
 * needs to 'listen' for the mouse moving. To do this you will
 * notice in the class definition the words 'implement MouseMotionListener'.
 *
 * The MouseMotionListener is what is called an 'interface'. Think of
 * an interface as a contract. Any class that implements a specific
 * interface guarantees that it will implement the methods associated
 * with the interface.
 *
 * There are 2 methods associated with the MouseMotionListener interface:
 * mouseMoved() and mouseDragged(). We have to implement both of them,
 * but in our case we aren't going to do anything in the mouseMoved()
 * method. We are only going to do something with mouseDragged().
 */
public class Paddle implements MouseMotionListener {
    /**
     * Current location of the left side of the paddle.
     */
    int x = 100;
    /**
     * Current location of the top of the paddle.
     */
    int y;

    /**
     * size of the paddle.
     */
    int width = 80;
    int height = 10;

    /**
     * reference to the game board.
     */
    Gameboard board;
    /**
     * Color of the paddle.
     */
    private Color color = Color.WHITE;

    /**
     * Create the paddle.
     *
     * We figure out where to position the paddle vertically based on the
     * size of the board.
     * @param board
     */
    public Paddle(Gameboard board) {
        this.board = board;

        // position the top of the paddle 100 pixels above the bottom of the board.
        y = board.getHeight() - 100;
    }

    /**
     * Get the left side of the paddle.
     * @return
     */
    int getLeftX() {
        return x;
    }

    /**
     * Get the right side of the paddle.
     * @return
     */
    int getRightX() {
        return x + width;
    }

    /**
     * Get the top of the paddle;
     * @return
     */
    int getTopY() {
        return y;
    }

    /**
     * Get the bottom of the paddle.
     * @return
     */
    int getBottomY() {
        return y + height;
    }

    /**
     * Get the horizontal center of the paddle.
     * @return
     */
    int getCenterX() {
        return x + (width / 2);
    }

    /**
     * Paint the paddle.
     * @param g
     */
    void paint(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    /**
     * When we receive a mouseDragged() event position the center of
     * the paddle to the same point as the mouse.
     * @param mouseEvent
     */
    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        x = mouseEvent.getX() - (width / 2);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        // do nothing if the mouse moves
    }
}
