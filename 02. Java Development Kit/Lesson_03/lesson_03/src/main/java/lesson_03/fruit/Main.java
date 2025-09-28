package lesson_03.fruit;


public class Main {
    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Fruit> fruitBox = new Box<>();

        fruitBox.addFruit(new Orange());
        fruitBox.addFruit(new Apple());

        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

//        System.out.println(appleBox.compare(orangeBox));
//        appleBox.transferFruits(appleBox);
        System.out.println(orangeBox.compare(orangeBox));
        orangeBox.transferFruits(orangeBox);

        System.out.println(fruitBox);
        System.out.println(fruitBox.getFruitCount());

    }
}
