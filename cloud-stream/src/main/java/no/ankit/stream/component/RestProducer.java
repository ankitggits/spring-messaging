package no.ankit.stream.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


/**
 * Created by AB75448 on 02.09.2016.
 */
@RestController
@EnableBinding(Source.class)
public class RestProducer {

    @Autowired
    private Source channels;

    @RequestMapping(path = "/messages/{text}", method = RequestMethod.GET, consumes = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void handleRequest(@PathVariable String text, @RequestHeader(HttpHeaders.CONTENT_TYPE) Object contentType) {
        sendMessage(text, contentType);
    }

    private void sendMessage(Object body, Object contentType) {
        channels.output().send(MessageBuilder.createMessage(body,
                new MessageHeaders(Collections.singletonMap(MessageHeaders.CONTENT_TYPE, contentType))));
    }


}
