package lesson_01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    JButton btnStart = new JButton("New Game");
    JButton btnExit = new JButton("Exit");

    Map map;
    SettingsWindow settings;

    GameWindow() {
        super();

        setDefaultCloseOperation(EXIT_ON_CLOSE);    // стандартное поведение при закрытии окна - завершение приложения
        setLocation(WINDOW_POSX, WINDOW_POSY);  // задание позиции игрового окна на экране
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);   // задание геометрии (размер) игрового окна
        setTitle("TicTacToe");  // заголовок окна
        setResizable(false);    // запрет на изменение размера игрового окна

        map = new Map();
        settings = new SettingsWindow(this);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // добавление кнопок на панель
        JPanel panBottom = new JPanel(new GridLayout(1, 2));
        panBottom.add(btnStart);
        panBottom.add(btnExit);
        add(panBottom, BorderLayout.SOUTH); // BorderLayout.SOUTH --> расположение кнопок снизу
        add(map);

        setVisible(true);
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }
}
