package platform.codingnomads.co.springdata.example.dml.introducingrepositories.crudrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class CrudRepoDemo implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CrudRepoDemo.class);
    }

    //autowire the UserRepo into the class to gain access to the CRUD methods
    @Autowired
    UserRepo userRepo;

    @Override
    public void run(String... args) throws Exception {
        //create new user
        User user = User.builder().firstName("Bobby").lastName("Bobbert").age(56).build();
        User user2 = User.builder().firstName("Joanne").lastName("Joanna").age(36).build();
        User user3 = User.builder().firstName("Terry").lastName("Tobaggen").age(39).build();
        User user4 = User.builder().firstName("Janice").lastName("Spanice").age(66).build();

        //save user and assign what is returned to the user variable.
        user = userRepo.save(user);
        user2 = userRepo.save(user2);

        User[] newUsers= {user3, user4};
        Iterable<User> newUsersIterable = Arrays.asList(newUsers);
        newUsersIterable =  userRepo.saveAll(newUsersIterable);


        //userRepo.saveAll(newUsers);

        Iterable<User> users = userRepo.findAll();

        for(User u : users){
            System.out.println(u.toString());
        }



        for(User u : newUsersIterable){
            System.out.println(u.toString());
        }

        //delete the user using the id of the inserted user object
        //userRepo.deleteById(user.getId());
        //userRepo.deleteById(user2.getId());

        userRepo.deleteAll();
    }
}
