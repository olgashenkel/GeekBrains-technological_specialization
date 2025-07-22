package seminar_05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DZ_1 {
    public static void main(String[] args) {
        String sourceDirectory = "."; // Путь к директории
        String backupDirectory = "./backup"; // Путь резервной копии
        backupDirectory(sourceDirectory, backupDirectory);
    }



    public static void backupDirectory(String sourceDirPath, String backupDirPath) {
        Path sourceDir = Paths.get(sourceDirPath);
        Path backupDir = Paths.get(backupDirPath);

        if (!Files.exists(sourceDir) || !Files.isDirectory(sourceDir)) {
            System.err.println("Ошибка: Источник не является директорией или не существует.");
            return;
        }

        try {
            if (!Files.exists(backupDir)) {
                Files.createDirectories(backupDir);
            }

            Files.list(sourceDir)
                    .filter(Files::isRegularFile)
                    .forEach(sourceFile -> {
                        Path backupFile = backupDir.resolve(sourceFile.getFileName());
                        try {
                            Files.copy(sourceFile, backupFile, StandardCopyOption.REPLACE_EXISTING);
                            System.out.println("Файл скопирован: " + sourceFile.getFileName());
                        } catch (IOException e) {
                            System.err.println("Ошибка при копировании файла " + sourceFile.getFileName() + ": " + e.getMessage());
                        }
                    });
            System.out.println("Резервная копия создана в: " + backupDir);

        } catch (IOException e) {
            System.err.println("Ошибка при создании директории: " + e.getMessage());
        }
    }

}
