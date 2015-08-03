import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Birds implements MouseListener, KeyListener, MouseMotionListener, Runnable
{
    public Graphics2D gm;
    static public ScreenManager s;
    
    PlayBird Bird;
    Chirping chirping;
    Crow crow;
    
    public static Image menu, about, help, background, pause, highscore;
    
    static boolean GameMenu = true;
    static boolean letTheBirdToUpdate = true;
    static boolean HighScore = false;
    static boolean Pause = false;
    static boolean Help = false;
    static boolean About = false;
    static boolean Resume = false;
    static boolean Play = false;
    static boolean mPlay = false;
    static boolean mHighScore = false;
    static boolean mPause = false;
    static boolean mAbout = false;
    static boolean mHelp = false;
    static boolean mExit = false;
    static boolean mPausea = false;
    static boolean mResumea = false;
    static boolean mBacka = false;
    static boolean mHelpa = false;
    static boolean mAbouta = false;
    static boolean mHighscorea = false;
    static boolean birdDrawnOneTime = false;
    static boolean showBird = false;
    static boolean birdNo = false;
    private boolean start = false;
    
    long cumTime,timePassed,timePassed2=0,passedTime;
    
    final static SoundThread bsound = new SoundThread(); //Will start background sound
    
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
         Bird = new PlayBird();
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
                Paint.paintOpeningScreen(gm);
                s.update();
                gm.dispose();
                if(HighScore == true)
                 {
                     while(HighScore == true)
                     {
                         Graphics2D g1=s.getGraphics();
                         Paint.paintHighScore(g1);
                         s.update();
                         gm.dispose();
                     }
                 }
                 if(About == true)
                 {
                     while(About == true)
                     {
                        Graphics2D g1=s.getGraphics();
                        Paint.paintAbout(g1);
                        s.update();
                        gm.dispose();
                     }
                 }
                 if(Help == true)
                 {
                     while(Help == true)
                     {
                         Graphics2D g1=s.getGraphics();
                         Paint.paintHelp(g1);
                         s.update();
                         gm.dispose();
                     }
                 }
                 if(Play == true)
                 {
                     Pause = false;
                     showBird = true;
                     cumTime = System.currentTimeMillis();
                     gm = s.getGraphics();
                     while(Play == true)
                     {
                         start = true;
                        if (letTheBirdToUpdate == true)
                        {
                            letTheBirdToUpdate = false;
                            Bird.updateBird();
                        }
                         gm = s.getGraphics();
                         paintPlay(gm);
                         s.update();
                         gm.dispose();
                         if(Pause == true)
                         {
                             showBird = false;
                             while(Pause == true)
                             {
                                 Graphics2D g3 = s.getGraphics();
                                 Paint.paintPause(g3);
                                 s.update();
                                 gm.dispose();
                             }
                             start = false;
                         }
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
    
    public void paintPlay(Graphics2D g)
     {
         g.drawImage(background, 0, 0, null);
         Clouds.paintCloud(g);         
         timePassed = System.currentTimeMillis() - cumTime;
         timePassed2 += timePassed;
         if(timePassed2<50000)
            Bird.paint(g);
         Clouds.updatingClouds();
         Font f = new Font("Papyrus", Font.BOLD, 20);
         Color norm = new Color(49,50,93);
         Color m = new Color(253,136,40);
         g.setFont(f);
         if(mBacka==true)
         {
             g.setColor(m);
             g.drawString("BACK", 20, 550);
         }
         else
         {
             g.setColor(norm);
             g.drawString("BACK", 20, 550);
         }
         if(mPausea == true)
         {
             g.setColor(m);
             g.drawString("PAUSE", 685, 550);
         }
         else
         {
             g.setColor(norm);
             g.drawString("PAUSE", 685, 550);
         }
         
     }
      
    public void mouseClicked(MouseEvent e) 
    {
        if(e.getX()>550 && e.getX()<642 && e.getY()<240 && e.getY()>205 && Play == false && Pause == false)
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
        {
            Play = true;
            start = false;
        }
        if(e.getX()>20 && e.getX()<88 && e.getY()>530 && e.getY()<550)
            Play = false;
        if(e.getX()>685 && e.getX()<768 && e.getY()>530 && e.getY()<550)
            Pause = true;
        if(e.getX()>260 && e.getX()<510 && e.getY()<400 && e.getY()>340)
        {
            Pause = false;
            start = false;
        }
        if(e.getX()>550 && e.getX()<715 && e.getY()<135 && e.getY() > 100)
            HighScore = true;
        if(e.getX()>375 && e.getX()<453 && e.getY()<500 && e.getY()>478)
            HighScore = false;
        if (Play == true && Pause == false)
        {
            if(birdNo == true)
                birdNo = false;
            else
                birdNo = true;
            About = false;
            Help = false;
            HighScore = false;
            letTheBirdToUpdate = true;
            timePassed2 = 0;
            cumTime = System.currentTimeMillis();
            int x = (int)e.getX();
            int y = (int)e.getY();
            if(x>Bird.x && x<Bird.x+50 && y>Bird.y && y<Bird.y+50 )
            {
                chirping = new Chirping();
                System.out.println("HIT");
            }
            else
            {
                if(start == true)
                    crow = new Crow();
                System.out.println("NOT");
            }
        }
    }

    public void keyPressed(KeyEvent e) 
    {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
            System.exit(0);
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
        if(e.getX()>20 && e.getX()<88 && e.getY()>530 && e.getY()<550)
            mBacka = true;
        else
            mBacka = false;
        if(e.getX()>685 && e.getX()<768 && e.getY()>530 && e.getY()<550)
            mPausea = true;
        else
            mPausea = false;
        if(e.getX()>260 && e.getX()<510 && e.getY()<400 && e.getY()>340)
            mResumea = true;
        else
            mResumea = false;
        if(e.getX()>375 && e.getX()<453 && e.getY()<500 && e.getY()>478)//width 55
            mHighscorea = true;
        else
            mHighscorea = false;
    }    
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}