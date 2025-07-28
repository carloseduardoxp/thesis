import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {
    public static void main(String[] args) {
        try {
            // Load audio file
            File audioFile = new File("your_music_file.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            
            // Get audio format
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            
            // Open audio clip
            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);
            
            // Play the clip
            audioClip.start();
            
            // Keep program running while sound plays
            while (audioClip.isRunning()) {
                Thread.sleep(100);
            }
            
            // Close resources
            audioClip.close();
            audioStream.close();
            
        } catch (UnsupportedAudioFileException | IOException | 
                LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
