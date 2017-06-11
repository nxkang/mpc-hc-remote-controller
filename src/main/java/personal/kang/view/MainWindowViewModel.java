package personal.kang.view;

import com.eeeeeric.mpc.hc.api.MediaPlayerClassicHomeCinema;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import personal.kang.LocalMpcObserver;

import java.io.IOException;
import java.util.Observable;

/**
 * Created by kang on 2017/6/10.
 */
@Component
public class MainWindowViewModel extends Observable {

    Logger LOGGER = LoggerFactory.getLogger(MainWindowViewModel.class);



    @FXML
    private Label filePathLabel;

    @FXML
    void handleOpenFile() {

        LOGGER.debug("openFile clicked.");

        this.setChanged();
        this.notifyObservers(MpcEvent.OPEN_FILE);

    }

    @FXML
    void handlePlay() {

        LOGGER.debug("play clicked.");

        this.setChanged();
        this.notifyObservers(MpcEvent.PLAY);
    }

    @FXML
    void handlePause() {

        LOGGER.debug("pause clicked.");

        this.setChanged();
        this.notifyObservers(MpcEvent.PAUSE);
    }

    @FXML
    void handleSync() {

        LOGGER.debug("sync clicked.");

        this.setChanged();
        this.notifyObservers(MpcEvent.SYNC);
    }

}
