package seminar_05;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task_4 {
    public static void main(String[] args) throws IOException {

        // Получаем текущую рабочую директорию
        Path currentDir = Paths.get(".");

        // Используем DirectoryStream для перечисления файлов и папок
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(currentDir)) {
            System.out.println("Содержимое текущей папки:");
            for (Path file : stream) {
                // Выводим имя файла или папки
                System.out.println(file.getFileName());
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении директории: " + e.getMessage());
        }
    }
}
