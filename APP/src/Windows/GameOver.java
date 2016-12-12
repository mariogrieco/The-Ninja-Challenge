package Windows;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Esta clase es la encargada de mostrar el panel de game over en el
 * LevelController creacion manual de los componentes de la escena
 *
 * @author: Mario Josue Grieco Villamizar Universidad Nacional Experimental del
 * Tachira
 * @version: 0.1
 */

public class GameOver implements Screem {

    /**
     * panel donde se colocaras todos los elementos de la clase
     */
    public JPanel panel;
    /**
     * Esta imagen tendra la letras del game over
     */

    public JLabel imgConteiner;
    /**
     * usada por imgConteinar para colocar las imagenes
     */
    public ImageIcon img;

    /**
     * boton para salir
     */
    JLabel salirBTN;
    /**
     * boton de reinicio
     */
    JLabel reiniciarBTN;

    /**
     * el boton de salir tiene 2 estados por lo tanto tiene 2 imagenes
     */
    ImageIcon salir[];
    /**
     * el boton de reiniciar tiene 2 estados por lo tanto tiene 2 imagenes
     */
    ImageIcon reiniciar[];

    /**
     * se necesitan algunos estados de levelcontroller
     */
    public LevelsController controller;

    //public Image img;
    /**
     * constructor
     */
    public GameOver() {

        //btns
        salirBTN = new JLabel();
        reiniciarBTN = new JLabel();
        salir = new ImageIcon[2];
        reiniciar = new ImageIcon[2];

        try {
            salir[0] = new ImageIcon(ImageIO.read(new File("src/OverMenu/S1.png")));
            salir[1] = new ImageIcon(ImageIO.read(new File("src/OverMenu/S1.png")));
            reiniciar[0] = new ImageIcon(ImageIO.read(new File("src/OverMenu/R1.png")));
            reiniciar[1] = new ImageIcon(ImageIO.read(new File("src/OverMenu/R2.png")));

        } catch (IOException err) {
            System.out.println("Windows.GameOver.<init>()");
        }

        salirBTN.setSize(salir[0].getIconWidth(), salir[0].getIconWidth());
        salirBTN.setLocation(width / 3, heigth - 200);
        salirBTN.setName("s");
        salirBTN.setIcon(salir[0]);
        salirBTN.setFocusable(false);
        salirBTN.addMouseListener(new ActionsBtns());
        salirBTN.setVisible(true);

        reiniciarBTN.setSize(reiniciar[0].getIconWidth(), reiniciar[0].getIconWidth());
        reiniciarBTN.setLocation((width / 3) + reiniciar[0].getIconWidth() + 50, heigth - 200);
        reiniciarBTN.setIcon(reiniciar[0]);
        reiniciarBTN.addMouseListener(new ActionsBtns());
        reiniciarBTN.setName("r");
        reiniciarBTN.setFocusable(false);
        reiniciarBTN.setVisible(true);

        // Gamer Over red text
        panel = new JPanel();
        imgConteiner = new JLabel();

        try {   
            img = new ImageIcon(ImageIO.read(new File("src/Pausa/gameover.png")));
        } catch (IOException err) {
            System.out.println("Windows.GameOver.<init>()");
        }

        imgConteiner.setSize(img.getIconWidth(), img.getIconHeight());
        imgConteiner.setIcon(img);
        imgConteiner.setLocation(20, 0);
        imgConteiner.setFocusable(false);
        imgConteiner.setVisible(true);

        panel.setSize(width, heigth);
        panel.setLayout(null);
        panel.setBackground(new Color(12, 12, 12, 0));
        panel.add(imgConteiner);
        panel.add(salirBTN);
        panel.add(reiniciarBTN);
        panel.setVisible(false);

    }

    /**
     * clase aninima actions
     */
    class ActionsBtns implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getComponent().getName().equals("r")) {
                controller.viewLabel.enemiLive.setVisible(false);
                
                controller.sceneNumber = 1;
                controller.lastEscene = 1;
                controller.refreshEscene(1);
                controller.setInitLevel(1);
                controller.setInit(1);
                
            }
            if (e.getComponent().getName().equals("s")) {
                System.exit(0);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

}
