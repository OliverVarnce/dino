package world.ucode;

import java.awt.*;

public class Menu {
    public Rectangle playButton = new Rectangle(GamePanel.WIDTH / 2 - 50, 150, 100, 50);
    public Rectangle helpButton = new Rectangle(GamePanel.WIDTH / 2 - 50, 250, 100, 50);
    public Rectangle quitButton = new Rectangle(GamePanel.WIDTH / 2 - 50, 350, 100, 50);

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font fnt0 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.black);
        g.drawString("T-REX Menu", GamePanel.WIDTH / 3 - 10, 70);

        Font fnt1 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt1);
        g.drawString("Play", playButton.x + 18, playButton.y + 33);
        g.drawString("Help", helpButton.x + 18, helpButton.y + 33);
        g.drawString("Quit", quitButton.x + 18, quitButton.y + 33);
        g2d.draw(playButton);
        g2d.draw(helpButton);
        g2d.draw(quitButton);
    }
}
