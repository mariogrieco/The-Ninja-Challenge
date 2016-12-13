/**
 * Esta clase es el controlador de la scena numero 1
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
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Esta clase es el controlador de la scena numero 1 detector de colisiones
 * implements ActionListener
 *
 * @author: Mario Josue Grieco Villamizar Universidad Nacional Experimental del
 * Tachira
 * @version: 0.1
 */
public class Scena2Controller implements ActionListener, Screem {

    /**
     * Si el coin de esa escena sube o baja
     *
     * @see Entities.Items
     */
    public int coinOrientation = 1;
    /**
     * NO SE USA LA VIDA DEL PERSONAJE EN ESTO ESTA ES LA QUE PUEDE AGARRAR Si
     * la vida que podria agarrar de esa escena sube o baja en ( no es la del
     * personaje)
     *
     * @see Entities.Items
     */
    public int liveOrientation;
    /**
     * Parametro necesario pasado por el constructor
     *
     * @see LevelsController
     */
    public LevelsController world;
    /**
     * Contador para la animacion de los coins
     */
    public int cointAnimation = 0;
    /**
     * bandera
     */
    public int warning = 0;
    /**
     * bandera2
     */
    public int warning2 = 0;
    /**
     * cuantas veces se inicializa la escena
     */
    public int block = 0;

    /**
     * Contador de reservado para animacion
     */
    int contador = 1;

    /**
     * Contador de reservado para animacion
     */
    int contador2 = 1;

    /**
     * Contador de reservado para animacion
     */
    int contador3 = 1;
    /**
     * Contador de reservado para animacion
     */
    int contador5 = 1;
    /**
     * cuantas veces se inicializa la escena
     */
    int init = 0;

    public int one = 0;

    /**
     * Constructor parametrico parametro unico LevelsController nombredo world
     *
     * @see world LevelsController
     * @param world LevelsController
     */
    public Scena2Controller(LevelsController world) {
        this.world = world;

    }

