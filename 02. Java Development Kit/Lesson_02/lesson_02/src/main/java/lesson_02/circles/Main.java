package lesson_02.circles;


import lesson_02.circles.view.MianWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MianWindow();
            }
        });
    }
}
