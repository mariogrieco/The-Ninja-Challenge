
package Entities;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

 
/**
 * Esta clase define los recursos necesarios para la animacion de la sangre del personaje
 * @author: Mario Josue Grieco Villamizar
 * Universidad Nacional Experimental del Tachira
 * @version: 0.1
 * @see Entities
 */
public class Blood {
    
   
   /**
   * array de images ( coleccion de transicion de la animacion blooding)
   */
    public Image[] images;
    
   /**
   * el estado en el cual se encuentra el array images[]
   */
    public int State;
    
   /**
   * coordenada en x donde sera instanciada la imagen
   */
    public int x;
   
   /**
   *  coordenada en y donde sera instanciada la imagen
   */
    public int y;
    
   /**
   *  ancho de la imagen
   */
    public int w;
    
    
   /**
   *  alto de la imagen
   */
    public int h;
    
    /**
     * 
     * Constructor Parametrico ( int x,int y) coordenada en x 'y' en y donde se colocara la imagen, poco util mas adelante se altera
     *  
     * @param x cordenada en x donde se instanciara la imagen
     * @param y coordenada en y donde se instanciara la imagen
     */
    
    public Blood(int x,int y){
        images = new Image[6];
        this.x = x;
        this.y = y;
        w = 310/4;
        h = 310/4;
        
        try{
            for (int i = 0; i < 6; i++) {
                images[i] = ImageIO.read(new File("src/salpicadura/blood"+(i)+".png"));
            }
        }catch(IOException err){
   /**
   * ocurrio algun error al cargar las imagenes
   */
            System.out.println("Entities.Blood.<init>()");
        }
    }
    
}
