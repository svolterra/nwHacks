package ui;

import javax.swing.*;

public class MyFrame extends JFrame {

    MyPanel panel;

    MyFrame(){


        panel = new MyPanel();

        JButton encourageButton = new JButton();
//        encourageButton.setForeground(new Color(228, 181, 236, 255));
//        encourageButton.setBackground(new Color(187, 249, 255, 245));
        encourageButton.setBounds(220,250,100,80);
//        encourageButton.addActionListener(this);

        this.add(encourageButton);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}
