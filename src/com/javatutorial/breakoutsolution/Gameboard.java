package com.javatutorial.breakoutsolution;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Gameboard extends JPanel implements Runnable {
    public static final int WIDTH = 992;
    public static final int HEIGHT = 700;
    private Ball ball;
    private Scoreboard scoreboard;
    private Paddle paddle;
    private ArrayList<Brick> bricks = new ArrayList<Brick>();
    private boolean gameOver = false;
    private boolean running = false;

    public Gameboard() {
        super();
        setSize(WIDTH, HEIGHT);
        setFocusable(true);
        setBackground(new Color(30, 30, 30));
        ball = new Ball(this, 100, 250);
        createPaddle();
        createBricks();
        scoreboard = new Scoreboard(this);
        repaint();
    }

    void createBricks() {
        bricks.clear();
        ArrayList<Color> colors = new ArrayList<Color>();
        colors.add(Color.YELLOW);
        colors.add(Color.GREEN);
        colors.add(Color.RED);
        ArrayList<Integer> rowPoints = new ArrayList<Integer>();
        rowPoints.add(50);
        rowPoints.add(25);
        rowPoints.add(10);

        int y = 80;
        for (int i = 0; i < 6; i++) {
            int x = Brick.SEPARATION;
            while (x < getWidth() - Brick.WIDTH) {
                bricks.add(new Brick(colors.get(i/2), rowPoints.get(i/2), x, y));
                x += (Brick.WIDTH + Brick.SEPARATION);
            }
            y += Brick.HEIGHT + Brick.SEPARATION;
        }
    }
    void createPaddle() {
        paddle = new Paddle(this);
        this.addMouseMotionListener(paddle);
    }
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2);
        paddle.paint(g2);
        for (Brick b: bricks) {
            b.paint(g2);
        }
        scoreboard.paint(g2);
        if (gameOver) {
            g2.setColor(Color.WHITE);
            g2.drawString("Game Over", WIDTH / 2 - 100, HEIGHT / 2);
        }
    }

    void start() {
        running = true;
    }
    void stop() {
        System.out.println("stop()");
        running = false;
    }
    void gameOver() {
        gameOver = true;
    }
    @Override
    public void run() {
        repaint();
        start();
        runGame();
    }
    private void runGame() {
        while (running) {
            try {
                Thread.sleep(5);
                ball.move();
                repaint();
                int paddleCollision = ball.collides(paddle);
                if (paddleCollision != 0) {
                    ball.moveAbovePaddle(paddle);
                    ball.flipYVelocity();
                    if ((ball.dx > 0 && paddleCollision < 0) ||
                            (ball.dx < 0 && paddleCollision > 0)) {
                        ball.flipXVelocity();
                    }
                }
                for (int i = 0; i < bricks.size(); i++) {
                    Brick b = bricks.get(i);
                    if (ball.collides(b)) {
                        scoreboard.increment(b);
                        bricks.remove(i);
                        ball.flipYVelocity();
                        if (bricks.isEmpty()) {
                            gameOver = true;
                        }
                        break;
                    }
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
