package platform.codingnomads.co.springdata.example.mybatis.myoneandmany;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import platform.codingnomads.co.springdata.example.mybatis.myoneandmany.mappers.TeacherMapper;
import platform.codingnomads.co.springdata.example.mybatis.myoneandmany.mappers.CourseMapper;
import platform.codingnomads.co.springdata.example.mybatis.myoneandmany.models.Teacher;
import platform.codingnomads.co.springdata.example.mybatis.myoneandmany.models.Course;

import java.util.ArrayList;
import java.util.Collections;

@SpringBootApplication
public class MyOneAndManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyOneAndManyApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(CourseMapper courseMapper, TeacherMapper teacherMapper) {
        return (args) -> {
            Teacher teacher1 = new Teacher();
            teacher1.setGivenName("Bob");
            teacher1.setSurname("LeSlob");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("This is the first teacher prior to database submission:");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println(teacher1.toString());
            teacherMapper.insertNewTeacher(teacher1);

            Teacher teacher2 = new Teacher();
            teacher2.setGivenName("Sarah");
            teacher2.setSurname("Schlara");
            teacherMapper.insertNewTeacher(teacher2);

            Course course1 = new Course();
            course1.setCourseName("Python 101");
            course1.setTeacher(teacher1);
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("This is the first course prior to database submission:");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println(course1.toString());
            System.out.println("---------------------------------------------------------------------------------");


            Teacher teacher3 = teacherMapper.getTeacherByIdWithCourses(1L);
            System.out.println("This is the first teacher following database submission:");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println(teacher3.toString());
            System.out.println("---------------------------------------------------------------------------------");
            courseMapper.insertNewCourse(course1);


            Course course2 = new Course();
            course2.setCourseName("JavaScript 101");
            course2.setTeacher(teacher2);
            courseMapper.insertNewCourse(course2);

            courseMapper.deleteCourseById(9L);

            Course course3 = courseMapper.getCourseById(3L);
            System.out.println(course3.toString());

            System.out.println("These are the courses with the Course Name 'Python 101':");
            System.out.println("---------------------------------------------------------------------------------");
            ArrayList<Course> pythonCourses = courseMapper.getCoursesByName(
                    "Python 101");
            for (Course c : pythonCourses) {
                System.out.println(c.toString());
                System.out.println("---------------------------------------------------------------------------------");
            }


            ArrayList<Course> sarahCourses = courseMapper.getCoursesByTeacherId(teacher2.getId());
            System.out.println("These are the courses with the newest teacher:");
            System.out.println("---------------------------------------------------------------------------------");

            for (Course c : sarahCourses) {
                System.out.println(c.toString());
                System.out.println("---------------------------------------------------------------------------------");
            }
        };
    }
}
