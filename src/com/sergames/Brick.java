package com.sergames;

import java.awt.*;

public class Brick {
    private static final int X = 50;
    private static final int Y = 50;
    private static final int WIDTH = 120;
    private static final int HEIGHT = 20;
    private Main game;

    public Brick(Main game) {
        this.game = game;
    }

    public void paint(Graphics2D g) {
        g.fillRect(X, Y, WIDTH, HEIGHT);
    }

    public Rectangle getBounds() {
        return new Rectangle(X, Y, WIDTH, HEIGHT);
    }

    public int getTopY() {
        return Y;
    }

    public int getBotY() {
        return Y + HEIGHT;
    }

}
