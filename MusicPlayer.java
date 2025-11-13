import java.io.File;
import javax.sound.sampled.*;

public class MusicPlayer 
{
    private Clip clip;
    
    public void play_1(String filename)
    {
        new Thread(() -> {
            try {
                File audioFile = new File(filename);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.loop(0);
                // Can use to repeat clip.loop(Clip.LOOP_CONTINUOUSLY);
                // Can add clip.loop(3) to play 3 times. Etc.
                clip.start();
            } catch (Exception e) {
                System.out.println("Could not play music: " + e.getMessage());
            }
        }).start();
    }
    public void play_2(String filename)
    {
        new Thread(() -> {
            try {
                File audioFile = new File(filename);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                // Can use to repeat clip.loop(Clip.LOOP_CONTINUOUSLY);
                // Can add clip.loop(3) to play 3 times. Etc.
                clip.start();
            } catch (Exception e) {
                System.out.println("Could not play music: " + e.getMessage());
            }
        }).start();
    }
    
    public void stop()
    {
        if (clip != null && clip.isRunning())
        {
            clip.stop();
            clip.close();
        }
    }
}