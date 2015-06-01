import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundThread implements Runnable
{
//    public volatile boolean f = false;
    
    SoundThread()
    {
        Thread t = new Thread(this, "Sound Thread");
        t.setPriority(2);
        t.start();
    }
    
    public void run()
    {
//        while(f == false)
//        {
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
//        }
    }
}
