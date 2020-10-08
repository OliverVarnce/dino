package world.ucode;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

//        public Rectangle playButton = new Rectangle(GamePanel.WIDTH / 2 - 50, 150, 100, 50);
//        public Rectangle helpButton = new Rectangle(GamePanel.WIDTH / 2 - 50, 250, 100, 50);
//        public Rectangle quitButton = new Rectangle(GamePanel.WIDTH / 2 - 50, 350, 100, 50);

        int mx = e.getX();
        int my = e.getY();

        //PlayButton
        if (mx >= 350 && mx <= 449) {
            if (my >= 178 && my <= 222) {
//                System.out.println("-------------------------");
//                System.out.println(GamePanel.State);
//                System.out.println("-------------------------");
                //Pressed PlayButton
                GamePanel.State = GamePanel.STATE.GAME;
//                System.out.println("-------------------------");
//                System.out.println(GamePanel.State);
//                System.out.println("-------------------------");
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
