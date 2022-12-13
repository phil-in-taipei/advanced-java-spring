package platform.codingnomads.co.springweb.resttemplate.PATCH.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Builder
@NoArgsConstructor
public class User {
    private long id;
    private String email;
    private String first_name;
    private String last_name;
    private long updated_at;
    private long created_at;


}
