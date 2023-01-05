package platform.codingnomads.co.springtest.lab.exceptions;

public class NoSuchMovieException extends Exception {
    public NoSuchMovieException(String message) {
        super(message);
    }

    public NoSuchMovieException() {
    }
}
