package shop;

import java.util.Random;

public abstract class AbstractEntity {

    private static int id;

    public AbstractEntity() {
        this.id = new Random(System.currentTimeMillis()).nextInt(20000);
    }

    static {
        System.out.println(id);
    }

    public int getId() {
        return id;
    }
}
