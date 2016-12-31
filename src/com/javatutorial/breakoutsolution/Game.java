package com.javatutorial.breakoutsolution;

import javax.swing.JFrame;

public class Game {
    public static void main(String[] args) throws Exception {
        // create our gameboard. the gameboard controls everything.
        Gameboard board = new Gameboard();

        // create a graphics frame. this defines the window the game will be
        // played in.
        JFrame frame = new JFrame("Breakout");
        // set the size of the frame, make it visible, set a flag that indicates
        // that it can't be resized.
        frame.setSize(Gameboard.WIDTH, Gameboard.HEIGHT);
        frame.setVisible(true);
        frame.setResizable(false);

        // tell the system that when someone closes the window we should just
        // exit the game entirely.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add our gameboard to the frame. the reason we can do this is because
        // the gameboard is a subclass of a JPanel which is another graphics
        // library element that comes with java.
        frame.add(board);

        // create a thread, and start the game.
        Thread gameThread = new Thread(board);
        gameThread.start();
    }
}
