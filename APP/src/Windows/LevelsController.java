/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;

import Entities.Liana;
import Entities.Personaje;
import Entities.SaveData;
import Entities.Sounds;
import ScenasController.Scena1Controller;
import ScenasController.Scena2Controller;
import ScenasController.Scena3Controller;
import ScenasController.Scena4Controller;
import ScenasController.Scena5Controller;
import ScenasController.Scena6Controller;
import ScenasController.Scena7Controller;
import ScenasController.Scena8Controller;
import ScenasWorld.Scena1World;
import ScenasWorld.Scena2World;
import ScenasWorld.Scena3World;
import ScenasWorld.Scena4World;
import ScenasWorld.Scena5World;
import ScenasWorld.Scena6World;
import ScenasWorld.Scena7World;
import ScenasWorld.Scena8World;
import static Windows.Screem.heigth;
import static Windows.Screem.width;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Esta clase determina cual escena inicia dependiando de carga o nueva partida
 * crea la transsion entre las mismas activa o desectiva los controladores de
 * cada escena elimina los controladores de cada ecena determina cuando muuere y
 * el personaje pierde una vida mueve el panel de vida coins y kunas de manera
 * animada bloque la entrada por teclado cuando se encuentra la transicion de
 * escena esta clase coloca en pantalla con coordenadas relativas los objetos
 * como el indicador de la vida, los puntos el nombre de personje la cantidad de
 * kunais creacion manual de los componentes de la escena establece coordenadas
 * y rectangulos de interseccion
 *
 * @author: Mario Josue Grieco Villamizar Universidad Nacional Experimental del
 * Tachira
 * @version: 0.1
 */
public class LevelsController extends JPanel implements Screem {

    Runtime garbage;
    public JLabel cargando;
    ImageIcon icon;

    /**
     * Timer donde ira de manera alternada por escena el controllador de cada
     * escena
     */
    public Timer controllerTimer;

    /**
     * Pinta el mundo es un loop
     */
    public Timer wordlPaint;

    /**
     * controllador de escena
     */
    public Scena1World scena1 = null;
    /**
     * controllador de escena
     */
    public Scena2World scena2 = null;
    ;
    /**
     * controllador de escena
     */
    public Scena3World scena3 = null;
    ;
    /**
     * controllador de escena
     */
    public Scena4World scena4 = null;
    ;
    /**
     * controllador de escena
     */
    public Scena5World scena5 = null;
    ;
    /**
     * controllador de escena
     */
    public Scena6World scena6 = null;
    ;
    /**
     * controllador de escena
     */
    public Scena7World scena7 = null;
    ;
    /**
     * controllador de escena
     */
    public Scena8World scena8 = null;
    ;
    /**
     * controllador de escena
     */

    /**
     * Carga el personaje Principal con coordenadas
     */
    public Personaje main;

    /**
     * controllador de la altira del suelo ( se esta eliminando su
     * implementacion)
     */
    public int groundInt;
    /**
     * que se impriman los cuadros de interseccion
     */
    public boolean developerMode = false;
    /**
     * que se muestre el mensaje de game over
     */
    public GameOver gameOver;
    /**
     * Contaodr usado para la animacion de transsicon
     */
    int contador = 1;
    /**
     * Contaodr usado para la animacion de transsicon
     */
    int contador2 = 1;
    /**
     * el panel de objetos como vida puntos tiempos..
     */
    public GameView viewLabel;
    /**
     * Contaodr usado para la animacion de transsicon
     */
    public int movements = 0;
    /**
     * Numero de escena en la cual se encuentra activo el personaje
     */
    public int sceneNumber = 1;
    /**
     * El controllador se encuentra cargado con la escena
     */
    boolean level1start = false;
    /**
     * El controllador se encuentra cargado con la escena
     */
    boolean level2start = false;
    /**
     * El controllador se encuentra cargado con la escena
     */
    boolean level3start = false;
    /**
     * El controllador se encuentra cargado con la escena
     */
    boolean level4start = false;
    /**
     * El controllador se encuentra cargado con la escena
     */
    boolean level5start = false;
    /**
     * El controllador se encuentra cargado con la escena
     */
    boolean level6start = false;
    /**
     * El controllador se encuentra cargado con la escena
     */
    boolean level7start = false;
    /**
     * El controllador se encuentra cargado con la escena
     */
    boolean level8start = false;
    /**
     * Se esta moviendo o esta ocurriendo la transcion
     */

    public boolean moving = false;

    /**
     * Se esta bloqueando la entrada por teclado 
     */
    public boolean blockEntry = false;
    /**
     * se bloquea el movimiento horizontal de los paneles
     */
    boolean blockgo = false;
    /**
     * Ultima vida recordada del personaje
     */
    int lastLive = 0;
    /**
     * Tiempo transcurrido
     */
    public Timer tiempo;
    /**
     * Se segundos que an pasado
     */
    public int segundos = 0;
    /**
     * reservado para la animacion( contador)
     */
    int l = 0;
    /**
     * reservado para la animacion ( contador)
     */
    int set2 = 0;
    /**
     * reservado para la animacion ( contador)
     */
    int bloqueader = 0;
    /**
     * rel nivel en el que se encuentra
     */
    public int levelCount = 1;
    /**
     * esta pasado la escena
     */
    public boolean pasing = false;

    public boolean enemi7deap = true;
    /**
     * para cargar en el controllador priceipal el controllador de esta escena
     */
    Scena1Controller c1;

    /**
     * para cargar en el controllador priceipal el controllador de esta escena
     */
    Scena2Controller c2;

    /**
     * para cargar en el controllador priceipal el controllador de esta escena
     */
    Scena3Controller c3;

    /**
     * para cargar en el controllador priceipal el controllador de esta escena
     */
    Scena4Controller c4;

    /**
     * para cargar en el controllador priceipal el controllador de esta escena
     */
    Scena5Controller c5;

    /**
     * para cargar en el controllador priceipal el controllador de esta escena
     */
    Scena6Controller c6;

    /**
     * para cargar en el controllador priceipal el controllador de esta escena
     */
    Scena7Controller c7;

    /**
     * para cargar en el controllador priceipal el controllador de esta escena
     */
    Scena8Controller c8;

    /**
     * AGREGADO EXTRA ATRIBUTO REQUERIDO DE LA CLASE
     */
    public Sounds sonido;

    /**
     * Nombre del perosnaje
     */
    public String name = null;

    /**
     * Contenedor del Nombre del perosnaje
     */
    public JLabel nameConteiner = null;

    /**
     * Modificador para la version estable error del head en 1024m para abajo
     */
    int lastEscene = 1;

    // Unidad A desplazar
    /**
     * Constructor parametrico
     *
     * @param x ancho
     * @param y alto
     * @param viewLabel panel de vida coins tiempo
     * @param panel panel que se mostrara al morrir el personaje
     * @param initInt escena de origen el la que empezara
     */
    public LevelsController(int x, int y, final GameView viewLabel, GameOver panel, int initInt) {

        try {
            icon = new ImageIcon((new File("src/loading.gif")).toURI().toURL());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Make.class.getName()).log(Level.SEVERE, null, ex);
        }

