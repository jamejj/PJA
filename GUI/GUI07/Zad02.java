package GUI.GUI07;

import javax.swing.*;
import java.awt.*;

public class Zad02 {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Zad 02");
        frame.setSize(300, 300);

        JTextArea textArea = new JTextArea(){

            @Override
            public void setFont(Font f) {
                Font newFont = new Font("Arial",Font.BOLD,40);
                super.setFont(newFont);
            }
            @Override
            public void setForeground(Color c) {
                super.setForeground(Color.BLUE);
            }

            @Override
            public void setBackground(Color c) {
                super.setBackground(Color.ORANGE); // np. zawsze pomarańczowe tło
            }
        };
        textArea.setBackground(Color.BLUE);
        JScrollPane scrollPane = new JScrollPane(textArea);


        
        frame.add(scrollPane);

        frame.setVisible(true);

    }

}