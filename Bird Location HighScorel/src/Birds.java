import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.*;

/**
*   @Author: Asif Mohaimen
*   @Reg. No.: 2012331054
*   @Project: Bird Location
*   @Renamed: For The Birds
*   @Game Type: Testing the sharpness of eyesight.
*/

/**
*   This is the main class of this project.
*/

public class Birds implements MouseListener, KeyListener, MouseMotionListener, Runnable
{
    /**
    * gm = Main Graphics2D Object. Where the game window runs.
    */
    public Graphics2D gm;
    
    /**
     * s = Main ScreenManager Object. Where the game window runs.
     */
    static public ScreenManager s;
    
    /**
     * Descriptions for the objects made:
     * Bird = it is the Object of the PlayBird Class. Which defines the position of the bird.
     * Chirping = it is the sound thread object for the successful hit sound clip.
     * crow = it is the sound thread object for the unsuccessful hit sound clip.
     */
    PlayBird Bird;
    Chirping chirping;
    Crow crow;
    
    /**
     * Images Used to display the background of each and every new window.
     */
    public static Image menu, about, help, background, pause, highscore, score, levelEasy, levelMedium, levelHard;
    
    /**
     * Descriptions for this variable group:
     * static private integers are for monitoring the scores & number of remaining shots.
     * static public boolean key variables are used for monitoring the current selection of the user.
     * Easy, Medium & Hard boolean variables are used for monitoring which level of difficulty the user have chosen.
     * Scr & Sht means Score & Shots accordingly.  This Strings are used to display the score & remaining shots during gameplay.
     */
    static private int ScoreEasy = 0, ShotsEasy = 10, ScoreMedium = 0, ShotsMedium = 15, ScoreHard = 0, ShotsHard = 20;
    static public boolean keyEasy = true, keyMedium = false, keyHard = false;
    static public boolean Easy = false, Medium = false, Hard = false;
    static public String ScrEasy, ShtEasy, ScrMedium, ShtMedium, ScrHard, ShtHard;
    
    /**
     * These High integers are used to store the HighScore.
     */
    static public int HardHigh, MediumHigh, EasyHigh;
    
    /**
     * These are the boolean variables to control the whole gameplay.
     */
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
    
    /**
     * These variables control the timings in various difficulty levels.
     */
    long cumTime,timePassed,timePassed2=0,passedTime;
    
    /**
     * This static object initiates the Background Sound at the very beginning.
     */
    final static SoundThread bsound = new SoundThread();
    
    /**
     * DisplayMode to choose for full screen.
     * Note: This is initiated only for my own pc.
     *       Haven't got the opportunity to check if it works on every pc.
     *       But in most cases it works fine.
     */
    public static final DisplayMode modes1[]=
    {
        new DisplayMode(800,600,32,0),
    };
    
    /**
     * The main method of the game.
     * Here the main object to run the game is created.
     * It also initiates the run method by which every single task of the game is performed.
     * @param args = arguments from the terminal. Not needed.
     */
    public static void main(String args[])
    {
        Birds main = new Birds();
        main.run();
    }
    
    /**
     * This method initializes everything to start the game.
     */
    void init()
     {
         menu = new ImageIcon("Files/Images/Menu.png").getImage();
         about = new ImageIcon("Files/Images/About.png").getImage();
         help = new ImageIcon("Files/Images/Help.png").getImage();
         background = new ImageIcon("Files/Images/background.png").getImage();
         pause = new ImageIcon("Files/Images/Pause.png").getImage();
         highscore = new ImageIcon("Files/Images/HighScore.png").getImage();
         score = new ImageIcon("Files/Images/Score.png").getImage();
         levelEasy = new ImageIcon("Files/Images/LevelEasy.png").getImage();
         levelMedium = new ImageIcon("Files/Images/LevelMedium.png").getImage();
         levelHard = new ImageIcon("Files/Images/LevelHard.png").getImage();
         s = new ScreenManager();
         Bird = new PlayBird();
         getHighScore();
     }
    