        cargando = new JLabel(icon);
        cargando.setLocation(width / 2 - icon.getIconWidth() / 2, heigth / 2 - icon.getIconHeight() / 2);
        cargando.setVisible(false);
        cargando.setSize(icon.getIconWidth(), icon.getIconHeight());
        cargando.setFocusable(false);
        garbage = Runtime.getRuntime();
        name = JOptionPane.showInputDialog("Ingresa un nombre de juegador", "SASUKINI");
        nameConteiner = new JLabel(name + "");
        nameConteiner.setSize(300, 100);
        nameConteiner.setLocation(0, 0);
        nameConteiner.setFocusable(false);
        nameConteiner.setVisible(true);
        nameConteiner.setForeground(Color.WHITE);
        nameConteiner.setFont(new Font("tipe 2", Font.BOLD, 12));
        sonido = new Sounds();
        this.viewLabel = viewLabel;
        this.viewLabel.saveOption = new SaveData(this);
        gameOver = panel;
        groundInt = heigth - 181;
        main = new Personaje(0, y - (200 * 2), (500 / 3), (500 / 3));

        // modificado en la version estable 
//        scena1 = new Scena1World();
//        scena2 = new Scena2World();
//        scena3 = new Scena3World();
//        scena4 = new Scena4World();
//        scena5 = new Scena5World();
//        scena6 = new Scena6World();
//        scena7 = new Scena7World();
//        scena8 = new Scena8World();
// modificacion
        c1 = new Scena1Controller(this);
        c2 = new Scena2Controller(this);
        c3 = new Scena3Controller(this);
        c4 = new Scena4Controller(this);
        c5 = new Scena5Controller(this);
        c6 = new Scena6Controller(this);
        c7 = new Scena7Controller(this);
        c8 = new Scena8Controller(this);
        refreshEscene(1);
        lastLive = viewLabel.determineLive();

        super.setLayout(null);
        super.add(nameConteiner);
        super.add(cargando);
        super.setBackground(Color.WHITE);
//        viewLabel.acumLive = (99999);
        controllerTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        // la vida lok?
//             viewLabel.setLive2(1);
//        setInit(1);       // nuevo y requerido
        setInitLevel(initInt);  // para cargar partida

        contador = 0;

        wordlPaint = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameConteiner.setLocation((int) main.x + 50, (int) main.y - 50);

                if (sceneNumber != 7 && sceneNumber < 7) {
                    c7.init1 = 0;
                }
                if (sceneNumber != 1) {
                    c1.init = 0;
                }
                if (main.x < 0) {
                    main.runing = false;
                    main.x = 100;
                }
                if (sceneNumber == 5) {
                    tiempo.start();
                }

                if (levelCount == 1) {
                    sonido.ambiente.loop(Clip.LOOP_CONTINUOUSLY);
                    sonido.ambiente2.setMicrosecondPosition(0);
                    sonido.ambiente2.stop();
                    sonido.boos.stop();

                } else if (sceneNumber < 7 && sceneNumber > 4) {
                    sonido.ambiente.setMicrosecondPosition(0);
                    sonido.ambiente.stop();
                    sonido.ambiente2.loop(Clip.LOOP_CONTINUOUSLY);
                    sonido.boos.stop();
                }
                if (sceneNumber >= 7) {
                    sonido.ambiente2.stop();
                    sonido.ambiente.stop();
                    sonido.boos.loop(Clip.LOOP_CONTINUOUSLY);
                }

                if (sceneNumber > 4) {
                    levelCount = 2;
                }
                if (sceneNumber <= 4) {
                    levelCount = 1;
                }
                if (lastLive > viewLabel.determineLive() && viewLabel.acumLive > 0 && sceneNumber > 1 && sceneNumber < 7 && main.deading == false) { // main ground! deap false v2
                    main.climbing = false;
                    main.subiendo = false;
                    main.bajando = false;
                    main.sliding = false;
                    main.throwing = false;
                    main.jumpingThrowing = false;
                    blockEntry = true;
                    pasing = true;
                    main.y = (heigth / 2) - 65;
                    if (l == 0) {
                        l++;
                        moving = true;
                        main.y = 100;
                        blockEntry = true;
                    }

                    if (movements + 10 <= 0) {
                        movements += 10;
                        main.x -= 10;
                        main.gliding = true;
                        main.block = false;
                        blockEntry = true;
                        viewLabel.setRelative((-10));
                        if (movements * -1 <= width * (sceneNumber - 2)) {
                            sceneNumber--;
                            refreshEscene(sceneNumber);
                        }
                    } else if (l != 0) {
                        sceneNumber = 1;
                        l = 0;
                        lastLive--;
                        level1start = false;
                        level2start = false;
                        level3start = false;
                        level4start = false;
                        level5start = false;
                        level6start = false;
                        level7start = false;
                        level8start = false;

                        main.ground = false;
                        moving = false;
                        blockEntry = true;
                        if (main.y > heigth - 181 - main.h || main.y < heigth / 2) {
                            main.y = heigth - 181 - main.h;
                            blockEntry = false;
                        }

                        removeActions();
//                        setInit(1);
                        sceneNumber = 1;
                        level1start = false;
                        hoStart();
                        setInitLevel(1);
//                        main.timer.restart();
                        pasing = false;
                        blockEntry = false;
                    }

//                    blockEntry = false;
                } else if (l != 0) {
                    main.x = 50;
                    main.ground = false;
                    blockEntry = false;
                    pasing = false;
                    l = 0;
                    moving = false;
                    sceneNumber = 1;
                }

