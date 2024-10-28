package toby.boot.config.autoconfig;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import toby.boot.config.MyAutoConfiguration;

@MyAutoConfiguration
class TomcatWebServerConfig {

    @Bean
    ServletWebServerFactory servletContainer() {
        return new TomcatServletWebServerFactory();
    }

}
