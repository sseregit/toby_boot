package toby.boot.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                "toby.boot.config.autoconfig.TomcatWebServerConfig",
                "toby.boot.config.autoconfig.DispatcherServletConfig"
        };
    }
}
