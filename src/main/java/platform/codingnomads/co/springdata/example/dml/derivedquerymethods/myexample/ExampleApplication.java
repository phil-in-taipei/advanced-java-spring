package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
@SpringBootApplication

public class ExampleApplication implements CommandLineRunner {

    @Autowired
    CakeRepo cakeRepo;

    @Autowired
    IcingRepo icingRepo;

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        Icing vanillaIcing = Icing.builder().flavor("vanilla").available(true).build();
        Icing chocolateIcing = Icing.builder().flavor("chocolate").available(true).build();
        Icing mintIcing = Icing.builder().flavor("mint").available(false).build();

        vanillaIcing = icingRepo.save(vanillaIcing);
        chocolateIcing = icingRepo.save(chocolateIcing);
        mintIcing = icingRepo.save(mintIcing);

        icingRepo.flush();


        Cake birthdayCake = Cake.builder()
                .cakeName("birthday")
                .price(19.99)
                .icing(chocolateIcing)
                .build();

        Cake weddingCake = Cake.builder()
                .cakeName("wedding")
                .price(59.99)
                .icing(mintIcing)
                .build();

        Cake graduationCake = Cake.builder()
                .cakeName("graduation")
                .price(35.00)
                .icing(vanillaIcing)
                .build();

        Cake getWellSoonCake = Cake.builder()
                .cakeName("get well soon")
                .price(40.00)
                .icing(vanillaIcing)
                .build();

        final List<Cake> cakes = Arrays.asList(
                birthdayCake, weddingCake, graduationCake, getWellSoonCake
        );

        if (cakeRepo.findAll().isEmpty()) {
            cakeRepo.saveAll(cakes);
        }

        cakeRepo.flush();

        final List<Cake> birthdayCakes = cakeRepo.findByCakeNameIs("birthday");
        System.out.println();

        System.out.println("***************************************************findByCakeNameIs***************************************************");
        System.out.println("There are this many items in the query: " + birthdayCakes.size());
        for (Cake cake: birthdayCakes) {
            System.out.println(cake);
        }

        final List<Cake> vanillaIcingCakes = cakeRepo.findByIcing_FlavorIs("vanilla");
        System.out.println();

        System.out.println("***************************************************findByIcing_FlavorIs***************************************************");
        System.out.println("There are this many items in the query: " + vanillaIcingCakes.size());
        for (Cake cake: vanillaIcingCakes) {
            System.out.println(cake);
        }

        List<Cake> cheapCakes =  cakeRepo.findByPriceLessThan(40.00);
        System.out.println("***************************************************findByPriceLessThan***************************************************");
        System.out.println("There are this many items in the query: " + cheapCakes.size());
        for (Cake cake: cheapCakes) {
            System.out.println(cake);
        }

        List<Cake> expensiveCakes =  cakeRepo.findByPriceGreaterThanEqual(40.00);
        System.out.println("***************************************************findByPriceGreaterThanEqual**********************************************");
        System.out.println("There are this many items in the query: " + expensiveCakes.size());
        for (Cake cake: expensiveCakes) {
            System.out.println(cake);
        }
    }

}
