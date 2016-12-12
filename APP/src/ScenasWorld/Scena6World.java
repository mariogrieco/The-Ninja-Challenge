/**
 * Esta clase es el scena world de la scena numero 6
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
 * Esta clase es el scena world de la scena numero 6
 * creacion manual de los componentes de la escena
 * establece coordenadas y rectangulos de interseccion
 * implements ActionListener
 */
public class Scena6World implements Screem {
   
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
     * Items cierras 
     * @see Items
     */
    
    public Items bolaMaluca[];
    
        /**
     * Constructor
     */
     public Scena6World(){
         
        fondo = new Image[4];
        border = new int[4][4];

        try{
            fondo[0] = ImageIO.read(new File("src/level2/s2/Fondo/1.jpg"));
            border[0][0] = 0;
            border[0][1] = 0;
            border[0][2] = width;
            border[0][3] = heigth;
            
            fondo[1] = ImageIO.read(new File("src/level2/s2/Fondo/2.png"));
            border[1][0] = 0;
            border[1][1] = heigth-210;
            border[1][2] = width;
            border[1][3] = 210;
            
            fondo[2] = ImageIO.read(new File("src/level2/s2/Fondo/3.png"));
            border[2][0] = 250;
            border[2][1] = heigth-190;
            border[2][2] = 150;
            border[2][3] = 210;
            
            fondo[3] = ImageIO.read(new File("src/level2/s2/Fondo/3.png"));
            border[3][0] = 650;
            border[3][1] = heigth-190;
            border[3][2] = 150;
            border[3][3] = 210;
            
        }
        catch(IOException err){
            System.out.println("ScenasWorld.Scena3World.<init>()");
        }
        
        bolaMaluca = new Items[3];
        bolaMaluca[0] = new Items(0, 0, 100, 100);
        bolaMaluca[1] = new Items(0, 0, 100, 100);
        bolaMaluca[2] = new Items(0, 0, 100, 100);
        for (int i = 0; i < 3; i++) {
            bolaMaluca[i].IMG = new Image[10];
            bolaMaluca[i].state = 0;
            bolaMaluca[i].orientation = 1;
            try {
                for (int j = 0; j < 9; j++) {
                    bolaMaluca[i].IMG[j] = ImageIO.read(new File("src/Saw/Saw" + (j + 1) + ".png"));
                }
            } catch (IOException ex) {
                System.out.println("ScenasWorld.Scena1World.<init>() bad enemi");
            }
        }
            bolaMaluca[0].y = (int) (heigth-185-bolaMaluca[1].getEnemi2d().getHeight()/2);
            bolaMaluca[0].x = width;
            
            bolaMaluca[1].y = (int) (heigth-185-bolaMaluca[1].getEnemi2d().getHeight()/2);
            bolaMaluca[1].x = width;
            
            bolaMaluca[2].y = (int) (heigth-185-bolaMaluca[2].getEnemi2d().getHeight()/2);
            bolaMaluca[2].x = width/2;
    }

    /**
     * retorna cada Rectangulo que se pide
     *
     * @param x numero del rectangulo ( imagen de fondo o objeto)
     * @return Rectangle2D.Double
     */
    public Rectangle2D getRectangle(int x) {
        
        if ( x == 2) {
            return new Rectangle2D.Double(border[x][0]+55,border[x][1],45,border[x][3]);
        }
        if ( x == 3) {
            return new Rectangle2D.Double(border[x][0]+55,border[x][1],45,border[x][3]);
        }
        if ( x == 1) {
            return new Rectangle2D.Double(border[x][0],border[x][1]+20,border[x][2],border[x][3]-20);
        }
        return new Rectangle2D.Double(border[x][0],border[x][1],border[x][2],border[x][3]);
    }
    
    
    /**
     * Establece las coordenadas relativas
     *
     * @param x determina las coordenadas relativas
     */
    public void SetRelativeObjects(int x){
        relativeCoord += x;
        
  
        for (int i = 0; i < 4; i++) {
            border[i][0] += relativeCoord;
        }
        for (int i = 0; i < 3; i++) {
            bolaMaluca[i].x += relativeCoord;
        }
        
    }
}
