package shop;

import java.util.List;
import java.util.stream.Collectors;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class Receipt extends AbstractEntity{

    private double summ;
    private String date;
    private List<Product> productList;
    private Salesman salesman;
    private Customer customer;

    public Receipt(List<Product> productList, Salesman salesman, Customer customer) {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.date = myDateObj.format(myFormatObj);
        this.productList = productList;
        this.salesman = salesman;
        this.customer = customer;
        double summ = 0;
        for (Product product : productList) {
            summ += product.getPrice();
        }
        this.summ = summ;
    }

    public double getSumm() {
        return summ;
    }

    public String getDate() {
        return date;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Receipt other = (Receipt) obj;
        if (!this.productList.equals(other.productList)) {
            return false;
        }
        if (this.summ != other.summ) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (productList != null ? productList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Receipt [ " + getDate() + ", Salesman=" + getSalesman().getLastName()+ ", Customer=" + getCustomer().getLastName() + ", Products=" + getProductList().stream().flatMap(p -> Stream.of(p.getName(), p.getPrice())).collect(Collectors.toList()) + ", SUMM=" + getSumm();
    }
}
