package toby.boot.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.RestClient;

import static org.assertj.core.api.Assertions.assertThat;

class HelloApiTest {

    @Test
    void helloApi() {
        //given
        //when
        //then
        ResponseEntity<String> res = RestClient.create("http://localhost:8080")
                .get()
                .uri("/hello?name={name}", "Spring")
                .retrieve()
                .toEntity(String.class);

        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        assertThat(res.getBody()).isEqualTo("Hello Spring!");

    }

    @Test
    void failsHelloApi() {
        //given
        //when
        //then
        ResponseEntity<String> res = new TestRestTemplate()
                .getForEntity("http://localhost:8080/hello?name=", String.class);

        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
