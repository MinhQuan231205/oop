import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameEndMenu extends KeyAdapter {
    GamePanel gamePanel;
    Random random1, random2;
    public int i, j;
    public String[] Congratulate = {
        "Sir",
        "Well played",
        "Congratulation!"
    };
    public String[] Despise = {
        "Such a loser!",
        "The best you can do?",
        "What a shame!"
    };
    GameEndMenu(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        random1 = new Random();
        random2 = new Random();
        i = random1.nextInt(3);
        j = random2.nextInt(3);
    }
    public void keyPressed(KeyEvent e) {
        //handle when players pressed specific keys
        if (gamePanel.gameState == GamePanel.STATE.End) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                i = random1.nextInt(3);
                j = random2.nextInt(3);
                gamePanel.newScore();
                if (gamePanel.gamemode == 1)
                    gamePanel.gameState = GamePanel.STATE.PlayvsPlayer;
                else if (gamePanel.gamemode == 2)
                    gamePanel.gameState = GamePanel.STATE.PlayvsCom;
            }
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                i = random1.nextInt(3);
                j = random2.nextInt(3);
                gamePanel.newScore();
                gamePanel.gameState = GamePanel.STATE.Menu;
            }
        }
    }
    public void paintComponent(Graphics g) {
        //draw texts
        Graphics2D g2 = (Graphics2D) g;
        float thickness = 5;
        Stroke oldStroke = ((Graphics2D) g).getStroke();
        ((Graphics2D) g).setStroke(new BasicStroke(thickness));

        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Courier New", 1, 35));
        g.drawString("GAME OVER", 280, GamePanel.GAME_HEIGHT/2 - 100);

        g.setFont(new Font("Courier New", 1, 21));
        if (gamePanel.score.player_1_score == 10) {
            g.drawString(Congratulate[i] + " P1", 85, 245);
            g.drawString(Despise[j] + " P2", GamePanel.GAME_WIDTH/2 + 55, 245);
        }
        if (gamePanel.score.player_2_score == 10) {
            g.drawString(Despise[i] + " P1", 55, 245);
            g.drawString(Congratulate[j] + " P2", GamePanel.GAME_WIDTH/2 + 55, 245);
        }

        g.setColor(Color.LIGHT_GRAY);
        g.drawString("Press Enter to play again", 25, 430);
        g.drawString("Press Esc to return to Menu", 25, 460);
    }
}
