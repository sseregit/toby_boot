package toby.boot.helloboot;

import org.springframework.boot.SpringApplication;
import toby.boot.config.MySpringBootApplication;

@MySpringBootApplication
class HellobootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }

}
