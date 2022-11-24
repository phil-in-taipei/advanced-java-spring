package platform.codingnomads.co.ioc.lab.initial;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Note: exclude allows this application to run without loading the data resources
// included in later labs. It would not be required otherwise
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) //
public class CodingNomadDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                CodingNomadConfiguration.class);
        CodingNomad codingNomad = ctx.getBean(CodingNomad.class);
        System.out.println(codingNomad.createAwesomeSoftware());
    }
}
