package view;

import javax.swing.*;
import java.awt.*;

public class CafePanel extends JPanel implements Runnable {
    final int screenWidth = 1400;
    final int screenHeight = 800;
    int FPS = 5;
    private int choice = 0;
    private CafeView cafeView;

    KeyHandler keyHandler = new KeyHandler();
    Thread cafeSimulationThread;
    Background backgroundView = new Background(keyHandler);
    Text text = new Text();
    TakeOrderScene takeOrderScene = new TakeOrderScene(keyHandler, this);

    public CafePanel(CafeView cafeView){
        this.cafeView = cafeView;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.pink);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void starCafeSimulationThread(){
        cafeSimulationThread = new Thread(this);
        cafeSimulationThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (cafeSimulationThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graph2D = (Graphics2D) g;

        takeOrderScene.setScene(graph2D);

        graph2D.dispose();
    }

    public int getScreenHeight(){
        return screenHeight;
    }

    public int getScreenWidth(){
        return  screenWidth;
    }

    public void update() {
        takeOrderScene.updatePointer();
        takeOrderScene.updateScene();
    }

    public void updateChoice() {
        choice = takeOrderScene.getChoice();
        cafeView.giveChoiceToController(choice);
    }

    public void changeScene(int numberScene){
        backgroundView.setBackground(numberScene);
    }
}
