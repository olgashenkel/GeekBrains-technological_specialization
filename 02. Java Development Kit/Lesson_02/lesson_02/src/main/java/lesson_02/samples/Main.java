package lesson_02.samples;

import lesson_02.bricks.view.MianWindow;

import javax.swing.*;


public class Main {

    public interface MouseListener{
        void mouseUp();
        void mouseDown();
    }

    private static class MouseAdapter implements MouseListener{
        @Override
        public void mouseUp() {

        }

        @Override
        public void mouseDown() {

        }
    }

    private static void addMouseListener (MouseListener l){
        l.mouseDown();
        l.mouseUp();
    }

    public static void main(String[] args) {
        // Исключения в графическом интерфейсе:
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Exceptional();
            }
        });


        new MianWindow();
        new lesson_02.circles.view.MianWindow();

        MouseAdapter m = new MouseAdapter();
//        m.mouseDown();
//        m.mouseUp();
        addMouseListener(m);
        addMouseListener(new MouseAdapter());
        MouseListener l = new MouseListener() {
            @Override
            public void mouseUp() {

            }

            @Override
            public void mouseDown() {

            }
        };
        addMouseListener(l);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseUp() {

            }

            @Override
            public void mouseDown() {

            }
        });

    }

}
