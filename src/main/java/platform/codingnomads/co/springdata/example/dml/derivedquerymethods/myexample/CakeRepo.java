package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface CakeRepo extends JpaRepository<Cake, Long>  {

    List<Cake> findByCakeNameIs(String cakeName);

    List<Cake> findByIcing_FlavorIs(String flavor);

    List<Cake> findByPriceLessThan(double price);

    List<Cake> findByPriceGreaterThanEqual(double price);

}
