package personal.kang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import personal.kang.view.MainWindowViewModel;
import personal.kang.view.MpcEvent;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by kang on 2017/6/10.
 */
@Component
public class RemoteMpcObserver  implements MpcObserver {

    Logger LOGGER = LoggerFactory.getLogger(RemoteMpcObserver.class);

    @Autowired
    private RemoteMpcService remoteMpcService;

    public void addObserver(Observable observable) {
        observable.addObserver(this);
    }

    public void openFile() {

        LOGGER.debug("openFile..");


    }

    public void play() throws IOException {

        LOGGER.debug("play..");

        remoteMpcService.play();

    }

    public void pause() throws IOException {

        LOGGER.debug("pause..");

        remoteMpcService.pause();
    }

    public void sync() {

        LOGGER.debug("sync...");

        remoteMpcService.sync();
    }

    public void update(Observable o, Object arg) {

        MainWindowViewModel mainVm = (MainWindowViewModel) o;
        MpcEvent event = (MpcEvent) arg;

        try {

            if (event == MpcEvent.PLAY) {
                this.play();
            } else if (event == MpcEvent.PAUSE) {
                this.pause();
            } else {
                LOGGER.info("can't execute {}", arg.toString());
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
