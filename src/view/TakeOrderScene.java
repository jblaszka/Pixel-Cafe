package view;

import java.awt.*;
import java.util.ArrayList;

public class TakeOrderScene {
    private int chosen_pos = 0;
    private int choice = 0;
    private final int pos_1 = 630;
    private final int pos_2 = 670;
    private final int pos_3 = 705;
    private final int pos_4 = 743;

    KeyHandler keyHandler;
    Background backgroundView;
    CafePanel cafePanel;
    Text text = new Text();
    int scene = 0;
    private final ArrayList<Integer> position = new ArrayList<Integer>();

    public TakeOrderScene(KeyHandler keyHandler, CafePanel cafePanel) {
        this.keyHandler = keyHandler;
        this.backgroundView = new Background(keyHandler);
        this.cafePanel = cafePanel;
        position.add(pos_1);
        position.add(pos_2);
        position.add(pos_3);
        position.add(pos_4);
    }

    public void updatePointer() {
        if (keyHandler.downPressed) {
            if(chosen_pos >= 3){
                chosen_pos = 0;
            }else {
                chosen_pos++;
            }
        } else if (keyHandler.upPressed) {
            if(chosen_pos <= 0){
                chosen_pos = 0;
            }else {
                chosen_pos--;
            }
        }
    }

    public void setScene(Graphics2D graphics2D){
        backgroundView.drawBackground(graphics2D);

        if(scene == 0){
            sceneTakeOrder(graphics2D);
            updateChoice();
        }else if(scene == 1){
            sceneChoseCondiment(graphics2D);
        }
    }

    public void sceneTakeOrder(Graphics2D graphics2D){
        text.setMessage(">");
        text.setFontSize(30);
        text.setMessagePosition(580, position.get(chosen_pos));
        text.drawMessage(graphics2D);

        text.setMessage("Hello. What can i get you?");
        text.setMessagePosition(695, 225);
        text.drawMessage(graphics2D);

    }

    public void sceneChoseCondiment(Graphics2D graphics2D){
        text.setMessage(">");
        text.setFontSize(30);
        text.setMessagePosition(580, position.get(chosen_pos));
        text.drawMessage(graphics2D);

        text.setMessage("Any additions to the drink?");
        text.setMessagePosition(685, 225);
        text.drawMessage(graphics2D);
    }

    public void updateChoice(){
        if(keyHandler.accepted){
            System.out.println("BYM");
            switch (chosen_pos){
                case 0 -> choice = 1;
                case 1 -> choice = 2;
                case 2 -> choice = 3;
                case 3 -> choice = 4;
            }
            cafePanel.updateChoice();
        }
    }

    public int getChoice(){
        return choice;
    }

    public void updateScene(){
        if(keyHandler.accepted) {
            scene ++;
        }
    }
}
