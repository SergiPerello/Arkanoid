package com.sergames;

import java.awt.*;

public class Brick {
    private int x;
    private int y;
    private int width = 80;
    private int height = 20;
    private Main game;

    public Brick(Main game, int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;
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
