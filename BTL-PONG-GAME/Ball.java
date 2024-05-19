import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Ball extends Rectangle{
    Random random;
    int XVelocity;
    int YVelocity;
    int Velocity = 12;
    Ball(int x, int y, int width, int height) {
        super(x, y, width, height);
        random = new Random();

        //random initial ball's direction
        int randomXDirection = random.nextInt(2);
        if (randomXDirection == 0) {
            randomXDirection--;
        }
        setXDirection(2 * randomXDirection);
        int randomYDirection = random.nextInt(2);
        if (randomYDirection == 0) {
            randomYDirection--;
        }
        setYDirection(2 * randomYDirection);
    }
    public void setXDirection(int randomXDirection) {
        //set ball's direction in coordinate x
        XVelocity = randomXDirection;
    }
    public void setYDirection(int randomYDirection) {
        //set ball's direction in coordinate y
        YVelocity = randomYDirection;
    }
    public void move() {
        //change ball's position
        x += XVelocity;
        y += YVelocity;
    }
    public void draw(Graphics g) {
        //draw animation
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
    }
}
