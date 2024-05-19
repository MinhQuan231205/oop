import java.awt.*;
public class Score extends Rectangle{
    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player_1_score;
    int player_2_score;

    Score(int GAME_WIDTH, int GAME_HEIGHT) {
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
    }
    public void draw(Graphics g) {
        //draw score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.PLAIN, 60));
        g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
        g.drawString(String.valueOf(player_1_score/10) + String.valueOf(player_1_score%10), (GAME_WIDTH/2)-85, 50);
        g.drawString(String.valueOf(player_2_score/10) + String.valueOf(player_2_score%10), (GAME_WIDTH/2)+20, 50);
    }
}
