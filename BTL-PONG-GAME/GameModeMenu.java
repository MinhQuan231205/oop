import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameModeMenu extends MouseAdapter {
    GamePanel gamePanel;
    Image BackGroundofGMM;
    int check = 0;
    GameModeMenu(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        BackGroundofGMM = new ImageIcon("src\\Resources\\backgroundofmenu.png").getImage();
    }
    public void mousePressed(MouseEvent e) {
        //handle mouse's click
        int mx = e.getX();
        int my = e.getY();
        if (gamePanel.gameState == GamePanel.STATE.ModeMenu) {
            if (ismouseOver(mx, my, GamePanel.GAME_WIDTH/2 - 100, 294, 220, 49)) {
                gamePanel.gameState = GamePanel.STATE.PlayvsPlayer;
                gamePanel.gamemode = 1;
            }
            if (ismouseOver(mx, my, GamePanel.GAME_WIDTH/2 - 100, 364, 220, 49)) {
                gamePanel.gameState = GamePanel.STATE.PlayvsCom;
                gamePanel.gamemode = 2;
            }
            if (ismouseOver(mx, my,20, 20, 48, 24)) {
                gamePanel.gameState = GamePanel.STATE.Quit;
                System.exit(0);
            }
        }
    }
    public void mouseReleased(MouseEvent e) {
        //do nothing when mouse released
    }
    public void mouseMoved(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (ismouseOver(mx, my, GamePanel.GAME_WIDTH/2 - 100, 364, 220, 49)) {
            check = 1;
        }
        else if (ismouseOver(mx, my, GamePanel.GAME_WIDTH/2 - 100, 294, 220, 49)) {
            check = 2;
        }
        else if (ismouseOver(mx, my, 20, 20, 48, 24)) {
            check = 3;
        }
        else check = 0;
    }
    public boolean ismouseOver(int mx, int my, int x, int y, int width, int height) {
        //check whether mouse is over specific buttons
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
    public void paintQuit(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRoundRect(20, 20, 48, 24, 5, 5);

        g.setColor(Color.WHITE);
        g.drawRoundRect(20, 20, 48, 24, 5, 5);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", 1, 13));
        g.drawString("QUIT", 29, 35);
    }
    public void paintmovedonQuit(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRoundRect(20, 20, 48, 24, 5, 5);

        g.setColor(Color.GRAY);
        g.drawRoundRect(20, 20, 48, 24, 5, 5);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Courier New", 1, 13));
        g.drawString("QUIT", 29, 35);
    }
    public void paintOnePlayer(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRoundRect(GamePanel.GAME_WIDTH/2 - 100, 364, 220, 49, 10, 10);

        g.setColor(Color.WHITE);
        g.drawRoundRect(GamePanel.GAME_WIDTH/2 - 100, 364, 220, 49, 10, 10);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", 1, 29));
        g.drawString("ONE PLAYER", GamePanel.GAME_WIDTH/2 - 79, 398);
    }
    public void paintmovedonOnePlayer(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRoundRect(GamePanel.GAME_WIDTH/2 - 100, 364, 220, 49, 10, 10);

        g.setColor(Color.GRAY);
        g.drawRoundRect(GamePanel.GAME_WIDTH/2 - 100, 364, 220, 49, 10, 10);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Courier New", 1, 29));
        g.drawString("ONE PLAYER", GamePanel.GAME_WIDTH/2 - 79, 398);
    }
    public void paintTwoPlayers(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRoundRect(GamePanel.GAME_WIDTH/2 - 100, 294, 220, 49, 10, 10);

        g.setColor(Color.WHITE);
        g.drawRoundRect(GamePanel.GAME_WIDTH/2 - 100, 294, 220, 49, 10, 10);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", 1, 29));
        g.drawString("TWO PLAYERS", GamePanel.GAME_WIDTH/2 - 86, 328);
    }
    public void paintmovedonTwoPlayers(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRoundRect(GamePanel.GAME_WIDTH/2 - 100, 294, 220, 49, 10, 10);

        g.setColor(Color.GRAY);
        g.drawRoundRect(GamePanel.GAME_WIDTH/2 - 100, 294, 220, 49, 10, 10);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Courier New", 1, 29));
        g.drawString("TWO PLAYERS", GamePanel.GAME_WIDTH/2 - 86, 328);
    }
    public void paintComponent(Graphics g) {
        //draw bg
        g.drawImage(BackGroundofGMM, 0, 0, null);

        //draw title
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", 1, 50));
        g.drawString("PONG GAME", GamePanel.GAME_WIDTH / 2 - 132, 100);

        //draw button
        Graphics2D g2 = (Graphics2D) g;
        float thickness = 3;
        Stroke oldStroke = ((Graphics2D) g).getStroke();
        ((Graphics2D) g).setStroke(new BasicStroke(thickness));
        if (check == 0) {
            paintQuit(g);
            paintOnePlayer(g);
            paintTwoPlayers(g);
        }
        if (check == 1) {
            paintQuit(g);
            paintmovedonOnePlayer(g);
            paintTwoPlayers(g);
        }
        if (check == 2) {
            paintQuit(g);
            paintOnePlayer(g);
            paintmovedonTwoPlayers(g);
        }
        if (check == 3) {
            paintmovedonQuit(g);
            paintOnePlayer(g);
            paintTwoPlayers(g);
        }
    }
}
