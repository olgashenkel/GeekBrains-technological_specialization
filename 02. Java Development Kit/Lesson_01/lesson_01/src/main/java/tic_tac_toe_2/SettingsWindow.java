package tic_tac_toe_2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private final int HEIGHT = 200, WIDTH = 350;

    JButton startButton;


    SettingsWindow(GameWindow gameWindow) {
        startButton = new JButton("Запустить новую игру");

        setLocationRelativeTo(gameWindow);
        setSize(WIDTH, HEIGHT);

        iconTicTacToe();    // Метод - изменение стандартной иконки java в игровом окне

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(0, 3, 3, 3);     // параметры игрового поля
                setVisible(false);
            }
        });

        add(startButton);
    }


    private void iconTicTacToe() {
        // изменение стандартной иконки java в игровом окне
        try {
            ImageIcon imageIcon = new ImageIcon("src/images/TicTacToeIcon_2.png");
            setIconImage(imageIcon.getImage());

        } catch (NullPointerException e) {
            System.out.println("Ошибка: " + e);
        }
    }

}
