package platform.codingnomads.co.springdata.example.springdatajdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringDataJDBCDemo2 implements CommandLineRunner {
    @Autowired
    JdbcTemplate jdbcTemplate2;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJDBCDemo2.class);
    }

    @Override
    public void run(String... strings) {

        try {
            //create employee table using the JdbcTemplate method "execute"
            jdbcTemplate2.execute("CREATE TABLE restaurants (id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                    "restaurant_name VARCHAR(255) NOT NULL);");
        } catch (Exception e) {
            //nothing
        }

        //create a list of first and last names
        List<Object[]> names = Stream.of("McDonalds", "KFC", "Taco Bell")
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        for (Object[] name : names) {
            jdbcTemplate2.execute(String.format("INSERT INTO restaurants(restaurant_name) VALUES ('%s')", name[0]));
        }

        jdbcTemplate2.query(
                        "SELECT id, restaurant_name FROM restaurants",
                        (rs, rowNum) -> new Restaurant(rs.getLong("id"), rs.getString("restaurant_name"))
                )
                .forEach(restaurant -> System.out.println("Printing a restaurant: "+ restaurant.toString()));

        //truncate the table
        jdbcTemplate2.execute("TRUNCATE TABLE restaurants;");
        //delete the table
        jdbcTemplate2.execute("DROP TABLE restaurants");
    }
}
