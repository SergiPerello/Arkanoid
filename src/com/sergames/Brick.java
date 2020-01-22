package com.sergames;

import java.awt.*;

public class Brick {
    private static final int x = 100;
    private static final int y = 100;
    private static final int width = 200;
    private static final int height = 200;
    private Main game;

    public Brick(Main game) {
        this.game = game;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public int getTopY() {
        return y;
    }

    public int getBotY() {
        return y + height;
    }

    public int getRightX() {
        return x + width;
    }

    public int getLeftX() {
        return x;
    }
}
