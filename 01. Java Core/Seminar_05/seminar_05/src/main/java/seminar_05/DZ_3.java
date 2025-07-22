package seminar_05;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class DZ_3 {
    public static void main(String[] args) throws IOException {

        int[] ar20 = new int[9];

        FileInputStream fis = new FileInputStream("src/main/resources/board.txt");
        int b;
        int i = 0;
        while ((b = fis.read()) != -1) {
            for (int v = 0; v < 3; ++v) {
                ar20[i++] = b >> (v * 2) & 0x3;
            }
        }
        fis.close();
        System.out.println(Arrays.toString(ar20));
    }
}
