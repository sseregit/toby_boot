package toby.boot.config.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;
import toby.boot.config.ConditionalMyOnClass;
import toby.boot.config.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
class JettyWebServerConfig {

    @Bean("jettyWebServerFactory")
    @ConditionalOnMissingBean
    ServletWebServerFactory servletWebServerFactory(Environment env) {
        JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
        factory.setContextPath(env.getProperty("contextPath"));
        return factory;
    }

}
