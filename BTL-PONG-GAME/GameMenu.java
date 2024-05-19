import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import java.util.*;
import javax.swing.*;

public class GameMenu extends MouseAdapter {
    Image BackGroundofMenu;
    GamePanel gamePanel;
    int check = 0;

    GameMenu(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        BackGroundofMenu = new ImageIcon("src\\Resources\\backgroundofmenu.png").getImage();
    }

    public void mousePressed(MouseEvent e) {
        //handle mouse's click
        int mx = e.getX();
        int my = e.getY();
        if (gamePanel.gameState == GamePanel.STATE.Menu) {
            if (ismouseOver(mx, my, GamePanel.GAME_WIDTH / 2 - 60, 250, 120, 40)) {
                gamePanel.gameState = GamePanel.STATE.ModeMenu;
            }
            if (ismouseOver(mx, my, 20, 20, 48, 24)) {
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
        if (ismouseOver(mx, my, GamePanel.GAME_WIDTH / 2 - 60, 250, 120, 40)) {
            check = 1;
        }
        else if (ismouseOver(mx, my, 20, 20, 48, 24)) {
            check = 2;
        }
        else check = 0;

    }

    public boolean ismouseOver(int mx, int my, int x, int y, int width, int height) {
        //check whether mouse is over specific buttons
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else
                return false;
        } else
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
    public void paintStart(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRoundRect(GamePanel.GAME_WIDTH / 2 - 59, 250, 120, 40, 10, 10);

        g.setColor(Color.WHITE);
        g.drawRoundRect(GamePanel.GAME_WIDTH / 2 - 60, 250, 120, 40, 10, 10);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", 1, 30));
        g.drawString("START", GamePanel.GAME_WIDTH / 2 - 45, 278);
    }
    public void paintmovedonStart(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRoundRect(GamePanel.GAME_WIDTH / 2 - 60, 250, 120, 40, 10, 10);

        g.setColor(Color.GRAY);
        g.drawRoundRect(GamePanel.GAME_WIDTH / 2 - 60, 250, 120, 40, 10, 10);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Courier New", 1, 30));
        g.drawString("START", GamePanel.GAME_WIDTH / 2 - 45, 278);
    }

    public void paintComponent(Graphics g) {
        //draw background
        g.drawImage(BackGroundofMenu, 0, 0, null);

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
            paintStart(g);
        }
        if (check == 1) {
            paintQuit(g);
            paintmovedonStart(g);
        }
        if (check == 2) {
            paintmovedonQuit(g);
            paintStart(g);
        }
    }


}
