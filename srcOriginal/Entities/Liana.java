
package Entities;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Esta clase es unica, define los recursos necesarios para la animacion de la liana
 * @author: Mario Josue Grieco Villamizar
 * Universidad Nacional Experimental del Tachira
 * @version: 0.1
 * @see Entities
 */
public class Liana  {
     /**
     *  publica coordenada x en memoria ( no necesariamente en la pantalla o el view) de la liana
     */
    public float x;
    
     /**
     *  publica coordenada y en memoria ( no necesariamente en la pantalla o el view) de la liana
     */
    public float y;
    
     /**
     *  publica coordenada x del punto 2 de la liana en memoria ( no necesariamente en la pantalla o el view) de la liana
     */
    public float w;
    
    /**
     *  publica coordenada y del punto 2 de la liana en memoria ( no necesariamente en la pantalla o el view) de la liana
     */
    public float h;
     /**
     *  publicacoordenada estado de la liana del punto de equilibrio a la derecha up = true lo contrario false
     */
        public boolean up;
     /**
     *  publica objeto reservado para otros casos
     */
        public Line2D objeto;
        
     /**
     * 
     * publico, Constructor carga las coordenadas iniciales de la imagen x1,x2,y1,y2 y2 como h y y1 como w
     * @param i x1
     * @param i0 x2
     * @param i1 y1
     * @param i2 y2 
     * son los puntos para crear la liana ( esta se anima en el controllador de la escena )
     */
    

    public Liana(int i, int i0, int i1, int i2) {
       this.x = i;
       this.y = i0;
       this.w = i1;
       this.h = i2;
       up = true;
    }
    
     /**
     * 
     * Metodo que retorna solo la liana para imprmir en pantalla con line2d y graphics2d
     *  
     * @return  Line2D.Foat(x1,x2,y1,y2)
     */
    public Line2D getRectangle(){
       return new Line2D.Float(x, y, w, h);
    }
    
     /**
     * 
     * Metodo que retorna solo la interseccion de la liana para permitir interaccion en pantalla con line2d y graphics2d
     *  
     * @return  Rectangle2D.Double(w-50,h-100,100,100);
     */
    public Rectangle2D getRectangle2d(){
        return new Rectangle2D.Double(w-50,h-100,100,100);
    }
}
