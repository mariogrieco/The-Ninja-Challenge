package Windows;

import Entities.Personaje;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.Timer;

/**
 * Esta clase el controlador general y el menu de inicio y carga
 * 
 * determina cuando esta cargando y que escena iniciar pausa
 * esta incluye todos los keyListener del personaje principal
 *
 * @author: Mario Josue Grieco Villamizar Universidad Nacional Experimental del
 * Tachira
 * @version: 0.1
 */
public class Make extends JFrame implements Screem {
/**
 *  el controllador principal
 */
    public LevelsController controller;
    /**
 *  no usado
 */
    public Toolkit tols;
    /**
 * Se carga el menu secundario
 */
    public MenuSecundario menu;
    /**
 * una clave para los cheats aun no se usa
 */
    public String password;
    /**
 * carga el game view ( la vida el pantalla los coins etc..)
 */
    public GameView gameView;
    /**
 * carga el panel para cuando muera
 */
    public GameOver DeadPanel;
    /**
 * Menu de inicio
 */
    MainMenu menus;
/**
 * IMAGEN DE CARGA
 */
    ImageIcon CARGA;
    /**
 * Contenedor de la imagen de carga
 */
    JLabel fondo;
    /**
 * Controllador de timer del KeyListerner
 */
    public Timer main;
    /**
 * Icon para el gif de carga
 */
    Icon icon;
        /**
 * url para el gif de carga
 */
     URL url;
    
    int contador;
    int contadorI = 0;
    
        /**
 * Determina cuando se carga o no ina partida
 * @param x a cual escena ir
 */
    public void cargar(int x){
        initGame(x);
        controller.setInitLevel(x);
       
    }
    
        /**
 * determina cuando empieza de 0 el juego
 * @param level 0 por defecto
 */
    public void initGame(int level){
        controller.controllerTimer.start();
        controller.main.timer.start();
       
        super.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (controller.blockEntry == false) {

                    if (controller.main.lianing) {
                        controller.main.lianing = false;
                        controller.main.jumpingLianing = true;
                        controller.main.ground = false;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_LEFT && controller.main.deading == false) {
                        controller.main.orientation = -1;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT && controller.main.deading == false) {
                        controller.main.orientation = 1;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_C) {
                        if (controller.main.runing == true && controller.main.gliding == false) {
                            controller.main.sliding = true;
                        }
                    }
                    if ( /*controller.Make.climbing == false && */ e.getKeyCode() == KeyEvent.VK_LEFT && controller.main.ground && controller.main.deading == false || (controller.main.gliding && e.getKeyCode() == KeyEvent.VK_LEFT) && controller.main.deading == false) {
                        if ( controller.main.climbing) {
                            controller.main.climbing = false;
                            controller.main.ground = false;
                        }
                        controller.main.idling = false;
                        controller.main.runing = true;
                    }

                    if ((/*controller.Make.climbing == false && */e.getKeyCode() == KeyEvent.VK_RIGHT && controller.main.ground && controller.main.deading == false) || (controller.main.gliding && e.getKeyCode() == KeyEvent.VK_RIGHT) && controller.main.deading == false) {
                        if ( controller.main.climbing) {
                            controller.main.climbing = false;
                            controller.main.ground = false;
                        }
                        controller.main.runing = true;
                        controller.main.idling = false;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_SPACE && controller.main.ground && controller.main.deading == false && controller.main.throwing == false) {
                        controller.main.jumping = true;
                        controller.main.climbing = false;
                        controller.main.idling = false;

                    }
                    if (gameView.kunakeLength > 0 && e.getKeyCode() == KeyEvent.VK_K && controller.main.jumping == false && controller.main.gliding == false && controller.main.deading == false && controller.main.throwing == false && controller.main.instantiate == false) {
                        controller.main.runing = false;
                        controller.main.idling = false;
                        controller.main.gliding = false;
                        controller.main.throwing = true;
                        gameView.panel.repaint();
                        gameView.setKani(1);
                    }
                    if (gameView.kunakeLength > 0 && e.getKeyCode() == KeyEvent.VK_K && controller.main.jumping == true && controller.main.gliding == false && controller.main.deading == false && controller.main.jumpingThrowing == false && controller.main.instantiate == false) {
                        controller.main.idling = false;
                        controller.main.gliding = false;
                        controller.main.throwing = false;
                        controller.main.jumpingThrowing = true;
                        gameView.panel.repaint();
                        gameView.setKani(1);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_M && controller.main.gameOver == false) {
                        controller.main.runing = false;
                        if ( menu.panel.isVisible() == false) {
                            controller.main.timer.stop();
                            controller.controllerTimer.stop();
                            controller.wordlPaint.stop();
                            controller.tiempo.stop();
                            menu.panel.setVisible(true);
                        } else {
                            menu.panel.setVisible(false);
                            controller.main.timer.start();
                            controller.controllerTimer.start();
                            controller.tiempo.start();
                            controller.wordlPaint.start();
                        }

                    }
                    if ( controller.sceneNumber == 2 && e.getKeyCode() == KeyEvent.VK_UP && controller.main.onClian && /**
                             * controller.main.gliding == false &&*
                             */
                        controller.main.runing == false && controller.main.sliding == false) {
                        controller.main.subiendo = true;
                        controller.main.climbing = true;
                        controller.main.gliding = false;
                        controller.main.ground = true;
                        controller.main.runing = false;
                    }
//                    else if (controller.Make.climbing && controller.Make.onTop == false) {
//                        controller.Make.subiendo = false;
//                        controller.Make.climbing = false;
//                        controller.Make.ground = false;
//                    }
                    if ( controller.sceneNumber == 2 && e.getKeyCode() == KeyEvent.VK_DOWN && controller.main.onClian2 ) {
                        controller.main.bajando = true;
                        controller.main.climbing = true;
                        controller.main.onTop = false;
                        controller.main.gliding = false;
                        controller.main.ground = true;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT && controller.main.deading == false) {
                    if (controller.main.idling == false) {
                        controller.main.runing = false;
                        controller.main.idling = true;
                        controller.main.run = 0;
                    }
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT && controller.main.deading == false) {
                    if (controller.main.idling == false) {
                        controller.main.runing = false;
                        controller.main.idling = true;
                        controller.main.run = 0;
                    }

                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    controller.main.subiendo = false;
                }
                
                if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
                        controller.main.bajando = false;
               }
                // jumping false from controller personaje
            }
        });
        getContentPane().remove(menus);
        super.setContentPane(controller);
        super.add(menu.panel);
        super.add(gameView.panel);
        super.add(DeadPanel.panel);
        
    }
    
        /**
 * constructor no confundir con el metodo main de java
 */
    public Make() {
             JOptionPane.showMessageDialog(null, "Juego Creado por Mario Josue Grieco Villamizar ci 26205981");
             JOptionPane.showMessageDialog(null, "El codigo en github licencia Apache 2.0");
             JOptionPane.showMessageDialog(null, "mariojosuexz@gmail.com");
             JOptionPane.showMessageDialog(null, "UNET - segundo semestre");
             JOptionPane.showMessageDialog(null, "7/12/216");
        try {
            icon = new ImageIcon((new File("src/inicio/carga.gif")).toURI().toURL());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Make.class.getName()).log(Level.SEVERE, null, ex);
        }
        menus = new MainMenu(this);
        fondo = new JLabel(icon);
        
