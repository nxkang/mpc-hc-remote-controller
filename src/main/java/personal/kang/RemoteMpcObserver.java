package personal.kang;

import com.eeeeeric.mpc.hc.api.MediaPlayerClassicHomeCinema;
import com.eeeeeric.mpc.hc.api.TimeCode;
import com.eeeeeric.mpc.hc.api.TimeCodeException;
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
public class RemoteMpcObserver implements MpcObserver {

    Logger LOGGER = LoggerFactory.getLogger(RemoteMpcObserver.class);

    @Autowired
    private MediaPlayerClassicHomeCinema mpc;

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

        try {

            TimeCode now = mpc.getPosition();
            remoteMpcService.sync(now);

        } catch (IOException | TimeCodeException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public void update(Observable o, Object arg) {

        MainWindowViewModel mainVm = (MainWindowViewModel) o;
        MpcEvent event = (MpcEvent) arg;

        try {

            if (event == MpcEvent.PLAY) {
                this.play();
            } else if (event == MpcEvent.PAUSE) {
                this.pause();
            } else if (event == MpcEvent.SYNC) {
                this.sync();
            } else {
                LOGGER.info("can't execute {}", arg.toString());
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
