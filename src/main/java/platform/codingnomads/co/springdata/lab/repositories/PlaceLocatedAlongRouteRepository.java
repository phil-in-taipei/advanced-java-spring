package platform.codingnomads.co.springdata.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springdata.lab.models.PlaceLocatedAlongRoute;

import java.util.List;

public interface PlaceLocatedAlongRouteRepository extends JpaRepository<PlaceLocatedAlongRoute, Long> {
    List<PlaceLocatedAlongRoute> findAllByArea_code(String code);

    List<PlaceLocatedAlongRoute> findAllDistinctByRoutes_code(String code);
}
