package lesson_02.images.exceptions;

import javax.swing.*;


public class ImagesOverflowException extends RuntimeException {
    public ImagesOverflowException(){
        JOptionPane.showMessageDialog(
                null, "Невозможно создать более 15 объектов",
                "Exception", JOptionPane.ERROR_MESSAGE
        );
    }
}
