package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "icing")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Icing {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String flavor;

    @Column(nullable = false)
    private boolean available;
}
