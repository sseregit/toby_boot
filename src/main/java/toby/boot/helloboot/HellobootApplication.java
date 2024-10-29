package toby.boot.helloboot;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.simple.JdbcClient;

@SpringBootApplication
class HellobootApplication {

    private final JdbcClient jdbcClient;

    public HellobootApplication(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }

    @PostConstruct
    void init() {
        jdbcClient.sql("""
                        create table if not exists hello(name varchar(50) primary key, count int)
                        """)
                .update();
    }

}
