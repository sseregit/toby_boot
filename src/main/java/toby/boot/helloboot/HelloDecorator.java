package toby.boot.helloboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
class HelloDecorator implements HelloService {

    private final HelloService target;

    public HelloDecorator(HelloService target) {
        this.target = target;
    }

    @Override
    public String sayHello(String name) {
        return """
                ****************************
                             %s
                ****************************             
                """.formatted(target.sayHello(name));
    }

    @Override
    public int countOf(String name) {
        return target.countOf(name);
    }
}
