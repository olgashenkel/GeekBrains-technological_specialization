package lesson_02.bricks;

import lesson_02.circles.Background;
import lesson_02.common.CanvasRepaintListener;
import lesson_02.common.Interactable;
import lesson_02.common.MainCanvas;
import lesson_02.common.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MianWindow extends JFrame implements CanvasRepaintListener, MouseListener {
    private static final int PST_X = 1200;
    private static final int PST_Y = 200;
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 400;

    private final Interactable[] interactables = new Interactable[10];


    public MianWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(PST_X, PST_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Bricks");
        interactables[0] = new Background();
        for (int i = 1; i < interactables.length; i++) {
            interactables[i] = new Brick();
        }

        MainCanvas canvas = new MainCanvas(this);
        canvas.addMouseListener(this);
        add(canvas);
        setVisible(true);
    }

    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].render(canvas, g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Clicked!");
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
