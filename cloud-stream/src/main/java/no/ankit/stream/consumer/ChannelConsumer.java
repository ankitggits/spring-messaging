package no.ankit.stream.consumer;

import no.ankit.stream.component.TaskChannel;
import no.ankit.stream.component.TaskMessage;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * Created by AB75448 on 05.09.2016.
 */
@EnableBinding(TaskChannel.class)
public class ChannelConsumer {

    @StreamListener(TaskChannel.OUTPUT)
    public void loggerSink(TaskMessage taskMessage) {
        System.out.println("Received on Channel Consumer: " + taskMessage.getValue());
    }
}

