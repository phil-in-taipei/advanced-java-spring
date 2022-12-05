package platform.codingnomads.co.springdata.example.mybatis.resultsandresult;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Instrument {
    private Long id;

    private String instrumentName;

    private String instrumentType;

    public Instrument(String instrumentName, String instrumentType) {
        this.instrumentName = instrumentName;
        this.instrumentType = instrumentType;
    }
}
