package task_02;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    String productName;
    double price;


    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Товар: " +
                "наименование товара - " + productName + '\'' +
                ", цена - " + price;
    }
}
