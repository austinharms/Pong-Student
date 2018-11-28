import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (austin) 
 * @version (11/27/2018)
 */
public class Ball extends Actor
{
    //TODO (44): Declare an integer instance constant called SIZE that is initialized to 20
    private final int SIZE = 20;

    //TODO (45): Declare a static integer instance variable (private static int) called velocity initialized to 0
    private static int velocity = 0;

    /**
     * TODO (46): Declare a default constructor for the Ball class
     * 
     * TODO (47): Inside the method, declare a local GreenfootImage variable called ballImage
     *            initialized to a new GrenfootImage object that has a width 
     *            of SIZE and a height of SIZE
     * 
     * TODO (48): Set the color of the ballImage to WHITE
     * 
     * TODO (49): Fill an oval on the ballImage that starts at (0,0) and has a width of SIZE and a height of SIZE
     * 
     * TODO (50): Set the image of the Ball class to the ballImage
     * 
     * TODO (51): Turn the ball a random number of degrees between 0 and 360 (360 not included)
     */

    /**
     * ball sets the image of the ball to a white circle set to a random rotation
     * 
     * @param Nothing there are no paramitors
     * @return nothing is returned
     */
    public Ball()
    {
        GreenfootImage ballImage = new GreenfootImage(SIZE, SIZE);
        ballImage.setColor(Color.WHITE);
        ballImage.fillOval(0, 0, SIZE, SIZE);
        setImage(ballImage);
        setRotation(Greenfoot.getRandomNumber(360));
    }

    /**
     * Act every cycle of the program it checks if the game is running and if 
     * it is it moves the ball and runs the checkCollison method
     * 
     * @param Nothing there are no paramitors
     * @return nothing is returned
     */
    public void act() 
    {
        // Add your action code here.
        //TODO (82): Declare a local PlayField variable called field that is initialized to store a reference to the PlayField object
        PlayField field = (PlayField) getWorld();

        //TODO (83): If the game has started (PlayField has a method for checking this)...
        if(field.getStarted() == true)
        {
            move(velocity);
            checkCollision();
        }
        //TODO (84): Move the ball at a speed of velocity

        //TODO (107): Use a method to check if the ball has collided with something
    }

    /**
     * TODO (85): Declare a method called checkCollision that does not
     *          return anything and has no parameters
     *          
     * TODO (86): Inside the method, declare a local Actor variable called hitting
     *            that is initialized to an intersecting object of class Paddle 
     *            (use the getOneIntersectingObject method, which can be found in the Actor documentation)
     * 
     * TODO (87): Declare a local PlayField variable called world that is initialized
     *            to a reference to the PlayField object
     * 
     * TODO (88): Declare a local Score variable called getPoint
     * 
     * TODO (89): If the hitting object is not nothing (i.e. != null)...
     * 
     *      TODO (90): Set the velocity variable equal to negative velocity
     *      
     *      TODO (91): Set the rotation of the ball to the negative equivalent of the current rotation ( -getRotation() )
     *      
     *      TODO (92): Move the ball at the current velocity
     *      
     * TODO (93): If the y location of the Ball is less than or equal to 10...
     * 
     *      TODO (94): Set the rotation of the ball to the negative equivalent of the current rotation
     *      
     * TODO (95): If the y location of the Ball is greater than or equal to 590...
     * 
     *      TODO (96): Set the rotation of the ball to the negative equivalent of the current rotation
     *      
     * TODO (97): If the x location of the Ball is less than or equal to 10...
     * 
     *      TODO (98): Remove this object from the world
     *      
     *      TODO (99): Initialize the getPoint variable to (Score)world.getObjects(Score.class).get(1) (this will get player two's scoreboard)
     *      
     *      TODO (100): Increase the score of the scoreboard that will be getting a point by using the countScore method of getPoint
     *      
     *      TODO (101): Reset the world by using the reset method of world
     *      
     * TODO (102): Otherwise, if the x location of the Ball is greater than or equal to 790...
     * 
     *      TODO (103): Remove this object from the world
     *      
     *      TODO (104): Initialize the getPoint variable to (Score)world.getObjects(Score.class).get(0) (this will get player one's scoreboard)
     *      
     *      TODO (105): Increase the score of the scoreboard that will be getting a point by using the countScore method of getPoint
     *      
     *      TODO (106): Reset the world by using the reset method of world
     */

    /**
     * checkCollision checks if the ball has collided with somthing 
     * and if so it makse the ball bounce off it also checks if the ball has 
     * gone all the way the the left or right it adds a pont to the respective player
     * 
     * @param Nothing there are no paramitors
     * @return nothing is returned
     */
    private void checkCollision()
    {
        Actor hitting = getOneIntersectingObject(Paddle.class);
        PlayField field = (PlayField) getWorld();
        Score getPoint;
        if(hitting != null)
        {
            velocity = -velocity;
            setRotation(-getRotation());
            move(velocity);
        }
        if(getY() <= 10)
        {
            setRotation(-getRotation());
        }
        if(getY() >= 590)
        {
            setRotation(-getRotation());
        }
        if(getX() <= 10)
        {
            field.removeObject(this);
            getPoint = (Score)field.getObjects(Score.class).get(1);
            getPoint.countScore();
            field.reset();
        }
        else if(getX() >= 790)
        {
            field.removeObject(this);
            getPoint = (Score)field.getObjects(Score.class).get(0);
            getPoint.countScore();
            field.reset();
        }
    }

    /**
     * TODO (52): Declare a public method called setVelocity that does not
     *            return anything and has an integer parameter called v
     *          
     * TODO (53): Inside the method, set velocity variable to the v parameter
     */
    
    /**
     * setVelocity sets the velocity to the v paramiter
     * 
     * @param an int used to set the velocity of the ball
     * @return nothing is returned
     */
    public void setVelocity(int v)
    {
        velocity = v;
    }
}
