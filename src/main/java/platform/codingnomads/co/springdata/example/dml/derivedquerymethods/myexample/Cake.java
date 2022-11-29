package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;
import lombok.*;
import platform.codingnomads.co.springdata.example.dml.derivedquerymethods.codewarriorexample.EmailAddress;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Cake {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cakeName;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "icing_id")
    private Icing icing;

}
