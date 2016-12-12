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

public class Scena7Controller implements ActionListener {

    /**
     * Necesita el controlador principal de niveles
     *
     * @see ScenasWorld
     */
    public LevelsController world;

    /**
     * si ocurre algun hit el enimigo correra dependiendo de este estado
     */
    int salvarse = 0;
    /**
     * cuando y cuantas veces en el tiempo se inicializa la escena
     */
    public int init1 = 0;
    /**
     * cuando y cuantas veces en el tiempo se inicializa la escena
     */
    public int init2 = 0;
    /**
     * cuando el enemigo esta corriendo
     */
    int correr = 0;
    /**
     * cuando el enemigo esta corriendo y debe defender
     */
    int defendd = 12;
    /**
     * cuando cambia el tipo de ataque del enemigo
     */
    int initK = 0;
    /**
     * cuando el enemigo esta dando hits al main cuanto es lo maximo de vida que
     * le quitara
     */
    int hits = 0;

    int hitsBl = 0;
    int hitsAtLeft = 0;
    /**
     * cuando el enemigo esta dando puntos al main cuanto es lo maximo que le
     * dara
     */
    int maxHits = 0;
    /**
     * cuando el enemigo esta dando puntos al main cuanto es lo maximo que le
     * dara
     */
    int setPoint = 0;

    /**
     * cuando el enemigo esta muerto dejan de funcionar algunas cosas
     *
     * @see ScenasController.Scena8Controller para mas
     */
    public boolean muerto = false;

