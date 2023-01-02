package platform.codingnomads.co.springtest.understandingandusingprofiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
//@Profile("understanding_and_using_profiles")
@Profile({"test", "understanding_and_using_profiles", "bean_example"})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
