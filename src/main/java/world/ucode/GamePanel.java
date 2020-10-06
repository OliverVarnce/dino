package world.ucode;

import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import world.ucode.Ground;
import world.ucode.Dino;
import world.ucode.Obstacles;
import world.ucode.Menu;

class GamePanel extends JPanel implements KeyListener, Runnable {
  
  public static int WIDTH;
  public static int HEIGHT;
  private Thread animator;
  
  private boolean running = false;
  private boolean gameOver = false;

  Menu menu;
  Ground ground;
  Dino dino;
  Obstacles obstacles;

  private int score;
  
  public GamePanel() {
    WIDTH = UserInterface.WIDTH;
    HEIGHT = UserInterface.HEIGHT;


    menu = new Menu(HEIGHT);
    ground = new Ground(HEIGHT);
    dino = new Dino();
    obstacles = new Obstacles((int)(WIDTH * 1.5));

    score = 0;
    
    setSize(WIDTH, HEIGHT);
    setVisible(true);
  }
  
  public void paint(Graphics g) {
    super.paint(g);
    g.setFont(new Font("Courier New", Font.BOLD, 25));
    g.drawString("SCORE: ", getWidth() - 200, 40);
    g.drawString(Integer.toString(score), getWidth() - 45, 40);
    ground.create(g);
    dino.create(g);
    obstacles.create(g);
  }
  
  public void run() {
    running = true;

    while(running) {
      updateGame();
      repaint();      
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
      //докинуть звук дай
      System.out.println("collide");
    }
    // game complete condition
  }

  public void reset() {
    score = 0;
    System.out.println("reset");
    obstacles.resume();
    gameOver = false;
  }
  
  public void keyTyped(KeyEvent e) {
    // System.out.println(e);
    if(e.getKeyChar() == ' ') {    
      if(gameOver) reset();
      if (animator == null || !running) {
        System.out.println("Game starts");        
        animator = new Thread(this);
        animator.start();     
        dino.startRunning();   
      } else {
        dino.jump();
      }
    }
    if(e.getKeyChar() == 0x1b) {
      System.out.println("keyReleased: "+e);
    }
  }
  
  public void keyPressed(KeyEvent e) {
     //System.out.println("keyPressed: "+e);
  }
  
  public void keyReleased(KeyEvent e) {
    //System.out.println("keyReleased: "+e);
  }
}