package view;

import controller.CafeController;
import model.CafeModel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.Writer;
import java.security.PublicKey;

public class CafeView extends JPanel implements BaristaObserver {
    private final JFrame window;
    private final CafeModel cafeModel;
    private final CafePanel cafePanel;
    private final CafeController cafeController;
    private final KeyHandler keyHandler = new KeyHandler();
    SceneManager sceneManager;

    public CafeView(CafeController cafeController, CafeModel cafeModel){
        this.cafeModel = cafeModel;
        this.cafeController = cafeController;
        this.sceneManager = new SceneManager(keyHandler, this);
        this.cafePanel = new CafePanel(sceneManager, keyHandler);

        cafeModel.addBaristaObserver(this);
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setSize(1400, 838);
        window.add(cafePanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        cafePanel.starCafeSimulationThread();
    }

    @Override
    public void updateSelectedCoffee() {
        sceneManager.setSceneNumber(cafeModel.getNewScene());
    }

    @Override
    public void updateBill(){
        sceneManager.setPrice(cafeModel.getPrice());
    }

    public void giveChoiceToController(int choice){
        cafeController.setCoffee(choice);
    }

    public void setSelectedAdditives(int additivesNumber){
        cafeController.setAdditions(additivesNumber);
    }

    public void completeTheOrder(){
        cafeController.completeTheOrder();
    }

}
