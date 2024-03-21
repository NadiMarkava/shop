package exceptions;

public class ProductNotExistsException extends Exception {

    public ProductNotExistsException(String message) {
        super(message);
    }

    public ProductNotExistsException() {
    }
}
