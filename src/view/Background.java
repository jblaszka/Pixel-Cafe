package view;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Background {
    KeyHandler keyHandler;
    Text text = new Text();
    private String background;
    BufferedImage image;
    private BufferedImage takeOrder;
    private BufferedImage latte;
    private BufferedImage espresso;
    private BufferedImage additions;
    private BufferedImage americanoAndCappuccino;

    int backgroundNumber = 0;
    int lala = 5;

    private int posY = 630;

    public Background(KeyHandler keyHandler) {
        this.keyHandler = keyHandler;
        getBackgroundView();
        background = "takeOrder";
    }

    public void getBackgroundView() {
        try {
            takeOrder = ImageIO.read(new File("C:\\Users\\48791\\IdeaProjects\\Pixel-Cafe\\res\\background\\takeOrder_n.png"));
            latte = ImageIO.read(new File("C:\\Users\\48791\\IdeaProjects\\Pixel-Cafe\\res\\background\\latte.png"));
            espresso = ImageIO.read(new File("C:\\Users\\48791\\IdeaProjects\\Pixel-Cafe\\res\\background\\espresso.png"));
            americanoAndCappuccino = ImageIO.read(new File("C:\\Users\\48791\\IdeaProjects\\Pixel-Cafe\\res\\background\\americanoAndCappuccino.png"));
            additions = ImageIO.read(new File("C:\\Users\\48791\\IdeaProjects\\Pixel-Cafe\\res\\background\\additions.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBackground(String backgroundName) {
    }

    public void drawBackground(Graphics2D graph2D){
        if(backgroundNumber == 1){
            image = additions;
        }else if(backgroundNumber == 2){
            image = latte;
        }else if(backgroundNumber == 3){
            image = americanoAndCappuccino;
        }else if(backgroundNumber == 4){
            image = espresso;
        }else{
            image = takeOrder;
        }
        graph2D.drawImage(image, 0, 0, 1400, 800, null);
    }

    public void setBackgroundNumber(int backgroundNumber){
        this.backgroundNumber = backgroundNumber;
    }
}

