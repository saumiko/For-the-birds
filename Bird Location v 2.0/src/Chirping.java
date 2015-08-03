import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Chirping implements Runnable
{
    Chirping()
    {
        Thread t = new Thread(this, "Chirping");
        t.setPriority(9);
        t.start();
    }
    
    public void run()
    {
            try 
            {
                 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Files/Sound/Chirping.wav").getAbsoluteFile());
                 Clip clip = AudioSystem.getClip();
                 clip.open(audioInputStream);
                 clip.start();
            }
            catch(Exception ex){}
    }
}
