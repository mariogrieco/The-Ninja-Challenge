/**
 * Esta clase es el scena world de la scena numero 2
 * creacion manual de los componentes de la escena
 * establece coordenadas y rectangulos de interseccion
 * implements ActionListener
 *
 * @author: Mario Josue Grieco Villamizar Universidad Nacional Experimental del
 * Tachira
 * @version: 0.1
 */

package ScenasWorld;

import Entities.Items;
import Entities.PersonajeEnemi;
import Windows.Screem;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * COMO EN LOS ENGINES TODO LA CONSTRUCCION DEL MUNDO ES MANUAL OBJETO POR
 * OBJETO NADA DINAMICO
 * Esta clase es el scena world de la scena numero 2
 * creacion manual de los componentes de la escena
 * establece coordenadas y rectangulos de interseccion
 * implements ActionListener
 */
public class Scena2World implements Screem {

    /**
     * Arreglos de las imagenes que se usaran en la scena
     */
    public Image fondo[];
    /**
     * Personaje maluco
     *
     * @see Entities.Personaje
     */
    public PersonajeEnemi maluco;
    /**
     * Coordenadas x y, ancho y alto de cada una de las imagenes
     */
    public int border[][];
    /**
     * Arreglos de coins del mundo
     *
     * @see Entities.Items PARA MAS
     */
    public Items coins[];

    /**
     * Kunai
     *
     * @see Entities.Items PARA MAS
     */
    public Items Kunai;

    /**
     * Vida del mundo
     *
     * @see Entities.Items PARA MAS
     */
    public Items life;
    /**
     * Cada escena tendra unas coordenadas relativas y sus componentes tambien
     * para permitir la transicion
     */
    public int relativeCoord = 0;

        /**
     * Constructor de la escena
     */
    public Scena2World() {

        maluco = new PersonajeEnemi(((width / 2)), (heigth / 2) - 240, (500 / 3), (500 / 3));
        maluco.orientation = -1;

        int bajandoBdorder[];
        coins = new Items[3];
        life = new Items(250, heigth - 250, 80, 80);
        life.visible = false;
        life.IMG = new Image[1];
        Kunai = new Items(100, heigth - 150, 11, 56);
        Kunai.visible = false;
        Kunai.IMG = new Image[1];
        try {
            Kunai.IMG[0] = ImageIO.read(new File("src/pickups/kunai35.png"));
        } catch (IOException err) {
            System.out.println("ScenasWorld.Scena1World.<init>()");
        }

        try {
            life.IMG[0] = ImageIO.read(new File("src/pickups/4.png"));
        } catch (IOException err) {
            System.out.println("ScenasWorld.Scena1World.<init>()");
        }

        for (int i = 0; i < 3; i++) {
            coins[i] = new Items(-10, -180, 84 / 2, 84 / 2);
            if (i == 0) {
                coins[i].visible = true;
                coins[i] = new Items(700, (heigth / 2) - 180, 84 / 2, 84 / 2);
            } else {
                coins[i].visible = false;
            }
            coins[i].IMG = new Image[4];
            coins[i].state = 0;
            try {
                coins[i].IMG[0] = ImageIO.read(new File("src/pickups/gold_1.png"));
                coins[i].IMG[1] = ImageIO.read(new File("src/pickups/gold_2.png"));
                coins[i].IMG[2] = ImageIO.read(new File("src/pickups/gold_3.png"));
                coins[i].IMG[3] = ImageIO.read(new File("src/pickups/gold_4.png"));

            } catch (IOException ex) {
                System.out.println("ScenasWorld.Scena2World.<init>()");
            }
        }

        fondo = new Image[4];
        border = new int[4][4];
        try {
            fondo[0] = ImageIO.read(new File("src/level1/s2/Fondo/1.jpg"));
            border[0][0] = 0;
            border[0][1] = 0;
            border[0][2] = width;
            border[0][3] = heigth;

            fondo[1] = ImageIO.read(new File("src/level1/s2/Fondo/2.jpg"));
            border[1][2] = width;
            border[1][3] = 181;

            border[1][0] = 0;
            border[1][1] = heigth - 181;

            fondo[2] = ImageIO.read(new File("src/level1/s2/Fondo/3.png"));
            border[2][0] = ((width / 2) + 10);
            border[2][1] = heigth - 150 - 300;
            border[2][2] = 380;
            border[2][3] = 94;

            fondo[3] = ImageIO.read(new File("src/level1/s2/Fondo/4.png"));
            border[3][0] = ((width / 2) + 90);
            border[3][1] = heigth - 450;
            border[3][2] = 75;
            border[3][3] = 270;
        } catch (IOException err) {
            System.out.println("ScenasWorld.Scena2World.<init>()");
        }
         System.out.println("ScenasWorld.Scena2World.<load correct>()");
    }
//    version antigua
//    public Rectangle2D getRectangle(int x) {
//        if ( x == 3) {
//            return new Rectangle2D.Double(border[3][0]+30, border[3][1], 5, border[3][3]);
//        }
//         if ( x == 4 ) {
//            return new Rectangle2D.Double(border[3][0]-40, border[3][1]-190, 200,200);
//        }
//         if ( x == 2) {
//            return new Rectangle2D.Double(border[2][0], border[2][1]-80, border[2][2],border[2][3]+100);
//        }
//        return new Rectangle2D.Double(border[x][0], border[x][1], border[x][2], border[x][3]);
//    }

        /**
     * retorna cada Rectangulo que se pide
     *
     * @param x numero del rectangulo ( imagen de fondo o objeto)
     * @return  Rectangle2D.Double();
     */
    public Rectangle2D getRectangle(int x) {
        if (x == 20) {
            return new Rectangle2D.Double(border[3][0] - 10, border[3][1] - 50, 90, 150);
        }
        if (x == 3) {
            return new Rectangle2D.Double(border[3][0] + 20, border[3][1], 30, border[3][3]);
        }
        if (x == 4) {
            return new Rectangle2D.Double(border[3][0] - 50, border[3][1] - 200, 200, 200);
        }
        if (x == 2) {
            return new Rectangle2D.Double(border[2][0] + 30, border[2][1] - 80, border[2][2] - 100, border[2][3] + 100);
        }
        if (x == 9) {
            return new Rectangle2D.Double(border[3][0] + 25, border[3][1] - 190, 20, border[3][3] - 200);
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

        maluco.x += relativeCoord;
        for (int i = 0; i < 3; i++) {
            coins[i].x += relativeCoord;
        }

        life.x += relativeCoord;
        Kunai.x += relativeCoord;
        for (int i = 0; i < 4; i++) {
            border[i][0] += relativeCoord;
        }
    }
}
