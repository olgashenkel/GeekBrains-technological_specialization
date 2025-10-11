package lesson_06;

import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.io.InputStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public void printFile() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("hello.txt");
        System.out.println(new String(inputStream.readAllBytes()));
    }


    public static void main(String[] args) throws IOException {

        new Main().printFile();

    }
}