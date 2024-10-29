package toby.boot.helloboot;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import toby.boot.config.MySpringBootApplication;

@MySpringBootApplication
class HellobootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }

}
