
package Entities;

import java.awt.Image;
import java.awt.geom.Rectangle2D;

 
/**
 * Esta clase define los recursos necesarios para los Items (MONEDAS, kunais,vidas etc...)
 * @author: Mario Josue Grieco Villamizar
 * Universidad Nacional Experimental del Tachira
 * @version: 0.1
 * @see Entities
 */
public class Items {
    /**
     *  publica coordenada x en memoria ( no necesariamente en la pantalla o el view) del item
     */
    public int x;
        /**
     * publica coordenada y en memoria ( no necesariamente en la pantalla o el view) del item
     */
    public int y;
        /**
     * publica ancho del item
     */
    public int w;
     /**
     * publica alto item
     */
    public int h;
        /**
     * publica Coleccion de imagenes del item para su posterior animacion
     */
    public Image IMG[];
     /**
     * public Stado de la coleccion de imagenes en la pantalla ( la que se mostrara)
     * @see Entities.Items
     */
    public int state;
    
     /**
     * public el item mira a la derecha de la pantalla sera 1, a la izquierda -1
     */
    public int orientation = 1;
    
        
     /**
     * public este estado determinara si se muestra en pantalla o no y si puede interactuar con otros
     */
    public boolean visible = true;
    
        
    /**
     * 
     * publico, Constructor Parametrico ( int x,int y,int w,int h) coordenada en x 'y' en y donde se colocara la imagen, poco util mas adelante se altera. El alto y el Ancho
     *  
     * @param x cordenada en x donde se instanciara la imagen
     * @param y coordenada en y donde se instanciara la imagen
     * @param w ancho
     * @param h alto
     */
    
    public Items(int x,int y,int w,int h){
        state = 1;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    
     /**
     * 
     * Metodo que retorna el Rectangulo2d en el view activo para permiir la interaccion de los objetos 
     *  
     * @return  Rectangle2D tiene la corrdenada x,y el ancho y el alto de el objeto instanciado con esta clase
     */
    public Rectangle2D getEnemi2d(){
        return new Rectangle2D.Double(this.x,this.y,this.w,this.h);
    }
    
}