//        fondo.setIcon(CARGA);
        fondo.setName("f");
        fondo.setForeground(Color.red);
        fondo.setLocation(0,0);
        fondo.setSize(Screem.width,Screem.heigth);
        fondo.setFocusable(false);
        fondo.setVisible(true);
        fondo.setFont(new Font("tipe 2", Font.BOLD, 16));
        
                
        super.getContentPane().setBackground(new Color(21,25,31));
        
        super.setUndecorated(true);
        super.setSize(width, heigth);
//        super.setSize(icon.getIconWidth(),icon.getIconHeight());
        super.setLayout(null);

        super.setLocationRelativeTo(null);
//        menus = new MainMenu(this);
//        super.add(menus);
//        super.setVisible(true);
        super.getContentPane().add(fondo);
        super.setVisible(true);
//        Make.start();
        main = new Timer(50,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( contadorI > 4 ) {
                    System.out.println(".actionPerformed()");
//                    setLocationRelativeTo(menus);
                    setSize(width, heigth);
                    getContentPane().remove(fondo);
                    getContentPane().add(menus);
                    repaint();
                    contadorI =0;
                    main.stop();
                }
                contadorI++;
            }
        });
        
        gameView = new GameView();
        DeadPanel = new GameOver();
        controller = new LevelsController(width, heigth, gameView, DeadPanel,1);
        controller.controllerTimer.stop();
        controller.main.timer.stop();
        menu = new MenuSecundario(controller, gameView,this);

    }

            /**
 * metodo principal de java
 * @param args texto de ingreso
 */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Make APP = null;
        try{
            APP = new Make();
        }catch(OutOfMemoryError err){
            JOptionPane.showMessageDialog(null, "HEAD INSUFICIENTE INTENTA CORRER CON EL COMANDO -Xmx1024M");
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        
//        APP.initGame(WIDTH);
        APP.main.start();
    }

    void callMain() {
        controller = null;
        
        Make.main(null);
    }

}
