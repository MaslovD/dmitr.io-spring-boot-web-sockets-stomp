package io.dmitr.springbootwebsockets.web;

import io.dmitr.springbootwebsockets.websocket.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Created by dmaslov on 06/09/2017.
 */
@RestController
public class WebSocketController {
    @Autowired
    Producer producer;

    @RequestMapping("/send/{topic}")
    public void sender(@PathVariable String topic, @RequestParam String message) throws InterruptedException {

        //for (int i = 0; i < 100; i++) {
        // while (true) {
        producer.sendMessageTo(topic, message);
        //  Thread.sleep(100);
        //}

        //return "OK-Sent";
    }
}
