package platform.codingnomads.co.springtest.usingtestresttemplate.exceptions;

public class NoSuchCoffeePreferenceException extends Exception {
    public NoSuchCoffeePreferenceException(String message) {
        super(message);
    }

    public NoSuchCoffeePreferenceException() {
    }
}
