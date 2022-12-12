package platform.codingnomads.co.springweb.resttemplate.POST.models;
import lombok.Data;

@Data
public class UserResponseObject {

    User data;
    Error error;
    String status;
}
