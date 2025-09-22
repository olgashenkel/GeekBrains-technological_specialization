package lesson_02.bricks.sprites;

import lesson_02.common.MainCanvas;
import lesson_02.common.Sprite;

import java.awt.*;
import java.util.Random;

public class Brick extends Sprite {
    private float vX;
    private float vY;

    public Brick(int x, int y) {
        super(x, y);
        halfHeight = 20 + (float) (Math.random() * 50f);
        halfWidth = halfHeight;
        vX = 100f + (float) (Math.random() * 200f);
        vY = 100f + (float) (Math.random() * 200f);
    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect((int) getLeft(), (int) getTop(),
                (int) getWidth(), (int) getHeight());
    }


    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        x += vX * deltaTime;
        y += vY * deltaTime;

        if (getLeft() < canvas.getLeft()) {
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vY = -vY;
        }
    }

}
