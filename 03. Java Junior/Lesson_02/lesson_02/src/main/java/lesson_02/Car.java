package lesson_02;

public class Car {
    public String name;
    private String price;
    public String engType;
    public String engPower;
    public int maxSpeed;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Car(String name) {
        this.name = name;
        this.engType = "V8";
        this.engPower = "123";
        this.maxSpeed = 100;
        this.price = "100000";
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
