package no.ankit.amqp;

import no.ankit.amqp.component.TaskMessage;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class AmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmqpApplication.class, args);
	}
}
