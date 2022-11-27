package platform.codingnomads.co.springdata.example.ddl.onetoone.bidirectional;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "sponsors")
@NoArgsConstructor
@Getter
@Setter
public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String companyName;

    @OneToOne(mappedBy = "sponsor")
    private Driver driver;
}
