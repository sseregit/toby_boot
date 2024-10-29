package toby.boot.config.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import toby.boot.config.ConditionalMyOnClass;
import toby.boot.config.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
class JettyWebServerConfig {

    @Bean("jettyWebServerFactory")
    @ConditionalOnMissingBean
    ServletWebServerFactory servletWebServerFactory(ServerProperties properties) {
        JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
        factory.setContextPath(properties.getContextPath());
        factory.setPort(properties.getPort());
        return factory;
    }
}
