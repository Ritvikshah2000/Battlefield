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
            this.keysound = AudioSystem.getClip();   //音乐盒
            InputStream is = KeySound.class.getClassLoader().getResourceAsStream("keysound.wav");
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
