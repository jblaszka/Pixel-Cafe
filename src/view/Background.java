package view;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Background {
    KeyHandler keyHandler;
    BufferedImage image;
    private BufferedImage takeOrderScene;
    private BufferedImage paymentScene;
    private BufferedImage latte;
    private BufferedImage espresso;
    private BufferedImage additions;
    private BufferedImage americanoAndCappuccino;

    int backgroundNumber = 0;

    public Background(KeyHandler keyHandler) {
        this.keyHandler = keyHandler;
        getBackgroundView();
    }

    public void getBackgroundView() {
        try {
            takeOrderScene = ImageIO.read(new File("C:\\Users\\48791\\IdeaProjects\\Pixel-Cafe\\res\\background\\takeOrder_n.png"));
            additions = ImageIO.read(new File("C:\\Users\\48791\\IdeaProjects\\Pixel-Cafe\\res\\background\\additions.png"));
            paymentScene = ImageIO.read(new File("C:\\Users\\48791\\IdeaProjects\\Pixel-Cafe\\res\\background\\paymentScene.png"));
            latte = ImageIO.read(new File("C:\\Users\\48791\\IdeaProjects\\Pixel-Cafe\\res\\background\\latte.png"));
            espresso = ImageIO.read(new File("C:\\Users\\48791\\IdeaProjects\\Pixel-Cafe\\res\\background\\espresso.png"));
            americanoAndCappuccino = ImageIO.read(new File("C:\\Users\\48791\\IdeaProjects\\Pixel-Cafe\\res\\background\\americanoAndCappuccino.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBackground(String backgroundName) {
    }

    public void drawBackground(Graphics2D graph2D){
        if(backgroundNumber == 1) {
            image = additions;
        }else if(backgroundNumber == 2){
            image = paymentScene;
        }else if(backgroundNumber == 3){
            image = latte;
        }else if(backgroundNumber == 4){
            image = americanoAndCappuccino;
        }else if(backgroundNumber == 5){
            image = espresso;
        }else{
            image = takeOrderScene;
        }
        graph2D.drawImage(image, 0, 0, 1400, 800, null);
    }

    public void setBackgroundNumber(int backgroundNumber){
        this.backgroundNumber = backgroundNumber;
    }
}

