package personal.kang;

import com.eeeeeric.mpc.hc.api.MediaPlayerClassicHomeCinema;
import com.eeeeeric.mpc.hc.api.TimeCode;
import com.eeeeeric.mpc.hc.api.TimeCodeException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by kang on 2017/6/10.
 */
@Component
public class RemoteMpcServiceImpl {

    Logger LOGGER = Logger.getLogger(RemoteMpcServiceImpl.class);

    @Autowired
    private MediaPlayerClassicHomeCinema mpc;

    public void play() {

        LOGGER.debug("play..");

        try {
            mpc.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pause() {

        LOGGER.debug("pause..");

        try {
            mpc.pause();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sync(TimeCode timeCode) {

        LOGGER.debug("sync...");

        try {
            mpc.seek(timeCode);
        } catch (IOException | TimeCodeException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
