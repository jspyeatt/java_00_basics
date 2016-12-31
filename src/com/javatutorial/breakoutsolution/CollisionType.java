package com.javatutorial.breakoutsolution;

/**
 * Defines what type of collision the ball had with the paddle.
 */
public enum CollisionType {
    /**
     * Collision with left side of paddle.
     */
    LEFT,
    /**
     * Collision with right side of paddle.
     */
    RIGHT,
    /**
     * No collision with the paddle.
     */
    NONE;
}
