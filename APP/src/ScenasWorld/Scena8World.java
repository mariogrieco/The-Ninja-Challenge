/**
 * Esta clase es el scena world de la scena numero 8
 * creacion manual de los componentes de la escena
 * establece coordenadas y rectangulos de interseccion
 * implements ActionListener
 *
 * @author: Mario Josue Grieco Villamizar Universidad Nacional Experimental del
 * Tachira
 * @version: 0.1
 */
package ScenasWorld;

import Windows.Screem;
import static Windows.Screem.heigth;
import static Windows.Screem.width;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 *
 * COMO EN LOS ENGINES TODO LA CONSTRUCCION DEL MUNDO ES MANUAL OBJETO POR
 * OBJETO NADA DINAMICO
 * Esta clase es el scena world de la scena numero 8
 * creacion manual de los componentes de la escena
 * establece coordenadas y rectangulos de interseccion
 * implements ActionListener
 */
public class Scena8World implements Screem {

    /**
     * Arreglos de las imagenes que se usaran en la scena
     */
    public Image fondo[];
    /**
     * Coordenadas relativas de la escena y sus componentes en el mapa
     */
    public int border[][];
    /**
     * Coordenadas relativas de la escena y sus componentes en el mapa
     */
    public int relativeCoord = 0;
    /**
     * Mustra en pantalla el tiempototal
     */
    public JLabel tiempoTotal;
    /**
     * muestra en pantalla la vida restante
     */
    public JLabel vidaRestante;
    /**
     * muestra en pantalla los puntos restantes
     */
    public JLabel puntos;
    /**
     * muestra en pantalla las kunais gastadas
     */
    public JLabel KunaisUsadas;
    /**
     * muestra en pantalla los top 10
     */
    public JLabel[] top10;

     /**
     * inicialliza los jlabel
     */
    public void init() {

        tiempoTotal = new JLabel("90s");
        vidaRestante = new JLabel("900 puntos de vida");
        puntos = new JLabel("900 puntos");
        KunaisUsadas = new JLabel("12 kunais gastadas");
        top10 = new JLabel[11];

        for (int i = 0; i < 11; i++) {
            if (i == 10) {
                top10[i] = new JLabel("TOP 10");
                top10[i].setSize(100, 100);
                top10[i].setLocation(width / 2 + 100, heigth - 380 - i * 25);
                top10[i].setFont(new Font("tipe 2", Font.BOLD, 24));
            } else {
                top10[i] = new JLabel("123123");
                top10[i].setSize(100, 100);
                top10[i].setLocation(width / 2 + 100, heigth - 380 - i * 25);
            }
        }

        tiempoTotal.setSize(300, 100);
        vidaRestante.setSize(300, 100);
        puntos.setSize(300, 100);
        KunaisUsadas.setSize(300, 100);

        tiempoTotal.setLocation(width / 3 - 100, (heigth / 2) - 150);
        vidaRestante.setLocation(width / 3 - 100, (heigth / 2) - 200);
        puntos.setLocation(width / 3 - 100, (heigth / 2) - 250);
        KunaisUsadas.setLocation(width / 3 - 100, (heigth / 2) - 300);

        tiempoTotal.setFont(new Font("tipe 2", Font.BOLD, 24));
        vidaRestante.setFont(new Font("tipe 2", Font.BOLD, 24));
        puntos.setFont(new Font("tipe 2", Font.BOLD, 24));
        KunaisUsadas.setFont(new Font("tipe 2", Font.BOLD, 24));

        tiempoTotal.setFocusable(false);
        vidaRestante.setFocusable(false);
        puntos.setFocusable(false);
        KunaisUsadas.setFocusable(false);

        tiempoTotal.setForeground(Color.DARK_GRAY);
        vidaRestante.setForeground(Color.DARK_GRAY);
        puntos.setForeground(Color.DARK_GRAY);
        KunaisUsadas.setForeground(Color.DARK_GRAY);

    }
    
     /**
     * inicialliza la escena
     */

    public Scena8World() {

        init();
        fondo = new Image[3];
        border = new int[2][4];

        try {
            fondo[0] = ImageIO.read(new File("src/level2/s4/Fondo/1.jpg"));
            border[0][0] = 0;
            border[0][1] = 0;
            border[0][2] = width;
            border[0][3] = heigth;

            fondo[1] = ImageIO.read(new File("src/level2/s4/Fondo/2.png"));
            border[1][0] = 0;
            border[1][1] = heigth - 210;
            border[1][2] = width;
            border[1][3] = 210;

        } catch (IOException err) {
            System.out.println("ScenasWorld.Scena3World.<init>()");
        }
    }
    /**
     * retorna cada Rectangulo que se pide
     *
     * @param x numero del rectangulo ( imagen de fondo o objeto)
     * @return Rectangle2D.Double
     */
    public Rectangle2D getRectangle(int x) {

        if (x == 1) {
            return new Rectangle2D.Double(border[x][0], border[x][1] + 20, border[x][2], border[x][3] - 20);
        }
        return new Rectangle2D.Double(border[x][0], border[x][1], border[x][2], border[x][3]);
    }

        /**
     * Establece las coordenadas relativas
     *
     * @param x determina las coordenadas relativas
     */
    public void SetRelativeObjects(int x) {
        relativeCoord += x;

        for (int i = 0; i < 2; i++) {
            border[i][0] += relativeCoord;
        }

    }
}
