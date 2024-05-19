import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Paddle extends Rectangle{
    int id;
    int YVelocity;
    int speed = 10;
    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }
    public void keyPressed(KeyEvent e) {
        //paddles move when players pressed specific keys
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(-speed);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(speed);
                    move();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(-speed);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(speed);
                    move();
                }
                break;
        }
    }
    public void keyReleased(KeyEvent e) {
        //paddles remain still when players didn't press any specific keys
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(0);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(0);
                    move();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(0);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(0);
                    move();
                }
                break;
        }
    }
    public void setYDirection(int YDirection) {
        //set paddle's direction
        YVelocity = YDirection;
    }
    public void move() {
        //change paddle's postion
        y = y + YVelocity;
    }
    public void draw(Graphics g) {
        //draw animation
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

}
