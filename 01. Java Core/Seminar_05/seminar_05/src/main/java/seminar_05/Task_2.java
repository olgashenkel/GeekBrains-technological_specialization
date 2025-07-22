package seminar_05;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_2 {
    public static void main(String[] args) throws IOException {

        String filePath = "src/main/resources/array.txt";
        try {
            String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
            int[] numbers = readFileArray(fileContent);

            if (numbers != null) {
                System.out.println(Arrays.toString(numbers));
            }

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

    }


    public static int[] readFileArray(String input) throws IOException {
        String cleanedInput = input.trim();
        String numbersString = cleanedInput.substring(1, cleanedInput.length() - 1);
        String[] numberStrings = numbersString.split(",");

        List<Integer> numberList = new ArrayList<>();
        for (String numStr : numberStrings) {
            try {
                numberList.add(Integer.parseInt(numStr.trim()));
            } catch (NumberFormatException e) {
                System.err.println("Ошибка при преобразовании строки в число");
            }
        }
        return numberList.stream().mapToInt(Integer::intValue).toArray();

    }

}
