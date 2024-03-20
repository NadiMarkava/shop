package exceptions;

public class ProductCannotBeReturnException extends Exception{

    public ProductCannotBeReturnException(String message) {
        super(message);
    }

    public ProductCannotBeReturnException() {
    }
}
