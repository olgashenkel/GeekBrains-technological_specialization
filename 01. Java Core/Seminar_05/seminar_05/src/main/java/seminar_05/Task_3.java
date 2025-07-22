package seminar_05;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Task_3 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputFile = "src/main/resources/text.txt"; // Имя входного файла
        String outputFile = "src/main/resources/new_text.txt"; // Имя выходного файла
        String outputFile_2 = "src/main/resources/new_text_word.txt"; // Имя выходного файла - 2
//
//        // – Написать программу заменяющую указанный символ в текстовом файле на пробел,
//        // сохраняющую получившийся текст в новый файл.
//
//        System.out.print("Введите символ, необходимый для замены: ");
//        char character = scanner.next().charAt(0); // Заменяемый символ
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile, StandardCharsets.UTF_8));
//             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, StandardCharsets.UTF_8))) {
//
//            int c;
//            while ((c = reader.read()) != -1) {
//                if ((char) c == character) {
//                    writer.write(' ');
//                } else {
//                    writer.write(c);
//                }
//            }
//            System.out.println("Файл успешно обработан. Результат сохранен в " + outputFile);
//
//        } catch (IOException e) {
//            System.err.println("Ошибка при обработке файла: " + e.getMessage());
//        }


    /* Модифицировать алгоритм поиска замены символа так,
    чтобы программа осуществляла замену слова (последовательного набора символов)
    в исходном файле и записывала результат в новый файл.     */

        System.out.println();
        System.out.print("Введите слово, необходимое для замены: ");
        String word = scanner.nextLine(); // Заменяемое слово
        System.out.print("На какое слово необходимо заменить: ");
        String new_word = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile_2))) {

            String line;
            while ((line = reader.readLine()) != null) {
                    String modifiedLine = line.replace(word, new_word);
                    writer.write(modifiedLine);
                    writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



