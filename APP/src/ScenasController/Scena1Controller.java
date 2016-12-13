/**
 * Esta clase es el controlador de la scena numero 1
 * implements ActionListener
 * detector de colisiones
 *
 * @author: Mario Josue Grieco Villamizar Universidad Nacional Experimental del
 * Tachira
 * @version: 0.1
 */
package ScenasController;

import Entities.Personaje;
import ScenasWorld.Scena1World;
import Windows.LevelsController;
import static Windows.Screem.width;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Esta clase es el controlador de la scena numero 1
 * implements ActionListener
 * detector de colisiones
 *
 * @author: Mario Josue Grieco Villamizar Universidad Nacional Experimental del
 * Tachira
 * @version: 0.1
 */
public class Scena1Controller implements ActionListener {

    /**
     * Si el coin de esa escena sube o baja
     *
     * @see Entities.Items
     */
    public int coinOrientation;
    /**
     * NO SE USA LA VIDA DEL PERSONAJE EN ESTO ESTA ES LA QUE PUEDE AGARRAR Si
     * la vidade en esa escena sube o baja
     *
     * @see Entities.Items
     */
    public int liveOrientation;

    /**
     * La escena requiere unos estados del controlador principal ( el de los
     * niveles)
     *
     * @see LevelsController
     */
    public LevelsController world;

    /**
     * Contador de estado del coins reservado
     */
    int cointAnimation = 1;
    /**
     * Contador reservado para animacion
     */
    int contador = 1;
    /**
     * Contador reservado para animacion
     */
    int contador2 = 1;
    /**
     * Contador reservado para animacion
     */
    int contador3 = 1;
    /**
     * Contador de reservado para animacion
     */
    public int init = 0;

    /**
     * Constructor parametrico
     *
     * @param world LevelsController parametro unico nombrado world
     */
    public Scena1Controller(LevelsController world) {

        this.world = world;
        coinOrientation = 1;
        liveOrientation = -1;
    }

    @Override
    /**
     * Constructor parametrico
     *
     * @param e ActionEvent IMPLEMENTACION DEL ActionListener Action donde de
     * determina la interseccion de los objetos de la escena y algunos estados
     */
    public void actionPerformed(ActionEvent e) {
        if (init == 0) {
            world.sonido.cierra.setMicrosecondPosition(0);
            world.sonido.cierra.loop(Clip.LOOP_CONTINUOUSLY);
            init = 1;
        }
        if (cointAnimation % 4.5 == 0) {
            if (world.scena1.Coins[0].state + 1 < 4) {
                world.scena1.Coins[0].state += 1;
            } else {
                world.scena1.Coins[0].state = 0;
            }
            cointAnimation = 1;
        }
        cointAnimation++;

        if (contador3 % 1 == 0) {
            if (world.scena1.bolaMaluca.state + 1 < 9) {
                world.scena1.bolaMaluca.state += 1;
            } else {
                world.scena1.bolaMaluca.state = 0;
            }
            if (world.scena1.bolaMaluca.x < 350 + world.scena1.relativeCoord) {
                world.scena1.cierra = 1;
            } else if (world.scena1.bolaMaluca.x > (width - (world.scena1.bolaMaluca.w) - 250) + world.scena1.relativeCoord) {
                world.scena1.cierra = -1;
            }
            world.scena1.bolaMaluca.x += 10 * world.scena1.cierra;
            contador3 = 0;
        }
        if (world.main.ground == false) {
            if (world.scena1.getRectangle(1).intersects(world.main.getRectangle())) {
                world.main.ground = true;
            }

        }
        if (world.scena1.Coins[0].getEnemi2d().intersects(world.main.getRectangle())) {
            //System.out.println("ScenasController.Scena1Controller.actionPerformed()");
        }
        // daño cierra
        if (world.scena1.bolaMaluca.getEnemi2d().intersects(world.main.getRectangle()) && world.main.deading == false && world.pasing == false) {
            world.viewLabel.setLive2(6);
            world.main.sangre.x = (int) world.scena1.bolaMaluca.x;
            world.main.sangre.y = (int) world.scena1.bolaMaluca.y;
            world.main.bloading = true;
            if (world.main.hurt.isRunning() == false) {
                world.main.hurt.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } else {
            world.main.hurt.stop();
            world.main.hurt.setMicrosecondPosition(0);
        }

        if (world.scena1.Coins[0].getEnemi2d().intersects(world.main.getRectangle()) && world.pasing == false) {
            if (world.scena1.Coins[0].visible) {
                world.viewLabel.setPoints(50);
                world.main.Coining = true;
                world.scena1.Coins[0].visible = false;
                world.sonido.coin.setMicrosecondPosition(0);
                world.sonido.coin.start();
            }
        }

        if (world.scena1.vida.getEnemi2d().intersects(world.main.getRectangle()) && world.main.gameOver == false && world.pasing == false) {
            if (world.scena1.vida.visible) {
                world.viewLabel.setLive(150);
                world.scena1.vida.visible = false;
                world.sonido.live.setMicrosecondPosition(0);
                world.sonido.live.start();
            }
        }

        if (world.scena1.vida.getEnemi2d().intersects(world.main.kunai.getRectangle())) {
            world.scena1.vida.x = world.main.kunai.x + world.main.kunai.w;

        }
//        if (super.getDone().intersects(main.getRectangle()) ) {  //done level
//            done.pass = true;
//        }

        // COINS Animation
        world.scena1.Coins[0].y += 1 * coinOrientation;
        world.scena1.vida.y += 1 * liveOrientation;
        contador++;
        if (contador % 25 == 0) {
            coinOrientation *= -1;
            contador = 1;
        }
        contador2++;
        if (contador2 % 30 == 0) {
            liveOrientation *= -1;
            contador2 = 1;
        }
    }
}
