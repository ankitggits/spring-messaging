package no.ankit.amqp.component;

import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

/**
 * Created by AB75448 on 01.09.2016.
 */
@Component
public class TaskConsumer {

    public void handleMessage(String message) {
        System.out.println("Received summary: " + message);
    }
}
