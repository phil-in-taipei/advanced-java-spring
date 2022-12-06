package platform.codingnomads.co.springdata.example.mybatis.myoneandmany.mappers;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import platform.codingnomads.co.springdata.example.mybatis.myoneandmany.models.Course;
import platform.codingnomads.co.springdata.example.mybatis.myoneandmany.models.Teacher;

import java.util.ArrayList;
@Mapper
public interface CourseMapper {

    @Insert("INSERT INTO mybatis.courses " +
            "(course_name, teacher_id) " +
            "VALUES (#{courseName}, #{teacher.id});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertNewCourse(Course course);

    @Select("SELECT * " +
            "FROM mybatis.courses " +
            "WHERE id = #{param1};")
    @Results(
            id = "courseResultMap",
            value = {
                    @Result(property = "courseName", column = "course_name"),
                    @Result(
                            //property to map to
                            property = "teacher",
                            column = "teacher_id",
                            javaType = Teacher.class,
                            one = @One(
                                    select = "platform.codingnomads.co.springdata.example.mybatis.myoneandmany.mappers.TeacherMapper.getTeacherByIdWithoutCourses",
                                    fetchType = FetchType.LAZY
                            )
                    )
            }
    )
    Course getCourseById(Long id);

    @Select("SELECT *" +
            "FROM mybatis.courses " +
            "WHERE teacher_id = #{param1};")
    @ResultMap("courseResultMap")
    ArrayList<Course> getCoursesByTeacherId(Long teacherId);

    @Delete("DELETE FROM mybatis.courses WHERE id = #{param1};")
    void deleteCourseById(Long courseId);

    @Select("SELECT * " +
            "FROM mybatis.courses " +
            "WHERE course_name = #{param1};")
    @ResultMap("courseResultMap")
    ArrayList<Course> getCoursesByName(String courseName);

}
