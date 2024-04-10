package people;

import enums.DiscountCard;
import exceptions.InvalidInputException;
import interfaces.IPayment;
import interfaces.IReturn;
import interfaces.ISpeak;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shop.Product;
import shop.Receipt;

import java.util.Map;

public class Customer extends Person implements IPayment, ISpeak, IReturn {

    private final static Logger LOGGER = LogManager.getLogger(Customer.class);
    private DiscountCard discountCard;
    private Map<Product, Integer> productsToBuy;

    public Customer(String firstName, String lastName) throws InvalidInputException {
        super(firstName, lastName);
    }

    public Map<Product, Integer> takeProduct(Product product, int count) {
        productsToBuy.put(product, count);
        return productsToBuy;
    }

    public Map<Product, Integer> takeProducts(Map<Product, Integer> products) {
        productsToBuy.putAll(products);
        return productsToBuy;
    }

    public DiscountCard getDiscountCard() {
        return discountCard;
    }

    public Map<Product, Integer> getProductsToBuy() {
        return productsToBuy;
    }

    public void setProductsToBuy(Map<Product, Integer> productsToBuy) {
        this.productsToBuy = productsToBuy;
    }

    public boolean hasDiscountCard() {
        if (discountCard != null) {
            return true;
        }
        return false;
    }

    public void setDiscountCard(DiscountCard discountCard) {
        this.discountCard = discountCard;
    }

    @Override
    public void say(String message) {
        LOGGER.info(message);
    }

    @Override
    public void pay(double summ) {
        LOGGER.info("----Paid------" + summ);
    }

    @Override
    public void returnProducts(Receipt receipt) {
        LOGGER.info("----Refund------");
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        return result;
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
    public String toString() {
        return "Customer[" +
                "First name=" + getFirstName() + ", " +
                "Last name=" + getLastName() + ", " +
                "Discount=" + discountCard.getDiscount() +
                ']';
    }
}
