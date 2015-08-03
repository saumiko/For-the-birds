import java.awt.*;

public class Paint extends Birds
{
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
     
     static public void paintHighScore(Graphics2D g)
     {
         g.drawImage(Birds.highscore,0,0,null);
         Font f = new Font("Comic Sans MS", Font.BOLD, 24);
         Color norm = new Color(4,116,189);
         Color m = new Color(31,31,82);
         g.setFont(f);
         if(Birds.mouseArrivedOnHighScore == true)
         {
             g.setColor(m);
             g.drawString("BACK", 375, 500);
         }
         else
         {
             g.setColor(norm);
             g.drawString("BACK", 375, 500);
         }
             
     }
     
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
    
    static public void paintFinished(Graphics2D g)
    {
        g.drawImage(Birds.score,0,0,null);
        Font f = new Font("Impact", Font.BOLD, 50);
        Color sc = new Color(0,0,64);
        //String = Integer.toString(Birds.score1)
        g.setFont(f);
        g.setColor(sc);
        g.drawString(Birds.Scr1, 570, 300);
    }
    
    static public void paintLevel(Graphics2D g, int x, int y, int m)
    {
        //int x = 350, y = 200, m = 30;
        g.drawImage(Birds.level, 0, 0, null);
        Font f = new Font("Impact", Font.BOLD, 30);
        Color Off = new Color(9,9,47);
        Color On = new Color(232,115,41);
        g.setFont(f);
        if(Birds.mouseOnlevel1)
        {
            Birds.select1 = true;
            g.setColor(On);
            g.drawString("Level 1", x, y);
        }
        else
        {
            Birds.select1 = false;
            g.setColor(Off);
            g.drawString("Level 1", x, y);
        }
        if(Birds.mouseOnlevel2)
        {
            Birds.select2 = true;
            g.setColor(On);
            g.drawString("Level 2", x, y+m+5);
        }
        else
        {
            Birds.select2 = false;
            g.setColor(Off);
            g.drawString("Level 2", x, y+m+5);
        }
        if(Birds.mouseOnlevel3)
        {
            Birds.select3 = true;
            g.setColor(On);
            g.drawString("Level 3", x, y+2*m+5);
        }
        else
        {
            Birds.select3 = false;
            g.setColor(Off);
            g.drawString("Level 3", x, y+2*m+5);
        }
        if(Birds.mouseOnlevel4)
        {
            Birds.select4 = true;
            g.setColor(On);
            g.drawString("Level 4", x, y+3*m+5);
        }
        else
        {
            Birds.select4 = false;
            g.setColor(Off);
            g.drawString("Level 4", x, y+3*m+5);
        }
        if(Birds.mouseOnlevel5)
        {
            Birds.select5 = true;
            g.setColor(On);
            g.drawString("Level 5", x, y+4*m+5);
        }
        else
        {
            Birds.select5 = false;
            g.setColor(Off);
            g.drawString("Level 5", x, y+4*m+5);
        }
        if(Birds.mouseOnlevel6)
        {
            Birds.select6 = true;
            g.setColor(On);
            g.drawString("Level 6", x, y+5*m+5);
        }
        else
        {
            Birds.select6 = false;
            g.setColor(Off);
            g.drawString("Level 6", x, y+5*m+5);
        }
    }
}
