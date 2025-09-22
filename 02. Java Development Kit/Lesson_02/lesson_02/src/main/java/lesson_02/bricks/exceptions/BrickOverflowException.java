package lesson_02.bricks.exceptions;

import javax.swing.*;


public class BrickOverflowException extends RuntimeException {
    public BrickOverflowException(){
        JOptionPane.showMessageDialog(
                null, "Невозможно создать более 15 объектов",
                "Exception", JOptionPane.ERROR_MESSAGE
        );
    }
}
