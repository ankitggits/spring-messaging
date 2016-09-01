package no.ankit.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by hp on 9/1/2016.
 */

@SpringBootApplication
public class CloudStreamApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CloudStreamApplication.class, args);
    }

}
