import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Paints 
{
    public void paintPause(Graphics2D g)
     {
         g.drawImage(Birds.pause,0,0,null);
         Font f = new Font("Forte", Font.BOLD, 60);
         Color norm = new Color(4,116,189);
         Color m = new Color(31,31,82);
         g.setFont(f);
         if(mResumea == true)
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
     
     public void paintHighScore(Graphics2D g)
     {
         g.drawImage(highscore,0,0,null);
         Font f = new Font("Comic Sans MS", Font.BOLD, 24);
         Color norm = new Color(4,116,189);
         Color m = new Color(31,31,82);
         g.setFont(f);
         if(mHighscorea == true)
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
}
