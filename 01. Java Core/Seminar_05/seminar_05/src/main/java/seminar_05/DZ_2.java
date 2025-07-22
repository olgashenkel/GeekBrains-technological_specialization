package seminar_05;

import java.io.FileOutputStream;
import java.io.IOException;

public class DZ_2 {

    public static void main(String[] args) throws IOException {

        int[] ar2 = {3, 1, 0, 2, 1, 3, 2, 3, 0};

        FileOutputStream fos = new FileOutputStream("src/main/java/seminar_05/board.txt");
        for (int b = 0; b < 3; b++) { // write to 3 bytes
            byte wr = 0;
            for (int v = 0; v < 3; v++) { // write by 3 values in each
                wr += (byte) (ar2[3 * b + v] << (v * 2));
            }
            fos.write(wr);
        }
        fos.flush();
        fos.close();
    }
}

