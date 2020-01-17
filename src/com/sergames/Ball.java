package com.sergames;

import java.awt.*;

public class Ball {



    private static final int DIAMETER = 25;
    int x = 100;
    int y = 100;
    int xa = 1;
    int ya = 1;
    private Main game;

    public Ball(Main game) {
        this.game = game;
    }

    void move() {
        if (x + xa < 0)
            xa = game.speed;
        else if (x + xa > game.getWidth() - DIAMETER)
            xa = -game.speed;
        else if (y + ya < 0)
            ya = game.speed;
        else if (y + ya > game.getHeight() - DIAMETER)
            game.gameOver();
        else if (collisionPaddle()) {
            ya = -game.speed;
            y = game.paddle.getTopY() - DIAMETER;
            //game.speed++;
        } else if (collisionBrick()) {
            ya = -game.speed;
            y = game.brick.getTopY() -DIAMETER;
        }
        x = x + xa;
        y = y + ya;
    }

    private boolean collisionBrick() {
        return game.brick.getBounds().intersects(getBounds());
    }

    private boolean collisionPaddle() {
        return game.paddle.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
