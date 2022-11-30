package platform.codingnomads.co.springdata.example.dml.usingqueryannotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.SoilType;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.repositories.SoilTypeRepo;

import java.util.ArrayList;

@Service
public class SoilTypeService {
    @Autowired
    SoilTypeRepo soilTypeRepo;

    @Transactional
    public void saveStuff() {
            //soilTypeRepo.flush();
        System.out.println("Repo is empty -- creating objects ....");
        SoilType soilType1 = SoilType.builder().dry(true).ph(7.6).name("Soil1").build();
        soilTypeRepo.save(soilType1);
        SoilType soilType2 = SoilType.builder().dry(false).ph(7.2).name("Soil2").build();
        soilTypeRepo.save(soilType2);
        SoilType soilType3 = SoilType.builder().dry(true).ph(1.2).name("Soil3").build();
        soilTypeRepo.save(soilType3);
        SoilType soilType4 = SoilType.builder().dry(false).ph(12.8).name("Soil4").build();
        soilTypeRepo.save(soilType4);
        SoilType soilType5 = SoilType.builder().dry(false).ph(9.8).name("Soil5").build();
        soilTypeRepo.save(soilType5);
        SoilType soilType6 = SoilType.builder().dry(false).ph(6.9).name("Soil6").build();
        soilTypeRepo.save(soilType6);
        SoilType soilType7 = SoilType.builder().dry(false).ph(8.1).name("Soil7").build();
        soilTypeRepo.save(soilType7);
            //soilTypeRepo.flush();
        //}
    }

    @Transactional
    public void getStuff() {
        System.out.println("DRY SOILS");
        ArrayList<SoilType> soils = soilTypeRepo.findDrySoilType(Sort.by(Sort.Order.asc("name")));

        for (SoilType soil : soils) {
            System.out.println(soil.toString());
        }


        System.out.println("SOILS WITH PH BETWEEN 2.0 and 10.0");
        ArrayList<SoilType> soilsInRange = soilTypeRepo.getSoilTypeBasedOnPhRange(2.0, 10.0);

        for (SoilType soil : soilsInRange) {
            System.out.println(soil.toString());
        }

        Pageable pageReq = PageRequest.of(0, 2); // , Sort.by(Sort.Order.asc("name"))
        Page<SoilType> page;

        do {
        //get the page from the database
            page = soilTypeRepo.getSoilTypeBasedOnPhRangePageable(2.0, 10.0, pageReq);

            //print the page number + 1 to offset the start being 0
            System.out.println("PAGE " + (page.getNumber() + 1));

        //print the contents of the current page
            page.getContent().forEach(System.out::println);

        //get the next page request
           pageReq = pageReq.next();

         } while (page.hasNext());



    }
}
