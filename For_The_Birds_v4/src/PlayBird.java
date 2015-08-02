import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class PlayBird extends Birds
{
    private int i, show = 0;
    public int dx;
    public int dy;
    public int x = 0;
    public int y = 0;
    public int mx = 0;
    public int my = 0;
    public boolean hit;
    boolean click = false;
//    public Image[] bird1 = new  Image[40];
//    public Image[] bird2 = new  Image[40];
    Image bird6;
    ScreenManager s;
    Graphics2D gm;
    
    Random r = r = new Random();
    
    PlayBird()
    {
        s = super.s;
        gm = super.gm;
//        for(i=0;i<40;i++)
//        {
//            bird1[i] = new ImageIcon("Files/Images/Bird1.gif").getImage();
//            bird2[i] = new ImageIcon("Files/Images/Bird2.gif").getImage();
//        }
        bird6 = new ImageIcon("Files/Images/Bird1.gif").getImage();
    }
    
    public void updateBird(){
        x=0;
        y=0;
        while(y<100)
            y = r.nextInt(450);
        while(x<100)
            x = r.nextInt(700);
        //setxy(x,y);
    }
    
    public void setxy(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
   
    public int getx()
    {
        return x;
    }
    
    public int gety()
    {
        return y;
    }
    
   
    
    public void paint(Graphics2D g){
        g.drawImage(bird6, x, y, 50,50,null);
    }
    
    public void IncreaseShow()
    {
        show++;
    }
    
    public void mouseClicked(MouseEvent e) 
    {
        
       // click = true
    }

    public void mousePressed(MouseEvent e) 
    {
        
    }

    public void mouseReleased(MouseEvent e) 
    {
        
    }

    public void mouseEntered(MouseEvent e) 
    {
        
    }

    public void mouseExited(MouseEvent e) 
    {
        
    }
}