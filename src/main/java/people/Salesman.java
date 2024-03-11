package people;

import interfaces.ISpeak;

public class Salesman extends Person implements ISpeak {

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
    public void say(String message) {
        System.out.println(message);
    }
}
