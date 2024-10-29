package toby.boot.config.autoconfig;

import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import toby.boot.config.MyAutoConfiguration;

@MyAutoConfiguration
public class ServerPropertiesConfig {
    @Bean
    ServerProperties serverProperties(Environment env) {
        return Binder.get(env).bind("", ServerProperties.class).get();
    }
}
