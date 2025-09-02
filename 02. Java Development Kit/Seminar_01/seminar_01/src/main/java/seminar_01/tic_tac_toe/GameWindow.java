package seminar_01.tic_tac_toe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameWindow extends JFrame {

    private final int HEIGHT = 500, WIDTH = 500;  // задание геометрии (размер) игрового окна

    private JButton startButton, stopButton;

    private Map map;
    private SettingsWindow settings;


    public GameWindow() {
        super();

        setDefaultCloseOperation(EXIT_ON_CLOSE);    // стандартное поведение при закрытии окна - завершение приложения
        setTitle("TicTacToe");  // заголовок окна
        setSize(WIDTH, HEIGHT);  // задание геометрии (размер) игрового окна
        setResizable(false);    // запрет на изменение размера игрового окна
        setLocationRelativeTo(null);    // расположение окна посередине экрана

        startButton = new JButton("Новая игра");
        stopButton = new JButton("Выход");

        settings = new SettingsWindow(this);
        map = new Map();

        iconTicTacToe();    // Метод - изменение стандартной иконки java в игровом окне

        startButton.addActionListener(new ActionListener() {    // обработчик нажатий на кнопку "Старт" основного окна
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        stopButton.addActionListener(new ActionListener() {   // обработчик нажатий на кнопку "Стоп" основного окна
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // панель кнопок
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2)); // панель кнопок
        buttonsPanel.add(startButton);
        buttonsPanel.add(stopButton);
        add(BorderLayout.SOUTH, buttonsPanel);
        add(map);

        setVisible(true);   // вывод окна на экран


    }

    public void iconTicTacToe() {
        // изменение стандартной иконки java в игровом окне
        try {
            ImageIcon imageIcon = new ImageIcon("src/images/TicTacToeIcon_2.png");
            setIconImage(imageIcon.getImage());

        } catch (NullPointerException e) {
            System.out.println("Ошибка: " + e);
        }
    }


    void startNewGame(int mode, int fieldSize) {
        map.startNewGame(mode, fieldSize);
    }


}
