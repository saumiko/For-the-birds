import java.awt.*;

/**
 * @Author: Asif Mohaimen
 * @Reg. No.: 2012332054
 * @Class: This class contains all of the paint methods except which are needed during the gameplay.
 */
public class Paint extends Birds
{
    /**
     * This method displays the Pause Screen.
     * @param g refers to the main Graphics2D object.
     */
    static public void paintPause(Graphics2D g)
     {
         g.drawImage(Birds.pause,0,0,null);
         Font f = new Font("Forte", Font.BOLD, 60);
         Color norm = new Color(4,116,189);
         Color m = new Color(31,31,82);
         g.setFont(f);
         if(Birds.mouseArrivedOnResume == true)
         {
             g.setColor(m);
             g.drawString("RESUME", 260, 400);
         }
         else
         {
             g.setColor(norm);
             g.drawString("RESUME", 260, 400);
         }
     }
     
    /**
     * This method displays the HighScore Screen.
     * @param g refers to the main Graphics2D object.
     */
     static public void paintHighScore(Graphics2D g)
     {
         int Sx = 465, Sy = 213;
         String easy = Integer.toString(EasyHigh)+"/10";
         String medium = Integer.toString(MediumHigh)+"/15";
         String hard = Integer.toString(HardHigh)+"/20";
         g.drawImage(Birds.highscore,0,0,null);
         Font f = new Font("Comic Sans MS", Font.BOLD, 24);
         Font fs = new Font("Kristen ITC", Font.BOLD, 24);
         Color norm = new Color(4,116,189);
         Color m = new Color(31,31,82);
         Color S = new Color(0,0,98);
         g.setColor(S);
         g.setFont(fs);
         g.drawString(easy, Sx, Sy);
         g.drawString(medium, Sx, Sy+36);
         g.drawString(hard, Sx, Sy+72);
         g.setFont(f);
         if(Birds.mouseArrivedOnHighScore == true)
         {
             g.setColor(m);
             g.drawString("BACK", 350, 500);
         }
         else
         {
             g.setColor(norm);
             g.drawString("BACK", 350, 500);
         }
             
     }
     
     /**
     * This method displays the Game info.
     * @param g refers to the main Graphics2D object.
     */
    static public void paintAbout(Graphics2D g)
    {
        g.drawImage(Birds.about,0,0,null);
        Font f = new Font("Forte", Font.BOLD, 30);
        Color norm = new Color(221, 222, 227);
        Color m = new Color(82, 104, 169);
        g.setFont(f);
        if(Birds.mouseArrivedOnAbout == true)
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
    
    /**
     * This method displays the Game Help.
     * @param g refers to the main Graphics2D object.
     */
    static public void paintHelp(Graphics2D g)
    {
        g.drawImage(Birds.help,0,0,null);
        Font f = new Font("Forte", Font.BOLD, 30);
        Color norm = new Color(170, 151, 109);
        Color m = new Color(82, 104, 169);
        g.setFont(f);
        if(Birds.mouseArrivedOnHelp == true)
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
    
    /**
     * This method displays the Game Menu.
     * @param g1 refers to the main Graphics2D object.
     */
    static public void paintOpeningScreen(Graphics2D g1)
     {
         g1.drawImage(Birds.menu,0,0,null);
         Font f = new Font("Forte", Font.BOLD, 30);
         Color norm = new Color(221, 222, 227);
         Color m = new Color(82, 104, 169);
         g1.setFont(f);
         if(Birds.mouseOnPlay == true)
         {
             g1.setColor(m);
             g1.drawString("Play", 550, 100);
         }
         else
         {
             g1.setColor(norm);
             g1.drawString("Play", 550, 100);
         }
         if(Birds.mouseOnHighScore == true)
         {
             g1.setColor(m);
             g1.drawString("High Score", 550, 135);
         }
         else
         {
             g1.setColor(norm);
             g1.drawString("High Score", 550, 135);
         }
         if(Birds.mouseOnHelp == true)
         {
             g1.setColor(m);
             g1.drawString("Help", 550, 170);
         }
         else
         {
             g1.setColor(norm);
             g1.drawString("Help", 550, 170);
         }
         if(Birds.mouseOnAbout == true)
         {
             g1.setColor(m);
             g1.drawString("About", 550, 205);
         }
         else
         {
             g1.setColor(norm);
             g1.drawString("About", 550, 205);
         }
         if(Birds.mouseOnExit == true)
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
    
    /**
     * This method displays the Score Screen at the end of the game.
     * @param g refers to the main Graphics2D object.
     */
    static public void paintFinished(Graphics2D g)
    {
        g.drawImage(Birds.score,0,0,null);
        Font f = new Font("Impact", Font.BOLD, 50);
        Color sc = new Color(0,0,64);
        //String = Integer.toString(Birds.score1)
        g.setFont(f);
        g.setColor(sc);
        if(Birds.Easy)
        g.drawString(Birds.ScrEasy, 570, 300);
        if(Birds.Medium)
        g.drawString(Birds.ScrMedium, 570, 300);
        if(Birds.Hard)
        g.drawString(Birds.ScrHard, 570, 300);
    }
    
    /**
     * This method displays the Level Selection Screen.
     * Being handled by the keyboard.
     * @param g refers to the main Graphics2D object.
     */
    static public void paintLevel(Graphics2D g)
    {
        if(keyEasy)
            g.drawImage(Birds.levelEasy,0,0,null);
        else if(keyMedium)
            g.drawImage(Birds.levelMedium, 0, 0, null);
        else if(keyHard)
            g.drawImage(Birds.levelHard, 0, 0, null);
    }
}
