import java.awt.*;
import javax.swing.*;
public class GameFrame extends JFrame {
    public GamePanel gamepanel;
    GameFrame() {
        gamepanel = new GamePanel();
        this.add(gamepanel);
        this.setTitle("Pong game");
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
