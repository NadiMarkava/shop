package shop;

public class DiscountCard extends AbstractEntity {

    private double balance;

    public DiscountCard(double discount) {
        this.balance = discount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "DiscountCard{" +
                "balance=" + balance +
                '}';
    }
}
