package MyException;

public class numPlayersInvalid extends Exception {
    public numPlayersInvalid(String message) {
        super(message);
    }

    public numPlayersInvalid(String message, Throwable cause) {
        super(message, cause);
    }

    public numPlayersInvalid(Throwable cause) {
        super(cause);
    }
}
