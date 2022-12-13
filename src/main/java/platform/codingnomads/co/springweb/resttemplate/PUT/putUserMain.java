package platform.codingnomads.co.springweb.resttemplate.PUT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.ResponseObject;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.Task;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.User;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.UserResponseObject;

@SpringBootApplication
public class putUserMain {
    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(putUserMain.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            int userId = 411;

            UserResponseObject responseObject = restTemplate
                    .getForObject(
                            "http://demo.codingnomads.co:8080/tasks_api/users/" +
                                    userId, UserResponseObject.class);

            User userToUpdate;
            if (responseObject == null) {
                throw new Exception("The server did not return anything. Not even a ResponseObject!");
            } else if (responseObject.getData() == null) {
                throw new Exception("The task with ID " + userId + " could not be found");
            } else {
                userToUpdate = responseObject.getData();
            }

            userToUpdate.setEmail("Laura@gmx.com");
            userToUpdate.setFirst_name("Laurra");
            userToUpdate.setLast_name("Schmooura");

            restTemplate.put(
                    "http://demo.codingnomads.co:8080/tasks_api/users/"
                            + userToUpdate.getId(), userToUpdate);

            responseObject = restTemplate.getForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/users/" + userId, UserResponseObject.class);
            System.out.println(responseObject.toString());


            userToUpdate.setFirst_name("Lourah");
            userToUpdate.setLast_name("Schmuuuoooooura");

            HttpEntity<User> httpEntity = new HttpEntity<>(userToUpdate);

            ResponseEntity<UserResponseObject> response = restTemplate.exchange(
                    "http://demo.codingnomads.co:8080/tasks_api/users/" + userToUpdate.getId(),
                    HttpMethod.PUT, httpEntity, UserResponseObject.class);
            System.out.println(response.toString());
        };
    }
}
