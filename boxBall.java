import java.awt.*;
import java.awt.geom.*;

/**
 * Class boxBall - a graphical ball that observes the effect of gravity. The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will fall downwards, accelerating with time due to the effect of gravity, and bounce
 * upward again when hitting the ground.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Michael Kölling (mik)
 * @author David J. Barnes
 * @author Bruce Quig
 *
 * @version 2016.02.29
 */

public class boxBall
{
    //private static final int GRAVITY = 3;  // effect of gravity

    //private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;
    private final int topPosition;
    private final int leftWallPosition;
    private final int rightWallPosition;
    // y position of ground
    private Canvas canvas;
    private int ySpeed = (int)(Math.random()*30) + 1;
    private int xSpeed = (int)(Math.random()*30) + 1;
    // initial downward speed

    /**
     * Constructor for objects of class boxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public boxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int groundPos, int topPos, int leftWallPos, int rightWallPos, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        topPosition = topPos;
        leftWallPosition = leftWallPos;
        rightWallPosition = rightWallPos;
        canvas = drawingCanvas;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        //ySpeed += GRAVITY;
        yPosition += ySpeed;
        xPosition += xSpeed;

        // check if it has hit the ground
        if (yPosition >= (groundPosition - diameter) && ySpeed > 0) 
        {
            yPosition = (int)(groundPosition - diameter);
            ySpeed = -ySpeed;
        }
        
        //check if it has hit the right wall
        if (xPosition >= (rightWallPosition - diameter) && xSpeed > 0) 
        {
            xPosition = (int)(rightWallPosition - diameter);
            xSpeed = -xSpeed;
        }
        
        //check if it has hit the top wall
        if (yPosition <= (topPosition) && ySpeed < 0) 
        {
            yPosition = (int)(topPosition);
            ySpeed = -ySpeed;
        }
        
        //check if it has hit the left wall
        if (xPosition <= (leftWallPosition) && xSpeed < 0) 
        {
            xPosition = (int)(leftWallPosition + 1);
            xSpeed = -xSpeed;
        }
        

        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
