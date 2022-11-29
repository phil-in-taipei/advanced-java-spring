package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IcingRepo extends JpaRepository<Icing, Long>{
}
