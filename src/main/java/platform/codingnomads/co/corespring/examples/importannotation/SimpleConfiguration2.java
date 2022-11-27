package platform.codingnomads.co.corespring.examples.importannotation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleConfiguration2 {
    @Bean
    public SpringDeveloper2 springDeveloper2() {
        return new SpringDeveloper2();
    }
}
