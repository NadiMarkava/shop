package shop;

public class Customer extends Person {

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
        if (this.discountCard.getDiscount() != other.discountCard.getDiscount()) {
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
                "Discount=" + discountCard.getDiscount() +
                ']';
    }
}
