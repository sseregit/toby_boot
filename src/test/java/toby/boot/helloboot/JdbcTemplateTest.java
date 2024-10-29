package toby.boot.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.simple.JdbcClient;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
public class JdbcTemplateTest {

    @Autowired
    JdbcClient jdbcClient;

    @Test
    void insertAndQuery() {
        jdbcClient.sql("""
                        insert into hello values(?, ?)
                        """)
                .params("Toby", 3)
                .update();

        jdbcClient.sql("""
                        insert into hello values(?, ?)
                        """)
                .params("Spring", 1)
                .update();

        Long count = jdbcClient.sql("""
                        select count(*) from hello
                        """)
                .query(Long.class).single();

        assertThat(count).isEqualTo(2);
    }

}
