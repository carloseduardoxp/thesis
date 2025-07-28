import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class PlaySound {
    public static void main(String[] args) {
        try {
            // Path to your WAV file
            File soundFile = new File("path/to/your/sound.wav");
            
            // Get audio input stream from file
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            
            // Get a clip resource
            Clip clip = AudioSystem.getClip();
            
            // Open audio clip and load samples from the audio input stream
            clip.open(audioStream);
            
            // Start playing
            clip.start();
            
            // Keep program running till sound is playing
            Thread.sleep(clip.getMicrosecondLength() / 1000);
            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
