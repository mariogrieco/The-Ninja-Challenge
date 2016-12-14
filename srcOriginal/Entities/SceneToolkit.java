package Entities;


import java.awt.Image;
import java.awt.geom.Rectangle2D;

/**
 * Esta clase no se uso por que era tan fea como yo
 * @author: Mario Josue Grieco Villamizar
 * Universidad Nacional Experimental del Tachira
 * @version: 0.1
 * @see Entities
 */

public abstract class SceneToolkit {
    public Image[] background;
    public Integer x[];
    public Integer y[];
    public Integer w[];
    public Integer h[];
    
    public SceneToolkit(Integer[] x, Integer[] y, Integer[] w, Integer[] h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    
    public Rectangle2D getRectangle(int i,int p){
        return new Rectangle2D.Double(x[i],y[p],w[i],h[p]);
    }
}
