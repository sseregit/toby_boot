package toby.boot.config.autoconfig;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import toby.boot.config.MyAutoConfiguration;

@MyAutoConfiguration
class JettyWebServerConfig {

    @Bean("jettyWebServerFactory")
    ServletWebServerFactory servletWebServerFactory() {
        return new JettyServletWebServerFactory();
    }

}
