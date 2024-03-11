package shop;

public class Provider extends AbstractEntity {

    private String name;
    private Address address;

    public Provider(String name) {
        this.name = name;
    }

    public Provider(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
