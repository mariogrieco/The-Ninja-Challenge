/**
 * Esta clase es el scena world de la scena numero 1
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
import Entities.Personaje;
import Windows.Screem;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * COMO EN LOS ENGINES TODO LA CONSTRUCCION DEL MUNDO ES MANUAL OBJETO POR
 * OBJETO NADA DINAMICO
 * Esta clase es el scena world de la scena numero 1
 * creacion manual de los componentes de la escena
 * establece coordenadas y rectangulos de interseccion
 * implements ActionListener
 */
public class Scena1World implements Screem {

    /**
     * Arreglos de las imagenes que se usaran en la scena
     */
    public Image fondo[];
    /**
     * Coordenadas x y, ancho y alto de cada una de las imagenes
     */
    public int border[][];
    /**
     * Items del mundo
     *
     * @see Entities.Items PARA MAS
     */
    public Items bolaMaluca;
    /**
     * Arreglos de coins del mundo
     *
     * @see Entities.Items PARA MAS
     */
    public Items Coins[];
    /**
     * vida del mundo
     *
     * @see Entities.Items PARA MAS
     */
    public Items vida;

    /**
     * Contador reservado para la cierra
     *
     * @see Entities.Items PARA MAS
     */
    public int cierra = 1;

    /**
     * Cada escena tendra unas coordenadas relativas y sus componentes tambien
     * para permitir la transicion
     */
    public int relativeCoord = 0;

    /**
     * Constructor de la escena
     */
    public Scena1World() {

        fondo = new Image[2];
        border = new int[2][4];
        bolaMaluca = new Items(50, 0, 100, 100);
        Coins = new Items[3];
        vida = new Items(250, heigth - 250, 80, 80);
        vida.IMG = new Image[1];

        try {
            vida.IMG[0] = ImageIO.read(new File("src/pickups/4.png"));
        } catch (IOException err) {
            System.out.println("ScenasWorld.Scena1World.<init>()");
        }

        for (int i = 0; i < 3; i++) {
            Coins[i] = new Items(4 + (width / 2), (heigth / 2) - 75, 84 / 2, 84 / 2);
            Coins[i].IMG = new Image[4];
            Coins[i].state = 0;
            try {
                Coins[0].IMG[0] = ImageIO.read(new File("src/pickups/gold_1.png"));
            } catch (IOException ex) {
                System.out.println("ScenasWorld.Scena1World.<init>()");
            }
            try {
                Coins[0].IMG[1] = ImageIO.read(new File("src/pickups/gold_2.png"));
            } catch (IOException ex) {
                System.out.println("ScenasWorld.Scena1World.<init>()");
            }
            try {
                Coins[0].IMG[2] = ImageIO.read(new File("src/pickups/gold_3.png"));
            } catch (IOException ex) {
                System.out.println("ScenasWorld.Scena1World.<init>()");
            }
            try {
                Coins[0].IMG[3] = ImageIO.read(new File("src/pickups/gold_4.png"));
            } catch (IOException ex) {
                System.out.println("ScenasWorld.Scena1World.<init>()");
            }
        }

        bolaMaluca.IMG = new Image[10];
        bolaMaluca.state = 0;
        try {
            for (int i = 0; i < 9; i++) {
                bolaMaluca.IMG[i] = ImageIO.read(new File("src/Saw/Saw" + (i + 1) + ".png"));
            }
        } catch (IOException ex) {
            System.out.println("ScenasWorld.Scena1World.<init>() bad enemi");
        }

        bolaMaluca.y = (int) (heigth - 181 - (bolaMaluca.getEnemi2d().getCenterY()));
        bolaMaluca.x = 230;

        try {
            fondo[0] = ImageIO.read(new File("src/level1/s1/fondo/1.png"));
            border[0][2] = width;
            border[0][3] = heigth;
            border[0][0] = 0;
            border[0][1] = 0;
        } catch (IOException ex) {
            System.out.println("ScenasWorld.Scena1World.<init>() err WOW!");
        }

        try {
            fondo[1] = ImageIO.read(new File("src/level1/s1/fondo/2.png"));
            border[1][2] = width;
            border[1][3] = 181;

            border[1][0] = 0;
            border[1][1] = heigth - 181;
        } catch (IOException ex) {
            System.out.println("ScenasWorld.Scena1World.<init>() err WOW!");
        }
    }

    /**
     * retorna cada Rectangulo que se pide
     *
     * @param x numero del rectangulo ( imagen de fondo o objeto)
     * @return new Rectangle2D.Double(border[x][0], border[x][1], border[x][2], border[x][3]);
     */
    public Rectangle2D getRectangle(int x) {
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

        bolaMaluca.x += relativeCoord;
        for (int i = 0; i < 3; i++) {
            Coins[i].x += relativeCoord;
        }
        vida.x += relativeCoord;

    }
}
