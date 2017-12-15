package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.RenderingHints.Key;
import java.awt.event.*;

public class okno extends JFrame {
    private pole gameP;
   // private int slogn;

    private class myKey implements KeyListener {
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == 27) {
                okno.this.setEnabled(false);
                menu m = new menu(gameP.points);
                m.addWindowListener(new WindowAdapter(){
                    public void windowClosing(WindowEvent evt){
                        gameP.unpause();
                        okno.this.setEnabled(true);
                        m.dispose();

                    }
                });
                m.b1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        gameP.renew();
                        gameP.unpause();
                        okno.this.setEnabled(true);
                        m.dispose();
                    }
                });

                gameP.pause();
//System.exit(0);
            }
            if (key == 37) {
                if (gameP.x - 30 > -114) {
                    gameP.x -= 30;
                } else {
                    gameP.x = 886;
                }
            }
            if (key == KeyEvent.VK_ENTER) {
                okno ok = new okno();
                ok.setVisible(true);
            }
            if (key == 39) {
                if (gameP.x + 30 < 886) {
                    gameP.x += 30;
                } else {
                    gameP.x = -114;
                }
            }
        }

        public void keyReleased(KeyEvent e) {
        }

        public void keyTyped(KeyEvent e) {
        }
    }

    public okno() {
        //this.slogn = slogn;
        addKeyListener(new myKey());
        setFocusable(true);
        setBounds(0, 0, 1000, 600);
        setTitle("Игра: TwitchEmotes");
        gameP = new pole();
        Container cont = getContentPane();
        cont.add(gameP);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}