package io.panki0xff.hsbcjavatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HsbcJavaTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(HsbcJavaTestApplication.class, args);
    }

}
