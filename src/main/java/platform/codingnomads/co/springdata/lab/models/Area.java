package platform.codingnomads.co.springdata.lab.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "areas")
@Builder
public class Area implements Serializable {

    private static final long serialVersionUID = 153236560504273881L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String code;

    @OneToMany(mappedBy = "area")
    private List<PlaceLocatedAlongRoute> placesLocatedAlongRoutes;

    public void addPlaceLocatedAlongRoute(PlaceLocatedAlongRoute placeLocatedAlongRoute) {
        if (this.placesLocatedAlongRoutes == null) {
            this.placesLocatedAlongRoutes = new ArrayList<>(Collections.singletonList(placeLocatedAlongRoute));
        } else {
            this.placesLocatedAlongRoutes.add(placeLocatedAlongRoute);
        }
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", PlacesLocatedAlongRoutes=" + placesLocatedAlongRoutes +
                '}';
    }

    public String toStringWithoutPlacesLocatedAlongRoutes() {
        return "Area{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
