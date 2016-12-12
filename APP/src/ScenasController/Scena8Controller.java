/**
 * Esta clase es el controlador de la scena numero 6
 * detector de colisiones
 * implements ActionListener
 *
 * @author: Mario Josue Grieco Villamizar Universidad Nacional Experimental del
 * Tachira
 * @version: 0.1
 */
package ScenasController;

import Windows.LevelsController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Esta clase es el controlador de la scena numero 6
 * detector de colisiones
 * implements ActionListener
 *
 * @author: Mario Josue Grieco Villamizar Universidad Nacional Experimental del
 * Tachira
 * @version: 0.1
 */

public class Scena8Controller implements ActionListener {

    /**
     * Necesita el controlador principal de niveles
     *
     * @see ScenasWorld
     */
    public LevelsController world;

    /**
     * Determina Cuantas veces se inicializa la escena
     *
     * @see ScenasWorld
     */
    public int init = 0;

    /**
     * Constructor parametrico
     *
     * @param world parametro que determina el atributo
     * @see ScenasWorld
     */
    public Scena8Controller(LevelsController world) {
        this.world = world;
    }

    @Override
    /**
     * Action donde de determina la interseccion de los objetos de la escena y
     * algunos estados
     *
     * @param e Es un Action Event
     */
    public void actionPerformed(ActionEvent e) {
        world.sceneNumber = 8;
        world.viewLabel.enemiLive.setVisible(false);
        if (world.main.ground == false) {
            if (world.scena8.getRectangle(1).intersects(world.main.getRectangle())) {
                world.main.ground = true;
            }

        }
        if (world.main.ground == true && init == 0) {
            init = 1;
            world.tiempo.stop();
            world.scena8.KunaisUsadas.setText(world.viewLabel.ContadorGastadas + " kunais gastaddas");
            world.scena8.puntos.setText("Puntos: " + world.viewLabel.puntos.getText());
            world.scena8.tiempoTotal.setText(" Tiempo Total: " + world.segundos);
            world.scena8.vidaRestante.setText("Vida Resante: " + world.viewLabel.acumLive);
        }
    }

}
