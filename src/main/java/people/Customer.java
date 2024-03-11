package people;

import interfaces.IReturn;
import interfaces.ISpeak;
import shop.DiscountCard;
import interfaces.IPayment;
import shop.Product;

import java.util.List;

public class Customer extends Person implements IPayment, ISpeak, IReturn {

    private DiscountCard discountCard;

    private List<Product> productsToBuy;

    public Customer(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public List<Product>  takeProduct(Product product) {
        productsToBuy.add(product);
        return productsToBuy;
    }

    public List<Product> takeProducts(List<Product> products) {
        productsToBuy.addAll(products);
        return productsToBuy;
    }


    public DiscountCard getDiscountCard() {
        return discountCard;
    }

    public List<Product> getProductsToBuy() {
        return productsToBuy;
    }

    public boolean hasDiscountCard() {
        if (discountCard != null) {
            return true;
        }
        return false;
    }


    public void setProductsToBuy(List<Product> productsToBuy) {
        this.productsToBuy = productsToBuy;
    }

    public void setDiscountCard(DiscountCard discountCard) {
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
        if (this.discountCard.getDiscount() != other.discountCard.getDiscount()) {
            return false;
        }
        return true;
    }

    @Override
    public void say(String message) {
        System.out.println(message);
    }

    @Override
    public void pay(double summ) {
        System.out.println("----Paid------" + summ);
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
                "Discount=" + discountCard.getDiscount() +
                ']';
    }

    @Override
    public void returnProducts(List<Product> products) {
        System.out.println("----Paid------");
    }
}
