package people;

import exceptions.InvalidInputException;
import shop.AbstractEntity;

public abstract class Person extends AbstractEntity {

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) throws InvalidInputException {
        this.firstName = firstName;
        this.lastName = lastName;
        if (lastName == null) {
            throw new InvalidInputException("!!!Last name can't be null!!!" + lastName);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
