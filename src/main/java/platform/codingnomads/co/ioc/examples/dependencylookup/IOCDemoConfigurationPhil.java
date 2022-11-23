package platform.codingnomads.co.ioc.examples.dependencylookup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class IOCDemoConfigurationPhil {

    public GreetingProvider provider() {
        return new PhilGreetingProvider();
    }

    @Bean
    public GreetingRenderer renderer() {
        GreetingRenderer renderer =
                new StandardOutGreetingRenderer();
        renderer.setGreetingProvider(provider());
        return renderer;
    }
}
