package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MyFrame extends JFrame {
    private MyPanel panel;
    private JLabel motivationLabel;
    private List<String> motivations = new ArrayList<>();

    public MyFrame() {
        panel = new MyPanel();
        motivationLabel = new JLabel("", SwingConstants.CENTER);
        motivationLabel.setBounds(110, 10, 600, 200);
        add(motivationLabel);


        JButton encourageButton = new JButton("Click me!");
        encourageButton.setBounds(220, 260, 200, 80);
        encourageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> encouragements = readTextFile();
                Random rand = new Random();
                String randomString = encouragements.get(rand.nextInt(encouragements.size()));
                motivationLabel.setText(randomString);
                motivationLabel.setFont(new Font("SansSerif", Font.ITALIC, 15));
                motivationLabel.setForeground(new Color(0,0,0));
            }
        });

        add(encourageButton);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public List<String> readTextFile() {
        try {
            File encouragementTxt = new File("encouraging-sentences.txt");
            Scanner myReader = new Scanner(encouragementTxt);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                motivations.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
        }
        return motivations;
    }
}
