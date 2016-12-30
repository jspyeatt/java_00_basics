package com.javatutorial.breakoutsolution;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by John on 12/26/2016.
 */
public class Gameboard extends JPanel {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
    private ArrayList<Brick> bricks = new ArrayList<Brick>();
    private ArrayList<Ball> balls = new ArrayList<Ball>();
    private Scoreboard scoreboard = new Scoreboard();
    private Paddle paddle;

    public Gameboard() {
        super();
        setSize(WIDTH, HEIGHT);
        setFocusable(true);
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
    }
}
