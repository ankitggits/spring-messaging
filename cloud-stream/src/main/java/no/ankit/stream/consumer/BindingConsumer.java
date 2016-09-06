package no.ankit.stream.consumer;

import no.ankit.stream.component.TaskMessage;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * Created by hp on 9/1/2016.
 */
@EnableBinding(Sink.class)
public class BindingConsumer {

    @StreamListener(Sink.INPUT)
    public void loggerSink(TaskMessage taskMessage) {
        System.out.println("Received on binding consumer: " + taskMessage.getValue());
    }
}
