package toby.boot.helloboot;

import org.springframework.stereotype.Service;

@Service
class SimpleHelloService implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name + "!";

    }
}
