package no.ankit.stream.component;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * Created by hp on 9/1/2016.
 */
@EnableBinding(Sink.class)
public class TaskConsumer {

    @StreamListener(Sink.INPUT)
    public void loggerSink(String taskMessage) {
        System.out.println("Received: " + taskMessage);
    }
}
