package view;

import javax.swing.*;
import java.awt.*;

public class CafePanel extends JPanel implements Runnable {
    final int screenWidth = 1400;
    final int screenHeight = 800;
    int FPS = 6;

    KeyHandler keyHandler;
    Thread cafeSimulationThread;
    SceneManager sceneManager;

    public CafePanel( SceneManager sceneManager, KeyHandler keyHandler){
        this.sceneManager = sceneManager;
        this.keyHandler = keyHandler;
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
        sceneManager.drawScene(graph2D);
        graph2D.dispose();
    }

    public void update() {
        sceneManager.updatePointer();
    }

    public int getScreenHeight(){
        return screenHeight;
    }

    public int getScreenWidth(){
        return  screenWidth;
    }

}


