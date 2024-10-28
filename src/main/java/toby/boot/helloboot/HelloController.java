package toby.boot.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    String hello(String name) {
        if (Objects.isNull(name) || name.isEmpty()) throw new IllegalArgumentException();

        return helloService.sayHello(name);
    }

}
