package shop;

import java.util.Random;

public abstract class AbstractEntity {

    private int id;

    public AbstractEntity() {
        this.id = getId();
    }

    public int getId() {
        Random r = new Random(System.currentTimeMillis());
        return 10000 + r.nextInt(20000);
    }
}
