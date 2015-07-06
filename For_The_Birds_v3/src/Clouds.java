import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Clouds 
{
    public Image cloud1, cloud2, cloud3, cloud4;
    private int cloud1x = 100;
    private int cloud2x = 200;
    private int cloud3x = 500;
    private int cloud1y = 40;
    private int cloud2y = 100;
    private int cloud3y = 300;
    private int cloud4x = 800;
    private int cloud4y = 600;
    
    Clouds()
    {
        cloud1 = new ImageIcon("Files/Images/cloud1.png").getImage();
        cloud2 = new ImageIcon("Files/Images/cloud2.png").getImage();
        cloud3 = new ImageIcon("Files/Images/cloud3.png").getImage();
        cloud4 = new ImageIcon("Files/Images/cloud4.png").getImage();
    }
    
}
