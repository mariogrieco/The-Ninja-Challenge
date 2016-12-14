package Windows;

import Entities.SaveData;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Esta clase coloca en pantalla con coordenadas relativas los objetos como el
 * indicador de la vida, los puntos el nombre de personje la cantidad de kunais
 * creacion manual de los componentes de la escena establece coordenadas y
 * rectangulos de interseccion
 *
 * @author: Mario Josue Grieco Villamizar Universidad Nacional Experimental del
 * Tachira
 * @version: 0.1
 */
public class GameView implements Screem {
    
    /**
     * panel donde se colocaras todos los elementos de la clase
     */
    public JPanel panel;
    /**
     * vida
     */
    public JLabel vida;
    /**
     * por medio de setSize se determina la barra de vida
     */
    public JLabel vidaState;
    /**
     * indicador de monedas
     */
    public JLabel monedas;
    /**
     * indicador de tiempo
     */
    public JLabel time;
    /**
     * indicador de puntos
     */
    public JLabel puntos;
    /**
     * texto del indicador de monedas
     */
    public JLabel monedasText;
    /**
     * texto del indicador de puntos
     */
    public JLabel timeText;
    /**
     * texto del indicador de tiempo
     */
    public JLabel timText;
    /**
     * indicador de las imagenes de la kunais que tiene el personaje
     */
    public JLabel kaniImgConteiner;
    /**
     * texto del indicador de kunaisindicador de monedas
     */
    public JLabel kaniText;
    /**
     * imagenes del contenedor del indicador de kunais
     */
    public ImageIcon kaniImg;

    public JLabel open;
    public JLabel close;

    /**
     * imagen del indicador Jlabel COMO image ICON
     */
    ImageIcon liveBackground;
    /**
     * imagen del indicador Jlabel monedas
     */
    ImageIcon forMonedas;
    /**
     * imagen del indicador Jlabel time
     */
    ImageIcon forTime;
    /**
     * imagen del indicador Jlabel estado de vida
     */
    ImageIcon forLibeState;
    /**
     * timer para la vida ( indicador)
     */
    public Timer animation = null;
        /**
     * timer para la vida ( indicador)
     */
    public Timer timing = null;
    /**
     * cantidad de kunais ( retorno del Personaje principal)
     */
    int kunakeLength = 3;
        /**
     * Cantidad de Segundos
     */
    int segundos = 0;
    /**
     * coordenadas relativas
     */
    int relative = 0;
    /**
     * No usado en esta version
     */
    public int live = 0;
    /**
     * Cantidad de vidas maximo 3
     */
    public int liveLength = 3;

    public JLabel liveLengthConteiner[];
    public ImageIcon liveLengthImg;

    public int acumLive = 0;

    public int objetivo = 0;
    public int acum = 0;

    int contador = 0;
    int contador2 = 0;
    int contador3 = 0; // para las vidas en pantalla
    public int barraState = 0;
    int livec = 0;

    public JLabel enemiLive;
    public int enemiAcumLive = 167;
    public SaveData saveOption;

    public int ContadorGastadas = 0;
    int lastLive = 0;

