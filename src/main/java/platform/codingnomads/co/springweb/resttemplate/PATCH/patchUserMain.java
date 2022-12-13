package platform.codingnomads.co.springweb.resttemplate.PATCH;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.PATCH.models.ResponseObject;
import platform.codingnomads.co.springweb.resttemplate.PATCH.models.Task;
import platform.codingnomads.co.springweb.resttemplate.PATCH.models.UserResponseObject;
import platform.codingnomads.co.springweb.resttemplate.PATCH.models.User;

import java.util.Objects;

@SpringBootApplication
public class patchUserMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(patchUserMain.class, args);
    }

    @Bean
    public RestTemplate restTemplate() { // note: different for patch requests
        HttpClient client = HttpClients.createDefault();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(client));
        return restTemplate;
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            User user = new User();
            user.setId(411);
            user.setEmail("LaoRa@gmx.com"); // the other fields will be null


            UserResponseObject objectResponse = restTemplate
                    .patchForObject("http://demo.codingnomads.co:8080/tasks_api/users/"
                            + user.getId(), user, UserResponseObject.class);

            System.out.println(Objects.requireNonNull(objectResponse));

            user.setFirst_name("Lao-Ra");

            HttpEntity<User> httpEntity = new HttpEntity<>(user);

            ResponseEntity<UserResponseObject> response = restTemplate
                    .exchange(
                            "http://demo.codingnomads.co:8080/tasks_api/users/"
                                    + user.getId(), HttpMethod.PATCH,
                            httpEntity, UserResponseObject.class);

            System.out.println(Objects.requireNonNull(response));
        };
    }

}
