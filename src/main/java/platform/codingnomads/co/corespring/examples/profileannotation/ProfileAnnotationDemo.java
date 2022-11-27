package platform.codingnomads.co.corespring.examples.profileannotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import platform.codingnomads.co.corespring.examples.propertysourceannoation.App;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ProfileAnnotationDemo {
    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(ProfileAnnotationDemo.class);
        final SpringDeveloper springDeveloper = ctx.getBean(SpringDeveloper.class);
        System.out.println("Values from myapp.properties: " +
                "App Name: " + springDeveloper.getAppName() + ", App Version: " + springDeveloper.getAppVersion());
        ctx.close();
    }
}
