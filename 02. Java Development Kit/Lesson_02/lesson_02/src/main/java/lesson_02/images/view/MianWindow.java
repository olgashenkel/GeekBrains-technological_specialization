package lesson_02.images.view;

import lesson_02.images.exceptions.ImagesOverflowException;
import lesson_02.images.sprites.Background;
import lesson_02.images.sprites.Images;
import lesson_02.common.CanvasRepaintListener;
import lesson_02.common.Interactable;
import lesson_02.common.MainCanvas;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MianWindow extends JFrame implements CanvasRepaintListener, Thread.UncaughtExceptionHandler {
    private static final int PST_X = 200;
    private static final int PST_Y = 200;
    private static final int WINDOW_WIDTH = 900;
    private static final int WINDOW_HEIGHT = 600;
    private static final String TITLE = "Images";

    private static final int DEFAULT_COUNT_SPRITES = 4;
    private static final int MAX_COUNT_SPRITES = 15;
    private static final Random random = new Random();

    private Interactable[] interactable;
    private int countSprites;


    public MianWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(PST_X, PST_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(TITLE);
        setResizable(false);    // запрет на изменение размера игрового окна
        setLocationRelativeTo(null);    // расположение окна посередине экрана


        iconBricks();

        initSprites();
        MainCanvas canvas = new MainCanvas(this);
        add(canvas);
        addMouseListener(new MouseListener(this));
        setVisible(true);
    }

    private void initSprites() {
        interactable = new Interactable[MAX_COUNT_SPRITES];
        interactable[0] = new Background();
        countSprites = 1;
        for (int i = 1; i < DEFAULT_COUNT_SPRITES; i++) {
            addSprite(random.nextInt(WINDOW_WIDTH), random.nextInt(WINDOW_HEIGHT));
        }
    }

    public void addSprite(int x, int y) {
        if (countSprites >= MAX_COUNT_SPRITES) {
            throw new ImagesOverflowException();
        }
        interactable[countSprites++] = new Images(x, y);
    }

    public void removeSprite() {
        if (countSprites <= 1) {
            return;
        }
        countSprites--;
    }

    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }


    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < countSprites; i++) {
            interactable[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < countSprites; i++) {
            interactable[i].render(canvas, g);
        }
    }


    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e instanceof ImagesOverflowException) {
            e.fillInStackTrace();
        }
    }


    public void iconBricks() {
        // изменение стандартной иконки java в игровом окне
        try {
            ImageIcon imageIcon = new ImageIcon("src/images/geekbrains.png");
            setIconImage(imageIcon.getImage());

        } catch (NullPointerException e) {
            System.out.println("Ошибка: " + e);
        }
    }

}