    /**
     * Constructor de la escena
     *
     * @param world permite crear uno de los atributos
     */
    public Scena7Controller(LevelsController world) {
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
        if (init1 == 0) {
            world.enemi7deap = false;
            world.sceneNumber = 7;
            world.tiempo.start();
            world.tiempo.restart();
            world.viewLabel.enemiLive.setVisible(true);
            world.scena2.maluco.timer.setDelay(12);
            world.scena2.maluco.timer.restart();
            world.scena2.maluco.deading = false;
            world.scena2.maluco.ground = false;
            world.scena2.maluco.x = Screem.width + world.scena7.relativeCoord - 300;
            world.scena2.maluco.y = -10;

            init1 = 1;
        }

        if (world.scena2.maluco.deading == false) {
            if (world.main.x > Screem.width + world.scena7.relativeCoord - 140 && world.sceneNumber == 7) {
                world.main.x = Screem.width + world.scena7.relativeCoord - 220;
                world.main.runing = false;
                if (init1 == 1) {
                    world.scena2.maluco.timer.stop();
                    JOptionPane.showMessageDialog(null, "MATA AL ENEMIGO PARA CONTINUAR!");
                    world.scena2.maluco.timer.start();
                }
                init1 = 2;
            }
            if (world.main.x < world.scena7.relativeCoord - 20 && world.sceneNumber == 7) {
                world.main.x = world.scena7.relativeCoord + 20;
                world.main.runing = false;
                if (init2 == 0) {
                    world.main.timer.stop();
                    world.scena2.maluco.timer.stop();
                    JOptionPane.showMessageDialog(null, "MATA AL ENEMIGO PARA regresar!");
                    world.main.timer.start();
                    world.scena2.maluco.timer.start();
                }
                init2 = 2;
            }
        }
        if (world.main.ground == false) {
            if (world.scena7.getRectangle(1).intersects(world.main.getRectangle())) {
                world.main.ground = true;
            }

        }

        //Ataques
        if (world.scena2.maluco.kunai.getRectangle().intersects(world.main.getRectangle()) && world.scena7.enemi.deading == false) {
            world.viewLabel.setLive2(2);

            if (initK == 0) {
                world.viewLabel.addKunai(1);
                initK = 2;
            }

            if (world.main.hurt.isRunning() == false) {
                world.main.hurt.setMicrosecondPosition(0);
                world.main.hurt.start();
            }
            world.main.sangre.x = world.scena2.maluco.kunai.x;
            world.main.sangre.y = world.scena2.maluco.kunai.y;;
            world.main.bloading = true;
            hits++;
            if (correr != 1 && hits > 10) {
                correr = 1;
            }
            if (world.viewLabel.acumLive <= 0) {
                world.main.deading = true;
            }

        } else {
            initK = 0;
            hits = 0;
        }

        if (world.main.kunai.getRectangle().intersects(world.scena2.maluco.getRectangle()) && world.scena7.enemi.deading == false) {
            if (maxHits < 4) {
                world.viewLabel.setEnemiLive(5);
            } else {
                maxHits = 0;
            }
            maxHits++;
            defendd = 0;
            if (world.main.hurt.isRunning() == false) {
                world.main.hurt.setMicrosecondPosition(0);
                world.main.hurt.start();
            }
            world.scena2.maluco.sangre.x = world.main.kunai.x;
            world.scena2.maluco.sangre.y = world.main.kunai.y;;
            world.scena2.maluco.bloading = true;
        }

        if (world.viewLabel.enemiAcumLive <= 0 && setPoint == 0) {
            world.scena2.maluco.deading = true;
            world.enemi7deap = true;
            muerto = true;
            world.viewLabel.setPoints2(25);
            world.viewLabel.enemiLive.setVisible(false);
            setPoint = 1;
        }

        //LITLE IA
        int main = (int) (world.main.x - world.scena7.relativeCoord);
        int enemigo = (int) (world.scena2.maluco.x - (world.scena7.relativeCoord));
        world.viewLabel.enemiLive.setLocation(enemigo, (int) world.scena2.maluco.y - 50);

        if (world.scena2.maluco.getRectangle().intersects(world.scena7.getRectangle(1))) {
            world.scena2.maluco.ground = true;
        }

        if (world.main.getRectangle().intersects(world.scena2.maluco.getRectangle())) {
            correr = 1;
        }

        if (world.scena7.enemi.deading == false && muerto == false && world.main.deading == false) {
            if (world.scena2.maluco.sliding == false) {
                if (world.main.x - world.scena2.maluco.x < 0) {
                    // main a la izqerfa

                    if (enemigo - main <= 200 && world.scena2.maluco.orientation == -1 && world.main.sliding == false && correr != 1 || defendd == 0) {
                        if (world.scena2.maluco.orientation == -1) {
                            world.scena2.maluco.orientation = 1;
                        }
                        world.scena2.maluco.runing = true;
                        world.scena2.maluco.kunai.y = -1000;
                        salvarse = 0;
                        defendd = 1;
                    }
                }
                if (world.main.x - world.scena2.maluco.x > 0) {
                    // main a la derecha

                    if (main - enemigo <= 200 && world.scena2.maluco.orientation == 1 && world.main.sliding == false || correr == 1 || defendd == 0) {
                        if (world.scena2.maluco.orientation == 1) {
                            world.scena2.maluco.orientation = -1;
                        }
                        world.scena2.maluco.runing = true;
                        world.scena2.maluco.kunai.y = -1000;
                        if (world.scena2.maluco.instantiate) {
//                                world.scena2.maluco.kunai.orientation = 1;
                        }
                        world.scena2.maluco.throwing = false;
                        salvarse = 0;
                        correr = 0;
                        defendd = 1;
                    }

                }

                // para de correr 
                if (salvarse != 0) {
                    if (world.main.x - world.scena2.maluco.x < 0) {
                        // main a la izqerfa

                        if (enemigo - main <= 450 && world.scena2.maluco.orientation == -1) {
                            world.scena2.maluco.runing = false;
                        }
                    }
                    if (world.main.x - world.scena2.maluco.x > 0) {
                        // main a la derecha

                        if (main - enemigo <= 450 && world.scena2.maluco.orientation == 1) {
                            world.scena2.maluco.runing = false;
                        }

                    }
                }

                //cuando pega
                if (salvarse != 0) {
                    if (world.main.x - world.scena2.maluco.x < 0 && world.main.sliding == false) {
                        // main a la izqerfa

                        if (enemigo - main <= 300 && world.scena2.maluco.orientation == -1) {
                            world.scena2.maluco.runing = false;
                            if (hitsAtLeft % 2 == 0) {
                                world.scena2.maluco.throwing = true;
                            }
                            hitsBl = 0;
                        }
                    }
                    if (world.main.x - world.scena2.maluco.x > 0) {
                        // main a la derecha
                        hitsAtLeft++;
                        if (main - enemigo <= 300 && world.scena2.maluco.orientation == 1) {
                            world.scena2.maluco.runing = false;
                            world.scena2.maluco.throwing = true;
                            if (hitsBl == 0) {
//                                hitsAtLeft++;   
                            }
                            hitsBl = 1;
                        }

                    }
                }

                // regresa al salir de la pantalla
                if (world.scena2.maluco.x > Screem.width + world.scena7.relativeCoord) {
                    world.scena2.maluco.x = world.scena7.relativeCoord;
                    world.scena2.maluco.orientation = 1;
                    salvarse = 1;
                }
                if (world.scena2.maluco.x < world.scena7.relativeCoord - 100) {
                    world.scena2.maluco.x = Screem.width + world.scena7.relativeCoord;
                    world.scena2.maluco.orientation = -1;
                    salvarse = 1;
                }

            }
        }
    }

}
