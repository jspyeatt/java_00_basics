package com.javatutorial.breakoutsolution;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The game board.
 *
 * Like a real game this gameboard has: a ball, a paddle, bricks and a scoreboard.
 *
 * Also, the game board knows how to execute the game. (Its behavior).
 *
 * One thing that is very important to remember when dealing with the java graphics
 * library is graphics work on a grid. In a graphics grid the point 0,0 appears
 * in the upper left corner and x goes positive as it moves to the right and y
 * goes positive as you go down.
 * Also understand that when we build graphical elements on a panel such as balls,
 * rectangles (bricks) and text (scoreboard) the positioning of those elements
 * also begins in the top left corner of the element.
 */
public class Gameboard extends JPanel implements Runnable {
    /**
     * The width and height of the gameboard in pixels.
     */
    public static final int WIDTH = 992;
    public static final int HEIGHT = 700;

    // the game ball, scoreboard, paddle and bricks.
    private Ball ball;
    private Scoreboard scoreboard;
    private Paddle paddle;
    private ArrayList<Brick> bricks = new ArrayList<Brick>();

    /**
     * This is a flag that is set when the game is over. When this flag
     * is set to true the game loop ends, thus ending the game.
     */
    private boolean gameOver = false;
    /**
     * flag indicating the game is currently running.
     */
    private boolean running = false;

    /**
     * The constructor for the game board. This constructor does a lot
     * of things.
     * <ul>
     *     <li>set the size of the gameboard panel, gives it the mouse's focus
     *     and sets the background color to a dark gray.</li>
     *     <li>Create the game ball and initially position it at (100, 250)</li>
     *     <li>Create the paddle, bricks and scoreboard.</li>
     * </ul>
     */
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

    /**
     * This method creates the bricks.
     *
     * There are 6 different rows of bricks, two of each color. Different
     * rows of bricks are worth different points.
     */
    void createBricks() {
        // empty the list of bricks
        bricks.clear();

        // I'm going to build the 6 rows of bricks with with an nested loop below.
        // To do that I need to create a list of colors and points.
        ArrayList<Color> rowColors = new ArrayList<Color>();
        rowColors.add(Color.YELLOW);
        rowColors.add(Color.YELLOW);
        rowColors.add(Color.GREEN);
        rowColors.add(Color.GREEN);
        rowColors.add(Color.RED);
        rowColors.add(Color.RED);
        ArrayList<Integer> rowPoints = new ArrayList<Integer>();
        rowPoints.add(50);
        rowPoints.add(50);
        rowPoints.add(25);
        rowPoints.add(25);
        rowPoints.add(10);
        rowPoints.add(10);

        /*
        This is the loop that builds the 6 rows of bricks. It does it one row at a time
        starting at the top row. The for loop is run once for each row. The while loop
        builds the bricks from left to right until it reaches the right edge of the frame.
         */

        int y = 80;  // the top row of bricks begins 80 pixels down from the top of the frame

        // loop 6 times. once for each row of bricks.
        for (int rowNumber = 0; rowNumber < 6; rowNumber++) {

            // position the first brick in the row (the one farthest to the left just off
            // the left side of the frame (Brick.SEPARATION) is a small offset we use
            // as a gap between bricks.
            int x = Brick.SEPARATION;

            // this loop puts the bricks across the frame from left to right. Note, the reason
            // we have to put the getWidth() - Brick.WIDTH is because the value of x identifies
            // left edge of the brick being drawn. Since the brick is Brick.WIDTH wide we don't
            // want to start a new brick too far to the right.
            while (x < getWidth() - Brick.WIDTH) {

                // create a brick with the appropriate color, points and position on the panel
                // and add it to the list of bricks for the game.
                Brick aBrick = new Brick(rowColors.get(rowNumber), rowPoints.get(rowNumber), x, y);
                bricks.add(aBrick);

                // increment our x position to the point where the next brick in the row will be
                // placed the next time we go through the while loop.
                x += (Brick.WIDTH + Brick.SEPARATION);
            }

            // when you've made it to here that means you've completed all the bricks in the row.
            // so increment the positioner for the y axis in preparation for the next time
            // through the loop.
            y += Brick.HEIGHT + Brick.SEPARATION;
        }
    }

