package people;

import interfaces.ISaying;
import people.Person;

public class Salesman extends Person implements ISaying {

    private double salary;

    public Salesman(String firstName, String lastName, double salary) {
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
    public void say() {
        System.out.println("Hello dear!");
    }
}
