package no.ankit.stream.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by AB75448 on 02.09.2016.
 */
@RestController
@EnableBinding(Source.class)
public class RestProducer {

    @Autowired
    MessageChannel output;

    @RequestMapping("/messages/{text}")
    public ResponseEntity<?> sendMessage(@PathVariable String text){
        output.send(MessageBuilder.withPayload("hello"+ text).build());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
