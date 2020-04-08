package music;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class KeySound {
    private Clip keysound;

    public KeySound()
    {
        try
        {
            this.keysound = AudioSystem.getClip();
            InputStream is = KeySound.class.getClassLoader().getResourceAsStream("sound/keysound.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(is);
            this.keysound.open(ais);
            this.keysound.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop()
    {
        this.keysound.close();
    }
}