    /**
     * Action donde de determina la interseccion de los objetos de la escena y
     * algunos estados
     *
     * @param e Es un Action Event
     */
    public void actionPerformed(ActionEvent e) {
        if (init == 0) {
            world.sonido.cierra.stop();
            world.scena2.maluco.orientation = -1;
            init = 1;
        }

        if (cointAnimation % 4.5 == 0) {
            if (world.scena2.coins[0].state + 1 < 4) {
                world.scena2.coins[0].state += 1;
                world.scena2.coins[1].state += 1;
                world.scena2.coins[2].state += 1;
            } else {
                world.scena2.coins[0].state = 0;
                world.scena2.coins[1].state = 0;
                world.scena2.coins[2].state = 0;
            }
            cointAnimation = 1;
        }
        cointAnimation++;

        // COINS Animation
        contador++;
        contador5++;
        for (int i = 0; i < 3; i++) {
            if (world.scena2.coins[i].visible == true) {
                world.scena2.coins[i].y += 1 * coinOrientation;
            }

        }
        if (contador5 % 2 == 0) {
            if (world.scena2.life.visible == true) {
                world.scena2.life.y += 1 * coinOrientation;
            }
        }
        if (contador5 % 5 == 0) {
            if (world.scena2.Kunai.visible == true) {
                world.scena2.Kunai.y += 1 * coinOrientation;
            }
            contador5 = 1;
        }

        if (contador % 25 == 0) {
            coinOrientation *= -1;
            contador = 1;
        }

        if (world.scena2.maluco.kunai.getRectangle().intersects(world.main.getRectangle()) && world.scena2.maluco.deading == false && world.main.deading == false && world.pasing == false) {
            world.viewLabel.setLive2(7);
            if (world.main.hurt.isRunning() == false) {
                world.main.hurt.setMicrosecondPosition(0);
                world.main.hurt.start();
            }
            world.main.sangre.x = world.scena2.maluco.kunai.x;
            world.main.sangre.y = world.scena2.maluco.kunai.y;;
            world.main.bloading = true;
        }

        if (world.main.kunai.getRectangle().intersects(world.scena2.maluco.getRectangle()) && world.scena2.maluco.deading == false && world.scena2.maluco.runing == false) {
            world.scena2.maluco.throwing = false;
            world.scena2.maluco.deading = true;
            world.viewLabel.setPoints2(1750);
            one = 1;
            int increments = 1;
            for (int i = 0; i < 3; i++) {
                if (world.scena2.coins[i].visible == false) {
                    world.scena2.coins[i].x = (int) (world.scena2.maluco.x - increments / 2);
                    world.scena2.coins[i].y = (int) (world.scena2.maluco.y - increments / 2);
                    world.scena2.Kunai.x = (int) (world.scena2.maluco.x - increments / 3);
                    world.scena2.Kunai.y = (int) (world.scena2.maluco.y - increments / 2 / 2);
                    increments += 100;
                    world.scena2.coins[i].visible = true;
                }
                world.scena2.life.x = (int) (world.scena2.maluco.x - 150 / 2);
                world.scena2.life.y = (int) (world.scena2.maluco.y + 50);
                world.scena2.Kunai.visible = true;
                world.scena2.life.visible = true;
            }
        }

        // fisica 
        if (world.main.ground == false) {
            if (world.scena2.getRectangle(1).intersects(world.main.getRectangle()) || world.scena2.getRectangle(1).intersects(world.main.getRectangle())) {
                world.main.ground = true;
                world.main.onTop = false;
            }
        }
        //Escalera script
        if (world.main.jumping || world.main.sliding) {
            world.main.onClian = false;
            world.main.onClian2 = false;
            world.main.notfound = true;
        }
//        if ( world.main.runing && world.main.c) {
//            world.main.onClian = false;
//            world.main.notfound = true;
//        }
        // raro
        if (world.main.onTop && world.main.bajando) {
            if (block == 0) {
                world.main.y += 10;
                block = 1;
            }
            world.main.climbing = true;
        } else {
            block = 0;
        }
        if (world.main.getRectangle().intersects(world.scena2.getRectangle(20)) && world.main.gliding == false && world.main.jumping == false && block == 0) {
            world.main.onClian2 = true;

        } else {
            world.main.onClian2 = false;
            world.main.bajando = false;
        }

        if (world.scena2.getRectangle(3).intersects(world.main.getRectangle()) && world.main.bajando == false) {
            world.main.onClian = true;
            world.main.notfound = false;
        } else {
            world.main.onClian = false;
            world.main.notfound = false;
        }

        if (world.scena2.getRectangle(4).contains(world.main.getRectangle()) && world.scena2.getRectangle(2).intersects(world.main.getRectangle())) {
            world.main.climbing = false;
            world.main.subiendo = false;
            world.main.onClian = false;
            world.main.onTop = true;
        }

        if (world.scena2.getRectangle(2).intersects(world.main.getRectangle()) == false && world.main.onTop == true) {
            world.main.onTop = false;
            world.main.ground = false;
            world.main.onClian = false;
            world.main.notfound = true;
        }

        if (world.main.subiendo || world.main.bajando) {
            world.main.x = world.scena2.getRectangle(3).getX() - 70;
        }

        // pequeña IA n#1
        if (one == 0) {

            if (world.scena2.maluco.ground == false) {
                if (world.scena2.getRectangle(1).intersects(world.scena2.maluco.getRectangle())) {
                    world.scena2.maluco.ground = true;
                }
            }
            if (world.scena2.maluco.deading == false && world.main.onTop == false && warning2 == 0) {

                if (world.scena2.maluco.ground == false) {
                    if (world.scena2.getRectangle(1).intersects(world.scena2.maluco.getRectangle())) {
                        world.scena2.maluco.ground = true;
                    }
                }
                if (world.scena2.maluco.x > (width * 2) - 400) { // no tiene relativo cuidado!
                    world.scena2.maluco.runing = false;
                }
                if (world.scena2.maluco.ground && warning == 0) {
                    world.scena2.maluco.throwing = false;
                    world.scena2.maluco.runing = true;
                }
                if (world.scena2.maluco.x < (width / 2) + 10 + world.scena2.relativeCoord && warning == 0) {
                    world.scena2.maluco.runing = false;
                    if (world.scena2.maluco.throwing == false && world.scena2.maluco.instantiate == false) {
                        world.scena2.maluco.throwing = false;
                    }
                }
                if (world.scena2.maluco.x < width + 100) {
                    world.scena2.maluco.orientation *= -1;
                    world.scena2.maluco.runing = true;
                }
                if ((world.scena2.maluco.x - world.main.x < 350 + world.scena2.relativeCoord) && world.scena2.maluco.orientation < 0 && warning == 0) {
                    world.scena2.maluco.orientation *= -1;
                    world.scena2.maluco.runing = true;
                    world.scena2.maluco.throwing = false;
                    warning = 1;
                }

                if (warning == 1 && world.scena2.maluco.gliding == false) {
                    if (contador2 % 40 == 0) {
                        world.scena2.maluco.runing = false;
                        world.scena2.maluco.orientation *= -1;
                        world.scena2.maluco.throwing = true;

                        warning = 2;
                        contador2 = 1;
                    }
                    contador2++;
                }
                if (warning == 2 && world.scena2.maluco.throwing == false && world.scena2.maluco.instantiate == false && world.scena2.maluco.deading == false) {
                    world.scena2.maluco.throwing = true;
                }
            }

            if (world.main.onTop && world.scena2.maluco.deading == false || world.scena2.maluco.ground == true && world.main.onClian) {
                if (warning2 == 0) {
                    world.scena2.maluco.throwing = false;
                    world.scena2.maluco.runing = true;
                    warning2 += 1;
                }
                if (warning2 == 1) {
                    if (contador3 % 100 == 0) {
                        world.scena2.maluco.orientation *= -1;
                        world.scena2.maluco.runing = false;
                        warning2 = 9;
                        contador3 = 0;
                    }
                }
                contador3++;

            }
            if (warning2 == 9 && world.scena2.maluco.deading == false && world.main.ground == true) {
                if ((world.main.x - world.scena2.maluco.x) < 250) {
                    world.scena2.maluco.orientation *= -1;
                    world.scena2.maluco.runing = true;
                    warning2 = 10;
                }
            }
            if (world.scena2.maluco.x < 100 + world.scena2.relativeCoord && world.scena2.maluco.deading == false) {
                world.scena2.maluco.runing = false;

                if (warning != 20) {
                    world.scena2.maluco.orientation *= -1;
                    warning = 20;
                }
                world.scena2.maluco.throwing = true;
            }
        }
        // end 1

        // Items controller
        if (world.main.getRectangle().intersects(world.scena2.coins[0].getEnemi2d()) && world.scena2.coins[0].visible == true && world.pasing == false) {
            if (world.scena2.coins[0].visible) {
                world.sonido.coin.setMicrosecondPosition(0);
                world.sonido.coin.start();
                world.scena2.coins[0].visible = false;
                world.viewLabel.setPoints(50);
            }

        }

        if (world.main.getRectangle().intersects(world.scena2.coins[1].getEnemi2d()) && world.scena2.coins[1].visible == true && world.pasing == false) {

            if (world.scena2.coins[1].visible) {
                world.sonido.coin.setMicrosecondPosition(0);
                world.sonido.coin.start();
                world.viewLabel.setPoints(150);
                world.main.Coining = true;
                world.scena2.coins[1].visible = false;

            }
        }

        if (world.main.getRectangle().intersects(world.scena2.coins[2].getEnemi2d()) && world.scena2.coins[2].visible == true) {
            if (world.scena2.coins[2].visible) {
                world.sonido.coin.setMicrosecondPosition(0);
                world.sonido.coin.start();
                world.viewLabel.setPoints(25);
                world.main.Coining = true;
                world.scena2.coins[2].visible = false;

            }

        }
        if (world.main.getRectangle().intersects(world.scena2.life.getEnemi2d()) && world.scena2.life.visible == true && world.pasing == false) {
            if (world.scena2.life.visible) {
                world.sonido.coin.setMicrosecondPosition(0);
                world.sonido.coin.start();
                world.viewLabel.setLive(50);
                world.scena2.life.visible = false;
            }

        }
        if (world.main.getRectangle().intersects(world.scena2.Kunai.getEnemi2d()) && world.scena2.Kunai.visible == true && world.pasing == false) {
            if (world.scena2.Kunai.visible) {
                world.sonido.live.setMicrosecondPosition(0);
                world.sonido.live.start();
                world.viewLabel.addKunai(5);
                world.main.Coining = true;
                world.scena2.Kunai.visible = false;

            }
        }
    }

}
