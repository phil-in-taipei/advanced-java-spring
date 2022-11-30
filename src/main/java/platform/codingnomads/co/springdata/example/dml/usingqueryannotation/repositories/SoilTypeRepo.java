package platform.codingnomads.co.springdata.example.dml.usingqueryannotation.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.SoilType;

import java.util.ArrayList;

@Repository
public interface SoilTypeRepo extends JpaRepository<SoilType, Long> {

    @Query("SELECT s FROM SoilType s WHERE dry = true")
    ArrayList<SoilType> findDrySoilType(Sort sort);
    @Query("SELECT s FROM SoilType s WHERE ph > ?1 AND ph < ?2")
    ArrayList<SoilType> getSoilTypeBasedOnPhRange(double minPh, double maxPh);

    @Query("SELECT s FROM SoilType s WHERE ph > ?1 AND ph < ?2")
    Page<SoilType> getSoilTypeBasedOnPhRangePageable(double minPh, double maxPh, Pageable pageable);

}
