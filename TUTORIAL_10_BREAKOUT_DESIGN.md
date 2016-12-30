# Breakout Game
If you remember from our discussion regarding classes and objects we normally refer
to them as nouns. These nouns have attributes and they also have actions. So
the attributes will become variables of the classes and methods for the objects
are actions and therefore described as verbs.

So let's look at a Breakout game screen briefly 
![Breakout](https://github.com/jspyeatt/java_00_basics/blob/master/BREAKOUT_01.png "Breakout").

Looking at the screen what are the nouns we see? And what attributes do they have?

1. Paddle  
   * width and height
   * color
   * position (both X and Y)
1. Ball  
   * color
   * radius
   * position (x and y)
   * speed (both in x and y direction)
1. Bricks  
   * width and height
   * color
   * position (x and y)
   * point value
1. Scoreboard  
   * point total
   * position
   * font type
   * font size
   * color
1. Game board  
   * width and height
   * a scoreboard
   * a paddle
   * bricks
   * balls (one in play and N waiting to be played)
   
So at a minimum it looks like we have 6 different things in our game. So let's start
to think about what types of actions these objects can have. Some are obvious. Some
are going to be more subtle.

Because this is a graphics program something needs to know how to draw the objects
on the screen. The thing that makes the most sense is that the object should know
how to draw itself. So the ball knows how to draw itself. The scoreboard knows
how to draw itself, etc...

Here are some other actions each object should have.
1. Paddle  
    * move left or right - needs to also understand when it gets to the edge of the
      board not to move any farther.
    * needs to react to right and left arrow keys or the mouse moving
1. Ball  
    * move all over the screen.
    * how to reflect its motion when it collides with the paddle, a wall or a brick
    * when it collides with the paddle, a brick or a wall.
    * know when it has gone past the paddle to the bottom of the screen.
    * how to alter its speed in the x or y direction.
1. Bricks  
    * need to know how to disappear when the ball hits it
    * needs to know how to tell the scoreboard that it was hit.
1. Scoreboard  
    * increment the score when a brick is hit
    * reset the scoreboard

In the [next section](TUTORIAL_11_BREAKOUT_BASICS.md) we will demonstrate some extremely
rudimentary graphics manipulations.
    