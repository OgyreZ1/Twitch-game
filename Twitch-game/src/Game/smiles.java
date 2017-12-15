package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class smiles {
    public BufferedImage smiles;
    public int x, y;
    public Boolean act;
    public Timer timerUpdate;

    public smiles(BufferedImage smile) {
        timerUpdate = new Timer(150, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vniz();
            }
        });
        this.smiles = smile;
        act = false;
    }

    public void start() {
        timerUpdate.start();
        y = 0;
        x = (int) (Math.random() * 772);
        act = true;
    }

    public void vniz() {
        if (act == true) {
            y += 10;
        }
        if ((y ) >= 400) {
            timerUpdate.stop();
        }
    }

    public void draw(Graphics gr) {
        if (act == true) {
            gr.drawImage(smiles, x, y, 112, 112, null);
        }
    }
}

