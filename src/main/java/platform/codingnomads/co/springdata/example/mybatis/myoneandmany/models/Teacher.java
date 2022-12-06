package platform.codingnomads.co.springdata.example.mybatis.myoneandmany.models;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Song;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@ToString(exclude = "courses")
public class Teacher {

    private Long id;

    private String givenName;

    private String surname;

    private ArrayList<Course> courses;

}
