package seminar_03.task_01;

import java.io.DataInput;
import java.io.InputStream;

public class Task_01<T extends Comparable<T>, V extends InputStream & DataInput, K extends Number> {
    private T t;
    private V v;
    private K k;

    public Task_01(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public V getV() {
        return v;
    }

    public K getK() {
        return k;
    }

    public void getName(){
        System.out.println("Имя класса переменной T: " + t.getClass().getName());
        System.out.println("Имя класса переменной V: " + v.getClass().getName());
        System.out.println("Имя класса переменной K: " + k.getClass().getName());
    }


}