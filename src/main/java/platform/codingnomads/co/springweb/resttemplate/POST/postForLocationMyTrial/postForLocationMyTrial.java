package platform.codingnomads.co.springweb.resttemplate.POST.postForLocationMyTrial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.POST.models.UserResponseObject;
import platform.codingnomads.co.springweb.resttemplate.POST.models.User;
//import platform.codingnomads.co.springweb.resttemplate.POST.postForEntityMyTrial.postForEntityMyTrialMain;

import java.net.URI;
import java.util.Objects;

@SpringBootApplication
public class postForLocationMyTrial {
    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(postForLocationMyTrial.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            User newUser = User.builder()
                    .email("eugene_baffle@hotmail.com")
                    .first_name("Eugene")
                    .last_name("Baffle")
                    .build();

            //URI returnedLocation = restTemplate
            //        .postForLocation("http://demo.codingnomads.co:8080/tasks_api/users", newUser,
            //                UserResponseObject.class);

           // System.out.println(Objects.requireNonNull(returnedLocation));

            ResponseEntity<?> responseEntity = restTemplate
                    .postForEntity("http://demo.codingnomads.co:8080/tasks_api/users", newUser,
                            UserResponseObject.class);

            System.out.println(responseEntity.getHeaders().get("Location"));

        };
    }
}
