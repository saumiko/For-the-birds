import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Birds implements MouseListener, KeyListener, MouseMotionListener, Runnable
{
    public Graphics2D gm;
    PlayBird Bird;
    Clouds cloud;
    public ScreenManager s;
    public static Image menu, about, help, background, pause, highscore;
    boolean GameMenu = true;
    boolean HighScore = false;
    boolean Pause = false;
    boolean Help = false;
    boolean About = false;
    boolean Resume = false;
    public static boolean Play = false;
    boolean mPlay = false;
    boolean mHighScore = false;
    boolean mPause = false;
    boolean mAbout = false;
    boolean mHelp = false;
    boolean mExit = false;
    boolean mPause_a = false;
    boolean mResume_a = false;
    public static boolean cloudPlay = false;
    
    public static void main(String args[])
    {
        Birds main = new Birds();
        main.run();
    }
    
    public static final DisplayMode modes1[]=
    {
        new DisplayMode(800,600,32,0),
    };
    
    void init() //Will initialize all the elements
     {
         
         menu = new ImageIcon("Files/Images/Menu.png").getImage();
         about = new ImageIcon("Files/Images/About.png").getImage();
         help = new ImageIcon("Files/Images/Help.png").getImage();
         background = new ImageIcon("Files/Images/background.png").getImage();
         pause = new ImageIcon("Files/Images/Pause.png").getImage();
         highscore = new ImageIcon("Files/Images/HighScore.png").getImage();
         s = new ScreenManager();
     }
         
    public void run() 
    {
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
            while(GameMenu==true)
            {
                Graphics2D gm = s.getGraphics();
                paintOpeningScreen(gm);
                s.update();
                gm.dispose();
                if(HighScore == true)
                 {
                     while(HighScore == true)
                     {
                         Graphics2D g1=s.getGraphics();
                         paintHighScore(g1);
                         s.update();
                         gm.dispose();
                     }
                 }
                 if(About == true)
                 {
                     while(About == true)
                     {
                        Graphics2D g1=s.getGraphics();
                        paintAbout(g1);
                        s.update();
                        gm.dispose();
                     }
                 }
                 if(Help == true)
                 {
                     while(Help == true)
                     {
                         Graphics2D g1=s.getGraphics();
                         paintHelp(g1);
                         s.update();
                         gm.dispose();
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

    public void mouseClicked(MouseEvent e) 
    {
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
        if(e.getX()>550 && e.getX()<613  && e.getY()< 100 && e.getY()>70)
            Play = true;
        if(e.getX()>20 && e.getX()<88 && e.getY()>530 && e.getY()<550)
            Play = false;
        if(e.getX()>685 && e.getX()<768 && e.getY()>530 && e.getY()<550)
            Pause = true;
        if(e.getX()>260 && e.getX()<510 && e.getY()<400 && e.getY()>340)
            Pause = false;
        if(e.getX()>550 && e.getX()<715 && e.getY()<135 && e.getY() > 100)
            HighScore = true;
        if(e.getX()>375 && e.getX()<453 && e.getY()<500 && e.getY()>478)
            HighScore = false;
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

    public void keyTyped(KeyEvent e) 
    {
        
    }

    public void keyPressed(KeyEvent e) 
    {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
            System.exit(0);
    }

    public void keyReleased(KeyEvent e) 
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