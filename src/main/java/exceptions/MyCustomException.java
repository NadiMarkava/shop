package exceptions;

public class MyCustomException extends Exception {

    public MyCustomException(String message)
    {
        super(message);
    }

    public MyCustomException() {
    }
}