    /**
     * This method reads the stored HighScores from the consecutive files.
     */
    private void getHighScore()
    {
        try
        {
            File Fe = new File("Files/Scores/Easy.txt");
            File Fm = new File("Files/Scores/Medium.txt");
            File Fh = new File("Files/Scores/Hard.txt");
            Scanner Se = new Scanner(Fe);
            Scanner Sm = new Scanner(Fm);
            Scanner Sh = new Scanner(Fh);
            EasyHigh = Se.nextInt();
            MediumHigh = Sm.nextInt();
            HardHigh = Sh.nextInt();
            Se.close();
            Sm.close();
            Sh.close();
        }
        catch(Exception e){}
    }
    
    /**
     * This method stores the new HighScores in the consecutive files.
     */
    private void putHighScore()
    {
        try
        {
            BufferedWriter outputWriter = null;
            if(Easy)
            {
                if(ScoreEasy>EasyHigh)
                {
                    EasyHigh = ScoreEasy;
                    try
                    {
                        outputWriter = new BufferedWriter(new FileWriter("Files/Scores/Easy.txt"));
                        outputWriter.write(Integer.toString(EasyHigh));
                        outputWriter.flush();  
                        outputWriter.close();
                    }
                    catch(Exception e){}
                }
            }
            if(Medium)
            {
                if(ScoreMedium>MediumHigh)
                {
                    MediumHigh = ScoreMedium;
                    try
                    {
                        outputWriter = new BufferedWriter(new FileWriter("Files/Scores/Medium.txt"));
                        outputWriter.write(Integer.toString(MediumHigh));
                        outputWriter.flush();  
                        outputWriter.close();
                    }
                    catch(Exception e){}
                }
            }
            if(Hard)
            {
                if(ScoreHard>HardHigh)
                {
                    HardHigh = ScoreHard;
                    try
                    {
                        outputWriter = new BufferedWriter(new FileWriter("Files/Scores/Hard.txt"));
                        outputWriter.write(Integer.toString(HardHigh));
                        outputWriter.flush();  
                        outputWriter.close();
                    }
                    catch(Exception e){}
                }
            }
                
        }
        catch(Exception e){}
    }
    
    /**
     * This method initializes the Scores to Zero and the Shots to the number of highest chances.
     */
    private void initScoreShot()
    {
        ScoreEasy = 0;
        ShotsEasy = 10; 
        ScoreMedium = 0; 
        ShotsMedium = 15; 
        ScoreHard = 0; 
        ShotsHard = 20;
        ScrEasy = Integer.toString(ScoreEasy);
        ShtEasy = Integer.toString(ShotsEasy);
        ScrMedium = Integer.toString(ScoreMedium);
        ShtMedium = Integer.toString(ShotsMedium);
        ScrHard = Integer.toString(ScoreHard);
        ShtHard = Integer.toString(ShotsHard);
        finish = false;
    }
    
