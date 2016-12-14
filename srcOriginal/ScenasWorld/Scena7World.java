/**
 * Esta clase es el scena world de la scena numero 7
 * creacion manual de los componentes de la escena
 * establece coordenadas y rectangulos de interseccion
 * implements ActionListener
 *
 * @author: Mario Josue Grieco Villamizar Universidad Nacional Experimental del
 * Tachira
 * @version: 0.1
 */
package ScenasWorld;

import Entities.PersonajeEnemi;
import Windows.Screem;
import static Windows.Screem.heigth;
import static Windows.Screem.width;
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
 * Esta clase es el scena world de la scena numero 7
 * creacion manual de los componentes de la escena
 * establece coordenadas y rectangulos de interseccion
 * implements ActionListener
 */
public class Scena7World implements Screem {

    /**
     * Arreglos de las imagenes que se usaran en la scena
     */
    public Image fondo[];
    /**
     * Coordenadas x y, ancho y alto de cada una de las imagenes
     */
    public int border[][];
    /**
     * Coordenadas relativas de la escena y sus componentes en el mapa
     */
    public int relativeCoord = 0;
    /**
     * el boss del mapa
     *
     * @see Entities.Personaje
     */
    public PersonajeEnemi enemi;

    public Scena7World() {

        enemi = new PersonajeEnemi(0, 0, 500 / 3, 500 / 3);
        fondo = new Image[3];
        border = new int[2][4];

        try {
            fondo[0] = ImageIO.read(new File("src/level2/s3/Fondo/1.png"));
            border[0][0] = 0;
            border[0][1] = 0;
            border[0][2] = width;
            border[0][3] = heigth;

            fondo[1] = ImageIO.read(new File("src/level2/s3/Fondo/2.png"));
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
