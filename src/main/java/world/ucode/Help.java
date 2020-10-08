package world.ucode;

import java.awt.*;

public class Help {
    public Rectangle returnButton = new Rectangle(GamePanel.WIDTH / 2 - 50, 650, 100, 50);

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font fnt0 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.black);
        g.drawString("T-REX Help", GamePanel.WIDTH / 3 - 10, 70);

        Font fnt1 = new Font("arial", Font.BOLD, 18);
        g.setFont(fnt1);
        g.drawString("Keys:   'SPACE BUTTON' - draw to jump t-rex", 150, 150);
        g.drawString("RETURN", returnButton.x - 33, returnButton.y + 55);
        g2d.draw(returnButton);
    }
}
