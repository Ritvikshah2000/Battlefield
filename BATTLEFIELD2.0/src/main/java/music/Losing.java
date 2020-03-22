package music;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class Losing {
    private Clip LosingSound;

    public Losing()
    {
        try
        {
            this.LosingSound = AudioSystem.getClip();   //音乐盒
            InputStream is = Losing.class.getClassLoader().getResourceAsStream("losegame.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(is);
            this.LosingSound.open(ais);
            this.LosingSound.start();
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
        this.LosingSound.close();
    }
}
