package platform.codingnomads.co.springdata.lab.models;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "places_located_along_routes")
public class PlaceLocatedAlongRoute {

    private static final long serialVersionUID = -5832297257746489251L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "destination_generator")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Area area;

    @ManyToMany
    @JoinTable(name="place_route", joinColumns = @JoinColumn(name = "place_along_route_id"),
            inverseJoinColumns = @JoinColumn(name = "route_id"))
    private List<Route> routes;

    public PlaceLocatedAlongRoute(String name, Area area) {
        this.name = name;
        this.area = area;
        area.addPlaceLocatedAlongRoute(this);
    }

    public PlaceLocatedAlongRoute(String name, Area area, Route route) {
        this.name = name;
        this.area = area;
        this.routes = List.of(route);
    }

    public void addRoutes(List<Route> routes) {
        if (routes != null) {
            routes.forEach(r -> r.addPlaceLocatedAlongRoute(this));
        } else {
            routes = new ArrayList<>();
        }
        if (this.routes == null) {
            this.routes = routes;
        } else {
            this.routes.addAll(routes);
        }
    }

    @Override
    public String toString() {
        return "PlaceLocatedAlongRoute{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
