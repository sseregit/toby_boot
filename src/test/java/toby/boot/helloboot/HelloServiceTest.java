package toby.boot.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HelloServiceTest {

    @Test
    void simpleHelloService() {
        //given
        SimpleHelloService helloService = new SimpleHelloService();
        //when
        String ret = helloService.sayHello("Spring");
        //then
        assertThat(ret).isEqualTo("Hello Spring!");
    }

    @Test
    void helloDecorator() {
        HelloDecorator decorator = new HelloDecorator(name -> name);

        String ret = decorator.sayHello("Test");

        Assertions.assertThat(ret).isEqualTo("""
                ****************************
                             Test
                ****************************
                """);
    }

}