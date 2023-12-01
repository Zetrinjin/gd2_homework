package fight.join;

import javax.persistence.Column;

public class ProductShop extends Mall{

    @Column
    private String productName;

    public ProductShop(String productName) {
        this.productName = productName;
    }

    public ProductShop(String id, String name, Double salary, String productName) {
        super(id, name, salary);
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
