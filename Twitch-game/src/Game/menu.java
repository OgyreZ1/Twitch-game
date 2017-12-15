package Game;

import java.awt.Button;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.*;

public class menu extends JFrame {
    int score;
    public Button b1;
    public menu(int points) {
        setFocusable(true);
        setBounds(500,500, 270, 170);
        setTitle("Меню");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        setLayout(null);


//        JTextField label = new JTextField()
        Button b = new Button("Выход");

        b.setBounds(80,50,100,20);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        Container cont = getContentPane();
        cont.add(b);
        JLabel label = new JLabel();
        label.setText("Ваш счёт: "+ points);
        label.setBounds(80,80,100,20);
        cont.add(label);

        b1 = new Button("Заново");
        b1.setBounds(80,20,100,20);
        cont.add(b1);
        setVisible(true);

    }

}