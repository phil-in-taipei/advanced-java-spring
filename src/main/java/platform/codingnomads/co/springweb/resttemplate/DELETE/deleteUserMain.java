package platform.codingnomads.co.springweb.resttemplate.DELETE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.DELETE.models.User;
import platform.codingnomads.co.springweb.resttemplate.DELETE.models.UserResponseObject;

import java.util.Objects;

@ComponentScan(basePackages = "")
@SpringBootApplication
public class deleteUserMain {
    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(deleteUserMain.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            User newUser = User.builder()
                    .email("xxxxxxx@gmx.com")
                    .first_name("McQue")
                    .last_name("Leslie")
                    .build();

            User newUser2 = User.builder()
                    .email("j!????dskjdsm@gmx.com")
                    .first_name("Colin")
                    .last_name("Schamllin")
                    .build();

            ResponseEntity<UserResponseObject> responseEntity = restTemplate
                    .postForEntity("http://demo.codingnomads.co:8080/tasks_api/users", newUser,
                            UserResponseObject.class);

            if (responseEntity.getStatusCode().equals(HttpStatus.CREATED)) {
                System.out.println(Objects.requireNonNull(responseEntity.getBody()));
                newUser = Objects.requireNonNull(responseEntity.getBody().getData());

            } else {
                System.out.println(Objects.requireNonNull(responseEntity.getBody()).getError());
            }

            System.out.println("The user was successfully created");
            System.out.println(newUser);

            //delete the newTask using the ID the server returned
            restTemplate.delete("http://demo.codingnomads.co:8080/tasks_api/users/" + newUser.getId());
            System.out.println("The user was also successfully deleted");




            responseEntity = restTemplate
                    .postForEntity("http://demo.codingnomads.co:8080/tasks_api/users", newUser2,
                            UserResponseObject.class);

            if (responseEntity.getStatusCode().equals(HttpStatus.CREATED)) {
                System.out.println(Objects.requireNonNull(responseEntity.getBody()));
                newUser2 = Objects.requireNonNull(responseEntity.getBody().getData());

            } else {
                System.out.println(Objects.requireNonNull(responseEntity.getBody()).getError());
            }

            try {
                restTemplate.getForEntity(
                        "http://demo.codingnomads.co:8080/tasks_api/users/"
                                + newUser2.getId(), UserResponseObject.class);
            } catch (HttpClientErrorException e) {
                System.out.println(e.getMessage());
            }

            System.out.println(newUser2);

            restTemplate.delete("http://demo.codingnomads.co:8080/tasks_api/users/" + newUser2.getId());


            /*HttpEntity<User> httpEntity = new HttpEntity<User>(newUser2);
            System.out.println(httpEntity);
            try {
                restTemplate.exchange("http://demo.codingnomads.co:8080/tasks_api/users/"
                + newUser2.getId(), HttpMethod.DELETE, httpEntity, UserResponseObject.class);
            } catch (HttpClientErrorException e) {
                System.out.println(e.getMessage());
            } */


        };
    }
}
