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
import Windows.Screem;
import static Windows.Screem.heigth;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase es el controlador de la scena numero 6
 * detector de colisiones
 * implements ActionListener
 *
 * @author: Mario Josue Grieco Villamizar Universidad Nacional Experimental del
 * Tachira
 * @version: 0.1
 */

public class Scena6Controller implements ActionListener {

    /**
     * Necesita el controlador principal de niveles
     *
     * @see ScenasWorld
     */
    public LevelsController world;

    /**
     * Contador reservado para la animacion de la cierra 2
     */
    public int contadorSaw2 = 1;
    /**
     * Orientacion para la animacion de la cierra 2
     */
    public int orientationSaw2 = 1;
    /**
     * Orientacion para la animacion de la cierra -1
     */
    public int orientationSaw1 = -1;
    int x = 0;
    public int movement2 = 1;

    /**
     * Contructor para metrico para inicializar la escena
     *
     * @param world muestra un levelcontroller
     */
    public Scena6Controller(LevelsController world) {
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
        world.viewLabel.enemiLive.setVisible(false);

        if (contadorSaw2 % 1 == 0) {
            if (world.scena6.bolaMaluca[2].state + 1 < 9) {
                world.scena6.bolaMaluca[2].state += 1;
                world.scena6.bolaMaluca[1].state += 1;
            } else {
                world.scena6.bolaMaluca[2].state = 0;
                world.scena6.bolaMaluca[1].state = 0;
            }
            contadorSaw2 = 1;
            world.scena6.bolaMaluca[2].x += x * orientationSaw2;
            world.scena6.bolaMaluca[1].x += 5 * orientationSaw1;
        } else {
            contadorSaw2++;
        }

        if (world.scena6.bolaMaluca[2].x > (Screem.width / 2) + world.scena6.relativeCoord && world.scena6.bolaMaluca[2].orientation == 1) {
            world.scena6.bolaMaluca[2].orientation = -1;
            orientationSaw2 = -1;
        }

        if (world.scena6.bolaMaluca[2].x < (Screem.width / 2) + world.scena6.relativeCoord - 150 && world.scena6.bolaMaluca[2].orientation == -1) {
            world.scena6.bolaMaluca[2].orientation = 1;
            orientationSaw2 = 1;
            movement2 = 1;
        }

        if (world.scena6.bolaMaluca[1].x < world.scena6.relativeCoord - 150) {
            world.scena6.bolaMaluca[1].x = (Screem.width) + world.scena6.relativeCoord;
            orientationSaw1 = -1;
        }

        movement2++;
        if (movement2 % 30 == 0) {
            movement2 = 1;
            if (x != 5) {
                x = 5;
            } else {
                x = 0;
            }
        }

        if (world.main.ground == false) {
            if (world.scena6.getRectangle(1).intersects(world.main.getRectangle())) {
                world.main.ground = true;
            }

        }
        if (world.main.y > heigth) {
            // animate livecomplete1 -= 1;
            world.main.y = heigth - 181 - world.main.h;
            world.main.x = 50 + world.scena6.relativeCoord;
        }
        if (world.main.getRectangle().intersects(world.scena6.getRectangle(2)) && world.moving == false) {
            world.main.ground = false;
            world.main.runing = false;
            world.main.x = world.scena6.getRectangle(2).getX() - (world.main.w / 2) + 20;
        }
        if (world.main.getRectangle().intersects(world.scena6.getRectangle(3))) {
            world.main.ground = false;
            world.main.runing = false;
            world.main.x = world.scena6.getRectangle(3).getX() - (world.main.w / 2) + 20;
        }
        if (world.scena6.bolaMaluca[2].getEnemi2d().intersects(world.main.getRectangle()) && world.moving == false) {
            world.viewLabel.setLive2(5);
            world.main.sangre.x = (int) world.scena6.bolaMaluca[2].x;;
            world.main.sangre.y = (int) world.scena6.bolaMaluca[2].y;
            world.main.bloading = true;
            if (world.main.hurt.isRunning() == false) {
                world.main.hurt.setMicrosecondPosition(0);
                world.main.hurt.start();
            }
        }
        if (world.scena6.bolaMaluca[1].getEnemi2d().intersects(world.main.getRectangle()) && world.moving == false) {
            world.viewLabel.setLive2(5);
            world.main.sangre.x = (int) world.scena6.bolaMaluca[1].x;;
            world.main.sangre.y = (int) world.scena6.bolaMaluca[1].y;
            world.main.bloading = true;
            if (world.main.hurt.isRunning() == false) {
                world.main.hurt.setMicrosecondPosition(0);
                world.main.hurt.start();
            }

        }
    }

}
