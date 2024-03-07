package people;

import interfaces.IReturn;
import shop.DiscountCard;
import interfaces.IPayment;
import interfaces.IPurchase;
import shop.Product;
import shop.Shop;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person implements IPurchase,IPayment,IReturn {

    private DiscountCard discountCard;

    public Customer(String firstName, String lastName, DiscountCard discountCard) {
        super(firstName, lastName);
        this.discountCard = discountCard;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if ((this.getFirstName() == null) ? (other.getFirstName() != null) : !this.getFirstName().equals(other.getFirstName())) {
            return false;
        }
        if (this.getLastName().equals(other.getLastName())) {
            return false;
        }
        if (this.discountCard.getBalance() != other.discountCard.getBalance()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer[" +
                "First name=" + getFirstName() + ", " +
                "Last name=" + getLastName() + ", " +
                "DiscountCard=" + discountCard.getId() + ", " +
                "Discount=" + discountCard.getBalance() +
                ']';
    }

    @Override
    public void pay(double primarySumm) {
        discountCard.setBalance(discountCard.getBalance() - primarySumm);
    }

    @Override
    public List<Product> buy(List<Product> productList) {
        productList.addAll(productList);
        return productList;
    }

    @Override
    public void returnProducts(List<Product> products) {
        double summ = 0;
        for (Product product : products) {
            summ += product.getPrice();
        }
        discountCard.setBalance(discountCard.getBalance() + summ);
    }

    public DiscountCard getDiscountCard() {
        return discountCard;
    }
}
