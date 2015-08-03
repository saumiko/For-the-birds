import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * @Author: Asif Mohaimen
 * @Reg. No. : 2012331054
 * @Class: This class plays the background sound at the very beginning of the game.
 */

public class SoundThread implements Runnable
{
    /**
     * Constructor.
     * Initiates the Thread.
     */
    SoundThread()
    {
        Thread t = new Thread(this, "Sound Thread");
        t.setPriority(2);
        t.start();
    }
    
    /**
     * Main Run Method.
     * Plays the background sound.
     * Starts again if the clip stops playing.
     */
    public void run()
    {
            try 
            {
                 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Files/Sound/Silk.wav").getAbsoluteFile());
                 Clip clip = AudioSystem.getClip();
                 clip.open(audioInputStream);
                 clip.start();
                 if(clip.isOpen()==false)
                     clip.loop(5);
            }
            catch(Exception ex){}
    }
}
