package com.sergames;

import java.awt.*;

public class Ball {
    private final int size = 25;
    private int x, y;
    private int dirX, dirY;
    private Main game;

    public Ball(Main game) {
        this.game = game;
        this.x = Const.WIDTH / 2;
        this.y = Const.HEIGHT / 2;
        this.dirX = 1;
        this.dirY = 1;
    }

    void move() {
        this.x = this.x + this.dirX;
        this.y = this.y + this.dirY;

        //walls collision
        if (this.x + this.dirX < 0)
            this.dirX = game.speed;
        else if (this.x + this.dirX + this.size > Const.WIDTH)
            this.dirX = -game.speed;
        else if (this.y + this.dirY < 0)
            this.dirY = game.speed;
        else if (this.y + this.dirY + this.size > Const.HEIGHT)
            game.gameOver();

        //item collision
        if (collisionPaddle()) {
            this.dirY = -game.speed;
            this.y = game.paddle.getTopY() - this.size;
            //game.speed++;
        }
        if (collisionBrick()) {
            if (game.brick.getTopY()>this.y){
                this.dirY = -game.speed;
            }
        }

    }

    private boolean collisionBrick() {
        return game.brick.getBounds().intersects(getBounds());
    }

    private boolean collisionPaddle() {
        return game.paddle.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.MAGENTA);
        g.fillOval(this.x, this.y, this.size, this.size);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, this.size, this.size);
    }
}
