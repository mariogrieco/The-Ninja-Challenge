/**
 * Esta clase es el scena world de la scena numero 4
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
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * COMO EN LOS ENGINES TODO LA CONSTRUCCION DEL MUNDO ES MANUAL OBJETO POR
 * OBJETO NADA DINAMICO
 * Esta clase es el scena world de la scena numero 4
 * creacion manual de los componentes de la escena
 * establece coordenadas y rectangulos de interseccion
 * implements ActionListener
 */

public class Scena4World implements Screem {

    /**
     * Arreglos de las imagenes que se usaran en la scena
     */
    public Image fondo[];
    /**
     * Coordenadas x y, ancho y alto de cada una de las imagenes
     */
    public int border[][];
    /**
     * Collecion de imagenes del cocodrilo
     */
    public Image alligator[];
    /**
     * El estado del cocodrilo ( cual imagen se mostrara)
     */
    public int alligatorState = 0;

    /**
     * Coordenadas relativas de la escena y sus componentes en el mapa
     */
    public int relativeCoord = 0;
    /**
     * orientacion de cocodrino normalmente es 1 derecaha -1 izquierda esta esta
     * invertida
     */
    public int cocodriloOrientation = 1; // esta invertida 

    /**
     * constructor
     */
    public Scena4World() {

        fondo = new Image[3];
        alligator = new Image[9];
        border = new int[4][4];

        try {
            fondo[0] = ImageIO.read(new File("src/level1/s4/Fondo/1.jpg"));
            border[0][0] = 0;
            border[0][1] = 0;
            border[0][2] = width;
            border[0][3] = heigth;

            fondo[1] = ImageIO.read(new File("src/level1/s4/Fondo/2.jpg"));
            border[1][0] = 0;
            border[1][1] = heigth - 181;
            border[1][2] = width;
            border[1][3] = 181;

            fondo[2] = ImageIO.read(new File("src/level1/s4/Fondo/3.png"));
            border[2][0] = (width / 2) - (width / 4);
            border[2][1] = heigth - 186;
            border[2][2] = (width / 2);
            border[2][3] = 186;

            alligator[0] = ImageIO.read(new File("src/level1/s4/Fondo/alligator0.png"));
            alligator[1] = ImageIO.read(new File("src/level1/s4/Fondo/alligator1.png"));
            alligator[2] = ImageIO.read(new File("src/level1/s4/Fondo/alligator2.png"));
            alligator[3] = ImageIO.read(new File("src/level1/s4/Fondo/alligator3.png"));
            alligator[4] = ImageIO.read(new File("src/level1/s4/Fondo/alligator4.png"));
            alligator[5] = ImageIO.read(new File("src/level1/s4/Fondo/alligator5.png"));
            alligator[6] = ImageIO.read(new File("src/level1/s4/Fondo/alligator6.png"));

            border[3][0] = (width / 2) - 150;
            border[3][1] = heigth - 320;
            border[3][2] = 260;
            border[3][3] = 220;

        } catch (IOException err) {
            System.out.println("ScenasWorld.Scena3World.<init>()");
        }
         System.out.println("ScenasWorld.Scena4World.<load correct>()");
    }

    /**
     * retorna cada Rectangulo que se pide
     *
     * @param x numero del rectangulo ( imagen de fondo o objeto)
     * @return Rectangle2D.Double
     */
    public Rectangle2D getRectangle(int x) {
        if (x == 9) {
            return new Rectangle2D.Double((border[2][0] + 50), border[2][1] + 6, border[2][2] - 100, border[2][3]);
        }
        if (x == 3) {
            return new Rectangle2D.Double(border[x][0] + 70, border[x][1] + 133, border[x][2] - 140, border[x][3] - 100);
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

        for (int i = 0; i < 4; i++) {
            border[i][0] += relativeCoord;
        }

    }
}
