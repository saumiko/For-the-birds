/*
This code just initializes the opening screen & Closes the screen on pressing "Esc".
*/
import java.awt.*;
import java.awt.event.*;
//import java.io.File;
//import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.Clip;
import javax.swing.*;

public class Birds implements /*MouseListener,*/ KeyListener//, MouseMotionListener
{
    ScreenManager s;
    Image menu;
    boolean gameRunning = true;
    int flag1 = 1;
    public static void main(String args[])
    {
        Birds b = new Birds();
        b.run();
    }
     private static final DisplayMode modes1[]=
     {
         new DisplayMode(800,600,32,0),
     };
     
     void init() //Will initialize all the elements
     {
         menu = new ImageIcon("Menu.png").getImage();
         
         s = new ScreenManager();
     }
     
     public void run()
     {
         s = new ScreenManager();
         init();
         try
         {
             DisplayMode dm = s.findFirstCompatibleMode(modes1);
             s.setFullScreen(dm);
             Window w = s.getFullScreenWindow();
             //w.addMouseListener(this);
             //w.addMouseMotionListener(this);
             w.addKeyListener(this);
             
             while(gameRunning == true)
             {
                 Graphics2D g1=s.getGraphics();
                 paintOpeningScreen(g1);
                 s.update();
                 g1.dispose();
                 //while(flag1==1)
                 //{
                     //while(Highscore)
                 //}
             }
         }
         catch(Exception e){}
         finally
         {
             s.restoreScreen();
         }
     }
     
     public void paintOpeningScreen(Graphics2D g1)
     {
         g1.drawImage(menu,0,0,null);
     }
     
     public void keyPressed(KeyEvent ke)
    {
        if(ke.getKeyCode()==KeyEvent.VK_ESCAPE)
        {
            System.exit(0);
        }
    }
    
    public  void keyReleased(KeyEvent ke)
    {
    
    }
    public  void keyTyped(KeyEvent ke)
    {
       
    }
}
