import javax.sound.sampled.*;

/**
 * @Author: Asif Mohaimen
 * @Reg. No. : 2012331054
 * @Class: This class controls the audio handling of the game.
 */

public class AudioPlayer 
{
    /**
     * @player: Object that contains the player.
     */
    static AudioPlayer player;
    
    /**
     * @clip: Object thst contains the audio clip.
     */
    private Clip clip;
    
    /**
     * Constructor for the class.
     */
    public AudioPlayer (String s)
    {    
        try 
        {
            AudioInputStream ais = 
                    AudioSystem.getAudioInputStream(
                        getClass().getResourceAsStream(s));
             AudioFormat baseFormat = ais.getFormat();
             AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,baseFormat.getSampleRate(),16,baseFormat.getChannels(),baseFormat.getChannels()*2,baseFormat.getSampleRate(),false);
             AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat,ais);
             clip = AudioSystem.getClip();
             clip.open(dais);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * This method plays the clip
     */
    public void play ()
    {
        if (clip ==  null){
            return ;
        }
        stop();
        clip.setFramePosition(0);
        clip.start();
    }
    
    /**
     * This method stops the running Audio Clip
     */
    public void stop(){
        if (clip.isRunning()){
            clip.stop();
        }
    }
    
    /**
     * This method closes the audio clip.
     */
    public void close(){
        stop();
        clip.close();
    }
}