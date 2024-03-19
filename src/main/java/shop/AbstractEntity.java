package shop;

import java.util.Random;

public abstract class AbstractEntity {

    private int id;

    public AbstractEntity() {
        this.id = new Random(System.currentTimeMillis()).nextInt(20000);
    }

    public int getId() {
        return id;
    }
}
