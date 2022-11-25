package platform.codingnomads.co.corespring.lab;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import platform.codingnomads.co.corespring.lab.complete.Turntable;

@Configuration
@ImportResource({"classpath*:xml-config/food-products.xml"})
public class CoreLabConfig {
    @Bean
    public Oven oven() {
        return new Oven("Panasonic", "PN-2000");
    }

}
