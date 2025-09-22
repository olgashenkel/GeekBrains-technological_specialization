package lesson_02.images.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {
    private MianWindow mianWindow;

    public MouseListener(MianWindow mianWindow) {
        this.mianWindow = mianWindow;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            mianWindow.removeSprite();
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            mianWindow.addSprite(e.getX(), e.getY());
        }
    }
}
