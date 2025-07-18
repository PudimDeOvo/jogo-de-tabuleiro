package MyException;

public class NumPlayersInvalid extends Exception {
  public NumPlayersInvalid(String message) {
    super(message);
  }

  public NumPlayersInvalid(String message, Throwable cause) {
    super(message, cause);
  }

  public NumPlayersInvalid(Throwable cause) {
    super(cause);
  }
}
