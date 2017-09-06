package io.dmitr.springbootwebsockets.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dmaslov on 06/09/2017.
 */
@Component
@ComponentScan(basePackages = "io.dmitr")
public class Producer {

    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyy HH:mm:ss");
    @Autowired
    private SimpMessagingTemplate template;

    public void sendMessageTo(String topic, String message) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append(dateFormatter.format(new Date()));
        builder.append("]");
        builder.append(message);
        this.template.convertAndSend("/topic/" + topic, builder.toString());

    }
}
