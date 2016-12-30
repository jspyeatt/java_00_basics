package com.javatutorial.breakoutsolution;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by John on 12/26/2016.
 */
public class Paddle implements MouseMotionListener {
    int x = 100;
    int y;
    int width = 80;
    int height = 10;
    Gameboard board;
    private Color color = Color.WHITE;

    public Paddle(Gameboard board) {
        this.board = board;
        y = board.getHeight() - 100;
    }
    int getLeftX() {
        return x;
    }
    int getRightX() {
        return x + width;
    }
    int getTopY() {
        return y;
    }
    int getBottomY() {
        return y + height;
    }
    int getCenterX() {
        return x + (width / 2);
    }

    void paint(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        x = mouseEvent.getX();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        // do nothing if the mouse moves
    }
}
