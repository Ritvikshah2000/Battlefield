package music;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class FreezeSound {
    private Clip freezesound;

    public FreezeSound()
    {
        try
        {
            this.freezesound = AudioSystem.getClip();   //音乐盒
            InputStream is = FreezeSound.class.getClassLoader().getResourceAsStream("sound/freezesound.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(is);
            this.freezesound.open(ais);
            this.freezesound.start();
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
        this.freezesound.close();
    }
}
