import java.awt.*;
import java.util.Random;
import javax.swing.*;

/**
 * @Author: Asif Mohaimen
 * @Reg. No. : 2012331054
 * @Class: This class controls the display of the bird at different positions during gameplay.
 */

public class PlayBird extends Birds
{
    /**
     * @x: Horizontal co-ordinate for the bird.
     * @y: Vertical co-ordinate for the bird.
     */
    public int x = 0;
    public int y = 0;
    
    /**
     * Images for the two birds.
     */
    Image bird1, bird2;
    
    /**
     * Random generator object.
     */
    static Random r  = new Random();
    
    /**
     * Constructor.
     * Initializes the images.
     */
    PlayBird()
    {
        bird1 = new ImageIcon("Files/Images/Bird1.gif").getImage();
        bird2 = new ImageIcon("Files/Images/Bird2.gif").getImage();
    }
    
    /**
     * This method updates the position of the bird.
     */
    public void updateBird(){
        x=0;
        y=0;
        while(y<100)
            y = r.nextInt(450);
        while(x<100)
            x = r.nextInt(700);
    }
    
    /**
     * This method displays the bird in the random positions.
     * @param g : main Graphics2D object.
     */
    public void paint(Graphics2D g)
    {
        if(Hard)
        {
            if(birdNumber)
                g.drawImage(bird1, x, y, 50,50,null);
            else
                g.drawImage(bird2, x, y, 50,50,null);
        }
        if(Medium)
        {
            if(birdNumber)
                g.drawImage(bird1, x, y, 70,70,null);
            else
                g.drawImage(bird2, x, y, 70,70,null);
        }
        if(Easy)
        {
            if(birdNumber)
                g.drawImage(bird1, x, y, 90,90,null);
            else
                g.drawImage(bird2, x, y, 90,90,null);
        }
    }
}