package platform.codingnomads.co.springdata.example.mybatis.resultsandresult;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface InstrumentMapper {
    @Insert("INSERT INTO mybatis.instruments " +
            "(instrument_name, instrument_type) " +
            "VALUES (#{instrumentName}, #{instrumentType});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertNewInstrument(Instrument instrument);

    @Select("SELECT * " +
            "FROM mybatis.instruments " +
            "WHERE id = #{param1};")
    @Results(
            id = "instrumentResultMap",
            value = {
                    @Result(property = "instrumentName", column = "instrument_name"),
                    @Result(property = "instrumentType", column = "instrument_type")
            }
    )
    Instrument getInstrumentById(Long id);

    @Select("SELECT * " +
            "FROM mybatis.instruments;")
    @ResultMap("instrumentResultMap")
    ArrayList<Instrument> getAllInstruments();

    @Select("SELECT *" +
            "FROM mybatis.instruments " +
            "WHERE instrument_type = #{param1};")
    @ResultMap("instrumentResultMap")
    ArrayList<Instrument> getInstrumentByType(String instrumentType);

}
