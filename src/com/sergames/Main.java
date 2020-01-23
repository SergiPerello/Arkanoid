package com.sergames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JPanel {

    int speed = 2;
    Ball ball = new Ball(this);
    Paddle paddle = new Paddle(this);
    Brick[] bricks = {
            new Brick(this, 0, 100),
            new Brick(this, 0, 300)
    };

    public Main() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                paddle.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                paddle.keyReleased(e);
            }
        });
        setFocusable(true);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Arkanoid");
        Main game = new Main();
        frame.add(game);
        frame.setIconImage(new ImageIcon("a.png").getImage());
        frame.setSize(Const.WIDTH, Const.HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }

    private int getScore() {
        return speed - 1;
    }

    public void gameOver() {
        JOptionPane.showMessageDialog(this, "your score is: " + getScore(),
                "Game Over", JOptionPane.ERROR_MESSAGE);
        System.exit(ABORT);
    }

    private void move() {
        ball.move();
        paddle.move();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        paddle.paint(g2d);
        for (Brick item : bricks) item.paint(g2d);

        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString(String.valueOf(getScore()), 10, 30);
    }

}