    /**
     * This is the main run method. Where the gameplay begins.
     * Every single task of this game is handled by this method.
     */
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
            /**
             * The following five lines are changing the mouse cursor.
             */
            Toolkit toolkit = Toolkit.getDefaultToolkit(); 
            Image image = toolkit.getImage("Files/Images/Ab.gif"); 
            Point hotSpot = new Point(0,0); 
            Cursor cursor = toolkit.createCustomCursor(image, hotSpot, "Ab");
            w.setCursor(cursor);
            /**
             * Here the game menu initializes.
             */
            while(GameMenu==true)
            {
                Graphics2D gm = s.getGraphics();
                Paint.paintOpeningScreen(gm);
                s.update();
                gm.dispose();
                /**
                 * This if block displays the HighScore.
                 */
                if(HighScore == true)
                 {
                     getHighScore();
                     while(HighScore == true)
                     {
                         Graphics2D g1=s.getGraphics();
                         Paint.paintHighScore(g1);
                         s.update();
                         gm.dispose();
                     }
                 }
                /**
                 * This if block displays the Game Info.
                 */
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
                 /**
                  * This if block displays the Help Screen.
                  */
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
                 /**
                  * This if block initiates the gameplay & displays the  level selection screen.
                  */
                 if(Play == true)
                 {
                     while(Play==true)
                     {
                         gm=s.getGraphics();
                         Paint.paintLevel(gm);
                         s.update();
                         gm.dispose();
                         /**
                          * Gameplay for easy difficulty level.
                          */
                         if(Easy)
                         {
                             initScoreShot();
                            Pause = false;
                            showBird = true;
                            cumTime = System.currentTimeMillis();
                            gm = s.getGraphics();
                            while(Play == true)
                            {
                                if(ShotsEasy > 0)
                                {
                                    start = true;
                                    if (letTheBirdToUpdate == true)
                                    {
                                        letTheBirdToUpdate = false;
                                        Bird.updateBird();
                                    }
                                    gm = s.getGraphics();
                                    paintPlayEasy(gm);
                                    s.update();
                                    gm.dispose();
                                    /**
                                     * Displays the pause screen.
                                     */
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
                                        /**
                                         * The following two lines are needed because
                                         * during mouse click on resume button one 
                                         * more shot is counted. To fix this bug these two
                                         * lines are added in every difficulty level.
                                         */
                                        ShotsEasy++;
                                        ShtEasy = Integer.toString(ShotsEasy);
                                        start = false;
                                    }
                                }
                                /**
                                 * When the game finishes this block displays the score screen.
                                 */
                                else if(finish)
                                {
                                    putHighScore();
                                    gm = s.getGraphics();
                                    Paint.paintFinished(gm);
                                    s.update();
                                    gm.dispose();
                                }
                                else
                                {
                                    Easy=false;
                                    Play=false;
                                }
                            }
                         }
                         /**
                          * Gameplay for the Medium Difficulty Level.
                          */
                         if(Medium)
                         {
                            initScoreShot();
                            Pause = false;
                            showBird = true;
                            cumTime = System.currentTimeMillis();
                            gm = s.getGraphics();
                            while(Play == true)
                            {
                                if(ShotsMedium > 0)
                                {
                                    start = true;
                                    if (letTheBirdToUpdate == true)
                                    {
                                        letTheBirdToUpdate = false;
                                        Bird.updateBird();
                                    }
                                    gm = s.getGraphics();
                                    paintPlayMedium(gm);
                                    s.update();
                                    gm.dispose();
                                    /**
                                     * Displays the pause screen.
                                     */
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
                                        /**
                                         * The following two lines are needed because
                                         * during mouse click on resume button one 
                                         * more shot is counted. To fix this bug these two
                                         * lines are added in every difficulty level.
                                         */
                                        ShotsMedium++;
                                        ShtMedium = Integer.toString(ShotsMedium);
                                        start = false;
                                    }
                                }
                                /**
                                 * When the game finishes this block displays the score screen.
                                 */
                                else if(finish)
                                {
                                    putHighScore();
                                    gm = s.getGraphics();
                                    Paint.paintFinished(gm);
                                    s.update();
                                    gm.dispose();
                                }
                                else
                                {
                                    Medium=false;
                                    Play=false;
                                }
                            }
                         }
                         /**
                          * Gameplay for hard difficulty level.
                          */
                         if(Hard)
                         {
                             initScoreShot();
                            Pause = false;
                            showBird = true;
                            cumTime = System.currentTimeMillis();
                            gm = s.getGraphics();
                            while(Play == true)
                            {
                                if(ShotsHard > 0)
                                {
                                    start = true;
                                    if (letTheBirdToUpdate == true)
                                    {
                                        letTheBirdToUpdate = false;
                                        Bird.updateBird();
                                    }
                                    gm = s.getGraphics();
                                    paintPlayHard(gm);
                                    s.update();
                                    gm.dispose();
                                    /**
                                     * Displays the pause screen. 
                                     */
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
                                        /**
                                         * The following two lines are needed because
                                         * during mouse click on resume button one 
                                         * more shot is counted. To fix this bug these two
                                         * lines are added in every difficulty level.
                                         */
                                        ShotsHard++;
                                        ShtHard = Integer.toString(ShotsHard);
                                        start = false;
                                    }
                                }
                                /**
                                 * When the game finishes this block displays the score screen.
                                 */
                                else if(finish)
                                {
                                    putHighScore();
                                    gm = s.getGraphics();
                                    Paint.paintFinished(gm);
                                    s.update();
                                    gm.dispose();
                                }
                                else
                                {
                                    Hard=false;
                                    Play = false;
                                }
                            }
                         }
                     }
                 }
            }
        }
        catch(Exception e){}
        finally
        {
            /**
             * This line restores the screen into the default display of the operating system after while exiting the program.
             */
            s.restoreScreen();
        }
    }
    
    /**
     * Paint method for the easy difficulty level.
     * time to display the bird is maintained in this method.
     * @param g contains the main Graphics2D object.
     */
    public void paintPlayEasy(Graphics2D g)
     {
         g.drawImage(background, 0, 0, null);
         Font fs = new Font("Impact", Font.BOLD, 20);
         Color Sc = new Color(0,0,64);
         g.setFont(fs);
         g.setColor(Sc);
         g.drawString("Score:", 550, 30);
         g.drawString("Shots Left:", 650, 30);
         g.drawString(ScrEasy, 610, 30);
         g.drawString(ShtEasy, 750, 30);
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
    
    /**
     * Paint method for the medium difficulty level.
     * time to display the bird is maintained in this method.
     * @param g contains the main Graphics2D object.
     */
    public void paintPlayMedium(Graphics2D g)
     {
         g.drawImage(background, 0, 0, null);
         Font fs = new Font("Impact", Font.BOLD, 20);
         Color Sc = new Color(0,0,64);
         g.setFont(fs);
         g.setColor(Sc);
         g.drawString("Score:", 550, 30);
         g.drawString("Shots Left:", 650, 30);
         g.drawString(ScrMedium, 610, 30);
         g.drawString(ShtMedium, 750, 30);
         Clouds.paintCloud(g);
         timePassed = System.currentTimeMillis() - cumTime;
         timePassed2 += timePassed;
         if(timePassed2<30000)
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
    
    /**
     * Paint method for the hard difficulty level.
     * time to display the bird is maintained in this method.
     * @param g contains the main Graphics2D object.
     */
    public void paintPlayHard(Graphics2D g)
     {
         g.drawImage(background, 0, 0, null);
         Font fs = new Font("Impact", Font.BOLD, 20);
         Color Sc = new Color(0,0,64);
         g.setFont(fs);
         g.setColor(Sc);
         g.drawString("Score:", 550, 30);
         g.drawString("Shots Left:", 650, 30);
         g.drawString(ScrHard, 610, 30);
         g.drawString(ShtHard, 750, 30);
         Clouds.paintCloud(g);
         timePassed = System.currentTimeMillis() - cumTime;
         timePassed2 += timePassed;
         if(timePassed2<10000)
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
    
     /**
      * This method can simply be called the master task handler for the game.
      * Handels each and every single mouse event.
      * @param e refers to the mouse clicking event.
      */
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
        {
            Easy = false;
            Medium = false;
            Hard = false;
            Play = false;
        }
        if(e.getX()>685 && e.getX()<768 && e.getY()>530 && e.getY()<550)
            Pause = true;
        if(e.getX()>260 && e.getX()<510 && e.getY()<400 && e.getY()>340)
        {
            Pause = false;
            start = false;
        }
        if(e.getX()>550 && e.getX()<715 && e.getY()<135 && e.getY() > 100)
            HighScore = true;
        if(e.getX()>350 && e.getX()<428 && e.getY()<500 && e.getY()>478)
            HighScore = false;
        if (Play == true && Pause == false)
        {
            if(Easy)
                ShotsEasy--;
            if(Medium)
                ShotsMedium--;
            if(Hard)
                ShotsHard--;
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
            /**
             * This if block checks the success of click and plays the sound.
             */
            if(Hard)
            {
                if(x>Bird.x && x<Bird.x+50 && y>Bird.y && y<Bird.y+50 )
                {
                    chirping = new Chirping();
                    ScoreHard++;
                }
                else
                {
                    if(start == true)
                        crow = new Crow();
                }
            }
            /**
             * This if block checks the success of click and plays the sound.
             */
            if(Medium)
            {
                if(x>Bird.x && x<Bird.x+70 && y>Bird.y && y<Bird.y+70 )
                {
                    chirping = new Chirping();
                    ScoreMedium++;
                }
                else
                {
                    if(start == true)
                        crow = new Crow();
                }
            }
            /**
             * This if block checks the success of click and plays the sound.
             */
            if(Easy)
            {
                if(x>Bird.x && x<Bird.x+90 && y>Bird.y && y<Bird.y+90 )
                {
                    chirping = new Chirping();
                    ScoreEasy++;
                }
                else
                {
                    if(start == true)
                        crow = new Crow();
                }
            }
            /**
             * These three if blocks updates the new scores and exits the game and controls the boolean to display the score screen.
             */
            if(Easy)
            {
                ScrEasy = Integer.toString(ScoreEasy);
                ShtEasy = Integer.toString(ShotsEasy);
                if(ShotsEasy == 0)
                    finish = true;
            }
            if(Medium)
            {
                ScrMedium = Integer.toString(ScoreMedium);
                ShtMedium = Integer.toString(ShotsMedium);
                if(ShotsMedium == 0)
                    finish = true;
            }
            if(Hard)
            {
                ScrHard = Integer.toString(ScoreHard);
                ShtHard = Integer.toString(ShotsHard);
                if(ShotsHard == 0)
                    finish = true;
            }
        }
    }
    
    /**
     * Handel the all key press events when the program runs.
     * The program Exits on pressing the escape key at anytime.
     * Handles the level selection screen.
     * @param e refers to the key pressing event.
     */
    public void keyPressed(KeyEvent e) 
    {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
            System.exit(0);
        finish = false;
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            if(keyEasy)
            {
                keyEasy=false;
                keyHard=false;
                keyMedium = true;
            }
            else if(keyMedium)
            {
                keyMedium=false;
                keyEasy=false;
                keyHard=true;
            }
            else if(keyHard)
            {
                keyHard=false;
                keyMedium=false;
                keyEasy=true;
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_UP)
        {
            if(keyEasy)
            {
                keyEasy=false;
                keyMedium=false;
                keyHard = true;
            }
            else if(keyMedium)
            {
                keyMedium=false;
                keyHard=false;
                keyEasy=true;
            }
            else if(keyHard)
            {
                keyHard=false;
                keyEasy=false;
                keyMedium=true;
            }
        }
        /**
         * Selects the chosen difficulty level by the user.
         */
        if(e.getKeyCode()==KeyEvent.VK_ENTER)
        {
            if(keyHard)
                Hard=true;
            else if(keyEasy)
                Easy=true;
            else if(keyMedium)
                Medium=true;
        }
    }
    
    /**
     * This method is only used for presenting an attractive GUI.
     * Handles the change of colors of different buttons if the mouse pointer goes over it.
     * @param e refers to the mouse event.
     */
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
        if(e.getX()>350 && e.getX()<428 && e.getY()<500 && e.getY()>478)//width 55
            mouseArrivedOnHighScore = true;
        else
            mouseArrivedOnHighScore = false;
    }
    
    /**
     * These are unused methods.
     * Bound to give blank bodies because of the implementations of
     * MouseListener, KeyListener, MouseMotionListener
     * @param e refers to the mouse & key events.
     */
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}