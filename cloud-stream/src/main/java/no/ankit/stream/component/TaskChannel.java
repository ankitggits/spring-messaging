package no.ankit.stream.component;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * Created by AB75448 on 05.09.2016.
 */
public interface TaskChannel {

    String INPUT = "taskInput";

    String OUTPUT = "taskOutput";

    @Input(INPUT)
    SubscribableChannel taskInput();

    @Output(OUTPUT)
    MessageChannel taskOutput();

}
