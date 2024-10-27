package toby.boot.helloboot;

import java.util.Objects;

class HelloController {

    String hello(String name) {

        SimpleHelloService helloService = new SimpleHelloService();

        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
