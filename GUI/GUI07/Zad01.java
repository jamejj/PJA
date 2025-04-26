package GUI.GUI07;

import javax.swing.*;
import java.awt.*;

public class Zad01 {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Moje okno");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 550);

        JPanel mainPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawLine(0,0,getWidth(),getHeight());
                g.drawLine(getWidth(),0,0,getHeight());
            }
        };

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}