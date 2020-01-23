package com.sergames;

import java.awt.*;

public class Ball {
    private final int size = 15;
    private int x, y;
    private int dirX, dirY;
    private Main game;

    public Ball(Main game) {
        this.game = game;
        this.x = Const.WIDTH / 2;
        this.y = Const.HEIGHT / 2;
        this.dirX = game.speed;
        this.dirY = game.speed;
    }

    void move() {

        //walls collision
        if (this.x + this.dirX < 0)
            this.dirX = game.speed;
        else if (this.x + this.dirX > Const.WIDTH - this.size * 2)
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
        if (collisionBrick()) { //Aquest metode m'ha portat 5 hores
            //Brick dimensions
            int topY = game.brick.getTopY();
            int botY = game.brick.getBotY();
            int rightX = game.brick.getRightX();
            int leftX = game.brick.getLeftX();

            if (this.y + size >= botY && (this.x <= rightX && this.x >= leftX)) {
                this.dirY = game.speed;
                System.out.println("Bot");
            } else if (this.y < topY && (this.x <= rightX && this.x >= leftX)) {
                this.dirY = -game.speed;
                System.out.println("Top");
            } else this.dirX = this.dirX > 0 ? -game.speed : game.speed;

            /*if (this.x <= rightX && this.x >= leftX) this.dirY = this.y >= botY ? game.speed : -game.speed;
            else this.dirX = this.dirX > 0 ? -game.speed : game.speed;*/
        }

        this.x = this.x + this.dirX;
        this.y = this.y + this.dirY;

    }

    private boolean collisionBrick() {
        for (Brick item : game.bricks) {
            return item.getBounds().intersects(getBounds());
        }
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
