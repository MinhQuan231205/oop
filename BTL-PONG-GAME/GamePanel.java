import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import java.util.*;
import javax.swing.*;
public class GamePanel extends JPanel implements Runnable{

    static final int GAME_WIDTH = 750;
    static final int GAME_HEIGHT = 500;
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 15;
    static final int PADDLE_HEIGHT = 100;
    int gamemode;
    Thread gameThread;
    Paddle paddle_1;
    Paddle paddle_2;
    ComPaddle paddle_com;
    Ball ball;
    Score score;
    Sound sound;
    Image BackGroundofGame;
    GameMenu gameMenu;
    GameModeMenu gameModeMenu;
    GameEndMenu gameEndMenu;
    public enum STATE {
        Menu, ModeMenu, Quit, PlayvsCom, PlayvsPlayer, End
    }
    public STATE gameState = STATE.Menu;
    GamePanel() {
        newPaddles();
        newBall();
        newMenus();
        newScore();
        newResources();

        this.setFocusable(true);
        this.addKeyListener(new ActionListener());
        this.addKeyListener(gameEndMenu);
        this.addMouseListener(gameMenu);
        this.addMouseMotionListener(gameMenu);
        this.addMouseListener(gameModeMenu);
        this.addMouseMotionListener(gameModeMenu);
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }
    public void newBall() {
        //init ball
        Random random = new Random();
        ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2), random.nextInt(GAME_HEIGHT-BALL_DIAMETER), BALL_DIAMETER, BALL_DIAMETER);
    }
    public void newPaddles() {
        //init paddles
        paddle_1 = new Paddle(30, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
        paddle_2 = new Paddle(GAME_WIDTH - PADDLE_WIDTH - 30, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 2);
        paddle_com = new ComPaddle(30, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT);
    }
    public void newMenus() {
        //init menus
        gameMenu = new GameMenu(this);
        gameModeMenu = new GameModeMenu(this);
        gameEndMenu = new GameEndMenu(this);
    }
    public void newResources() {
        //init sound and image
        sound = new Sound();
        BackGroundofGame = new ImageIcon("src\\Resources\\backgroundofgame.png").getImage();
    }
    public void newScore() {
        //init score
        score = new Score(GAME_WIDTH, GAME_HEIGHT);
    }
    public void paintComponent(Graphics g) {
        //paint animation according to gameState
        if (gameState == STATE.PlayvsPlayer) {
            g.drawImage(BackGroundofGame, 0, 0, this);
            draw(g);
        }
        else if (gameState == STATE.PlayvsCom) {
            g.drawImage(BackGroundofGame, 0, 0, this);
            draw(g);
        }
        else if (gameState == STATE.Menu) {
            gameMenu.paintComponent(g);
        }
        else if (gameState == STATE.ModeMenu) {
            gameModeMenu.paintComponent(g);
        }
        else if (gameState == STATE.End) {
            g.drawImage(BackGroundofGame, 0, 0, this);
            score.draw(g);
            gameEndMenu.paintComponent(g);
        }
    }
    public void draw(Graphics g) {
        //draw components when game is playing
        if (gameState == STATE.PlayvsPlayer || gameState == STATE.End)
            paddle_1.draw(g);
        if (gameState == STATE.PlayvsCom || gameState == STATE.End)
            paddle_com.draw(g);

        paddle_2.draw(g);
        ball.draw(g);
        score.draw(g);
        Toolkit.getDefaultToolkit().sync();
    }
    public void move() {
        //change the position of components
        if (gameState == STATE.PlayvsPlayer)
            paddle_1.move();
        if (gameState == STATE.PlayvsCom)
            Commove();

        paddle_2.move();
        ball.move();
    }
    public void checkCollision() {
        //check collision
        //ball bounces off at top and bottom
        if (ball.y <= 0) {
            ball.y = 0;
            playSound(0);
            ball.setYDirection(-ball.YVelocity);
        }
        if (ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
            ball.y = GAME_HEIGHT-BALL_DIAMETER;
            playSound(0);
            ball.setYDirection(-ball.YVelocity);
        }

        //ball bounces off paddles
        double Velocity = ball.Velocity;
        if (ball.intersects(paddle_1) && gameState == STATE.PlayvsPlayer ) {
            playSound(0);
            double dis = ball.y - paddle_1.y;
            if (dis < 22) dis = 22;
            if (dis > 78) dis = 78;
            //change the ball's orbit
            ball.XVelocity = (int)Math.round(Velocity * Math.sin((dis*Math.PI)/100));
            ball.YVelocity = (int)Math.round(Velocity * Math.cos((dis*Math.PI)/100));
            ball.setXDirection(ball.XVelocity);
            ball.setYDirection(-ball.YVelocity);
        }
        if (ball.intersects(paddle_2)) {
            playSound(0);
            double dis = ball.y - paddle_2.y;
            if (dis < 22) dis = 22;
            if (dis > 78) dis = 78;
            //change the ball's orbit
            ball.XVelocity = (int)Math.round(Velocity * Math.sin((dis*Math.PI)/100));
            ball.YVelocity = (int)Math.round(Velocity * Math.cos((dis*Math.PI)/100));
            ball.setXDirection(-ball.XVelocity);
            ball.setYDirection(-ball.YVelocity);
        }
        if (ball.intersects(paddle_com) && gameState == STATE.PlayvsCom) {
            playSound(0);
            double dis = ball.y - paddle_com.y;
            if (dis < 22) dis = 22;
            if (dis > 78) dis = 78;
            //change the ball's orbit
            ball.XVelocity = (int)Math.round(Velocity * Math.sin((dis*Math.PI)/100));
            ball.YVelocity = (int)Math.round(Velocity * Math.cos((dis*Math.PI)/100));
            ball.setXDirection(ball.XVelocity);
            ball.setYDirection(-ball.YVelocity);
        }

        //stop paddles at edges of window
        if (paddle_1.y <= 0) {
            paddle_1.y = 0;
        }
        if (paddle_1.y >= GAME_HEIGHT-PADDLE_HEIGHT) {
            paddle_1.y = GAME_HEIGHT - PADDLE_HEIGHT;
        }
        if (paddle_com.y <= 0) {
            paddle_com.y = 0;
        }
        if (paddle_com.y >= GAME_HEIGHT-PADDLE_HEIGHT) {
            paddle_com.y = GAME_HEIGHT - PADDLE_HEIGHT;
        }
        if (paddle_2.y <= 0) {
            paddle_2.y = 0;
        }
        if (paddle_2.y >= GAME_HEIGHT-PADDLE_HEIGHT) {
            paddle_2.y = GAME_HEIGHT - PADDLE_HEIGHT;
        }

        //renew when ball hit left and right of window
        if (ball.x <= 0) {
            playSound(1);
            score.player_2_score++;
            newBall();
        }
        if (ball.x >= GAME_WIDTH) {
            playSound(1);
            score.player_1_score++;
            newBall();
        }
    }
    public void run() {
        //game loop
        long lastTime = System.nanoTime();
        double amountofTicks = 60.0;
        double ns = 1000000000 / amountofTicks;
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 0) {
                if ((gameState == STATE.PlayvsPlayer) || (gameState == STATE.PlayvsCom)) {
                    move();
                    checkCollision();
                    isGameEnd();
                    repaint();
                }
                else if (gameState == STATE.Menu) {
                    repaint();
                }
                else if (gameState == STATE.ModeMenu) {
                    repaint();
                }
                else if (gameState == STATE.End) {
                    repaint();
                }
                delta--;
            }
        }
    }
    public void playMusic(int i) {
        //play the music of the game
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    public void stopMusicAndSound() {
        //stop music and sound
        sound.stop();
    }
    public void playSound(int i) {
        //play sound when collisions happen
        sound.setFile(i);
        sound.play();
    }
    public void Commove() {
        //computer's paddle change position in PvE mode
        if (gameState == STATE.PlayvsCom && ball.x < GAME_WIDTH/2 + 50) {
            int by = ball.y;
            int cy = paddle_com.y;
            if (by <= cy - 5) {
                paddle_com.setYDirection(-paddle_com.highspeed);
            }
            if (by <= cy + 5 && by > cy - 5) {
                paddle_com.setYDirection(-paddle_com.lowspeed);
            }
            if (by >= cy + 95 && by < cy + 105) {
                paddle_com.setYDirection(paddle_com.lowspeed);
            }
            if (by >= cy + 105) {
                paddle_com.setYDirection(paddle_com.highspeed);
            }
            paddle_com.move();
        }
    }
    public void isGameEnd() {
        //check whether game ends or not
        if (score.player_1_score == 10 || score.player_2_score == 10) {
            gameState = STATE.End;
        }
    }
    public class ActionListener extends KeyAdapter {
        //keyboard's input of players
        public void keyPressed(KeyEvent e) {
            paddle_1.keyPressed(e);
            paddle_2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e) {
            paddle_1.keyReleased(e);
            paddle_2.keyReleased(e);
        }
    }
}
