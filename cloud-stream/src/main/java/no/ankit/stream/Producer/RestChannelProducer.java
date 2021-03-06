package no.ankit.stream.Producer;

import no.ankit.stream.component.TaskChannel;
import no.ankit.stream.component.TaskMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

/**
 * Created by AB75448 on 05.09.2016.
 */
@RestController
@EnableBinding(TaskChannel.class)
public class RestChannelProducer {

    private MessageChannel output;

    @Autowired
    public RestChannelProducer(@Qualifier(TaskChannel.OUTPUT) MessageChannel output) {
        this.output = output;
    }

    @RequestMapping(path = "/messages/custom/{text}", method = RequestMethod.GET, consumes = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void handleRequest(@PathVariable String text, @RequestHeader(HttpHeaders.CONTENT_TYPE) Object contentType) {
        sendMessage(text, contentType);
    }

    private void sendMessage(String body, Object contentType) {
        output.send(MessageBuilder.createMessage(new TaskMessage(body),
                new MessageHeaders(Collections.singletonMap(MessageHeaders.CONTENT_TYPE, contentType))));
        System.out.println("Sent the message");
    }

}