    /**
     * Creates the paddle and tells the gameboard that it is interested in listening
     * for mouse motion events.
     */
    void createPaddle() {
        paddle = new Paddle(this);
        this.addMouseMotionListener(paddle);
    }

    /**
     * Painting is just as it sounds. It paints the graphical elements of the game
     * on the panel. paint() is normally called indirectly through repaint().
     *
     * repaint() will be called each time through the game loop.
     * @param g
     */
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // here we have to paint all of the elements of the game.
        ball.paint(g2);
        paddle.paint(g2);
        scoreboard.paint(g2);

        // we need to draw each brick that hasn't been hit by the ball.
        for (Brick b: bricks) {
            b.paint(g2);
        }

        // if the game has been flagged as being over, print Game Over
        // in the middle of the screen.
        if (gameOver) {
            g2.setColor(Color.WHITE);
            g2.drawString("Game Over", WIDTH / 2 - 100, HEIGHT / 2);
        }
    }

    /**
     * set the flag that the game is running.
     */
    void start() {
        running = true;
    }

    /**
     * set a flag so the game loop stops.
     */
    void stop() {
        System.out.println("stop()");
        running = false;
    }

    /**
     * set the flag indicating the game is over.
     */
    void gameOver() {
        gameOver = true;
    }

    /**
     * run() is the method that is called when you start a thread as we did
     * in the main method in the Game class.
     */
    @Override
    public void run() {
        repaint();
        start();
        runGame();
    }

    /**
     * Any interactive graphics game has something called a game loop.
     * A game loop continuously runs until the game is over. Each
     * iteration through the game loop marks the passage of one instance
     * in time. In that instance of time the game loop checks for all
     * possible changes to the state of the game.
     * What changes to the state of the game might that be?
     *
     * <ul>
     *     <li>The ball moving a small distance.</li>
     *     <li>The ball colliding with the side walls.</li>
     *     <li>The paddle might hit the ball.</li>
     *     <li>A ball might hit a brick which means the brick must be
     *     removed and points added to the scoreboard.</li>
     * </ul>
     * In our implementation every time we iterate through
     * the loop we are going to put the game to sleep for a short
     * period of time (5 milliseconds) otherwise it would loop too fast.
     */
    private void runGame() {

        // infinite loop until the game is no longer running.
        while (running) {
            try {
                // sleep for 5 milliseconds.
                Thread.sleep(5);

                // move the ball and repaint the screen
                ball.move();
                repaint();

                // check and see if the ball now collides with
                // the paddle
                CollisionType paddleCollision = ball.collides(paddle);

                // if there has been a collision between the paddle and the ball
                if (paddleCollision != CollisionType.NONE) {
                    // move the ball so it is just above the paddle.
                    // we do this just in case the ball is almost past the
                    // paddle when the collision occurs.
                    ball.moveAbovePaddle(paddle);

                    // change the balls vertical velocity so it goes back
                    // in the upward direction.
                    ball.flipYVelocity();

                    // This if statement will conditionally change the direction
                    // the ball is traveling in the x direction. If the ball is
                    // currently heading to the right and hits the left half
                    // of the paddle or the ball is traveling to the left and
                    // hits the right half of the paddle.
                    if ((ball.dx > 0 && paddleCollision == CollisionType.LEFT) ||
                            (ball.dx < 0 && paddleCollision ==CollisionType.RIGHT)) {
                        ball.flipXVelocity();
                    }
                }

                // Now we will check to see if the ball just hit any of the bricks.
                // loop through all of the visible bricks.
                for (int i = 0; i < bricks.size(); i++) {
                    Brick b = bricks.get(i);

                    // if the ball collides with the brick it is currently evaluating
                    if (ball.collides(b)) {

                        // increment the scoreboard based on the points for this brick
                        scoreboard.increment(b);
                        // remove the brick from the list of bricks
                        bricks.remove(i);
                        // change the direction of the ball in the y direction
                        ball.flipYVelocity();
                        // if there are no more bricks, flag the game as being over.
                        if (bricks.isEmpty()) {
                            gameOver = true;
                        }

                        // once you've hit a brick, break out of the loop that
                        // checks so we can make certain we only take out one
                        // brick at a time.
                        break;
                    }
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
