package no.ankit.stream.component;

/**
 * Created by hp on 9/1/2016.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@EnableBinding(Source.class)
public class HttpSource {

    @Autowired
    MessageChannel output;

    @RequestMapping(path = "/messages/{text}")
    public ResponseEntity<?> timerMessageSource(@PathVariable String text) {
        output.send(MessageBuilder.withPayload("hello"+ text).build());
        return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
    }
}
