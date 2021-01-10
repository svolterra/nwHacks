package ui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EncourageButton extends JFrame {
    private JFrame appFrame;

    private JPanel upperTextPanel;
    private JPanel buttonPanel;

    private JButton encourageButton;

    private JLabel buttonLabel;

    private List<String> encouragements = new ArrayList<>();

    public EncourageButton() {
        super("Encouragement Button");
        initializeGraphics();
    }

    private void initializeGraphics() {
        initAppFrame();
        initButton();
        initTextFrame();
    }

    private void initButtonFrame() {
        buttonPanel = new JPanel();
    }

    private void initButton() {
        initLabel();

        encourageButton = new JButton();
        encourageButton.setForeground(new Color(228, 181, 236, 255));
        encourageButton.setBackground(new Color(187, 249, 255, 245));
        encourageButton.setBounds(0,123,400,150);

        appFrame.add(encourageButton);
    }

    private void initLabel() {
        buttonLabel = new JLabel();

        buttonLabel.setText("Click me!");
        buttonLabel.setForeground(Color.pink);
        buttonLabel.setFont(new Font("SansSerif", Font.BOLD, 20));

        buttonLabel.setBounds(155, 178, 200, 25);

        appFrame.add(buttonLabel);
    }

    private void initTextFrame() {
        upperTextPanel = new JPanel();
        upperTextPanel.setBounds(0,0,400, 300);
        upperTextPanel.setVisible(true);
        appFrame.add(upperTextPanel);
    }



    private void initAppFrame() {
        appFrame = new JFrame("Encouragement button");
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setVisible(true);
        appFrame.setSize(400,300);
    }

    public void readEncouragements() {
        try {
            File myObj = new File("encouraging-sentences.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                encouragements.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        new EncourageButton();
    }
}
