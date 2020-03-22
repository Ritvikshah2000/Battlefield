package music;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class BGM {
    private Clip bgm;

    public BGM()
    {
        try
        {
            this.bgm = AudioSystem.getClip();   // music box
            InputStream is = BGM.class.getClassLoader().getResourceAsStream("bgm.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(is);
            this.bgm.open(ais);
            this.bgm.loop(Clip.LOOP_CONTINUOUSLY);    // play music continuously
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
        this.bgm.close();
    }
}
