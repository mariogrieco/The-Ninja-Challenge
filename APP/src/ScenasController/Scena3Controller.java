/**
 * Esta clase es el controlador de la scena numero 3
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase es el controlador de la scena numero 3
 * detector de colisiones
 * implements ActionListener, Screem
 *
 * @author: Mario Josue Grieco Villamizar Universidad Nacional Experimental del
 * Tachira
 * @version: 0.1
 */

public class Scena3Controller implements ActionListener, Screem {

    /**
     * Atributo requerido por el controllardor
     *
     * @see LevelsController
     */
    public LevelsController world;

    /**
     * Contador reservado para las animacions de la escena
     */
    public int contador = 0;

    /**
     * Constructor parametrico
     *
     * @param world LevelsController
     * @see LevelsController determinas ciertas intersecciones
     */
    public Scena3Controller(LevelsController world) {
        this.world = world;
    }

    @Override
    /**
     * Action donde de determina la interseccion de los objetos de la escena y
     * algunos estados
     */
    public void actionPerformed(ActionEvent e) {
        if (world.main.y > heigth) {
            // animate livecomplete1 -= 1;
            world.main.y = heigth - 181 - world.main.h;
            world.main.x = 40 + world.scena3.relativeCoord;
        }
        if (world.main.getRectangle().intersects(world.scena3.getRectangle(1))) {
            world.main.ground = true;
            world.main.block = true;
        }
        if (world.main.getRectangle().intersects(world.scena3.getRetorno())) {
            world.main.block = false;
        }
        if (world.main.getRectangle().intersects(world.scena3.getRectangle(9))) {
            world.main.ground = false;
            world.main.runing = false;
            if (contador < 150) {
                world.viewLabel.setLive2(3);
            }
            world.main.x = world.scena3.getRectangle(9).getCenterX();
            if (world.main.deading) {
                world.main.idling = false;
            }
            contador++;
        }
        if (world.scena3.lianaRect().contains(world.main.getRectangle().getCenterX(), world.main.getRectangle().getCenterY()) && world.main.jumpingLianing == false) {
            world.main.lianing = true;
            world.main.ground = true;
            world.main.x = world.scena3.lianaRect().getCenterX();
            world.main.runing = false;
//            world.main.y = world.scena3.lianaRect().getCenterY();

        }

        if (world.main.lianing && world.main.jumpingLianing == false) {
            world.main.x = world.scena3.x - 70;
            contador = 0;
//            world.main.y = world.scena3.y-world.main.h;
        }

        // Liana animation!
        if (world.scena3.contadorLiana % 1 == 0) {
            if (world.scena3.lianasSubiendo == false) {
                world.scena3.x -= 2;
                world.scena3.lianaOrientation = -1;
                if (world.scena3.x <= 300 + world.scena3.relativeCoord) {
                    world.scena3.lianasSubiendo = true;
                    world.scena3.contadorLiana = 0;
                }
            }
            if (world.scena3.lianasSubiendo == true) {
                world.scena3.x += 2;
                world.scena3.lianaOrientation = 1;
                if (world.scena3.x >= 660 + world.scena3.relativeCoord) {
                    world.scena3.lianasSubiendo = false;
                    world.scena3.contadorLiana = 0;
                }
            }
            world.scena3.contadorLiana = 0;
        }
        world.scena3.contadorLiana += 1;

    }

}
