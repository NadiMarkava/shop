package shop;

import java.util.List;

public class Product extends AbstractEntity {

    private String name;
    private double price;
    private ProductCategory productCategory;
    private Provider provider;

    public Product(String name, double price, ProductCategory productCategory, Provider provider) {
        super();
        this.name = name;
        this.price = price;
        this.productCategory = productCategory;
        this.provider = provider;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Provider getProviders() {
        return provider;
    }

    public void setProviders(Provider provider) {
        this.provider = provider;
    }

    public double getSumm(List<Product> products) {
        double summ = 0;
        for (Product product : products) {
            summ += product.getPrice();
        }
        return summ;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        if (!this.productCategory.getName().equals(other.productCategory.getName())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product [name=" + this.name + ", price=" + this.price + ", product category=" + this.productCategory.getName() + ", provider=" + provider.getName() + "]";
    }
}
