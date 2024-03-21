package exceptions;

public class DiscountCardAlreadyExistsException extends Exception {

    public DiscountCardAlreadyExistsException(String message) {
        super(message);
    }

    public DiscountCardAlreadyExistsException() {
    }
}
