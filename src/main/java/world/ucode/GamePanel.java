package world.ucode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GamePanel extends JPanel implements KeyListener, Runnable {

  public enum STATE {
    MENU,
    GAME,
    HELP
  };

  public static STATE State = STATE.MENU;

  public static int WIDTH;
  public static int HEIGHT;
  private Thread animator;
  public static  boolean mousePress = false;

  private Menu menu;
  private Help help;

  private boolean running = false;
  private boolean gameOver = false;
  private boolean sounds = false;

  Ground ground;
  Dino dino;
  Obstacles obstacles;

  private int score;

  public static void setPressMouse(boolean g) {
    mousePress = g;
    System.out.println("mousePress: "+g);
    System.out.println("STATE: "+State);
  }

  public GamePanel() {
    WIDTH = UserInterface.WIDTH;
    HEIGHT = UserInterface.HEIGHT;
    State = STATE.MENU;
    ground = new Ground(HEIGHT);
    dino = new Dino();
    obstacles = new Obstacles((int) (WIDTH * 1.5));
    score = 0;

    setSize(WIDTH, HEIGHT);
    setVisible(true);

    menu = new Menu();
    this.addMouseListener(new MouseInput());
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);

    help = new Help();

      if (State == STATE.GAME) {
        if (mousePress) {
          g.setFont(new Font("Courier New", Font.BOLD, 25));
          g.drawString("SCORE: ", getWidth() - 200, 40);
          g.drawString(Integer.toString(score), getWidth() - 45, 40);
          ground.create(g);
          dino.create(g);
          obstacles.create(g);
        }
      } else if (State == STATE.MENU) {
        menu.paint(g);
      } else if (State == STATE.HELP) {
        help.paint(g);
      }
  }
  
  public void run() {
      running = true;
    while(running) {
      updateGame();
      repaint();
      this.addMouseListener(new MouseInput());
      try {
        Thread.sleep(50);
      }

      catch(InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  
  public void updateGame() {
    score += 1;

    ground.update();
    obstacles.update();
      if(obstacles.hasCollided()) {
        dino.die();
        repaint();
        running = false;
        gameOver = true;
        //докинуть звук
        System.out.println("collide");
      }
  }

  public void reset() {
    score = 0;
    System.out.println("reset");
    obstacles.resume();
    gameOver = false;
  }

  @Override
  public void keyTyped(KeyEvent e) {
    if (mousePress == true) {
      if (State == STATE.GAME) {
        if(e.getKeyChar() == KeyEvent.VK_SPACE) {
          if(gameOver)
            reset();
          if (animator == null || !running) {
            animator = new Thread(this);
            animator.start();
            dino.startRunning();
          } else {
            dino.jump();
          }
      }
      if(e.getKeyChar() == 0x1b) {
        State = STATE.MENU;
      }
      }

    }
  }

  @Override
  public void keyPressed(KeyEvent e) {
     //System.out.println("keyPressed: "+e);
  }

  @Override
  public void keyReleased(KeyEvent e) {
    //System.out.println("keyReleased: "+e);
  }
}