    int var = 0;
    /**
     * Constructor
     */
    public GameView() {

        try {
            forMonedas = new ImageIcon(ImageIO.read(new File("src/ingame/coin.png")));
            forTime = new ImageIcon(ImageIO.read(new File("src/ingame/timer.png")));
            liveBackground = new ImageIcon(ImageIO.read(new File("src/ingame/life.png")));
            forLibeState = new ImageIcon(ImageIO.read(new File("src/ingame/lifebar.png")));
            kaniImg = new ImageIcon(ImageIO.read(new File("src/ingame/Kunai35.png")));
            liveLengthImg = new ImageIcon(ImageIO.read(new File("src/ingame/life25.png")));
        } catch (IOException ex) {
            System.out.println("Windows.GameView.<init>() error main view");
        }

        liveLengthConteiner = new JLabel[3];

        liveLengthConteiner[0] = new JLabel();
        liveLengthConteiner[1] = new JLabel();
        liveLengthConteiner[2] = new JLabel();

        for (int i = 0; i < 3; i++) {
            liveLengthConteiner[i].setSize(liveLengthImg.getIconWidth(), liveLengthImg.getIconHeight());
            liveLengthConteiner[i].setLocation(((liveLengthImg.getIconWidth() * i) + 90), 30);
            liveLengthConteiner[i].setIcon(liveLengthImg);
            liveLengthConteiner[i].setFocusable(false);
            liveLengthConteiner[i].setVisible(false);
        }
        liveLengthConteiner[1].setLocation(liveLengthConteiner[1].getX() + 5, 30);
        liveLengthConteiner[2].setLocation(liveLengthConteiner[2].getX() + 10, 30);

        kaniImgConteiner = new JLabel();
        kaniText = new JLabel();;

        kaniImgConteiner.setIcon(kaniImg);
        kaniImgConteiner.setSize(100, 100);
        kaniImgConteiner.setLocation(150, 150);
        kaniImgConteiner.setVisible(true);

        setKani(0);
        kaniText.setSize(50, 50);
        kaniText.setLocation(165, 170);
        kaniText.setForeground(Color.WHITE);
        kaniText.setVisible(true);
        kaniText.setFont(new Font("tipe 2", Font.BOLD, 18));

        monedasText = new JLabel("0");
        timeText = new JLabel("00:00");
        timText = new JLabel("0");
        puntos = new JLabel("00000");

        panel = new JPanel();
        vida = new JLabel();
        vidaState = new JLabel();;
        monedas = new JLabel();
        time = new JLabel();

        puntos.setFocusable(false);
        puntos.setForeground(Color.WHITE);
        puntos.setSize(100, 50);
        puntos.setLocation(width - 200, 10);
        puntos.setFont(new Font("tipe 2", Font.BOLD, 24));
        puntos.setVisible(true);

        vida.setSize(liveBackground.getIconWidth(), liveBackground.getIconHeight());
        vida.setIcon(liveBackground);
        vida.setLocation(25, 40);
        vida.setVisible(true);

        vidaState.setIcon(forLibeState);
        vidaState.setLocation(87, 57);
        vidaState.setVisible(true);

        //vidaState.setSize(live,forLibeState.getIconHeight());    
        monedas.setSize(forMonedas.getIconWidth(), forMonedas.getIconHeight());
        monedas.setIcon(forMonedas);
        monedas.setLocation(25, liveBackground.getIconHeight() + 40 + 5);
        monedas.setVisible(true);

        monedasText.setSize(forMonedas.getIconWidth(), forMonedas.getIconHeight());
        monedasText.setForeground(new Color(245, 245, 245));
        monedasText.setLocation(100, liveBackground.getIconHeight() + 40 + 5);
        monedasText.setVisible(true);

        time.setIcon(forTime);
        time.setSize(forTime.getIconWidth(), forTime.getIconHeight());
        time.setLocation((width / 2) - (forTime.getIconWidth() / 2), 10);
        time.setVisible(true);

        segundos(0);
        timText.setForeground(Color.DARK_GRAY);
        timText.setLocation(time.getX() + (forTime.getIconWidth() / 2)-5, 5);
        timText.setSize(forTime.getIconWidth(), forTime.getIconHeight());
        timText.setVisible(true);
        timText.setFont(new Font("tipe 2", Font.BOLD, 24));
        
        panel.setSize(width, heigth - 10);
        panel.setBackground(new Color(12, 12, 12, 0));
        panel.setFocusable(false);
        panel.setLayout(null);

        //anemi live
        enemiLive = new JLabel("");
        enemiLive.setVisible(false);
        enemiLive.setSize(enemiAcumLive, 30);
        enemiLive.setIcon(forLibeState);
        enemiLive.setForeground(Color.red);

        //adds
        panel.setLocation(0, 0);
        panel.add(kaniText);
        panel.add(kaniImgConteiner);
        panel.add(liveLengthConteiner[0]);
        panel.add(liveLengthConteiner[1]);
        panel.add(liveLengthConteiner[2]);
        panel.add(puntos);
        panel.add(timText);
        panel.add(monedasText);
        panel.add(vidaState);
        panel.add(vida);
        panel.add(time);
        panel.add(monedas);
        panel.add(enemiLive);
        panel.setVisible(true);
//        liveLength = 0;
        live = 0;
        acumLive = 0;
        setLive(150 * 3);

        animation = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (acumLive <= objetivo && acumLive <= 150 * 3) {
                    if (livec >= 150) {
                        livec = 0;
                    } else {
                        livec += 1;
                    }
                    acumLive += 1;

                    vidaState.setSize(livec, forLibeState.getIconHeight());
                    panel.repaint();
                    barraState = livec;
                } else {
//                    animation.stop();
                }
                determineLive();

            }

        });
        animation.start();

        determineLive();
    }

    /**
     * deja deAGREGAr VIDA A LA BARRA y quita vida de ella determina cuando
     * bajar las vidas
     *
     * @param x entero cantidad de vida a quitar por ml
     */
    public void setLive2(int x) {
        animation.stop();
        if (acumLive - x > 0) {
            //        determineLive();

            acumLive -= x;
//            livec -= x; // agregado!
            if (barraState - x <= 0 && liveLength - 1 > 1) {  // tenia <= a 0
                liveLength--;
                barraState = 150;
            } else if (barraState - x <= 0 && liveLength - 1 == 1) {
                liveLength--;
                barraState = acumLive;
            } else {
                barraState -= x;
            }
        } else {
            barraState = 0;
            acumLive = 0;

        }
        determineLive();
        vidaState.setSize(barraState, forLibeState.getIconHeight());
        livec = barraState;

    }

    /**
     * AGREGA VIDA A LA BARRA
     *
     * @param length entero cantidad de vida a agregar
     */
    public void setLive(int length) {

        objetivo = acumLive + length;
        System.out.println("obj " + objetivo + " acom " + acumLive + " leng " + length);
        if (animation != null) {
            animation.stop();
            animation.restart();

        }
    }

    /**
     * AGREGA VIDA A LA BARRA del enemigo
     *
     * @param x entero cantidad de vida a agregar
     */
    public void setEnemiLive(int x) {
        if (enemiAcumLive - x > 0) {
            enemiAcumLive -= x;
        } else {
            enemiAcumLive = 0;
        }
        enemiLive.setSize(enemiAcumLive, 30);
    }

    /**
     * agrega puntos a la barra de puntos
     *
     * @param a entero cantidad de puntos a agregar
     */

    public void setPoints2(int a) {
        int b = Integer.parseInt(puntos.getText());
        int c = a;
        int result = b + c;
        String r = Integer.toString(result);
        puntos.setVisible(false);
        puntos.setText(r);
        puntos.setVisible(true);
    }

    /**
     * agrega puntos a la barra de puntos
     *
     * @param a entero cantidad de puntos a agregar
     */
    public void setPoints(int a) {
        int b = Integer.parseInt(monedasText.getText());
        int c = a;
        int result = b + c;
        String r = Integer.toString(result);
        monedasText.setVisible(false);
        monedasText.setText(r);
        monedasText.setVisible(true);
    }

    /**
     * agrega kunais a la barra de kunais
     *
     * @param i entero cantidad de puntos a agregar
     */

    public void setKani(int i) {
        if (kunakeLength - i >= 0) {
            kunakeLength -= i;
            kaniText.setVisible(false);
            kaniText.setText("x" + Integer.toString(kunakeLength));
            kaniText.setVisible(true);
        }
        ContadorGastadas++;
    }

    /**
     * agrega kunais a la barra de kunais
     *
     * @param i entero cantidad de puntos a agregar
     */
    public void addKunai(int i) {
        kunakeLength += i;
//         kaniText.setVisible(false);
        kaniText.setText("x" + Integer.toString(kunakeLength));
//         kaniText.setVisible(true);
    }

    /**
     * Determina las coordenadas relativa del panel ( no se usa setVisible por
     * la transicion animada(
     *
     * @param x entero cantidad de puntos a agregar
     */
    public void setRelative(int x) {
        relative += x;
        panel.setLocation(relative, 0);
    }

    /**
     * Determina las vidas restantes dependiendo de cuanto baja la vida
     * @return w la cantidad de vidas
     */
    public int determineLive() {
        int w = 0;

        if (acumLive <= 0) {
            liveLength = 0;
            w = 0;
            liveLengthConteiner[0].setVisible(false);
            liveLengthConteiner[2].setVisible(false);
            liveLengthConteiner[1].setVisible(false);

        }
        if (acumLive > 0 && acumLive <= 150) {
            liveLength = 1;
            w = 1;
            liveLengthConteiner[0].setVisible(true);
            liveLengthConteiner[2].setVisible(false);
            liveLengthConteiner[1].setVisible(false);
        }
        if (acumLive > 150 && acumLive <= 150 * 2) {
            liveLength = 2;
            w = 2;
            liveLengthConteiner[0].setVisible(true);
            liveLengthConteiner[1].setVisible(true);
            liveLengthConteiner[2].setVisible(false);
        }
        if (acumLive > 150 * 2) {
            liveLength = 3;
            w = 3;
            liveLengthConteiner[0].setVisible(true);
            liveLengthConteiner[1].setVisible(true);
            liveLengthConteiner[2].setVisible(true);
        }
        return w;

    }

    /**
     * agrega segundos
     *
     * @param segundos entero segundoa agregar
     */
    void segundos(int segundos) {
        timText.setText(segundos + "");
        if (segundos > 9 && segundos < 100 && var == 0) {
            timText.setLocation(timText.getX() - 5, timText.getY());
            var++;
        }
        if (segundos > 99 && segundos < 1000 && var == 1) {
            timText.setLocation(timText.getX() - 5, timText.getY());
            var++;
        }
        if (segundos > 999 && segundos < 10000 && var == 2) {
            timText.setLocation(timText.getX() - 5, timText.getY());
            var++;
        }

    }
}
