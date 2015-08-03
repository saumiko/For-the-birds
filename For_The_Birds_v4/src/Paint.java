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
         if(Birds.mResumea == true)
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
         if(Birds.mHighscorea == true)
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
        if(Birds.mAbouta == true)
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
        if(Birds.mHelpa == true)
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
         if(Birds.mPlay == true)
         {
             g1.setColor(m);
             g1.drawString("Play", 550, 100);
         }
         else
         {
             g1.setColor(norm);
             g1.drawString("Play", 550, 100);
         }
         if(Birds.mHighScore == true)
         {
             g1.setColor(m);
             g1.drawString("High Score", 550, 135);
         }
         else
         {
             g1.setColor(norm);
             g1.drawString("High Score", 550, 135);
         }
         if(Birds.mHelp == true)
         {
             g1.setColor(m);
             g1.drawString("Help", 550, 170);
         }
         else
         {
             g1.setColor(norm);
             g1.drawString("Help", 550, 170);
         }
         if(Birds.mAbout == true)
         {
             g1.setColor(m);
             g1.drawString("About", 550, 205);
         }
         else
         {
             g1.setColor(norm);
             g1.drawString("About", 550, 205);
         }
         if(Birds.mExit == true)
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
    
}
