package platform.codingnomads.co.springdata.example.mybatis.myoneandmany.mappers;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import platform.codingnomads.co.springdata.example.mybatis.myoneandmany.models.Teacher;

import java.util.ArrayList;
@Mapper
public interface TeacherMapper {

    @Insert("INSERT INTO mybatis.teachers (given_name, surname) VALUES (#{givenName}, #{surname});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertNewTeacher(Teacher teacher);

    @Select("SELECT * FROM mybatis.teachers WHERE id = #{param1};")
    @Results(
            id = "teacherResultMap",
            value = {
                @Result(property = "id", column = "id"),
                @Result(property = "givenName", column = "given_name"),
                @Result(
                        property = "courses",
                        column = "id",
                        javaType = ArrayList.class,
                        many = @Many(
                                select = "platform.codingnomads.co.springdata.example.mybatis.myoneandmany.mappers.CourseMapper.getCoursesByTeacherId",
                                fetchType = FetchType.LAZY
                        )
                )
        }
    )
    Teacher getTeacherByIdWithCourses(Long id);


    @Select("SELECT * FROM mybatis.teachers WHERE id = #{param1};")
    @ResultMap("teacherResultMap")
    Teacher getTeacherByIdWithoutCourses(Long id);

}
