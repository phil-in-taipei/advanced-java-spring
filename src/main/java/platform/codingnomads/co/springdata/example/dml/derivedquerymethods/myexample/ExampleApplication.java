package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.codingnomads.co.springdata.example.dml.derivedquerymethods.codewarriorexample.CodeWarrior;
import platform.codingnomads.co.springdata.example.dml.derivedquerymethods.codewarriorexample.EmailAddress;
import platform.codingnomads.co.springdata.example.dml.derivedquerymethods.plantexample.Plant;

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

        final List<Cake> cakes = Arrays.asList(birthdayCake, weddingCake, graduationCake);

        if (cakeRepo.findAll().isEmpty()) {
            cakeRepo.saveAll(cakes);
        }

        cakeRepo.flush();

        final List<Cake> chocolateCakes = cakeRepo.findByCakeNameIs("chocolate");

        System.out.println("***************************************************findByCakeNameIs***************************************************");
        for (Cake c: chocolateCakes) {
            System.out.println(c);
        }
    }

}
