import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Okno extends JFrame {

    public Okno(){
        generujOkno();
    }

    public void generujOkno(){

        setLayout(new FlowLayout());

        JLabel a = new JLabel("a: ");
        JTextField jTextFieldA = new JTextField ("");
        jTextFieldA.setPreferredSize (new Dimension (100 , 20));

        JLabel b = new JLabel("b: ");
        JTextField jTextFieldB = new JTextField ("");
        jTextFieldB.setPreferredSize (new Dimension (100 , 20));

        JButton suma = new JButton("a+b");


        suma.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String txt1 = jTextFieldA.getText();
                String txt2 = jTextFieldB.getText();

                if(txt1.isEmpty() || txt2.isEmpty()){
                    throw new IllegalArgumentException("Pole nie moze byc puste");
                }

                try {
                    int a = Integer.parseInt(txt1.trim());
                    int b = Integer.parseInt(txt2.trim());
                    System.out.println(a+b);
                }catch (IllegalArgumentException ex){
                    System.out.println("Zły format");
                }
            }
        });


        add(a);
        add(jTextFieldA);
        add(b);
        add(jTextFieldB);
        add(suma);

        setVisible(true);
        setTitle("Sumator");
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }
}
