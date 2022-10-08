package view;

import java.awt.*;
import java.awt.image.PixelGrabber;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Text {

    Font pixelFont;
    private String message = "";
    private int x = 0, y = 0;
    private int size = 32;

    public Text(){

        try {
            InputStream myStream = new BufferedInputStream(new FileInputStream("C:\\Users\\48791\\IdeaProjects\\Pixel-Cafe\\res\\font\\pixelFont.ttf"));
            pixelFont = Font.createFont(Font.TRUETYPE_FONT, myStream);
        }catch (FontFormatException | IOException e){
            e.printStackTrace();
        }
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setMessagePosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setFontSize(int size){
        this.size = size;
    }

    public void drawMessage(Graphics2D graphics2D){
        graphics2D.setFont(pixelFont);
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, size));
        graphics2D.setColor(Color.black);
        graphics2D.drawString(message, x, y);
    }
}
