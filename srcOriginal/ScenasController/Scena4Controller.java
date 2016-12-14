/**
 * Esta clase es el controlador de la scena numero 4
 * detector de colisiones
 * implements ActionListener, Screem
 *
 * @author: Mario Josue Grieco Villamizar Universidad Nacional Experimental del
 * Tachira
 * @version: 0.1
 */
package ScenasController;

import Windows.LevelsController;
import Windows.Screem;
import static Windows.Screem.heigth;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Esta clase es el controlador de la scena numero 4
 * detector de colisiones
 * implements ActionListener, Screem
 *
 * @author: Mario Josue Grieco Villamizar Universidad Nacional Experimental del
 * Tachira
 * @version: 0.1
 */

public class Scena4Controller implements ActionListener {

    /**
     * Necesita el controlador principal de niveles
     *
     * @see ScenasWorld
     */
    public LevelsController world;
    /**
     * estado del cocodrilo ( abajo, mordiendo, arriba)
     */
    public int staeCount = 1;
    /**
     * contador para las animaciones del cocodrilo
     */
    int aligatorCount = 1;
    /**
     * booleano que determina si se intersecta el cocodrilo en un mal momento (
     * muere el personaje(
     */
    public boolean alligatorsTAE = false;
    /**
     * contador reservado para las animaciones
     */
    public int contador = 1;
    /**
     * tipo int con funcion de booleano necesario 3 estados por ello no es
     * boolean
     */
    public int noPasa = 0;
    /**
     * tipo int con funcion de booleano necesario 3 estados por ello no es
     * boolean determina cuando se inicializa el nivel
     */
    public int initResumen = 0;

    /**
     * Constructor parametrico
     *
     * @param world parametro necesario para el controlador secundario
     * @see LevelsController
     */
    public Scena4Controller(LevelsController world) {
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

        if (world.main.x > (Screem.width / 2) + (world.movements * -1)) {
            world.scena4.cocodriloOrientation = -1;
        } else {
            world.scena4.cocodriloOrientation = 1;
        }
        if (alligatorsTAE && world.main.getRectangle().intersects(world.scena4.getRectangle(3)) && noPasa != 1) {
//            world.main.ground = true;
        }

        if (alligatorsTAE == false && world.main.getRectangle().intersects(world.scena4.getRectangle(3)) == false && world.main.getRectangle().intersects(world.scena4.getRectangle(9)) == true) {
            world.main.ground = false;
            world.main.runing = false;
            noPasa = 1;
            world.viewLabel.setLive2(3);
            if (contador % 50 == 0) {
                world.main.y = heigth - 181 - world.main.h;
                world.main.x = 40 + world.scena4.relativeCoord;
                contador = 1;
            }
            contador++;
        }
        // intersecto al oocodrilo y no esta escondino o al agua
        if (alligatorsTAE == false && world.main.getRectangle().intersects(world.scena4.getRectangle(3))) {
            world.main.ground = false;
            world.main.runing = false;
            noPasa = 1;
            world.viewLabel.setLive2(5);
            if (contador % 1 == 0) {
                world.main.y = heigth - 181 - world.main.h;
                world.main.x = 40 + world.scena4.relativeCoord;
                contador = 1;
            }
            contador++;
        }

        if (world.main.getRectangle().intersects(world.scena4.getRectangle(1)) && world.main.getRectangle().intersects(world.scena4.getRectangle(9)) == false) {
            world.main.ground = true;
        }

        //intersecta el agua y no al cocodrilo sin determinar su estado 
        if (world.main.getRectangle().intersects(world.scena4.getRectangle(3)) == false && world.main.getRectangle().intersects(world.scena4.getRectangle(9).getX(), world.scena4.getRectangle(9).getY() - 10, world.scena4.getRectangle(9).getWidth(), world.scena4.getRectangle(9).getHeight())) {
            world.main.ground = false;
            world.main.runing = false;
            noPasa = 1;
//            world.main.x = world.scena4.getRectangle(9).getCenterX()-100;
            world.viewLabel.setLive2(3);
            if (contador % 50 == 0) {
                world.main.y = heigth - 181 - world.main.h;
                world.main.x = 40 + world.scena4.relativeCoord;
                contador = 1;
            }
            contador++;
        }

        if (aligatorCount % 8 == 0) {
            if (world.scena4.alligatorState + 1 < 7 && alligatorsTAE == false) {
                world.scena4.alligatorState += 1;
                if (world.scena4.alligatorState == 6) {
                    alligatorsTAE = true;
                }
            } else if (alligatorsTAE == false) {
                world.scena4.alligatorState = 0;
            }
            aligatorCount = 1;
        }
        if (staeCount % 120 == 0) {
            alligatorsTAE = false;
            staeCount = 1;
        }
        aligatorCount++;
        staeCount++;
        if (world.main.x > (Screem.width * 4) - 200 && initResumen == 0) {
            world.tiempo.stop();
            JOptionPane.showMessageDialog(null, "LEVEL1 DONE!");
            JOptionPane.showMessageDialog(null, world.segundos + "s");
            JOptionPane.showMessageDialog(null, "VidaResante: " + world.viewLabel.acumLive);
            JOptionPane.showMessageDialog(null, "MONEDAS " + world.viewLabel.monedasText.getText());
            JOptionPane.showMessageDialog(null, "KUNAIS " + world.viewLabel.kaniText.getText());
            JOptionPane.showMessageDialog(null, "PUNTOS " + world.viewLabel.puntos.getText());
            initResumen = 1;
        }
    }

}
