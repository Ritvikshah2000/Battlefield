package music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.Clip;
import java.io.IOException;
import java.io.InputStream;

public class Boom {
    private Clip boom;

    /**
     * Loads the audio clip to be played when the Player collides with a Bomb
     * @see javax.sound.sampled
     */
    public Boom()
    {
        try
        {
            this.boom = AudioSystem.getClip();
            InputStream is = Boom.class.getClassLoader().getResourceAsStream("sound/boom.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(is);
            this.boom.open(ais);
            this.boom.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Terminates the audio clip played when the Player collides with a Bomb
     */
    public void stop()
    {
        this.boom.close();
    }
}
