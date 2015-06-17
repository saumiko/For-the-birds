import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class Clouds implements Runnable 
{
    Image  cloud1, cloud2, cloud3, cloud4;
    int cloud1x = 100;
    int cloud2x = 200;
    int cloud3x = 500;
    int cloud1y = 40;
    int cloud2y = 100;
    int cloud3y = 300;
    int cloud4x = 800;
    int cloud4y = 600;
    ScreenManager s;
    Graphics2D g;
    
    Clouds(ScreenManager s1, Graphics2D g1)
    {
         s = s1;
         g = g1;
         
         cloud1 = new ImageIcon("Files/Images/cloud1.png").getImage();
         cloud2 = new ImageIcon("Files/Images/cloud2.png").getImage();
         cloud3 = new ImageIcon("Files/Images/cloud3.png").getImage();
         cloud4 = new ImageIcon("Files/Images/cloud4.png").getImage();
         
         Thread t = new Thread(this, "Clouds");
         t.setPriority(2);
         t.start();
    }
    
    public void updatingClouds(){

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
    
    public void run()
    {
//        DisplayMode dm = s.findFirstCompatibleMode(Birds.modes1);
//        s.setFullScreen(dm);
//        Window w = s.getFullScreenWindow();
         paintCloud(g,s);
    }
    
    public void paintCloud(Graphics2D g, ScreenManager s)
    {
        while(Birds.play == true && Birds.pause == false){ 
         g.drawImage(cloud1,cloud1x,cloud1y,null);
         g.drawImage(cloud2,cloud2x,cloud2y,null);
         g.drawImage(cloud3,cloud3x,cloud3y,null);
         g.drawImage(cloud4,cloud4x,cloud4y,null);
         updatingClouds();
//         s.update();
//         g.dispose();
        }
    }
}
