package Game;

import javax.swing.*;
import javax.imageio.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.event.*;

public class pole extends JPanel {
    private BufferedImage fon;
    private BufferedImage kappa;
    private BufferedImage Icon;
    public int x = 400;
    private int slogn = 1;
    private smiles[] gameSmiles;
    private smiles[] gameBadSmiles;
    private BufferedImage end;
    public Timer timerDraw, timerUpdate;
    public int points = 0;

    public pole() {
        this.slogn = slogn;

        try {
            kappa = ImageIO.read(new File("Images//Box2.png"));
        } catch (IOException ex) {
            System.out.println("ошибка с kappa");
        }
        try {
            fon = ImageIO.read(new File("Images//bg.jpg"));
        } catch (IOException ex) {
            System.out.println("ошибка с bg");
        }
        try {
            Icon = ImageIO.read(new File("Images//TwitchIcon.png"));
        } catch (IOException ex) {
            System.out.println("ошибка с TwitchIcon");
        }
        try {
            end = ImageIO.read(new File("Images//loser.png"));
        } catch (IOException ex) {
            System.out.println("ошибка с loser");
        }

        gameBadSmiles = new smiles[7];
        for (int i = 0; i < 7; i++) {
            try {
                gameBadSmiles[i] = new smiles(ImageIO.read(new File("Images//b" + i + ".png")));
            } catch (IOException ex) {
                System.out.println("ошибка с b");
            }}
            gameSmiles = new smiles[7];
            for (int j = 0; j < 7; j++) {
                try {
                    gameSmiles[j] = new smiles(ImageIO.read(new File("Images//s" + j + ".png")));
                } catch (IOException ex) {
                    System.out.println("ошибка с смайлами");
                }


            }
            timerUpdate = new Timer(1000, new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    updateStart();
                }
            });
            timerUpdate.start();

            timerDraw = new Timer(50, new ActionListener() {

                public void actionPerformed(ActionEvent e) {

                    repaint();
                }
            });
            timerDraw.start();

    }

    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        gr.drawImage(fon, 0, 0, null);
        gr.drawImage(kappa, x, 375, 228, 190, null);
        gr.drawImage(Icon, 650, 50, 100, 100, null);
        for (int i = 0; i < 7; i++) {

            gameSmiles[i].draw(gr);
            if (gameSmiles[i].act)
                if (gameSmiles[i].y >= 400) {
                    if (Math.abs(gameSmiles[i].x - (x + 120)) > 75) {
                        gr.drawImage(end, 300, 200, 300, 200, null);
                        timerDraw.stop();
                        timerUpdate.stop();
                        break;
                    } else {
                        points++;
                        gameSmiles[i].act = false;
                        if (points % 3 == 0)
                            slogn++;
                    }
                }
             for (int j = 0; j < 7; j++) {

                }gameBadSmiles[i].draw(gr);
            if (gameBadSmiles[i].act)
                if (gameBadSmiles[i].y >= 400) {
                    if (Math.abs(gameBadSmiles[i].x - (x+120)) < 75) {
                        gr.drawImage(end, 300, 200, 300, 200, null);
                        timerDraw.stop();
                        timerUpdate.stop();
                        break;
                    } else {
                        gameBadSmiles[i].act = false;

                    }

                }
            }
            gr.setFont(new Font("Century", 0, 40));
            gr.setColor(Color.red);
            gr.drawString("Score: " + points, 100, 100);
        }

    private void updateStart() {
        int kol = 0;
        for (int i = 0; i < 7; i++) {
            if (!gameSmiles[i].act) {
                if (kol < slogn) {
                    gameSmiles[i].start();
                    break;
                }
            } else {
                kol++;
            }
        }for (int i = 0; i < 7; i++) {
            if (!gameBadSmiles[i].act) {
                if (kol < slogn) {
                    gameBadSmiles[i].start();
                    break;
                }
            } else {
                kol++;
            }
        }

    }

    public void pause() {
        timerDraw.stop();
        timerUpdate.stop();
        for (int i = 0; i < 7; i++) {
            gameSmiles[i].timerUpdate.stop();
            gameBadSmiles[i].timerUpdate.stop();
        }
    }

    public void unpause() {
        timerDraw.start();
        timerUpdate.start();
        for (int i = 0; i < 7; i++) {
            gameSmiles[i].timerUpdate.start();
            gameBadSmiles[i].timerUpdate.start();
        }
    }

    public void renew() {
        for (int i = 0; i < 7; i++) {
            try {
                gameSmiles[i] = new smiles(ImageIO.read(new File("Images//s" + i + ".png")));
            } catch (IOException ex) {
                System.out.println("ошибка с смайлами");
            }
        }
        for (int i = 0; i < 7; i++) {
            try {
                gameBadSmiles[i] = new smiles(ImageIO.read(new File("Images//b" + i + ".png")));
            } catch (IOException ex) {
                System.out.println("ошибка с смайлами");
            }
        }
        points = 0;
        slogn = 1;
    }

}
