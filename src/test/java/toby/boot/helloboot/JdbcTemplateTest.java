package toby.boot.helloboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@HellobootTest
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
