package toby.boot.helloboot;

class SimpleHelloService implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name + "!";

    }
}