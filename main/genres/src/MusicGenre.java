import javax.sound.sampled.Clip;
import java.io.File;

public interface MusicGenre {
    File[] files = new File[5];

    void Resume(Clip clip, File file);

    void Pause(Clip clip, File file);

    void Skip(Clip clip, File file);

    void Restart(Clip clip, File file);

    void Quit(Clip clip,File file);

    void Features (Clip clip, File file);
}
