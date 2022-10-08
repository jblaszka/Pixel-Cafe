package view;

import controller.CafeController;
import model.CafeModel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.Writer;
import java.security.PublicKey;

public class CafeView extends JPanel implements BaristaObserver {
    private JFrame window;
    private CafeModel cafeModel;
    private CafePanel cafePanel;
    private CafeController cafeController;

    public CafeView(CafeController cafeController, CafeModel cafeModel){
        this.cafeModel = cafeModel;
        this.cafeController = cafeController;
        cafeModel.addBaristaObserver(this);
        window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setSize(1400, 838);
        this.cafePanel = new CafePanel(this);
        window.add(cafePanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        cafePanel.starCafeSimulationThread();

    }

    @Override
    public void updateSelectedCoffee() {
        cafePanel.changeScene(cafeModel.getNewScene());
    }

    @Override
    public void updateSelectedAdditives(){}


    public void giveChoiceToController(int choice){
        cafeController.setCoffee(choice);
    }

    public void setSelectedAdditives(int additivesNumber){
        cafeController.setAdditions(additivesNumber);
    }

}
