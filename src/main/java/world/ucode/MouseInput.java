package world.ucode;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        //PlayButton
        if (mx >= 350 && mx <= 449) {
            if (my >= 178 && my <= 222) {
                //Pressed PlayButton
                GamePanel.State = GamePanel.STATE.GAME;
                GamePanel.setPressMouse(true);
            }
        }

        //HelpButton
        if (mx >= 350 && mx <= 449) {
            if (my >= 250 && my <= 300) {
                //Pressed PlayButton
                GamePanel.State = GamePanel.STATE.HELP;
            }
        }

        //QuitButton
        if (mx >= 350 && mx <= 449) {
            if (my >= 350 && my <= 400) {
                if (GamePanel.State == GamePanel.STATE.MENU)
               System.exit(0);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
