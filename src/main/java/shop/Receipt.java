package shop;

import people.Customer;
import people.Salesman;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Receipt extends AbstractEntity {

    private double summ;
    private String date;
    private Map<Product, Integer> productList;
    private Salesman salesman;
    private Customer customer;

    public Receipt(Map<Product, Integer> productList, Salesman salesman, Customer customer) {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.date = myDateObj.format(myFormatObj);
        this.productList = productList;
        this.salesman = salesman;
        this.customer = customer;
        this.summ = getSumm(productList);
    }

    public Receipt() {
    }

    public double getSumm() {
        return summ;
    }

    public String getDate() {
        return date;
    }

    public Map<Product, Integer> getProductList() {
        return productList;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public Customer getCustomer() {
        return customer;
    }

    public <T extends Product, K> double getSumm(Map<T, K> productList) {
        return productList.keySet().stream().mapToDouble(product -> product.getPrice()).sum();
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
        return "Receipt [ " + getDate() + ", Salesman=" + getSalesman().getLastName() + ", Customer=" + getCustomer().getLastName() + ", Products=" + getProductList().keySet().stream().flatMap(p -> Stream.of(p.getName(), p.getPrice())).collect(Collectors.toList()) + ", SUMM=" + getSumm();
    }
}
