package africa.semicolon.com.quagga.exceptions;

public class ServiceDoesNotExistException extends RuntimeException {
    public ServiceDoesNotExistException(String message) {
        super(message);
    }
}
