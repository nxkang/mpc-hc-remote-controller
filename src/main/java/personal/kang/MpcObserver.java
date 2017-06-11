package personal.kang;

import java.io.IOException;
import java.util.Observer;

/**
 * Created by kang on 2017/6/10.
 */
public interface MpcObserver extends Observer {

    void openFile();

    void play() throws IOException;

    void pause() throws IOException;

    void sync();
}