                // subiendo
                // VERIFICAR BOSS ULTIMA ACTUALIZACION
                if (enemi7deap == true && moving == false && viewLabel.acumLive > 0) {

                    if (main.x >= (width * sceneNumber) - 150 && movements * -1 <= width * sceneNumber && main.orientation == 1) {
                        viewLabel.enemiLive.setVisible(false);
                        blockEntry = true;
                        movements -= 10;
                        blockgo = false;
                        viewLabel.setRelative(10);
                        main.runing = true;
                        if ((movements * -1)+10 >= width * sceneNumber) {
                            sceneNumber++;
                            main.runing = false;
                            blockEntry = false;
                            refreshEscene(sceneNumber);
                            lastLive = viewLabel.determineLive(); // bug pasa y baja al cambiar vida correguido XD
                            if (main.y > heigth - 181 - main.h) {
                                main.y = heigth - 181 - main.h;
//                                main.ground = false;
                            }
                        }
                    }

                    if (main.x <= (width * sceneNumber) / 2) {
                        blockgo = false;
                    }
                    if (scena3 != null) {
                        if (main.x <= 40 + scena3.relativeCoord) {
                            blockgo = false;
                        }
                    }
                    if (main.x < (width * sceneNumber) + 1 && main.x > width * sceneNumber / 2) {
                        blockgo = false;
                    }

                    // bajando
                    if (main.orientation == -1 && main.x + 15 <= (width * sceneNumber - (width)) && blockgo == false && sceneNumber > 1 && moving == false && viewLabel.acumLive > 0) {
                        viewLabel.enemiLive.setVisible(false);
                        movements += 10;
                        viewLabel.setRelative(-10);
                        blockEntry = true;
                        main.runing = true;
                        if ((movements * -1)+10 <= width * (sceneNumber - 2)) {
                            main.runing = false;
                            sceneNumber--;
                            blockgo = true;
                            blockEntry = false;
                            refreshEscene(sceneNumber);
                            if (main.y > heigth - 181 - main.h) {
                                main.y = heigth - 181 - main.h;
                            }
                            c7.init1 = 0;
                        }
                    }
                }
                repaint();
                hoStart();
            }

        });

        tiempo = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                segundos += 1;
                viewLabel.segundos(segundos);
            }

        });

        wordlPaint.start();
        main.timer.start();
        tiempo.start();
        gameOver.controller = this;
    }

    @Override
    /**
     * Pinta cada sscena que corresponda dependiendo de la transicicon
     *
     * @param g necesario por paint compoent
     */
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = ((Graphics2D) g);
        g2d.translate(movements, 0);

        if (viewLabel.acumLive <= 0) {
            main.deading = true;
        }

        deadAction();
        if (scena1 != null) {
            draw1(g2d);
        }
        if (scena2 != null && scena2.Kunai != null) {
            draw2(g2d);
        }
        if (scena3 != null) {
            draw3(g2d);
        }

        if (scena4 != null) {
            draw4(g2d);
        }

        if (scena5 != null) {
            draw5(g2d);
        }

        if (scena6 != null && scena6.bolaMaluca != null) {
            draw6(g2d);
        }

        if (scena7 != null) {
            draw7(g2d);
        }

        if (scena8 != null) {
            draw8(g2d);
        }
    }

    /**
     * Pinta solo esta escena
     *
     * @param g2d necesario por paint compoent
     */
    public void draw1(Graphics2D g2d) {
        // para imprimir la primera scena y la siguiente inmediata del primer nivel 
        if ((this.sceneNumber == 1 || sceneNumber == 2) || moving) {
            // scena 1
            g2d.drawImage(scena1.fondo[0], (scena1.border[0][0]), scena1.border[0][1], scena1.border[0][2], scena1.border[0][3], this);
            g2d.drawImage(scena1.bolaMaluca.IMG[scena1.bolaMaluca.state], (scena1.bolaMaluca.x) + (scena1.cierra > 0 ? scena1.bolaMaluca.w : 0), scena1.bolaMaluca.y, scena1.bolaMaluca.w * scena1.cierra * -1, scena1.bolaMaluca.h, this);
            g2d.drawImage(scena1.fondo[1], (scena1.border[1][0]), scena1.border[1][1], scena1.border[1][2], scena1.border[1][3], this);;

            if (developerMode == true) {
                g2d.setColor(Color.RED);
                g2d.draw(main.getRectangle());
                g2d.draw(scena1.bolaMaluca.getEnemi2d());
                g2d.draw(scena1.getRectangle(1));
                g2d.draw(scena1.vida.getEnemi2d());
                g2d.draw(scena1.Coins[0].getEnemi2d());
                g2d.draw(scena1.getRectangle(0));

                if (main.throwing) {
                    g2d.draw(main.kunai.getRectangle());
                }
            }
            if (scena1.Coins[0].visible) {
                g2d.drawImage(scena1.Coins[0].IMG[scena1.Coins[0].state], scena1.Coins[0].x, scena1.Coins[0].y, scena1.Coins[0].w, scena1.Coins[0].h, this);
            }
            if (scena1.vida.visible) {
                g2d.drawImage(scena1.vida.IMG[0], scena1.vida.x, scena1.vida.y, scena1.vida.w, scena1.vida.h, this);

            }
            drawMain(g2d);
        }
    }

    /**
     * Pinta solo esta escena
     *
     * @param g2d necesario por paint compoent
     */
    public void draw2(Graphics2D g2d) {
        if (this.sceneNumber == 2 || this.sceneNumber == 1 || sceneNumber == 3 || moving) {

            g2d.drawImage(scena2.fondo[0], (scena2.border[0][0]), scena2.border[0][1], scena2.border[0][2], scena2.border[0][3], this);
            g2d.drawImage(scena2.fondo[1], (scena2.border[1][0]), scena2.border[1][1], scena2.border[1][2], scena2.border[1][3], this);
            g2d.drawImage(scena2.fondo[2], (scena2.border[2][0]), scena2.border[2][1], scena2.border[2][2], scena2.border[2][3], this);
            g2d.drawImage(scena2.fondo[3], (scena2.border[3][0]), scena2.border[3][1], scena2.border[3][2], scena2.border[3][3], this);

            if (scena2.coins[0].visible) {
                g2d.drawImage(scena2.coins[0].IMG[scena2.coins[0].state], scena2.coins[0].x, scena2.coins[0].y, scena2.coins[0].w, scena2.coins[0].h, this);
            }
            if (scena2.coins[1].visible) {
                g2d.drawImage(scena2.coins[1].IMG[scena2.coins[1].state], scena2.coins[1].x, scena2.coins[1].y, scena2.coins[1].w, scena2.coins[1].h, this);
            }
            if (scena2.coins[2].visible) {
                g2d.drawImage(scena2.coins[2].IMG[scena2.coins[2].state], scena2.coins[2].x, scena2.coins[2].y, scena2.coins[2].w, scena2.coins[1].h, this);
            }
            if (scena2.life.visible) {
                g2d.drawImage(scena2.life.IMG[0], scena2.life.x, scena2.life.y, scena2.life.w, scena2.life.h, this);
            }
            if (scena2.Kunai.visible) {
                g2d.drawImage(scena2.Kunai.IMG[0], scena2.Kunai.x, scena2.Kunai.y, scena2.Kunai.w, scena2.Kunai.h, this);

            }

            if (developerMode) {
                g2d.setColor(Color.RED);
                g2d.draw(scena2.getRectangle(0));
                g2d.draw(scena2.getRectangle(1));
                g2d.draw(scena2.maluco.getRectangle());
                g2d.draw(scena2.getRectangle(4));
                g2d.draw(scena2.getRectangle(2));
                g2d.draw(scena2.getRectangle(3));
                g2d.draw(scena2.getRectangle(20));
                for (int i = 0; i < 3; i++) {
                    if (scena2.coins[i].visible) {
                        g2d.draw(scena2.coins[i].getEnemi2d());
                    }
                }
                if (scena2.Kunai.visible) {
                    g2d.draw(scena2.Kunai.getEnemi2d());
                }
                if (scena2.life.visible) {
                    g2d.draw(scena2.life.getEnemi2d());
                }

            }
            drawEnemi(g2d);
            drawMain(g2d);
        }
    }

    /**
     * Pinta solo esta escena
     *
     * @param g2d necesario por paint compoent
     */
    public void draw3(Graphics2D g2d) {
        if (sceneNumber == 3 || this.sceneNumber == 2 || sceneNumber == 4 || moving) {
            g2d.drawImage(scena3.fondo[0], (scena3.border[0][0]), scena3.border[0][1], scena3.border[0][2], scena3.border[0][3], this);
            g2d.drawImage(scena3.fondo[1], (scena3.border[1][0]), scena3.border[1][1], scena3.border[1][2], scena3.border[1][3], this);
            g2d.drawImage(scena3.fondo[2], (scena3.border[2][0]), scena3.border[2][1], scena3.border[2][2], scena3.border[2][3], this);
            g2d.setStroke(new BasicStroke(5));
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawLine(scena3.x, scena3.y, scena3.w, scena3.h);
            g2d.setStroke(new BasicStroke(1));

//            g2d.drawImage(scena3.madera, (int)scena3.lianaRect().getX(), (int)scena3.lianaRect().getY(), (int)scena3.lianaRect().getWidth(),(int)scena3.lianaRect().getHeight(),this);
            if (developerMode) {
                g2d.setColor(Color.RED);
                g2d.draw(scena3.getRectangle(0));
                g2d.draw(scena3.getRectangle(1));
                g2d.draw(scena3.getRectangle(9));
                g2d.draw(scena3.getRectangle(2));
                g2d.draw(scena3.lianaRect());
                g2d.draw(scena3.getRetorno());
            }
            drawMain(g2d);
        }
    }

    /**
     * Pinta solo esta escena
     *
     * @param g2d necesario por paint compoent
     */
    public void draw4(Graphics2D g2d) {
        if (sceneNumber == 4 || sceneNumber == 3 || sceneNumber == 5 || moving) {
            g2d.drawImage(scena4.fondo[0], (scena4.border[0][0]), scena4.border[0][1], scena4.border[0][2], scena4.border[0][3], this);
            g2d.drawImage(scena4.fondo[1], (scena4.border[1][0]), scena4.border[1][1], scena4.border[1][2], scena4.border[1][3], this);
            g2d.drawImage(scena4.fondo[2], (scena4.border[2][0]), scena4.border[2][1], scena4.border[2][2], scena4.border[2][3], this);
            drawMain(g2d);
            g2d.drawImage(scena4.alligator[scena4.alligatorState], (scena4.border[3][0]) + (scena4.cocodriloOrientation > 0 ? 0 : 260), scena4.border[3][1], scena4.border[3][2] * scena4.cocodriloOrientation, scena4.border[3][3], this);
            if (developerMode) {
                g2d.setColor(Color.RED);
                g2d.draw(scena4.getRectangle(0));
                g2d.draw(scena4.getRectangle(1));
                g2d.draw(scena4.getRectangle(2));
                g2d.draw(scena4.getRectangle(3));
                g2d.draw(scena4.getRectangle(9));
            }

        }
    }

    /**
     * Pinta solo esta escena
     *
     * @param g2d necesario por paint compoent
     */
    public void draw5(Graphics2D g2d) {
        if (sceneNumber == 4 || sceneNumber == 5 || moving || sceneNumber == 6 || moving) {
            g2d.drawImage(scena5.fondo[0], (scena5.border[0][0]), scena5.border[0][1], scena5.border[0][2], scena5.border[0][3], this);
            g2d.drawImage(scena5.bolaMaluca[0].IMG[scena5.bolaMaluca[0].state], scena5.bolaMaluca[0].x + (scena5.bolaMaluca[0].orientation < 0 ? scena5.bolaMaluca[2].w : 0), scena5.bolaMaluca[0].y, scena5.bolaMaluca[0].w * scena5.bolaMaluca[0].orientation, scena5.bolaMaluca[0].h, this);
            g2d.drawImage(scena5.bolaMaluca[1].IMG[scena5.bolaMaluca[1].state], scena5.bolaMaluca[1].x + (scena5.bolaMaluca[1].orientation < 0 ? scena5.bolaMaluca[2].w : 0), scena5.bolaMaluca[1].y, scena5.bolaMaluca[1].w * scena5.bolaMaluca[1].orientation, scena5.bolaMaluca[1].h, this);
            g2d.drawImage(scena5.bolaMaluca[2].IMG[scena5.bolaMaluca[2].state], scena5.bolaMaluca[2].x + (scena5.bolaMaluca[2].orientation < 0 ? scena5.bolaMaluca[2].w : 0), scena5.bolaMaluca[2].y, scena5.bolaMaluca[2].w * scena5.bolaMaluca[2].orientation, scena5.bolaMaluca[2].h, this);
            g2d.drawImage(scena5.fondo[1], (scena5.border[1][0]), scena5.border[1][1], scena5.border[1][2], scena5.border[1][3], this);
            if (developerMode) {
                g2d.setColor(Color.RED);
                g2d.draw(scena5.getRectangle(0));
                g2d.draw(scena5.getRectangle(1));
                g2d.draw(scena5.bolaMaluca[0].getEnemi2d());
                g2d.draw(scena5.bolaMaluca[1].getEnemi2d());
                g2d.draw(scena5.bolaMaluca[2].getEnemi2d());
            }

            drawMain(g2d);

        }
    }

    /**
     * Pinta solo esta escena
     *
     * @param g2d necesario por paint compoent
     */
    public void draw6(Graphics2D g2d) {
        if (scena6 != null) {

            if (sceneNumber == 5 || sceneNumber == 6 || sceneNumber == 7 || moving) {
                g2d.drawImage(scena6.fondo[0], (scena6.border[0][0]), scena6.border[0][1], scena6.border[0][2], scena6.border[0][3], this);
                g2d.drawImage(scena6.bolaMaluca[0].IMG[scena6.bolaMaluca[0].state], scena6.bolaMaluca[0].x + (scena6.bolaMaluca[0].orientation > 0 ? scena6.bolaMaluca[0].w : 0), scena6.bolaMaluca[0].y, scena5.bolaMaluca[0].w * scena6.bolaMaluca[0].orientation * -1, scena6.bolaMaluca[0].h, this);
                g2d.drawImage(scena6.bolaMaluca[1].IMG[scena6.bolaMaluca[1].state], scena6.bolaMaluca[1].x + (scena6.bolaMaluca[1].orientation < 0 ? scena6.bolaMaluca[1].w : 0), scena6.bolaMaluca[1].y, scena5.bolaMaluca[1].w * scena6.bolaMaluca[1].orientation, scena6.bolaMaluca[1].h, this);
                g2d.drawImage(scena6.bolaMaluca[2].IMG[scena6.bolaMaluca[2].state], scena6.bolaMaluca[2].x + (scena6.bolaMaluca[2].orientation > 0 ? scena6.bolaMaluca[2].w : 0), scena6.bolaMaluca[2].y, scena5.bolaMaluca[2].w * scena6.bolaMaluca[2].orientation * -1, scena6.bolaMaluca[2].h, this);
//            g2d.drawImage(scena6.bolaMaluca[3].IMG[scena6.bolaMaluca[3].state], scena6.bolaMaluca[3].x+(scena6.bolaMaluca[3].orientation<0?scena6.bolaMaluca[3].w:0), scena6.bolaMaluca[3].y,scena5.bolaMaluca[3].w*scena5.bolaMaluca[3].orientation,scena5.bolaMaluca[3].h,this);

                g2d.drawImage(scena6.fondo[1], (scena6.border[1][0]), scena6.border[1][1], scena6.border[1][2], scena6.border[1][3], this);
                g2d.drawImage(scena6.fondo[2], (scena6.border[2][0]), scena6.border[2][1], scena6.border[2][2], scena6.border[2][3], this);
                g2d.drawImage(scena6.fondo[3], (scena6.border[3][0]), scena6.border[3][1], scena6.border[3][2], scena6.border[3][3], this);
                drawMain(g2d);
                if (developerMode) {
                    g2d.setColor(Color.RED);
                    g2d.draw(scena6.bolaMaluca[0].getEnemi2d());
                    g2d.draw(scena6.bolaMaluca[1].getEnemi2d());
                    g2d.draw(scena6.bolaMaluca[2].getEnemi2d());
                    g2d.draw(scena6.getRectangle(0));
                    g2d.draw(scena6.getRectangle(1));
                    g2d.draw(scena6.getRectangle(2));
                    g2d.draw(scena6.getRectangle(3));
                }
            }
        }
    }

    /**
     * Pinta solo esta escena
     *
     * @param g2d necesario por paint compoent
     */
    public void draw7(Graphics2D g2d) {
        if (sceneNumber == 6 || sceneNumber == 7 || sceneNumber == 8 || moving) {
            g2d.drawImage(scena7.fondo[0], (scena7.border[0][0]), scena7.border[0][1], scena7.border[0][2], scena7.border[0][3], this);
            g2d.drawImage(scena7.fondo[1], (scena7.border[1][0]), scena7.border[1][1], scena7.border[1][2], scena7.border[1][3], this);
            drawMain(g2d);
            drawEnemi(g2d);
            if (developerMode) {
                g2d.setColor(Color.RED);
                g2d.draw(scena7.getRectangle(0));
                g2d.draw(scena7.getRectangle(1));
            }
        }
        c8.init = 0;
    }

    /**
     * Pinta solo esta escena
     *
     * @param g2d necesario por paint compoent
     */
    public void draw8(Graphics2D g2d) {
        if (sceneNumber == 7 || sceneNumber == 8 || moving) {
            g2d.drawImage(scena8.fondo[0], (scena8.border[0][0]), scena8.border[0][1], scena8.border[0][2], scena8.border[0][3], this);
            g2d.drawImage(scena8.fondo[1], (scena8.border[1][0]), scena8.border[1][1], scena8.border[1][2], scena8.border[1][3], this);
            drawMain(g2d);
        }
        if (sceneNumber == 8) {
            g2d.setColor(Color.RED);
            scena8.puntos.setVisible(true);
            scena8.KunaisUsadas.setVisible(true);
            scena8.tiempoTotal.setVisible(true);
            scena8.vidaRestante.setVisible(true);

//            for (int i = 0; i < 11; i++) {
//                scena8.top10[i].setVisible(true);
//                viewLabel.panel.add(scena8.top10[i]);
//            }
            viewLabel.panel.add(scena8.puntos);
            viewLabel.panel.add(scena8.KunaisUsadas);
            viewLabel.panel.add(scena8.tiempoTotal);
            viewLabel.panel.add(scena8.vidaRestante);

        } else {

            for (int i = 0; i < 11; i++) {
                scena8.top10[i].setVisible(false);
            }

            scena8.puntos.setVisible(false);
            scena8.KunaisUsadas.setVisible(false);
            scena8.tiempoTotal.setVisible(false);
            scena8.vidaRestante.setVisible(false);

        }
    }

    /**
     * Pinta soloel enemigo
     *
     * @param g2d necesario por paint compoent
     */
    public void drawEnemi(Graphics2D g2d) {
        if (scena2 != null) {

            if (scena2.maluco.runing && scena2.maluco.jumping == false && scena2.maluco.gliding == false && scena2.maluco.sliding == false && scena2.maluco.throwing == false && scena2.maluco.jumpingThrowing == false) {
                g2d.drawImage(scena2.maluco.RUN[scena2.maluco.run], (int) ((int) scena2.maluco.x + (scena2.maluco.orientation < 0 ? scena2.maluco.w : 0)), (int) scena2.maluco.y, (int) scena2.maluco.w * scena2.maluco.orientation, (int) scena2.maluco.h, this);

            }
            if (scena2.maluco.jumping && scena2.maluco.runing == false && scena2.maluco.gliding == false && scena2.maluco.jumpingThrowing == false) {
                g2d.drawImage(scena2.maluco.JUMP[scena2.maluco.jump], (int) ((int) scena2.maluco.x + (scena2.maluco.orientation < 0 ? scena2.maluco.w : 0)), (int) scena2.maluco.y, (int) scena2.maluco.w * scena2.maluco.orientation, (int) scena2.maluco.h, this);

            }
            if (scena2.maluco.idling && scena2.maluco.runing == false && scena2.maluco.jumping == false && scena2.maluco.gliding == false && scena2.maluco.sliding == false && scena2.maluco.sliding == false && scena2.maluco.throwing == false && scena2.maluco.jumpingThrowing == false) {
                g2d.drawImage(scena2.maluco.IDLE[scena2.maluco.idle], (int) ((int) scena2.maluco.x + (scena2.maluco.orientation < 0 ? scena2.maluco.w : 0)), (int) scena2.maluco.y, (int) scena2.maluco.w * scena2.maluco.orientation, (int) scena2.maluco.h, this);

            }
            if (scena2.maluco.jumping == true && scena2.maluco.runing == true && scena2.maluco.gliding == false && scena2.maluco.sliding == false && scena2.maluco.jumpingThrowing == false) {
                g2d.drawImage(scena2.maluco.JUMP[scena2.maluco.jump], (int) ((int) scena2.maluco.x + (scena2.maluco.orientation < 0 ? scena2.maluco.w : 0)), (int) scena2.maluco.y, (int) scena2.maluco.w * scena2.maluco.orientation, (int) scena2.maluco.h, this);
            }
            if (scena2.maluco.gliding == true && scena2.maluco.runing == true && scena2.maluco.sliding == false) {
                g2d.drawImage(scena2.maluco.Glide[scena2.maluco.glide], (int) ((int) scena2.maluco.x + (scena2.maluco.orientation < 0 ? scena2.maluco.w : 0)), (int) scena2.maluco.y, (int) scena2.maluco.w * scena2.maluco.orientation, (int) scena2.maluco.h, this);
            }
            if (scena2.maluco.gliding == true && scena2.maluco.jumping == false && scena2.maluco.runing == false) {
                g2d.drawImage(scena2.maluco.Glide[scena2.maluco.glide], (int) ((int) scena2.maluco.x + (scena2.maluco.orientation < 0 ? scena2.maluco.w : 0)), (int) scena2.maluco.y, (int) scena2.maluco.w * scena2.maluco.orientation, (int) scena2.maluco.h, this);
            }
            if (scena2.maluco.sliding) {
                g2d.drawImage(scena2.maluco.SLIDE[scena2.maluco.slide], (int) ((int) scena2.maluco.x + (scena2.maluco.orientation < 0 ? scena2.maluco.w : 0)), (int) scena2.maluco.y, (int) scena2.maluco.w * scena2.maluco.orientation, (int) scena2.maluco.h, this);
            }
            if (scena2.maluco.deading) {
                g2d.drawImage(scena2.maluco.Dead[scena2.maluco.dead], (int) ((int) scena2.maluco.x + (scena2.maluco.orientation < 0 ? scena2.maluco.w : 0)), (int) scena2.maluco.y, (int) scena2.maluco.w * scena2.maluco.orientation, (int) scena2.maluco.h, this);
            }
            if (scena2.maluco.throwing) {
                g2d.drawImage(scena2.maluco.THROW[scena2.maluco.throwState], (int) ((int) scena2.maluco.x + (scena2.maluco.orientation < 0 ? scena2.maluco.w : 0)), (int) scena2.maluco.y, (int) scena2.maluco.w * scena2.maluco.orientation, (int) scena2.maluco.h, this);
            }
            if (scena2.maluco.jumpingThrowing && scena2.maluco.gliding == false) {
                g2d.drawImage(scena2.maluco.JUMPINGTHROW[scena2.maluco.jumpingThwow], (int) ((int) scena2.maluco.x + (scena2.maluco.orientation < 0 ? scena2.maluco.w : 0)), (int) scena2.maluco.y, (int) scena2.maluco.w * scena2.maluco.orientation, (int) scena2.maluco.h, this);
            }
            if (scena2.maluco.instantiate) {
                g2d.drawImage(scena2.maluco.kunai.IMG, scena2.maluco.kunai.x + (scena2.maluco.kunai.orientation < 0 ? scena2.maluco.kunai.w : 0), (int) scena2.maluco.kunai.y, (int) scena2.maluco.kunai.w * scena2.maluco.orientation, (int) scena2.maluco.kunai.h, this);
            }
            if (scena2.maluco.bloading) {
                g2d.drawImage(scena2.maluco.sangre.images[scena2.maluco.sangre.State], (int) scena2.maluco.sangre.x + (scena2.maluco.orientation < 0 ? scena2.maluco.sangre.w : 0), scena2.maluco.sangre.y, scena2.maluco.sangre.w * scena2.maluco.orientation, scena2.maluco.sangre.h, this);
            }
            if (developerMode) {
                g2d.setColor(Color.RED);
                g2d.draw(scena2.maluco.getRectangle());
            }
        }
    }

    /**
     * Pinta solo el personaje principal
     *
     * @param g2d necesario por paint compoent
     */
    public void drawMain(Graphics2D g2d) {
        // siempre se debe imprimir
        if (main.climbing) {
            g2d.drawImage(main.Climb[main.climb], (int) ((int) main.x + (main.orientation < 0 ? main.w : 0)), (int) main.y, (int) (main.orientation * main.w), (int) main.h, this);
        }
        if (main.lianing) {
            g2d.drawImage(main.Climb[0], (int) ((int) main.x + (main.orientation < 0 ? main.w : 0)), (int) main.y, (int) (main.orientation * main.w), (int) main.h, this);
        }
        if (main.lianing == false && main.runing && main.jumping == false && main.gliding == false && main.sliding == false && main.throwing == false && main.jumpingThrowing == false) {
            g2d.drawImage(main.RUN[main.run], (int) ((int) main.x + (main.orientation < 0 ? main.w : 0)), (int) main.y, (int) (main.orientation * main.w), (int) main.h, this);
        }
        if (main.lianing == false && main.jumping && main.runing == false && main.gliding == false && main.jumpingThrowing == false) {
            g2d.drawImage(main.JUMP[main.jump], (int) ((int) main.x + (main.orientation < 0 ? main.w : 0)), (int) main.y, (int) (main.orientation * main.w), (int) main.h, this);
        }
        if (main.climbing == false && main.lianing == false && main.idling && main.runing == false && main.jumping == false && main.gliding == false && main.sliding == false && main.sliding == false && main.throwing == false && main.jumpingThrowing == false) {
            g2d.drawImage(main.IDLE[main.idle], (int) ((int) main.x + (main.orientation < 0 ? main.w : 0)), (int) main.y, (int) (main.orientation * main.w), (int) main.h, this);
        }
        if (main.lianing == false && main.jumping == true && main.runing == true && main.gliding == false && main.sliding == false && main.jumpingThrowing == false) {
            g2d.drawImage(main.JUMP[main.jump], (int) ((int) main.x + (main.orientation < 0 ? main.w : 0)), (int) main.y, (int) (main.orientation * main.w), (int) main.h, this);
        }
        if (main.lianing == false && main.climbing == false && main.ground == false && main.gliding == true && main.runing == true && main.sliding == false) {
            g2d.drawImage(main.Glide[main.glide], (int) ((int) main.x + (main.orientation < 0 ? main.w : 0)), (int) main.y, (int) (main.orientation * main.w), (int) main.h, this);
        }
        if (main.lianing == false && main.climbing == false && main.ground == false && main.gliding == true && main.jumping == false && main.runing == false) {
            g2d.drawImage(main.Glide[main.glide], (int) ((int) main.x + (main.orientation < 0 ? main.w : 0)), (int) main.y, (int) (main.orientation * main.w), (int) main.h, this);
        }
        if (main.lianing == false && main.sliding) {
            g2d.drawImage(main.SLIDE[main.slide], (int) ((int) main.x + (main.orientation < 0 ? main.w : 0)), (int) main.y, (int) (main.orientation * main.w), (int) main.h, this);
        }
        if (main.deading) {
            g2d.drawImage(main.Dead[main.dead], (int) ((int) main.x + (main.orientation < 0 ? main.w : 0)), (int) main.y, (int) (main.orientation * main.w), (int) main.h, this);
        }
        if (main.lianing == false && main.throwing) {
            g2d.drawImage(main.THROW[main.throwState], (int) ((int) main.x + (main.orientation < 0 ? main.w : 0)), (int) main.y, (int) (main.orientation * main.w), (int) main.h, this);
        }
        if (main.lianing == false && main.jumpingThrowing && main.gliding == false) {
            g2d.drawImage(main.JUMPINGTHROW[main.jumpingThwow], (int) ((int) main.x + (main.orientation < 0 ? main.w : 0)), (int) main.y, (int) (main.orientation * main.w), (int) main.h, this);
        }

        if (main.lianing == false && main.instantiate) {
            g2d.drawImage(main.kunai.IMG, (int) main.kunai.x + (main.kunai.orientation < 0 ? main.kunai.w : 0), main.kunai.y, main.kunai.w * main.kunai.orientation, main.kunai.h, this);
        }
        if (main.bloading) {
            g2d.drawImage(main.sangre.images[main.sangre.State], (int) main.sangre.x + (main.orientation < 0 ? main.sangre.w : 0), main.sangre.y, main.sangre.w * main.orientation, main.sangre.h, this);
        }
        if (developerMode) {
            g2d.setColor(Color.RED);
            g2d.draw(main.getRectangle());
        }
    }

    /**
     * Determina cual timer remover y cual iniciar
     */
    public void hoStart() {
        if (sceneNumber == 1 && level1start == false) {
            if (controllerTimer != null) {
                controllerTimer.stop();
            }
            removeActions();
            controllerTimer = new Timer(25, c1); // :( necesita el main :(
            main.block = false;
            level1start = true;
            level2start = false;
            level3start = false;
            level4start = false;
            level5start = false;
            level6start = false;
            level7start = false;
            level8start = false;
            controllerTimer.start();
        }
        if (sceneNumber == 2 && level2start == false) {
            if (controllerTimer != null) {
                controllerTimer.stop();
            }
            removeActions();
            controllerTimer = new Timer(25, c2); // :( necesita el main :(
            controllerTimer.start();
            level1start = false;
            level2start = true;
            level3start = false;
            level4start = false;
            level5start = false;
            level6start = false;
            level7start = false;
            level8start = false;
            main.block = false;
            scena2.maluco.timer.start();
            controllerTimer.start();
        }
        if (sceneNumber == 3 && level3start == false) {
            if (controllerTimer != null) {
                controllerTimer.stop();
            }
            removeActions();
            controllerTimer = new Timer(25, c3); // :( necesita el main :(
            main.block = true;
            level1start = false;
            level2start = false;
            level3start = true;
            level4start = false;
            level5start = false;
            level6start = false;
            level7start = false;
            level8start = false;
            controllerTimer.start();
        }
        if (sceneNumber == 4 && level4start == false) {
            if (controllerTimer != null) {
                controllerTimer.stop();
            }
            removeActions();
            controllerTimer = new Timer(25, c4); // :( necesita el main :(
            main.block = false;
            level1start = false;
            level2start = false;
            level3start = false;
            level4start = true;
            level5start = false;
            level6start = false;
            level7start = false;
            level8start = false;

            controllerTimer.start();
        }
        if (sceneNumber == 5 && level5start == false) {

            if (controllerTimer != null) {
                controllerTimer.stop();
            }
            removeActions();
            controllerTimer = new Timer(25, c5); // :( necesita el main :(
            main.block = false;
            level1start = false;
            level2start = false;
            level3start = false;
            level4start = false;
            level5start = true;
            level6start = false;
            level7start = false;
            level8start = false;
            controllerTimer.start();
        }
        if (sceneNumber == 6 && level6start == false) {
            if (controllerTimer != null) {
                controllerTimer.stop();
            }

            removeActions();
            controllerTimer = new Timer(25, c6); // :( necesita el main :(
            main.block = false;
            level1start = false;
            level2start = false;
            level3start = false;
            level4start = false;
            level5start = false;
            level6start = true;
            level7start = false;
            level8start = false;

            controllerTimer.start();
        }
        if (sceneNumber == 7 && level7start == false) {

            if (controllerTimer != null) {
                controllerTimer.stop();
            }

            removeActions();
            controllerTimer = new Timer(25, c7); // :( necesita el main :(
            main.block = false;
            level1start = false;
            level2start = false;
            level3start = false;
            level4start = false;
            level5start = false;
            level6start = false;
            level7start = true;
            level8start = false;

            controllerTimer.start();
        }
        if (sceneNumber == 8 && level8start == false) {

            if (controllerTimer != null) {
                controllerTimer.stop();
            }

            removeActions();
            controllerTimer = new Timer(25, c8); // :( necesita el main :(
            main.block = false;
            level1start = false;
            level2start = false;
            level3start = false;
            level4start = false;
            level5start = false;
            level6start = false;
            level7start = false;
            level8start = true;

            controllerTimer.start();
        }
    }

    public void setInit(int x) {
        refreshEscene(x);
        level1start = false;
        level2start = false;
        level3start = false;
        level4start = false;
        level5start = false;
        level6start = false;
        level7start = false;
        level8start = false;
        gameOver.panel.setVisible(false);
//             viewLabel.acumLive = 150;
        main.deading = false;
        main.gameOver = false;
        main.idling = true;
        viewLabel.barraState = 0;
        viewLabel.livec = 0;
        viewLabel.setLive(140);
        viewLabel.acumLive = 1;

//             viewLabel.determineLive();
        main.x = 50;
        main.y = heigth / 2;
        main.ground = false;
        movements = 0;
        viewLabel.relative = 0;

        viewLabel.panel.setLocation(0, 0);
        repaint();
    }

    /**
     * Determian dondo empezara el personaje Determina cual timer remover y cual
     * iniciar
     *
     * @param x escena a la cual ir
     */
    public void setInitLevel(int x) {
        sceneNumber = x;
        refreshEscene(x);

        if (controllerTimer != null) {
            removeActions();
        }
        movements = width * (sceneNumber - 1) * -1;
        if (moving == false) {
            main.x = (width * (sceneNumber - 1));
        }
        viewLabel.setRelative((width * (sceneNumber - 1)));
        hoStart();
    }

    /**
     * Determina cuando mostrar que el personaje muere
     */
    public void deadAction() {
        if (viewLabel.acumLive <= 0) {
            if (segundos % 3 == 0) {
//                JOptionPane.showMessageDialog(null, "player dead action!");
//                viewLabel.panel.setVisible(false);
                gameOver.panel.setVisible(true);
                repaint();
                scena2 = null;
                System.gc(); // empieza el recolector de basura elimina todo los null
                garbage.gc();

            }
        }
    }

    /**
     * resetea los timer y los controladores
     */
    public void removeActions() {

        if (controllerTimer != null) {
            controllerTimer.removeActionListener(c1);
            controllerTimer.removeActionListener(c2);
            controllerTimer.removeActionListener(c3);
            controllerTimer.removeActionListener(c4);
            controllerTimer.removeActionListener(c5);

            // v2 agregados
            controllerTimer.removeActionListener(c6);
            controllerTimer.removeActionListener(c7);
            controllerTimer.removeActionListener(c8);
        }
        controllerTimer = null;
        System.gc();
        garbage.gc();
    }

    /**
     * Modificacion para los lab de la unet 9/12/2016
     */
    public void refreshEscene(int x) {
//        cargando.setVisible(true);
//        repaint();
//        cargando.setLocation((width*lastEscene)-width/2, heigth/2-icon.getIconHeight()/2);
        // elimina las escenas correspondientes
        repaint();
        if (lastEscene == 1 && x == 1) {
            scena3 = null;
            scena4 = null;
            scena5 = null;
            scena6 = null;
            scena7 = null;
            scena8 = null;
        }
        if (lastEscene == 2 && x == 1) {
            scena3 = null;
            scena4 = null;
            scena5 = null;
            scena6 = null;
            scena7 = null;
            scena8 = null;
        }
        if (lastEscene == 1 && x == 2) {
            scena4 = null;
            scena5 = null;
            scena6 = null;
            scena7 = null;
            scena8 = null;
        }
        if (lastEscene == 2 && x == 3) {
            scena1 = null;
            scena5 = null;
            scena6 = null;
            scena7 = null;
            scena8 = null;
        }
        if (lastEscene == 3 && x == 2) {
            scena4 = null;
            scena5 = null;
            scena6 = null;
            scena7 = null;
            scena8 = null;
        }
        if (lastEscene == 3 && x == 4) {
            scena1 = null;
            scena2 = null;
            scena6 = null;
            scena7 = null;
            scena8 = null;
        }
        if (lastEscene == 4 && x == 3) {
            scena1 = null;
            scena5 = null;
            scena6 = null;
            scena7 = null;
            scena8 = null;
        }
        if (lastEscene == 5 && x == 6) {
            scena1 = null;
            scena2 = null;
            scena3 = null;
            scena4 = null;
            scena8 = null;
        }
        if (lastEscene == 6 && x == 5) {
            scena1 = null;
            scena2 = null;
            scena3 = null;
            scena7 = null;
            scena8 = null;
        }
        if (lastEscene == 7 && x == 8) {
            scena1 = null;
            scena2 = null;
            scena3 = null;
            scena4 = null;
            scena5 = null;
            scena6 = null;
        }
        if (lastEscene == 8 && x == 7) {
            scena1 = null;
            scena2 = null;
            scena3 = null;
            scena4 = null;
            scena5 = null;
            scena6 = null;
        }
        lastEscene = x; // determina cual sera la ultima nueva escena

        System.gc(); // empieza el recolector de basura elimina todo los null
        garbage.gc();
        repaint();
        // carga las escenas correspondientes
        try {

            if (x == 1) {
                if (scena1 == null) {
                    scena1 = new Scena1World();
                    scena1.SetRelativeObjects(0);
                }
                if (scena2 == null) {
                    scena2 = new Scena2World();
                    scena2.SetRelativeObjects(width);
                }
            }
            if (x == 2) {

                if (scena1 == null) {
                    scena1 = new Scena1World();
                    scena1.SetRelativeObjects(0);
                }
                if (scena2 == null) {
                    scena2 = new Scena2World();
                    scena2.SetRelativeObjects(width);
                }
                if (scena3 == null) {
                    scena3 = new Scena3World();
                    scena3.SetRelativeObjects(width * 2);
                }
            }
            if (x == 3) {
                if (scena2 == null) {
                    scena2 = new Scena2World();
                    scena2.SetRelativeObjects(width);
                }
                if (scena3 == null) {
                    scena3 = new Scena3World();
                    scena3.SetRelativeObjects(width * 2);
                }

                if (scena4 == null) {
                    scena4 = new Scena4World();
                    scena4.SetRelativeObjects(width * 3);
                }

            }
            if (x == 4) {
                if (scena3 == null) {
                    scena3 = new Scena3World();
                    scena3.SetRelativeObjects(width * 2);
                }
                if (scena4 == null) {
                    scena4 = new Scena4World();
                    scena4.SetRelativeObjects(width * 3);
                }
                if (scena5 == null) {
                    scena5 = new Scena5World();
                    scena5.SetRelativeObjects(width * 4);
                }
            }

            if (x == 5) {
                if (scena4 == null) {
                    scena4 = new Scena4World();
                    scena4.SetRelativeObjects(width * 3);
                }
                if (scena5 == null) {
                    scena5 = new Scena5World();
                    scena5.SetRelativeObjects(width * 4);
                }
                if (scena6 == null) {
                    scena6 = new Scena6World();
                    scena6.SetRelativeObjects(width * 5);
                }

            }
            System.gc(); // empieza el recolector de basura elimina todo los null
            garbage.gc();
            if (x == 6) {
                scena2 = new Scena2World(); // ESTA MAL PERO EL ENEMIGO ESTA COMO ATRIBUTO DE LA ESCENA 2
                scena2.coins = null;
                scena2.life = null;
                scena2.Kunai = null;
                scena2.fondo = null;
                System.gc(); // empieza el recolector de basura elimina todo los null
                garbage.gc();

                if (scena5 == null) {
                    scena5 = new Scena5World();
                    scena5.SetRelativeObjects(width * 4);
                }
                if (scena6 == null) {
                    scena6 = new Scena6World();
                    scena6.SetRelativeObjects(width * 5);
                }
                if (scena7 == null) {
                    scena7 = new Scena7World();
                    scena7.SetRelativeObjects(width * 6);
                }
            }
            if (x == 7) {
                if (scena6 == null) {
                    scena6 = new Scena6World();
                    scena6.SetRelativeObjects(width * 5);
                }
                if (scena7 == null) {
                    scena7 = new Scena7World();
                    scena7.SetRelativeObjects(width * 6);
                }
                if (scena8 == null) {
                    scena8 = new Scena8World();
                    scena8.SetRelativeObjects(width * 7);
                }

            }
            if (x == 8) {
                scena2 = new Scena2World(); // ESTA MAL PERO EL ENEMIGO ESTA COMO ATRIBUTO DE LA ESCENA 2
                scena2.coins = null;
                scena2.life = null;
                scena2.Kunai = null;
                scena2.fondo = null;
                System.gc(); // empieza el recolector de basura elimina todo los null
                garbage.gc();
                repaint();
                if (scena7 == null) {
                    scena7 = new Scena7World();
                    scena7.SetRelativeObjects(width * 6);
                }
                if (scena8 == null) {
                    scena8 = new Scena8World();
                    scena8.SetRelativeObjects(width * 7);
                }
            }
//            cargando.setVisible(false);
        } catch (OutOfMemoryError err) {
            JOptionPane.showMessageDialog(null, "HEAD INSUFICIENTE INTENTA CORRER CON EL COMANDO -Xmx1024M  donde se tiene el formato -Xmx[mas memoria]");
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        System.gc(); // empieza el recolector de basura elimina todo los null
        garbage.gc();
        repaint();
    }
}
