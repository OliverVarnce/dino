package world.ucode;

import world.ucode.Resource;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;

import javax.imageio.ImageIO;


public class Menu {
    private class MenuImage {
        BufferedImage image;
        int x;
    }

    public static int MENU_Y;

    private BufferedImage image;

    private ArrayList<Menu.MenuImage> menuImageSet;

    public Menu(int panelHeight) {
        MENU_Y = (int) (panelHeight - 0.25 * panelHeight);

        try {
            image = new Resource().getResourceImage("../../images/Sun.png");
        } catch (Exception e) {
            e.printStackTrace();
        }

        menuImageSet = new ArrayList<Menu.MenuImage>();


        for (int i = 0; i < 3; i++) {
            Menu.MenuImage obj = new Menu.MenuImage();
            obj.image = image;
            obj.x = 0;
            menuImageSet.add(obj);
        }
    }
}