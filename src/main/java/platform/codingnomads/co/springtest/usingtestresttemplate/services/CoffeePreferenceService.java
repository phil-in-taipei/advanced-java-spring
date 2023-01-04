package platform.codingnomads.co.springtest.usingtestresttemplate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.codingnomads.co.springtest.usingtestresttemplate.exceptions.NoSuchCoffeePreferenceException;
import platform.codingnomads.co.springtest.usingtestresttemplate.models.CoffeePreference;
import platform.codingnomads.co.springtest.usingtestresttemplate.repos.CoffeePreferenceRepo;

import java.util.ArrayList;

@Service
public class CoffeePreferenceService {

    @Autowired
    private CoffeePreferenceRepo repo;

    public CoffeePreference insertNewCoffeePreference(CoffeePreference coffeePreference) {
        return repo.save(coffeePreference);
    }

    public ArrayList<CoffeePreference> getAllCoffeePreferences()
            throws NoSuchCoffeePreferenceException{
        ArrayList<CoffeePreference> preferences = new ArrayList<>(repo.findAll());

        if (preferences.isEmpty()) {
            throw new NoSuchCoffeePreferenceException(
            "There are no coffee preferences yet :( feel free to add one though");
        }

        return preferences;
    }
}