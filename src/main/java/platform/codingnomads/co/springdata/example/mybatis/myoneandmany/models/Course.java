package platform.codingnomads.co.springdata.example.mybatis.myoneandmany.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Course {
    private Long id;

    private String courseName;

    private Teacher teacher;

    public Course(String name, Teacher teacher) {
        this.courseName = name;
        this.teacher = teacher;
    }
}
