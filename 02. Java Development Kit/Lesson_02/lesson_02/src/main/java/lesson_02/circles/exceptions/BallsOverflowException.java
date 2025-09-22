package lesson_02.circles.exceptions;

import javax.swing.*;

public class BallsOverflowException extends RuntimeException{
    public BallsOverflowException(){
        JOptionPane.showMessageDialog(
                null, "Невозможно создать более 15 объектов",
                "Exception", JOptionPane.ERROR_MESSAGE
        );
    }
}
