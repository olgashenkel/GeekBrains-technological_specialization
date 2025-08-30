package seminar_01;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {

    private final int HEIGHT = 350, WIDTH = 350;    // Размер окна

    private static final String GAME_SETTINGS = "Настройки игры";

    private static final String GAME_MODE = "Выберите режим игры ";
    private static final String PLAYER_VS_AI = "Человек против Компьютера";
    private static final String PLAYER_VS_PLAYER = "Человек против Человека";

    private static final String FIELD_SIZE = "Выберите размеры поля";
    private static final String SELECTED_FIELD_SIZE = "Установленный размер поля: ";

    private static final String LENGTH_VICTORY = "Выберите длину для победы";
    private static final String SELECTED_LENGTH_VICTORY = "Установленная длина: ";

    private static final String START_NEW_GAME = "Запустить новую игру";

    private static final int DEFAULT_VALUE = 3;
    private static final int MIN_VALUE = 3;
    private static final int MAX_VALUE = 10;
    private static final int STEP_FOR_INCREASING = 1;


    private JSlider jslFieldSize;
    private JRadioButton jrbHumanVsAi;
    private JRadioButton jrbHumanVsHuman;
    private JSlider jslVictorySize;

    JButton startButton = new JButton(START_NEW_GAME);


    SettingsWindow(GameWindow gameWindow) {

        setSize(WIDTH, HEIGHT); // Размер окна
        setLocationRelativeTo(gameWindow);  // Расположение окна относительного игрового поля
        iconTicTacToe();    // Метод - изменение стандартной иконки java в игровом окне
        setTitle(GAME_SETTINGS); // Заголовок окна


        setLayout(new GridLayout(0, 1));
        gameMode();     // Метод "Регулирование режима игры"
        fieldSize();    // Метод "Регулирование параметров поля"
        victoryOptions();  // Метод "Регулирование параметров для победы"
        startButton(gameWindow);    // Метод "Обработчик кнопки"
    }


    private void gameMode() {  // Метод "Регулирование режима игры"
    /* JLabel с заголовком «Выберите режим игры», сгруппированные в ButtonGroup
    переключаемые JRadioButton с указанием режимов «Человек против компьютера»
    и «Человек против человека»
    */
        jrbHumanVsAi = new JRadioButton(PLAYER_VS_AI, true);
        jrbHumanVsHuman = new JRadioButton(PLAYER_VS_PLAYER);
        ButtonGroup gameModeGroup = new ButtonGroup();
        gameModeGroup.add(jrbHumanVsAi);
        gameModeGroup.add(jrbHumanVsHuman);

        // Добавление значений в окно настроек
        add(new JLabel(GAME_MODE));
        add(jrbHumanVsAi);
        add(jrbHumanVsHuman);
    }


    private void fieldSize() {  // Метод "Регулирование параметров поля"
    /*JLabel с заголовком «Выберите размеры поля», JLabel с заголовком «Установленный
    размер поля:», JSlider со значениями 3..10
     */
        jslFieldSize = new JSlider(MIN_VALUE, MAX_VALUE, DEFAULT_VALUE);
        JLabel labelFieldSize = new JLabel(SELECTED_FIELD_SIZE + MIN_VALUE);

    // Добавление слушателя изменений
        jslFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Получаем слайдер из источника события
                JSlider sourceSlider = (JSlider) e.getSource();
                // Получаем новое значение
                int newValue = sourceSlider.getValue();
                // Обновляем текст метки
                labelFieldSize.setText(SELECTED_FIELD_SIZE + newValue);
            }
        });

        jslFieldSize.setPaintLabels(true);    // Отображение значений делений
//        jslFieldSize.setPaintTicks(true);     // Отображение делений
        jslFieldSize.setMajorTickSpacing(1); // Расстояние между делениями

        // Добавление значений в окно настроек
        add(new JLabel(FIELD_SIZE));
        add(labelFieldSize);
        add(jslFieldSize);
    }


    private void victoryOptions() {  // Метод "Регулирование параметров для победы"
    /* JLabel с заголовком «Выберите длину для победы», JLabel с заголовком
    «Установленная длина:», JSlider со значениями 3..10
     */
        jslVictorySize = new JSlider(MIN_VALUE, MAX_VALUE - 1, DEFAULT_VALUE);
        JLabel labelVictorySize = new JLabel(SELECTED_LENGTH_VICTORY + MIN_VALUE);

        // Добавление слушателя изменений
        jslVictorySize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Получаем слайдер из источника события
                JSlider sourceSlider = (JSlider) e.getSource();
                // Получаем новое значение
                int newValue = sourceSlider.getValue();
                // Обновляем текст метки
                labelVictorySize.setText(SELECTED_LENGTH_VICTORY + newValue);
            }
        });

        jslVictorySize.setPaintLabels(true);    // Отображение значений делений
//        jslVictorySize.setPaintTicks(true);     // Отображение делений
        jslVictorySize.setMajorTickSpacing(1); // Расстояние между делениями

        // Добавление значений в окно настроек
        add(new JLabel(LENGTH_VICTORY));
        add(labelVictorySize);
        add(jslVictorySize);
    }


    private void startButton(GameWindow gameWindow) {   // Метод "Обработчик кнопки"
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int mode = jrbHumanVsAi.isSelected() ? Map.MODE_HUMAN_VS_AI : Map.MODE_HUMAN_VS_HUMAN;
                int size = jslFieldSize.getValue();
                gameWindow.startNewGame(mode, size);
                setVisible(false);
            }
        });
        add(startButton);
    }


    private void iconTicTacToe() {    // Метод - изменение стандартной иконки java в игровом окне
        try {
            ImageIcon imageIcon = new ImageIcon("src/images/TicTacToeIcon_2.png");
            setIconImage(imageIcon.getImage());

        } catch (NullPointerException e) {
            System.out.println("Ошибка: " + e);
        }
    }

}
