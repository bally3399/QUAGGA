package africa.semicolon.com.quagga.exceptions;

public class CreateProductFailedException extends RuntimeException {
    public CreateProductFailedException(String message) {
        super(message);
    }
}
