package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.Image;

public class MyPanel extends JPanel  {


    Image background;
    MyPanel(){
        background = new ImageIcon("sheep.png").getImage();
        this.setPreferredSize(new Dimension(640,381));
    }
    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(background, 0, 0, null);
    }

}
