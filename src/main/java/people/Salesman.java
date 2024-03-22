package people;

import exceptions.InvalidInputException;
import interfaces.ISpeak;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Salesman extends Person implements ISpeak {

    private final static Logger LOGGER = LogManager.getLogger(Salesman.class);
    private double salary;

    public Salesman(String firstName, String lastName, double salary) throws InvalidInputException {
        super(firstName, lastName);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void say(String message) {
        LOGGER.info(message);
    }
}
