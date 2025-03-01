import java.awt.Color;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    
    public void boxBounce()
    {
        int ground = 400;
        int top = 100;
        int leftWall = 50;
        int rightWall = 550;
        int randomYPos = (int)((Math.random()*rightWall - 1)+ leftWall + 1);
        int randomXPos = (int)((Math.random()*ground - 1)+ top + 1);
        boolean finished = false;
        myCanvas.drawLine(50, ground, 550, ground);
        myCanvas.drawLine(50, top, 550, top);
        myCanvas.drawLine(leftWall, top, leftWall, ground);
        myCanvas.drawLine(rightWall, top, rightWall, ground);
        //myCanvas.drawLine(
        //(int xPos, int yPos, int ballDiameter, Color ballColor,
        //int groundPos, int topPos, int leftWallPos, int rightWallPos, Canvas drawingCanvas)
        boxBall box1 = new boxBall(randomXPos, randomYPos, 20, Color.BLUE, ground,top,leftWall, rightWall, myCanvas);
        box1.draw();
        
        //makes ball bounce forever
        while (!finished) 
        {
            myCanvas.wait(25);           // small delay
            box1.move();
            
        }
        
        
        
    }
}
