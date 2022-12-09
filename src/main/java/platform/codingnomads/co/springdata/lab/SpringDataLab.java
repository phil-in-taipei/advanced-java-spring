package platform.codingnomads.co.springdata.lab;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.PlaceLocatedAlongRoute;
import platform.codingnomads.co.springdata.lab.repositories.AreaRepository;
import platform.codingnomads.co.springdata.lab.repositories.PlaceLocatedAlongRouteRepository;
import platform.codingnomads.co.springdata.lab.repositories.RouteRepository;
import platform.codingnomads.co.springdata.lab.models.Route;
import platform.codingnomads.co.springdata.lab_complete.models.PointOfInterest;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataLab implements CommandLineRunner {

    private final AreaRepository areaRepository;

    private final RouteRepository routeRepository;

    private final PlaceLocatedAlongRouteRepository placeLocatedAlongRouteRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataLab.class);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        if (areaRepository.findAll().size() == 0) {
            final List<Area> areas = areaRepository.saveAll(
                    Arrays.asList(
                            Area.builder().code("A").build(),
                            Area.builder().code("B").build(),
                            Area.builder().code("C").build(),
                            Area.builder().code("D").build(),
                            Area.builder().code("G").build(),
                            Area.builder().code("H").build(),
                            Area.builder().code("Y").build(),
                            Area.builder().code("Z").build()
                    )
            );
        }

        if (routeRepository.findAll().size() == 0) {
            final List<Route> routes = routeRepository.saveAll(
                    Arrays.asList(
                            Route.builder().origin(areaRepository.findByCode("G"))
                                    .destination(areaRepository.findByCode("Z")).build(),
                            Route.builder().origin(areaRepository.findByCode("B"))
                                    .destination(areaRepository.findByCode("C")).build(),
                            Route.builder().origin(areaRepository.findByCode("Y"))
                                    .destination(areaRepository.findByCode("A")).build(),
                            Route.builder().origin(areaRepository.findByCode("H"))
                                    .destination(areaRepository.findByCode("G")).build()
                    )
            );
        }

        if (placeLocatedAlongRouteRepository.findAll().size() == 0) {
            PlaceLocatedAlongRoute placeLocatedAlongRoute1 = new PlaceLocatedAlongRoute("The Big Texan",
                    areaRepository.findByCode("A"));
            placeLocatedAlongRoute1.addRoutes(routeRepository.findAllByCodeContaining("A"));

            PlaceLocatedAlongRoute placeLocatedAlongRoute2 = new PlaceLocatedAlongRoute("House on the Rock",
                    areaRepository.findByCode("G"));
            placeLocatedAlongRoute2.addRoutes(routeRepository.findAllByCodeContaining("G"));

            PlaceLocatedAlongRoute placeLocatedAlongRoute3 = new PlaceLocatedAlongRoute("Lambert's",
                    areaRepository.findByCode("B"));
            placeLocatedAlongRoute3.addRoutes(routeRepository.findAllByCodeContaining("B"));

            PlaceLocatedAlongRoute placeLocatedAlongRoute4 = new PlaceLocatedAlongRoute("Denny's",
                    areaRepository.findByCode("A"),
                    routeRepository.findByCode("Y-A"));

            PlaceLocatedAlongRoute placeLocatedAlongRoute5 = new PlaceLocatedAlongRoute("South of the Border",
                    areaRepository.findByCode("C"),
                    routeRepository.findByCode("B-C"));

            placeLocatedAlongRouteRepository.saveAll(
                    List.of(placeLocatedAlongRoute1,
                            placeLocatedAlongRoute2, placeLocatedAlongRoute3,
                            placeLocatedAlongRoute4, placeLocatedAlongRoute5)
                    );
        }

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("These are the routes containing 'A':");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(routeRepository.findAllByCodeContaining("A"));
        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println("******************************************************************************************");

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("These are the the places in Area 'C':");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(placeLocatedAlongRouteRepository.findAllByArea_code("C"));
        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println("******************************************************************************************");

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("These are the the places along Route 'B-C':");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(placeLocatedAlongRouteRepository.findAllDistinctByRoutes_code("B-C"));
        System.out.println("------------------------------------------------------------------------------------------");

    }
}
