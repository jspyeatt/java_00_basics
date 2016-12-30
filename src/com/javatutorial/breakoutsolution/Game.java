package com.javatutorial.breakoutsolution;

import javax.swing.JFrame;

public class Game {
    public static void main(String[] args) throws Exception {

        JFrame frame = new JFrame("Breakout");
        frame.setSize(Gameboard.WIDTH, Gameboard.HEIGHT);
        frame.setVisible(true);
        frame.setResizable(false);
        Gameboard board = new Gameboard();
        frame.add(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Thread gameThread = new Thread(board);
        gameThread.start();
    }
}
