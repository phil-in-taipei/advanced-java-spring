package platform.codingnomads.co.springweb.resttemplate.POST.postForEntityMyTrial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.POST.models.ResponseObject;
import platform.codingnomads.co.springweb.resttemplate.POST.models.User;
import platform.codingnomads.co.springweb.resttemplate.POST.models.UserResponseObject;

import java.util.Objects;

@SpringBootApplication
public class postForEntityMyTrialMain {
    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(postForEntityMyTrialMain.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            User newUser = User.builder()
                    .email("sb@gmx.com")
                    .first_name("Sue")
                    .last_name("Blue")
                    .build();
            ResponseEntity<UserResponseObject> responseEntity = restTemplate
                    .postForEntity("http://demo.codingnomads.co:8080/tasks_api/users", newUser,
                            UserResponseObject.class);
            if (responseEntity.getStatusCode().equals(HttpStatus.CREATED)) {
                System.out.println(Objects.requireNonNull(responseEntity.getBody()));
            } else {
                System.out.println(Objects.requireNonNull(responseEntity.getBody()).getError());
            }
        };
    }
}
