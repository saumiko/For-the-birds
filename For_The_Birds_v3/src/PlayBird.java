import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class PlayBird extends Birds
{
    public int dx;
    public int dy;
    public int x = 0;
    public int y = 0;
    public int mx = 0;
    public int my = 0;
    public boolean hit;
    boolean click = false;
    public Image bird1, bird2;
    ScreenManager s;
    Graphics2D gm;
    
    Random r = r = new Random();
    
    PlayBird()
    {
        s = super.s;
        gm = super.gm;
        bird1 = new ImageIcon("Files/Images/Bird6.png").getImage();
        bird2 = new ImageIcon("Files/Images/Bird2.gif").getImage();
        while(y<100)
            y = r.nextInt(450);
        while(x<100)
            x = r.nextInt(700);
        setxy(x,y);
        Thread t = new Thread(this, "Bird");
        t.setPriority(6);
        t.start();
        
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
    
    public void run()
    {
        Thread t = Thread.currentThread();
        System.out.println(t);
        System.out.println(t);
        if(super.showBird)
        {
            System.out.println("Dhukse");
            //for(int i=0;i<10;i++)
            {
                System.out.println("Loop e Dhukse");
                try{
                    System.out.println("try block e Dhukse");
                //if(r.nextBoolean()){
                    //gm.drawImage(bird1, x, y, 80, 80, null);
                    //System.out.println("bird1");
                //}
//                else{
//                    gm.drawImage(bird2, x, y, 80, 80, null);
//                    System.out.println("Bird2");}
                s.update();
                }
                catch(Exception e){}
                finally
                {
                    click = false;
                }
                while(click == false)
                {
                    System.out.println("click hoenai!!!");
                    if(click == true)
                    {
                        System.out.println("click hoise!!!");
                        if(mx>x  && mx<x+80 && my>y && my < y+80)
                            hit = true;
                        else
                            hit = false;
                        break;
                    }
                }
                if(hit)
                    System.out.println("Hoise!");
                else
                    System.out.println("Hoynai!");
            }
        }
        return;
    }
    
    public void paint(Graphics2D g){
        g.drawImage(bird1, x, y, 80, 80, null);
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