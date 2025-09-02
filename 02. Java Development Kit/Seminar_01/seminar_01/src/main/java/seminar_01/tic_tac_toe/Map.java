package seminar_01.tic_tac_toe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {

    private static final Random RANDOM = new Random();
    private static final int DOT_PADDING = 15;   // отступ

    public static final int MODE_HUMAN_VS_AI = 0;
    public static final int MODE_HUMAN_VS_HUMAN = 1;


    private final int EMPTY_DOT = 0;    // хранение состояния ячейки поля - пустая ячейка
    private final int HUMAN_DOT = 1;    // хранение состояния ячейки поля - игрок
    private final int AI_DOT = 2;       // хранение состояния ячейки поля - компьютер


    private int panelWidth, panelHeight, cellHeight, cellWidth;     // размеры (ширина, высота) и отступы игрового окна
    //    private int size = 3;   // кол-во ячеек игрового поля
    private int size;
    private char[][] field;     // создание массива игрового поля
    private int mode;


    private int gameOverType;   // статус игры
    private static final int STATE_DRAW = 0;    // статус игры "Ничья"
    private static final int STATE_WIN_HUMAN = 1;    // статус игры "Победа игрока"
    private static final int STATE_WIN_AI = 2;    // статус игры "Победа компьютера"

    private static final String MSG_WIN_HUMAN_1 = "Победил Игрок 1!";   // Сообщение о результате игры
    private static final String MSG_WIN_HUMAN_2 = "Победил Игрок 2!";   // Сообщение о результате игры
    private static final String MSG_WIN_HUMAN = "Победил Игрок!";   // Сообщение о результате игры
    private static final String MSG_WIN_AI = "Победил Компьютер!";   // Сообщение о результате игры
    private static final String MSG_DRAW = "Ничья!";   // Сообщение о результате игры

    private boolean isGameOver;
    private boolean isInitialized;


    public Map() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {   // обработчик клика мышки
                update(e);
            }
        });
        isInitialized = false;
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1)); // Разместить рамку вокруг панели
    }

    void startNewGame(int mode, int size) {
//        System.out.printf("Mode: %d; \nSize: x=%d, y=%d; \nWin Length: %d\n",
//                mode, size);     // сообщение в консоли о параметрах игрового поля
        this.mode = mode;
        this.size = size;

        initMap();  // Метод инициализации игрового поля.

        isGameOver = false;
        isInitialized = true;

        repaint();
    }


    private void update(MouseEvent e) {   // обработчик клика мышки
        if (isGameOver || !isInitialized) return;
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return; // проверка хода игрока на ход в
        // пределах игр.поля и пустоту выбранной ячейки
        field[cellY][cellX] = HUMAN_DOT; // если условия для выполнения хода удовлетворяют, то игрок делает ход

//        if (checkEndGame(HUMAN_DOT, STATE_WIN_HUMAN)) return; // проверка на победу игроком


        System.out.printf("x=%d, y=%d\n", cellX, cellY);


        // если игрок своим ходом не одержал победу, то ход делает компьютер:
        aiTurn(); // метод хода компьютера
        repaint(); // метод перерисовки игрового поля

        checkEndGame(HUMAN_DOT, STATE_WIN_HUMAN);// проверка на победу игроком
        checkEndGame(AI_DOT, STATE_WIN_AI);// проверка на победу компьютером


    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }


    private void render(Graphics g) {
        if (!isInitialized) return;

        panelHeight = getHeight();    // высота игрового поля
        panelWidth = getWidth();    // ширина игрового поля
        cellHeight = panelHeight / size; // делим высоту игрового поля на кол-во ячеек - получаем высоту одной ячейки
        cellWidth = panelWidth / size;// делим ширину игрового поля на кол-во ячеек - получаем высоту одной ячейки

        // отрисовка сетки (измененный вариант)

        g.setColor(Color.DARK_GRAY);
        for (int i = 0; i < size; i++) {
            g.drawLine(0, cellHeight * i, panelWidth, cellHeight * i);  // горизонтальная линия
            g.drawLine(cellWidth * i, 0, cellWidth * i, panelHeight);  // вертикальная линия
        }

        // отрисовка хода (можно задать отрисовку Крестиков или Ноликов, вставку картинки и т.п.)
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (field[y][x] == EMPTY_DOT) continue;

                if (field[y][x] == HUMAN_DOT) {     // отрисовка хода игрока (крестик)
                    g.setColor(Color.BLACK);
                    g.drawLine(x * cellWidth + DOT_PADDING, y * cellHeight + DOT_PADDING,
                            (x + 1) * cellWidth - DOT_PADDING, (y + 1) * cellHeight - DOT_PADDING);
                    g.drawLine(x * cellWidth + DOT_PADDING, (y + 1) * cellHeight - DOT_PADDING,
                            (x + 1) * cellWidth - DOT_PADDING, (y) * cellHeight + DOT_PADDING);

                } else if (field[y][x] == AI_DOT) {      // отрисовка хода компьютера (нолик)
                    g.setColor(Color.RED);
                    g.drawOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                } else {
                    throw new RuntimeException("Unexpected value " + field[y][x] + " in cell: x="
                            + x + " y=" + y);
                }
            }
        }
        if (isGameOver) showMessageGameOver(g);
    }


    private void initMap() {    // Метод инициализации игрового поля. Его вызов размещен в методе старта

        // Создается новый пустой массив.
        field = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }


    private boolean isValidCell(int x, int y) {     // проверка отсутствия выхода за пределы поля
        return x >= 0 && x < size && y >= 0 && y < size;
    }

    private boolean isEmptyCell(int x, int y) {      // проверка хода на пустоту ячейки
        return field[y][x] == EMPTY_DOT;
    }

    private void aiTurn() {     // Метод - ход компьютера
//        if (turnAIWinCell()) return;
//        if (turnHumanWinCell()) return;

        int x, y;
        do {
            x = RANDOM.nextInt(size);
            y = RANDOM.nextInt(size);
        } while (!isEmptyCell(x, y));
        field[y][x] = AI_DOT;
    }

    private boolean isMapFull() {       // Метод проверки поля на НИЧЬЮ
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    private boolean checkWin(int c) {
//        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
//        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
//        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;
//
//        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
//        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
//        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;
//
//        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
//        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
//
//        return false;


        int sizeWin;
        int diag1 = 0, diag2 = 0, diag3 = 0, diag4 = 0, diag5 = 0, diag6 = 0;

        if (size > 3) {
            sizeWin = size - 1;
            for (int y = 1; y < size; y++) { // проверка победителя по диагонали, если поле больше, чем 3х3
                if (field[y][y - 1] == c) diag3++;
                if (field[y - 1][y] == c) diag4++;
                if (field[y - 1][size - 1 - y] == c) diag5++;
                if (field[y][size - y] == c) diag6++;
            }
        } else {
            sizeWin = size;
        }

        for (int x = 0; x < size; x++) {    // проверка победителя по строкам и столбцам
            int row = 0, column = 0;
            for (int y = 0; y < size; y++) {
                if (field[x][y] == c) column++;
                if (field[y][x] == c) row++;
            }
            if (column == sizeWin || row == sizeWin) return true;
        }
        for (int x = 0; x < size; x++) {   // проверка победителя по диагонали
            if (field[x][x] == c) diag1++;
            if (field[x][size - 1 - x] == c) diag2++;
        }
        return diag1 == sizeWin || diag2 == sizeWin || diag3 == sizeWin || diag4 == sizeWin || diag5 == sizeWin || diag6 == sizeWin;
    }


    private boolean checkEndGame(int dot, int gameOverType) {   // метод проверки состояния поля на победу или ничью
        if (checkWin(dot)) {
            this.gameOverType = gameOverType;
            isGameOver = true;
            repaint();
            return true;
        }
        if (isMapFull()) {
            this.gameOverType = STATE_DRAW;
            isGameOver = true;
            repaint();
            return true;
        }
        return false;
    }


    private void showMessageGameOver(Graphics g) {     // метод вызова сообщения с одним из вариантов исхода игры
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 170, getWidth(), 70);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Times New Roman", Font.BOLD, 48));
        switch (gameOverType) {
            case STATE_DRAW:
                g.drawString(MSG_DRAW, 180, getHeight() / 2);
                break;
            case STATE_WIN_AI:
                g.drawString(MSG_WIN_AI, 20, getHeight() / 2);
                break;
            case STATE_WIN_HUMAN:
                g.drawString(MSG_WIN_HUMAN, 70, getHeight() / 2);
                break;
            default:
                throw new RuntimeException("Unexpected gameOver state: " + gameOverType);
        }
    }


}
