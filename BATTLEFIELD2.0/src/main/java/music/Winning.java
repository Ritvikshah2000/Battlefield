package music;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class Winning {
    private Clip WinningSound;

    public Winning()
    {
        try
        {
            this.WinningSound = AudioSystem.getClip();   //音乐盒
            InputStream is = Winning.class.getClassLoader().getResourceAsStream("sound/wingame.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(is);
            this.WinningSound.open(ais);
            this.WinningSound.start();
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
        this.WinningSound.close();
    }
}
