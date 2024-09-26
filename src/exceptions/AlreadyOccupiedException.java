package exceptions;

public class AlreadyOccupiedException extends RuntimeException{
    public AlreadyOccupiedException() {
        super("The place is already occupied");
    }
}
