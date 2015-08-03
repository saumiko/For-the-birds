import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class PlayBird extends Birds
{
    public int x = 0;
    public int y = 0;
    Image bird1, bird2;
    
    static Random r = r = new Random();
    
    PlayBird()
    {
        bird1 = new ImageIcon("Files/Images/Bird1.gif").getImage();
        bird2 = new ImageIcon("Files/Images/Bird2.gif").getImage();
    }
    
    public void updateBird(){
        x=0;
        y=0;
        while(y<100)
            y = r.nextInt(450);
        while(x<100)
            x = r.nextInt(700);
    }
    
    public void paint(Graphics2D g)
    {
        if(birdNumber)
            g.drawImage(bird1, x, y, 50,50,null);
        else
            g.drawImage(bird2, x, y, 50,50,null);
    }
}