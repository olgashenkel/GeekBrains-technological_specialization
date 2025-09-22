package lesson_02.images.sprites;

import lesson_02.common.MainCanvas;
import lesson_02.common.Sprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Images extends Sprite {
    private float vX;
    private float vY;
    private Image image;
    private static final Random rnd = new Random();

    public Images(int x, int y) {
        super(x, y);
        loadImage();
        halfHeight = 19;
        halfWidth = 150;

        vX = 100 + (float) (Math.random() * 200);
        vY = 100 + (float) (Math.random() * 200);
    }

    private void loadImage() {
        try {
            image = ImageIO.read(new File("src/images/Geekbrains_logo.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        g.drawImage(image, (int) getLeft(), (int) getTop(),
                (int) getWidth(), (int) getHeight(), null);
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
