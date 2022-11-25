package platform.codingnomads.co.corespring.examples.primaryannotation;

import org.springframework.context.annotation.Bean;
import platform.codingnomads.co.corespring.examples.beanannotation.SampleBean;

public class PrimaryAnnotationConfig {
    @Bean
    public SampleBean secondBean() {
        return new SampleBean();
    }
}
