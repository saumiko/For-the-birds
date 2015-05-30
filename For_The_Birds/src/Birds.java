/*
This code initializes the opening screen.
Shows the game menu.
Changes the Mouse Cursor.
Shows about.
Shows help.
Exits on clicking Exit.
Exits on pressing "Esc".
*/
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Birds implements MouseListener, KeyListener, MouseMotionListener, Runnable
{
    ScreenManager s;
    Image menu, about, help;
    boolean gameRunning = false;
    boolean gameMenu = true;
    boolean mPlay = false;
    boolean mHighScore = false;
    boolean mHelp = false;
    boolean mAbout = false;
    boolean mExit = false;
    boolean About = false;
    boolean mAbouta = false;
    boolean mHelpa = false;
    boolean Help = false;
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
         menu = new ImageIcon("Files/Images/Menu.png").getImage();
         about = new ImageIcon("Files/Images/About.png").getImage();
         help = new ImageIcon("Files/Images/Help.png").getImage();
         s = new ScreenManager();
         //Thread t1 = new Thread();
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
             Toolkit toolkit = Toolkit.getDefaultToolkit(); 
             Image image = toolkit.getImage("Files/Images/Ab.gif"); 
             Point hotSpot = new Point(0,0); 
             Cursor cursor = toolkit.createCustomCursor(image, hotSpot, "Ab");
             w.setCursor(cursor); 
             while(gameMenu == true)
             {
                 Graphics2D g1=s.getGraphics();
                 paintOpeningScreen(g1);
                 s.update();
                 g1.dispose();
                 if(About == true)
                 {
                     while(About == true)
                     {
                        Graphics2D g2=s.getGraphics();
                        paintAbout(g2);
                        s.update();
                        g1.dispose();
                     }
                 }
                 if(Help == true)
                 {
                     while(Help == true)
                     {
                         Graphics2D g2=s.getGraphics();
                         paintHelp(g2);
                         s.update();
                         g1.dispose();
                     }
                 }
                 
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
     
     public void paintAbout(Graphics2D g)
    {
        g.drawImage(about,0,0,null);
        Font f = new Font("Forte", Font.BOLD, 30);
        Color norm = new Color(221, 222, 227);
        Color m = new Color(82, 104, 169);
        g.setFont(f);
        if(mAbouta == true)
        {
            g.setColor(m);
            g.drawString("Back", 700, 500);
        }
        else
        {
            g.setColor(norm);
            g.drawString("Back", 700, 500);
        }
    }
     
     public void paintHelp(Graphics2D g)
    {
        g.drawImage(help,0,0,null);
        Font f = new Font("Forte", Font.BOLD, 30);
        Color norm = new Color(170, 151, 109);
        Color m = new Color(82, 104, 169);
        g.setFont(f);
        if(mHelpa == true)
        {
            g.setColor(norm);
            g.drawString("Back", 700, 550);
        }
        else
        {
            g.setColor(m);
            g.drawString("Back", 700, 550);
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
        //System.out.println(e.getX() + " " + e.getY());
        if(e.getX()>550 && e.getX()<642 && e.getY()<240 && e.getY()>205)
            System.exit(0);
        if(e.getX()>550 && e.getX()<642 && e.getY()<205 && e.getY()>170)
            About = true;
        if(e.getX()>550 && e.getX()<618 && e.getY()<170 && e.getY()>135)
            Help = true;
        if(e.getX()>700 && e.getX()<815  && e.getY()< 500 && e.getY()>470)
            About = false;
        if(e.getX()>700 && e.getX()<815  && e.getY()< 550 && e.getY()>520)
            Help = false;
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
        if(e.getX()>700 && e.getX()<815  && e.getY()< 500 && e.getY()>470)
            mAbouta = true;
        else
            mAbouta = false;
        if(e.getX()>700 && e.getX()<815  && e.getY()< 550 && e.getY()>520)
            mHelpa = true;
        else
            mHelpa = false;
    }
}
