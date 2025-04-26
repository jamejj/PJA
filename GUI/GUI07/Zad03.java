package GUI.GUI07;

import javax.swing.*;
import java.awt.*;

public class Zad03 {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new Okno());

    }
}

class Okno extends JFrame {

    public Okno() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Zad 03");
        frame.setSize(300, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));
//        panel.setLayout(new GridLayout(0,1));
//        panel.setLayout(new GridLayout(1,0));
//        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
//        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
//        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
//        panel.setLayout(new GridLayout(1,0));

        panel.add(new JButton("Przycisk1"));
        panel.add(new JButton("Przycisk2"));
        panel.add(new JButton("P3"));
        panel.add(new JButton("P4"));
        panel.add(new JButton("Duży przycisk o numerze 5"));

        frame.add(panel);
        frame.setVisible(true);

    }
}
