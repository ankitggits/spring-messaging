package no.ankit.amqp.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by AB75448 on 02.09.2016.
 */
@RestController
@RequestMapping("/messages")
public class RestProducer {

    @Autowired
    AmqpTemplate amqpTemplate;

    @RequestMapping("/{text}")
    public ResponseEntity<?> sendMessage(@PathVariable String text){
        amqpTemplate.convertAndSend(text);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
