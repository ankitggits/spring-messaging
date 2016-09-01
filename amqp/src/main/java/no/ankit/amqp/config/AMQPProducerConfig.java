package no.ankit.amqp.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by AB75448 on 01.09.2016.
 */
@Configuration
public class AMQPProducerConfig extends AMQPConfig{

    @Bean
    @Primary
    public AmqpTemplate amqpTemplate(){
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setRoutingKey(super.tasksQueue);
        template.setQueue(super.tasksQueue);
        //template.setMessageConverter(jsonMessageConverter());
        return template;
    }

}