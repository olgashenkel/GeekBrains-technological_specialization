package task_02;

import task_02.Exception.AmountException;
import task_02.Exception.CustomerException;
import task_02.Exception.ProductException;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Object[][] info = {
                {buyers[0], products[0], 1}, //good
                {buyers[1], products[1], -1}, //bad amount -1
                {buyers[0], products[2], 150}, //bad amount >100
                {buyers[1], new Product("Flower", 10), 1}, //no item
                {new Buyer("Fedor", LocalDate.of(1991, 3, 3), "+3-444-555-66-77"), products[3], 1}, //no customer
        };
        int capacity = 0;
        int i = 0;
        while (capacity != orders.length - 1 || i != info.length) {
            try {
                orders[capacity] = makePurchase((Buyer) info[i][0], (Product) info[i][1], (int) info[i][2]);
                capacity++;
            } catch (ProductException e) {
                e.printStackTrace();
            } catch (AmountException e) {
                orders[capacity++] = makePurchase((Buyer) info[i][0], (Product) info[i][1], 1);
            } catch (CustomerException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("Orders made: " + capacity);
            }
            ++i;
        }

    }


    private final static Buyer[] buyers = {
            new Buyer("Иванов Иван Иванович", LocalDate.of(1995, 3, 3), "8999-555-44-33"),
            new Buyer("Сидоров Павел Игнатьевич", LocalDate.of(1985, 2, 1), "8999-666-44-33")
    };


    private final static Product[] products = {
            new Product("Пылесос", 3500),
            new Product("Стиральная машинка", 39000),
            new Product("Телевизор LG", 55000),
            new Product("Чайник электрический", 2700),
            new Product("Холодильник", 49000)
    };


    private static Order[] orders = new Order[5];


    private static boolean isInArray(Object[] arr, Object o) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i].equals(o)) return true;
        return false;
    }


    public static Order makePurchase(Buyer buyer, Product product, int quantity) {
        if (!isInArray(buyers, buyer)) {
            throw new CustomerException("Покупатель " + buyer + " не найден");
        }
        if (!isInArray(products, product)) {
            throw new ProductException("Товар " + buyer + " не найден");
        }
        if (quantity < 0 || quantity > 100) {
            throw new AmountException("Введено некорректное количество товара - " + quantity +
                    "\nУкажите количество товара в пределах от 1 до 100.");
        }
        System.out.println("\nПокупка\n" + "покупатель: " + buyer.fullName + " (возраст " + buyer.getAge() + ")"
                + " телефон: " + buyer.phone
                + "\nприобретенный товар: " + product.productName + " - " + product.price + "руб.");

        return new Order(buyer, product, quantity);
    }


}
