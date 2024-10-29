package toby.boot.helloboot;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepositoryJdbc implements HelloRepository {

    private final JdbcClient jdbcClient;

    public HelloRepositoryJdbc(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Hello findHello(String name) {
        try {
            Hello hello = jdbcClient.sql("""
                            select * from hello where name = :name
                            """).param("name", name)
                    .query(Hello.class)
                    .single();
            return hello;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void increase(String name) {
        Hello hello = findHello(name);
        if (hello == null) {
            jdbcClient.sql("""
                    insert into hello values (:name, :count)
                    """)
                    .param("name", name)
                    .param("count", 1)
                    .update();
            return;
        }

        jdbcClient.sql("""
                    update hello set count = :count where name = :name
                    """)
                .param("count", hello.getCount() + 1)
                .param("name", name)
                .update();

    }
}
