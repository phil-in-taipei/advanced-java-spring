package platform.codingnomads.co.springweb.resttemplate.POST.postForObjectMyTrial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.POST.models.ResponseObject;
import platform.codingnomads.co.springweb.resttemplate.POST.models.User;
import platform.codingnomads.co.springweb.resttemplate.POST.models.UserResponseObject;

@SpringBootApplication
public class postForObjectMyTrialMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(postForObjectMyTrialMain.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            User newUser = User.builder()
                    .email("ag123@gmail.com")
                    .first_name("Ali")
                    .last_name("Gee")
                    .build();

            UserResponseObject userReturnedByServerAfterPost = restTemplate
                    .postForObject("http://demo.codingnomads.co:8080/tasks_api/users", newUser, UserResponseObject.class);

            if (userReturnedByServerAfterPost != null) {
                System.out.println(userReturnedByServerAfterPost);
            }

        };
    }

}
