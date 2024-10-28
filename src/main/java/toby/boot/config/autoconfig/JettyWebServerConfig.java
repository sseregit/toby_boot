package toby.boot.config.autoconfig;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;
import toby.boot.config.MyAutoConfiguration;

@MyAutoConfiguration
@Conditional(JettyWebServerConfig.JettyCondition.class)
class JettyWebServerConfig {

    @Bean("jettyWebServerFactory")
    ServletWebServerFactory servletWebServerFactory() {
        return new JettyServletWebServerFactory();
    }

    static class JettyCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return false;
        }
    }
}
