import java.awt.*;

public class ComPaddle extends Rectangle {
    int highspeed = 9;
    int lowspeed = 4;
    int YVelocity;
    ComPaddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }
    public void setYDirection(int YDirection) {
        //set computer paddle direction
        YVelocity = YDirection;
    }
    public void move() {
        //change computer paddle's position
        y = y + YVelocity;
    }
    public void draw(Graphics g) {
        //draw animation
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }
}
