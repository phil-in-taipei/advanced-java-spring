package platform.codingnomads.co.springweb.resttemplate.GET.getForEntityMyTrial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.GET.models.BoredTemplate;

@SpringBootApplication
public class BoredApiGet {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(BoredApiGet.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            System.out.println("Starting the api command line runner in bored api");
            ResponseEntity<BoredTemplate> responseEntity =
                    restTemplate.getForEntity(
                            "https://www.boredapi.com/api/activity?participants={participants}",
                            BoredTemplate.class,
                            1
                    );
            if (responseEntity.getStatusCode().equals(HttpStatus.OK) && responseEntity.getBody() != null) {
                System.out.println("The api request has gone through");

                BoredTemplate boredTemplate = responseEntity.getBody();
                System.out.println("This is the boredTemplate");
                System.out.println(boredTemplate.toString());
            } else {
                System.out.println("Something went wrong! The response was not marked with status code 200");
            }
        };
    }

}
