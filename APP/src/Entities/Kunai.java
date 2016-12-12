 

package Entities;

import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Esta clase es unica, define los recursos necesarios para la animacion del kunai
 * @author: Mario Josue Grieco Villamizar
 * Universidad Nacional Experimental del Tachira
 * @version: 0.1
 * @see Entities
 */

public class Kunai {
    
     /**
     *  publica coordenada x en memoria ( no necesariamente en la pantalla o el view) del item
     */
    public int x;
     /**
     *  publica coordenada y en memoria ( no necesariamente en la pantalla o el view) del item
     */
    public int y;
    
     /**
     *  public w, ancho de la imagen del kunai
     */
    public int w;
     
    /**
     *  public, alto de la imagen del kunai
     */
    public int h;
     
    /**
     *  public IMG , imagen del kunai
     */
    public Image IMG;
     /**
     * public int, orientation 1 a la derecha -1 a la izquirda
     */
    public int orientation;
    
     /**
     * 
     * publico, Constructor carga las imagenes dentro de la ruta incluida en el mismo error no cargo el kunai
     *  
     */
    
    
    public Kunai(){
        orientation = 1;
        try {
            IMG = ImageIO.read(new File("src/Entities/NINJA/lanzando/Kunai35.png"));
        } catch (IOException ex) {
            System.out.println("No cargo el kunai");
        }
    }
     /**
     * 
     * Metodo que retorna el Rectangulo2d en el view activo para permiir la interaccion de los objetos 
     *  
     * @return  Rectangle2D tiene la corrdenada x,y el ancho y el alto de el objeto instanciado con esta clase
     */
    public Rectangle2D getRectangle(){
        return new Rectangle2D.Double(this.x,this.y,this.w,this.h);
    }
}
