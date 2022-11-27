package platform.codingnomads.co.springdata.example.springdatajdbc;
import lombok.Data;
@Data
public class Restaurant {
    private long id;
    private String restaurantName;

    Restaurant(long id, String restaurantName) {
        this.id = id;
        this.restaurantName = restaurantName;
    }
}
