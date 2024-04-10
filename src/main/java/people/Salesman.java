package people;

import enums.Position;
import exceptions.InvalidInputException;
import interfaces.ISpeak;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Salesman extends Person implements ISpeak {

    private final static Logger LOGGER = LogManager.getLogger(Salesman.class);
    private double salary;
    Position position;

    public Salesman(String firstName, String lastName, Position position, double salary) throws InvalidInputException {
        super(firstName, lastName);
        this.salary = salary;
        this.position = position;
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
