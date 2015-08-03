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
    
    public static Image menu, about, help, background, pause, highscore, score, level;
    
    int Score1, Shots1;
    
    static String Scr1, Sht1;
    
    static boolean level1 = false, level2 = false, level3 = false, level4 = false, level5 = false, level6 = false;
    static public boolean mouseOnlevel1 = false, mouseOnlevel2 = false, mouseOnlevel3 = false, mouseOnlevel4 = false, mouseOnlevel5 = false, mouseOnlevel6 = false;
    static public boolean select1 = false,select2 = false,select3 = false,select4 = false,select5 = false,select6 = false;
    static private int lx = 350, ly = 200, lm = 30, xD = 30;
    
    static boolean GameMenu = true;
    static boolean letTheBirdToUpdate = true;
    static boolean HighScore = false;
    static boolean Pause = false;
    static boolean Help = false;
    static boolean About = false;
    static boolean Resume = false;
    static boolean Play = false;
    static boolean mouseOnPlay = false;
    static boolean mouseOnHighScore = false;
    static boolean mouseOnPause = false;
    static boolean mouseOnAbout = false;
    static boolean mouseOnHelp = false;
    static boolean mouseOnExit = false;
    static boolean mouseArrivedOnPause = false;
    static boolean mouseArrivedOnResume = false;
    static boolean mouseArrivedOnBack = false;
    static boolean mouseArrivedOnHelp = false;
    static boolean mouseArrivedOnAbout = false;
    static boolean mouseArrivedOnHighScore = false;
    static boolean birdDrawnOneTime = false;
    static boolean showBird = false;
    static boolean birdNumber = false;
    private boolean start = false;
    private boolean finish = false;
    
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
         score = new ImageIcon("Files/Images/Score.png").getImage();
         level = new ImageIcon("Files/Images/Level.png").getImage();
         s = new ScreenManager();
         Bird = new PlayBird();
     }
    
    void initScoreShot()
    {
        Score1 = 0;
        Shots1 = 10;
        Scr1 = Integer.toString(Score1);
        Sht1 = Integer.toString(Shots1);
        finish = false;
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
                     initScoreShot();
                     Pause = false;
                     showBird = true;
                     cumTime = System.currentTimeMillis();
                     gm = s.getGraphics();
                     while(Play == true)
                     {
                         if(Shots1 > 0)
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
                         else if(finish)
                         {
                             gm = s.getGraphics();
                             //530,260
                             Paint.paintFinished(gm);
                             s.update();
                             gm.dispose();
                         }
                         else
                             Play = false;
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
         Font fs = new Font("Impact", Font.BOLD, 20);
         Color Sc = new Color(0,0,64);
         g.setFont(fs);
         g.setColor(Sc);
         g.drawString("Score:", 550, 30);
         g.drawString("Shots Left:", 650, 30);
         g.drawString(Scr1, 610, 30);
         g.drawString(Sht1, 750, 30);
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
         if(mouseArrivedOnBack==true)
         {
             g.setColor(m);
             g.drawString("BACK", 20, 550);
         }
         else
         {
             g.setColor(norm);
             g.drawString("BACK", 20, 550);
         }
         if(mouseArrivedOnPause == true)
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
    
    /*public void Hit(Graphics2D g)
    {
        Font Hf = new Font("Impact", Font.BOLD, 60);
        Color Hc = new Color(0,98,0);
        g.setFont(Hf);
        g.setColor(Hc);
        g.drawString("HIT!", 260, 400);
        try
        {
            Thread.sleep(100);
        }
        catch(Exception exc){}
        g.drawString("       ", 260, 400);
    }
    
    public void Failed(Graphics2D g)
    {
        Thread t = Thread.currentThread();
        Font Hf = new Font("Impact", Font.BOLD, 60);
        Color Hc = new Color(166,0,0);
        g.setFont(Hf);
        g.setColor(Hc);
        g.drawString("FAILED!", 260, 400);
        try
        {
            t.sleep(100);
        }
        catch(Exception exc){}
        g.drawString("         ", 260, 400);
    }*/
      
    public void mouseClicked(MouseEvent e) 
    {
        if(Play)
            System.out.println("X: "+e.getX()+"Y: "+e.getY());
        if(select1)
            level1 = true;
        if(select2)
            level2 = true;
        if(select3)
            level3 = true;
        if(select4)
            level4 = true;
        if(select5)
            level5 = true;
        if(select6)
            level6 = true;
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
            Score1 = Score1;
            Shots1 = Shots1+1;
        }
        if(e.getX()>550 && e.getX()<715 && e.getY()<135 && e.getY() > 100)
            HighScore = true;
        if(e.getX()>375 && e.getX()<453 && e.getY()<500 && e.getY()>478)
            HighScore = false;
        if (Play == true && Pause == false)
        {
            Shots1--;
            if(birdNumber == true)
                birdNumber = false;
            else
                birdNumber = true;
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
                //Hit(gm);
                Score1++;
            }
            else
            {
                if(start == true)
                    crow = new Crow();
                System.out.println("NOT");
                //Failed(gm);
            }
            Scr1 = Integer.toString(Score1);
            Sht1 = Integer.toString(Shots1);
            if(Shots1 == 0)
                finish = true;
        }
    }

    public void keyPressed(KeyEvent e) 
    {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
            System.exit(0);
        finish = false;
    }
    
    public void mouseMoved(MouseEvent e) 
    {
        if(e.getX()>550 && e.getX()<613  && e.getY()< 100 && e.getY()>70)
            mouseOnPlay = true;
        else
            mouseOnPlay = false;
        if(e.getX()>550 && e.getX()<715 && e.getY()<135 && e.getY() > 100)
            mouseOnHighScore = true;
        else
            mouseOnHighScore = false;
        if(e.getX()>550 && e.getX()<618 && e.getY()<170 && e.getY()>135)
            mouseOnHelp = true;
        else
            mouseOnHelp = false;
        if(e.getX()>550 && e.getX()<642 && e.getY()<205 && e.getY()>170)
            mouseOnAbout = true;
        else
            mouseOnAbout = false;
        if(e.getX()>550 && e.getX()<642 && e.getY()<240 && e.getY()>205)
            mouseOnExit = true;
        else
            mouseOnExit = false;
        if(e.getX()>700 && e.getX()<815  && e.getY()< 500 && e.getY()>470)
            mouseArrivedOnAbout = true;
        else
            mouseArrivedOnAbout = false;
        if(e.getX()>700 && e.getX()<815  && e.getY()< 550 && e.getY()>520)
            mouseArrivedOnHelp = true;
        else
            mouseArrivedOnHelp = false;
        if(e.getX()>20 && e.getX()<88 && e.getY()>530 && e.getY()<550)
            mouseArrivedOnBack = true;
        else
            mouseArrivedOnBack = false;
        if(e.getX()>685 && e.getX()<768 && e.getY()>530 && e.getY()<550)
            mouseArrivedOnPause = true;
        else
            mouseArrivedOnPause = false;
        if(e.getX()>260 && e.getX()<510 && e.getY()<400 && e.getY()>340)
            mouseArrivedOnResume = true;
        else
            mouseArrivedOnResume = false;
        if(e.getX()>375 && e.getX()<453 && e.getY()<500 && e.getY()>478)//width 55
            mouseArrivedOnHighScore = true;
        else
            mouseArrivedOnHighScore = false;
        if(e.getX()>lx && e.getX()<lx+xD && e.getY()>ly && e.getY()<ly+lm)
            mouseOnlevel1 = true;
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}