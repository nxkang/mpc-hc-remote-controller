package personal.kang;

import com.eeeeeric.mpc.hc.api.TimeCode;
import com.eeeeeric.mpc.hc.api.TimeCodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kang on 2017/6/10.
 */
@Component
public class RemoteMpcService {

    @Autowired
    private MessageChannel mpcRequests;

    //    @Gateway(requestChannel = "playRequests", replyChannel = "playResponses")
    void play() {

        MessageBuilder msg = MessageBuilder.withPayload("");

        Map<String, String> headers = new HashMap<>();
        headers.put("cmd", "play");
        msg.copyHeaders(headers);

        mpcRequests.send(msg.build());
    }

    //    @Gateway(requestChannel = "pauseRequests", replyChannel = "pauseResponses")
    void pause() {

        MessageBuilder msg = MessageBuilder.withPayload("");

        Map<String, String> headers = new HashMap<>();
        headers.put("cmd", "pause");
        msg.copyHeaders(headers);

        mpcRequests.send(msg.build());
    }

    //
//    @Gateway(requestChannel = "syncRequests", replyChannel = "syncResponses")
    void sync(TimeCode timeCode) {

        MessageBuilder msg = MessageBuilder.withPayload(timeCode);

        Map<String, String> headers = new HashMap<>();
        headers.put("cmd", "sync");
        msg.copyHeaders(headers);

        mpcRequests.send(msg.build());
    }
}
