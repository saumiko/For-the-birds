import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Clouds extends Birds
{
    private static final Image cloud1 = new ImageIcon("Files/Images/cloud1.png").getImage();
    private static final Image cloud2 = new ImageIcon("Files/Images/cloud2.png").getImage();
    private static final Image cloud3 = new ImageIcon("Files/Images/cloud3.png").getImage();
    private static final Image cloud4 = new ImageIcon("Files/Images/cloud4.png").getImage();
    static private int cloud1x = 100;
    static private int cloud2x = 200;
    static private int cloud3x = 500;
    static private int cloud1y = 40;
    static private int cloud2y = 100;
    static private int cloud3y = 300;
    static private int cloud4x = 800;
    static private int cloud4y = 600;
    
    static public void paintCloud(Graphics2D g)
    {
         g.drawImage(cloud1,cloud1x,cloud1y,null);
         g.drawImage(cloud2,cloud2x,cloud2y,null);
         g.drawImage(cloud3,cloud3x,cloud3y,null);
         g.drawImage(cloud4,cloud4x,cloud4y,null);
    }
    
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