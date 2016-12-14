/**
 * Esta clase es el controlador de la scena numero 5
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.Clip;

/**
 * Esta clase es el controlador de la scena numero 5
 * detector de colisiones
 * implements ActionListener
 *
 * @author: Mario Josue Grieco Villamizar Universidad Nacional Experimental del
 * Tachira
 * @version: 0.1
 */

public class Scena5Controller implements ActionListener {

    /**
     * Necesita el controlador principal de niveles
     *
     * @see ScenasWorld
     */
    public LevelsController world;

    /**
     * Si la cierra 1 se dirije a la derecha o a la izquierda 1,-1 en ese orden
     */
    public int orientationSaw1 = 1;

    /**
     * Si la cierra 2 se dirije a la derecha o a la izquierda 1,-1 en ese orden
     */
    public int orientationSaw2 = -1;

    /**
     * Si la cierra 3 se dirije a la derecha o a la izquierda 1,-1 en ese orden
     */
    public int orientationSaw3 = 1;

    /**
     * Contador reservado para la animacion de la cierra 1
     */
    public int contadorSaw1 = 1;
    /**
     * Contador reservado para la animacion de la cierra 2
     */
    public int contadorSaw2 = 1;
    /**
     * Contador reservado para la animacion de la cierra 3
     */
    public int contadorSaw3 = 1;

    /**
     * Constructor parametrico
     *
     * @param world creador de unos de los atributos
     */
    public Scena5Controller(LevelsController world) {
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
        if (world.main.ground == false) {
            if (world.scena5.getRectangle(1).intersects(world.main.getRectangle())) {
                world.main.ground = true;
            }

        }

        if (contadorSaw1 % 1 == 0) {
            if (world.scena5.bolaMaluca[0].state + 1 < 9) {
                world.scena5.bolaMaluca[0].state += 1;
            } else {
                world.scena5.bolaMaluca[0].state = 0;
            }
            contadorSaw1 = 1;
            world.scena5.bolaMaluca[0].x += 3 * orientationSaw1;
        } else {
            contadorSaw1++;
        }

        if (contadorSaw2 % 1 == 0) {
            if (world.scena5.bolaMaluca[1].state + 1 < 9) {
                world.scena5.bolaMaluca[1].state += 1;
            } else {
                world.scena5.bolaMaluca[1].state = 0;
            }
            contadorSaw2 = 1;
            world.scena5.bolaMaluca[1].x += 4 * orientationSaw2;
        } else {
            contadorSaw2++;
        }

        if (contadorSaw3 % 1 == 0) {
            if (world.scena5.bolaMaluca[2].state + 1 < 9) {
                world.scena5.bolaMaluca[2].state += 1;
            } else {
                world.scena5.bolaMaluca[2].state = 0;
            }
            contadorSaw3 = 1;
            world.scena5.bolaMaluca[2].x += 5 * orientationSaw3;
        } else {
            contadorSaw3++;
        }

        if (world.scena5.bolaMaluca[2].x < (world.scena5.relativeCoord) + 200 && orientationSaw3 == -1) {
            orientationSaw3 = 1;
            world.scena5.bolaMaluca[2].orientation = 1;
        }
        if (world.scena5.bolaMaluca[2].x > Screem.width + (world.scena5.relativeCoord) - 330 && orientationSaw3 == 1) {
            orientationSaw3 = -1;
            world.scena5.bolaMaluca[2].orientation = -1;
        }

        if (world.scena5.bolaMaluca[1].x < (world.scena5.relativeCoord) + 200 && orientationSaw2 == -1) {
            orientationSaw2 = 1;
            world.scena5.bolaMaluca[1].orientation = 1;
        }
        if (world.scena5.bolaMaluca[1].x > Screem.width + (world.scena5.relativeCoord) - 330 && orientationSaw2 == 1) {
            orientationSaw2 = -1;
            world.scena5.bolaMaluca[2].orientation = -1;
        }

        if (world.scena5.bolaMaluca[0].x < (world.scena5.relativeCoord) + 200 && orientationSaw1 == -1) {
            orientationSaw1 = 1;
            world.scena5.bolaMaluca[0].orientation = 1;

        }
        if (world.scena5.bolaMaluca[0].x > Screem.width + (world.scena5.relativeCoord) - 330 && orientationSaw1 == 1) {
            orientationSaw1 = -1;
            world.scena5.bolaMaluca[0].orientation = -1;
        }

        if (world.scena5.bolaMaluca[0].getEnemi2d().intersects(world.main.getRectangle()) && world.main.deading == false) {
            world.viewLabel.setLive2(5);
            world.main.sangre.x = (int) world.scena5.bolaMaluca[0].x;;
            world.main.sangre.y = (int) world.scena5.bolaMaluca[0].y;
            world.main.bloading = true;
            if (world.main.hurt.isRunning() == false) {
                world.main.hurt.setMicrosecondPosition(0);
                world.main.hurt.start();
            }

        }

        if (world.scena5.bolaMaluca[1].getEnemi2d().intersects(world.main.getRectangle()) && world.main.deading == false) {
            world.viewLabel.setLive2(5);
            world.main.sangre.x = (int) world.scena5.bolaMaluca[1].x;;
            world.main.sangre.y = (int) world.scena5.bolaMaluca[1].y;
            world.main.bloading = true;
            if (world.main.hurt.isRunning() == false) {
                world.main.hurt.setMicrosecondPosition(0);
                world.main.hurt.start();
            }
        }
        if (world.scena5.bolaMaluca[2].getEnemi2d().intersects(world.main.getRectangle()) && world.main.deading == false) {
            world.viewLabel.setLive2(5);
            world.main.sangre.x = (int) world.scena5.bolaMaluca[2].x;;
            world.main.sangre.y = (int) world.scena5.bolaMaluca[2].y;
            world.main.bloading = true;
            if (world.main.hurt.isRunning() == false) {
                world.main.hurt.setMicrosecondPosition(0);
                world.main.hurt.start();
            }
        }
    }

}
