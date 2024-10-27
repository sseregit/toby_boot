package toby.boot.helloboot;

import java.util.Objects;

class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    String hello(String name) {

        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
