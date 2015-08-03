import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Crow implements Runnable
{
    Crow()
    {
        Thread t = new Thread(this, "Crow");
        t.setPriority(9);
        t.start();
    }
    
    public void run()
    {
            try 
            {
                 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Files/Sound/Crow.wav").getAbsoluteFile());
                 Clip clip = AudioSystem.getClip();
                 clip.open(audioInputStream);
                 clip.start();
            }
            catch(Exception ex){}
    }
}
