import java.awt.*;
import java.util.Random;
import javax.swing.*;

/**
 * @Author: Asif Mohaimen
 * @Reg. No. : 2012331054
 * @Class: This class controls the Moving Clouds during gameplay.
 */

public class Clouds extends Birds
{
    /**
     * This variable group initiates the images for the clouds.
     */
    static private final Image cloud1 = new ImageIcon("Files/Images/cloud1.png").getImage();
    static private final Image cloud2 = new ImageIcon("Files/Images/cloud2.png").getImage();
    static private final Image cloud3 = new ImageIcon("Files/Images/cloud3.png").getImage();
    static private final Image cloud4 = new ImageIcon("Files/Images/cloud4.png").getImage();
    
    /**
     * This variable group determines the initial value of the clouds.
     */
    static private int cloud1x = 100;
    static private int cloud2x = 200;
    static private int cloud3x = 500;
    static private int cloud1y = 40;
    static private int cloud2y = 100;
    static private int cloud3y = 300;
    static private int cloud4x = 800;
    static private int cloud4y = 600;
    
    /**
     * This method paints the clouds on the screen during gameplay.
     * @param g refers to the main Graphis2D object.
     */
    static public void paintCloud(Graphics2D g)
    {
         g.drawImage(cloud1,cloud1x,cloud1y,null);
         g.drawImage(cloud2,cloud2x,cloud2y,null);
         g.drawImage(cloud3,cloud3x,cloud3y,null);
         g.drawImage(cloud4,cloud4x,cloud4y,null);
    }
    
    /**
     * This method updates the co-ordinates of the clouds.
     */
    static public void updatingClouds()
    {
        Random r = new Random();
        if (cloud1x > s.getWidth())
        {
            cloud1x = cloud1.getWidth(null) * (-1);
            cloud1y = r.nextInt(499);
        }
        if (cloud2x > s.getWidth())
        {
            cloud2x = cloud2.getWidth(null) * (-1);
            cloud2y = r.nextInt(499);
        }
        if (cloud3x > s.getWidth())
        {
            cloud3x = cloud3.getWidth(null) * (-1);
            cloud3y = r.nextInt(499);
        }
        if (cloud4x > s.getWidth())
        {
            cloud4x = cloud4.getWidth(null) * (-1);
            cloud4y = r.nextInt(499);
        }
        cloud1x += 1;
        cloud2x += 2;
        cloud3x += 1;
        cloud4x += 1;
    }   
}