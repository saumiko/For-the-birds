/*
This code initializes the opening screen.
Shows the game menu.
Exits on clicking Exit.
Exits on pressing "Esc".
*/
import java.awt.*;
import java.awt.event.*;
//import java.io.File;
//import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.Clip;
import javax.swing.*;

public class Birds implements MouseListener, KeyListener, MouseMotionListener
{
    ScreenManager s;
    Image menu;
    boolean gameRunning = false;
    boolean gameMenu = true;
    boolean mPlay = false;
    boolean mHighScore = false;
    boolean mHelp = false;
    boolean mAbout = false;
    boolean mExit = false;
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
             w.addMouseListener(this);
             w.addMouseMotionListener(this);
             w.addKeyListener(this);
             
             while(gameMenu == true)
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
         Font f = new Font("Forte", Font.BOLD, 30);
         Color norm = new Color(221, 222, 227);
         Color m = new Color(82, 104, 169);
         g1.setFont(f);
         if(mPlay == true)
         {
             g1.setColor(m);
             g1.drawString("Play", 550, 100);
         }
         else
         {
             g1.setColor(norm);
             g1.drawString("Play", 550, 100);
         }
         if(mHighScore == true)
         {
             g1.setColor(m);
             g1.drawString("High Score", 550, 135);
         }
         else
         {
             g1.setColor(norm);
             g1.drawString("High Score", 550, 135);
         }
         if(mHelp == true)
         {
             g1.setColor(m);
             g1.drawString("Help", 550, 170);
         }
         else
         {
             g1.setColor(norm);
             g1.drawString("Help", 550, 170);
         }
         if(mAbout == true)
         {
             g1.setColor(m);
             g1.drawString("About", 550, 205);
         }
         else
         {
             g1.setColor(norm);
             g1.drawString("About", 550, 205);
         }
         if(mExit == true)
         {
             g1.setColor(m);
             g1.drawString("Exit", 550, 240);
         }
         else
         {
             g1.setColor(norm);
             g1.drawString("Exit", 550, 240);
         }
     }
     
     public void keyPressed(KeyEvent ke)
    {
        if(ke.getKeyCode()==KeyEvent.VK_ESCAPE)
            System.exit(0);
    }
    
    public  void keyReleased(KeyEvent ke)
    {
    
    }
    
    public  void keyTyped(KeyEvent ke)
    {
       
    }

    
    public void mouseClicked(MouseEvent e) 
    {
        System.out.println(e.getX() + " " + e.getY());
        if(e.getX()>550 && e.getX()<642 && e.getY()<240 && e.getY()>205)
            System.exit(0);
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

    public void mouseDragged(MouseEvent e) 
    {
        
    }

    public void mouseMoved(MouseEvent e) 
    {
        if(e.getX()>550 && e.getX()<613  && e.getY()< 100 && e.getY()>70)
            mPlay = true;
        else
            mPlay = false;
        if(e.getX()>550 && e.getX()<715 && e.getY()<135 && e.getY() > 100)
            mHighScore = true;
        else
            mHighScore = false;
        if(e.getX()>550 && e.getX()<618 && e.getY()<170 && e.getY()>135)
            mHelp = true;
        else
            mHelp = false;
        if(e.getX()>550 && e.getX()<642 && e.getY()<205 && e.getY()>170)
            mAbout = true;
        else
            mAbout = false;
        if(e.getX()>550 && e.getX()<642 && e.getY()<240 && e.getY()>205)
            mExit = true;
        else
            mExit = false;
    }
}
