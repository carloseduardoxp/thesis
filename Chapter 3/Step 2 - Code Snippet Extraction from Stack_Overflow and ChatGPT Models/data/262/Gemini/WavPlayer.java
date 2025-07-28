import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class WavPlayer {

    public static void main(String[] args) {
        try {
            // Specify the path to your WAV file
            File audioFile = new File("path/to/your/audio.wav"); // <--- REPLACE THIS

            if (!audioFile.exists()) {
                System.out.println("Audio file not found: " + audioFile.getAbsolutePath());
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            System.out.println("Playing audio...");
            clip.start();

            // Keep the program alive while the audio plays
            // You might want to add a more sophisticated way to handle playback in a real application
            Thread.sleep(clip.getMicrosecondLength() / 1000); // Wait for the audio to finish

            clip.close();
            audioStream.close();
            System.out.println("Audio finished.");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
