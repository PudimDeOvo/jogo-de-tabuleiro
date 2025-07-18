package MyException;

public class NotEnoughTypesException extends RuntimeException {
    public NotEnoughTypesException(String message) {
        super(message);
    }
}
