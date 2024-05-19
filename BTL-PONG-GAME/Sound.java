import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];

    Sound() {
        //get sound
        soundURL[0] = getClass().getResource("/resources/ball-hit.wav");
        soundURL[1] = getClass().getResource("/resources/game-score.wav");
    }
    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch(Exception e) {
        }
    }
    public void play() {
        //start clip
        clip.start();
    }
    public void loop() {
        //loop clip
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop() {
        //stop clip
        clip.stop();
    }
}
