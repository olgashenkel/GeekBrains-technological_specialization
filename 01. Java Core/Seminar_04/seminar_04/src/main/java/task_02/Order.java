package task_02;


public class Order {
    Buyer buyer;
    Product product;
    int count;

    public Order(Buyer buyer, Product product, int count) {
        this.buyer = buyer;
        this.product = product;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Заказ {" +
                "покупатель: " + buyer +
                ", товар: " + product +
                ", количество: " + count +
                '}';
    }
}
