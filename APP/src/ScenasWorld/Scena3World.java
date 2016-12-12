/**
 * Esta clase es el scena world de la scena numero 3
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
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Scena3World implements Screem {

    /**
     * Arreglos de las imagenes que se usaran en la scena
     */
    public Image fondo[];
    /**
     * Coordenadas x y, ancho y alto de cada una de las imagenes
     */
    public int border[][];
    /**
     * la ultima version no lo usa
     */
    public int lianaFea[];
    /**
     * la ultima version no lo usa
     */
    public Image madera;
    /**
     * la ultima version no lo usa
     */
    public int retorno[];

    /**
     * coordenada x1 de la liana
     */
    public int x;
    /**
     * coordenada x2 de la liana
     */
    public int y;
    /**
     * coordenada y1 de la liana
     */
    public int w;
    /**
     * coordenada y2 de la liana
     */
    public int h;

    /**
     * contador reservado para la linana y su animacion
     */
    public int contadorLiana = 1;
    /**
     * detemina la orientacion de la liana reservado para la linana y su
     * animacion
     */
    public int lianaOrientation = -1;
    /**
     * Determina si la liana sube o baja
     */
    public boolean lianasSubiendo = false;
    /**
     * Cada escena tendra unas coordenadas relativas y sus componentes tambien
     * para permitir la transicion
     */
    public int relativeCoord = 0;

    /**
     * Constructor de la scena 3
     */
    public Scena3World() {
        fondo = new Image[3];
        border = new int[3][4];
        retorno = new int[4];

        lianaOrientation = 1;
        w = (width / 2) - 50;
        h = 50;

        x = (width / 4) + relativeCoord;
        y = (heigth / 2) + 50;
        try {
            fondo[0] = ImageIO.read(new File("src/level1/s3/Fondo/1.jpg"));
            border[0][0] = 0;
            border[0][1] = 0;
            border[0][2] = width;
            border[0][3] = heigth;

            fondo[1] = ImageIO.read(new File("src/level1/s3/Fondo/2.jpg"));
            border[1][2] = width;
            border[1][3] = 181;

            border[1][0] = 0;
            border[1][1] = heigth - 181;
            
            fondo[2] = ImageIO.read(new File("src/level1/s3/Fondo/3.png"));
            border[2][0] = (width / 2) - (width / 4);
            border[2][1] = heigth - 186;
            border[2][2] = (width / 2);
            border[2][3] = 186;

            retorno[0] = (width / 2) + (width / 2) - (width / 4);
            retorno[1] = heigth - 186;
            retorno[2] = width;
            retorno[3] = 186;

        } catch (IOException err) {
            System.out.println("ScenasWorld.Scena3World.<init>()");
        }
         System.out.println("ScenasWorld.Scena3World.<load correct>()");
        
    }
   

    /**
     * retorna cada Rectangulo que se pide
     *
     * @param x numero del rectangulo ( imagen de fondo o objeto)
     * @return Rectangle2D.Double
     */

    public Rectangle2D getRectangle(int x) {
        if (x == 9) {
            return new Rectangle2D.Double((border[2][0]) + 50, border[2][1], border[2][2] - 100, border[2][3]);
        }
        return new Rectangle2D.Double(border[x][0], border[x][1], border[x][2], border[x][3]);
    }

    /**
     * retorna la interseccion unicamente de la linana
     * @return   Rectangle2D.Double
     */
    public Rectangle2D lianaRect() {
        return new Rectangle2D.Double(x - 20, (heigth / 2) + 50, 50, 10);
    }

    /**
     * no usado en esta version
     * @return Rectangle2D.Double
     */

    public Rectangle2D getRetorno() {
        return new Rectangle2D.Double(retorno[0], retorno[1], retorno[2], retorno[3]);
    }

    /**
     * Establece las coordenadas relativas
     *
     * @param x determina las coordenadas relativas
     */
    public void SetRelativeObjects(int x) {
        relativeCoord += x;

        for (int i = 0; i < 3; i++) {
            border[i][0] += relativeCoord;
        }
        retorno[0] += relativeCoord;
        this.x += relativeCoord;
        w += relativeCoord;

    }
}
