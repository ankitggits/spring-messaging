package no.ankit.stream.Processor;

import no.ankit.stream.component.TaskChannel;
import no.ankit.stream.component.TaskMessage;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;


/**
 * Created by AB75448 on 05.09.2016.
 */

@Component
@EnableBinding(TaskChannel.class)
public class TaskProcessor {

    @StreamListener(TaskChannel.INPUT)
    @SendTo(TaskChannel.OUTPUT)
    public TaskMessage handle(TaskMessage message) {
        message.setValue("hello " + message.getValue());
        return message;
    }
}

