package toby.boot.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class HelloApiTest {

    @Test
    void helloApi() {
        //given
        //when
        //then
        ResponseEntity<String> res = RestClient.create("http://localhost:9090/app")
                .get()
                .uri("/hello?name={name}", "Spring")
                .retrieve()
                .toEntity(String.class);

        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        assertThat(res.getBody()).isEqualTo("""
                ****************************
                             Hello Spring!
                ****************************
                """);

    }

    @Test
    void failsHelloApi() {
        //given
        //when
        //then
        ResponseEntity<String> res = new TestRestTemplate()
                .getForEntity("http://localhost:9090/app/hello?name=", String.class);

        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
