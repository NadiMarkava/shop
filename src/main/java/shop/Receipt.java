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

    public double getSumm() {
        return summ;
    }

    public void setSumm(double summ) {
        this.summ = summ;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getSumm(List<Product> productList) {
        double summ = 0;
        for (Product product : productList) {
            summ += product.getPrice();
        }
        return summ;
    }

    public String getCurrentDateAndTime() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
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
        double thisSumm = this.getSumm(this.productList);
        double otherSumm = other.getSumm(other.productList);
        if (thisSumm != otherSumm) {
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
        return "Receipt [ " + getCurrentDateAndTime() + ", Salesman" + this.salesman.getLastName() + ", Products:" + productList.stream().flatMap(p -> Stream.of(p.getName(), p.getPrice())).collect(Collectors.toList()) + ", SUMM:" + getSumm(productList);
    }
}
