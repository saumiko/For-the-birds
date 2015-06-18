/*Logic notun kore lekha uchit*/
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class PlayBird implements MouseListener//, Runnable 
{
    public int dx;
    public int dy;
    public int x = 0;
    public int y = 0;
    public int mx = 0;
    public int my = 0;
    public Image bird1, bird2, transp;
    public boolean hit;
    boolean click = false;
    public ScreenManager s;
    public Graphics2D g;
    
    Random r = r = new Random();
    
    //public Timer timer;
    
    PlayBird(ScreenManager s, Graphics2D g1)
    {
        g = g1;
        this.s = s;
        bird1 = new ImageIcon("Files/Images/Bird1.gif").getImage();
        bird2 = new ImageIcon("Files/Images/Bird2.gif").getImage();
        transp = new ImageIcon("Files/Images/Trans.png").getImage();
        click = false;
        while(y<100)
            y = r.nextInt(450);
        while(x<100)
            x = r.nextInt(700);
        setxy(x,y);
//        Thread t = new Thread(this, "Bird");
//        t.setPriority(6);
//        t.start();
    }
    
    public void run()
    {
        PaintBird(g);
    }
    
    public void PaintBird(Graphics2D g)
    {
        if(Birds.showBird){
        
        //if(r.nextBoolean())
            g.drawImage(bird1, x, y, 80, 80, null);
        //else
            //g.drawImage(bird2, x, y, 80, 80, null);
        try
        {

        }
        catch(Exception e){}
        finally
        {
            click = false;
        }
        if(click == true)
        {
            if(mx>x  && mx<x+80 && my>y && my < y+80)
                hit = true;
            else
                hit = false;
        }
        
        return;}
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
    
    public void mouseClicked(MouseEvent e) 
    {
        click = true;
        //timer.stop();
        mx = (int)MouseInfo.getPointerInfo().getLocation().getX();
        my = (int)MouseInfo.getPointerInfo().getLocation().getY();
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    
    //private class TimerListener implements ActionListener
    //{
       // public void actionPerformed(ActionEvent e) 
        //{
            
        //}
        
    //}
}
