package music;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class Boom {
    private Clip boom;

    public Boom()
    {
        try
        {
            this.boom = AudioSystem.getClip();   //音乐盒
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

    public void stop()
    {
        this.boom.close();
    }
}
