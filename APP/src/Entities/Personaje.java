
package Entities;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Esta Clase ES PARA EL PERSONAJE PRINCIPAL determina el intervalo de los tiempos del personaje
 * su estados corriendo, saltando, cayendo etc
 * el estado de su animacion 
 * la imagen que se imprimira
 * si instancia el objeto kunai
 * @author: Mario Josue Grieco Villamizar
 * Universidad Nacional Experimental del Tachira
 * @version: 0.1
 * @see Entities
 */
public class Personaje implements MainController {
     /**
     *  publica coordenada x en memoria ( no necesariamente en la pantalla o el view) del personaje
     */
    public double x;
         /**
     *  publica coordenada y en memoria ( no necesariamente en la pantalla o el view) del personaje
     */
    public double y;

         /**
     *  publica ancho del personaje
     */
    public double w;
         /**
     *  publica alto del personaje
     */
    public double h;
    
         /**
     *  publica cuanto se desplazara en pixeles en los intervalos de animacion en milisegundos
     */
    public int desplazamiento = 7;

     /**
     *  publica otorga al gameView de la clase levelcontroller la vida del personaje
     */
    protected int vida;

     /**
     * Coleccion de imagenes de IDLE (QUIETO)
     */
    public Image IDLE[];
    /**
     * Coleccion de imagenes de RUN (CORRIENDO)
     */
    public Image RUN[];
    /**
     * Coleccion de imagenes de CLIMB(ESCALANDO O EN LA LIANA)
     */
    public Image Climb[];
       /**
     * Coleccion de imagenes de DEAD (MURIENDO)
     */
    public Image Dead[];
       /**
     * Coleccion de imagenes de GLIDE (CAYENDO CON PARACAIDAS)
     */
    public Image Glide[];
       /**
     * Coleccion de imagenes de JJUMP (SALTANDO)
     */
    public Image JUMP[];
       /**
     * Coleccion de imagenes de SLIDE (DESLIZANDOCE)
     */
    public Image SLIDE[];
       /**
     * Coleccion de imagenes de THROW (LANZANDO EL KUNAI), NO SE INSTANCIARA SINO HASTA EL ESTADO NECESARIO
     */
    public Image THROW[];
       /**
     * Coleccion de imagenes de JUMPINGTHROW (LANZANDO EL KUNAI MIENSTRAS SALTA)
     */
    public Image JUMPINGTHROW[];
    
     /**
     * Determina si el personaje esta saltando y lanzando el kunai cual sera el numero de la imagen a mostrar
     */
    public int jumpingThwow;
     /**
     * Determina si el personaje esta lanzando unicamente ,el kunai cual sera el numero de la imagen a mostrar
     */
    public int throwState;
         /**
     * Determina si el personaje esta corriendo cual sera el numero de la imagen a mostrar
     */
    public int run;
         /**
     * Determina si el personaje quieto cual sera el numero de la imagen a mostrar
     */
    public int idle;
         /**
     * Determina si el personaje esta escalando cual sera el numero de la imagen a mostrar
     */
    public int climb;
    public int dead;
         /**
     * Determina si el personaje esta muerto cual sera el numero de la imagen a mostrar
     */
    public int glide;
         /**
     * Determina si el personaje esta saltando cual sera el numero de la imagen a mostrar
     */
    public int jump;
         /**
     * Determina si el personaje se esta deslizando cual sera el numero de la imagen a mostrar
     */
    public int slide;

         /**
     * Determina si el personaje esta saltando y lanzando no sale aun el kunai!
     */
    public boolean jumpingThrowing;
         /**
     * Determina si el personaje esta saltando no sale aun el kunai!
     */
    public boolean throwing;
     /**
     * Determina si el personaje escalendo
     */
    public boolean climbing;    
    /**
     * Determina si el personaje muerto
     */
    public boolean deading;
         /**
     * Determina si el personaje cayendo con el paracaidas
     */
    public boolean gliding;
         /**
     * Determina si el personaje esta corriendo
     */
    public boolean runing;
         /**
     * Determina si el personaje esta quieto
     */
    public boolean idling;
         /**
     * Determina si el personaje esta en la liana
     */
    public boolean liana;
         /**
     * Determina si el personaje esta saltando
     */
    public boolean jumping;
         /**
     * Determina si el personaje esta saliendo de la liana
     */
    public boolean saliendo_liana;
         /**
     * Determina si el personaje esta tocando el suelo
     */
    public boolean ground;
         /**
     * Determina si el personaje se esta deslizando
     */
    public boolean sliding;
         /**
     * Determina si el personaje a instaciado el kunai
     */
    public boolean instantiate;
         /**
     * Determina si el personaje esta muerto y sale la pantalla game over necesario para evitar problemas de la primera version
     */
    public boolean gameOver;
         /**
     * Determina si el personaje esta subiendo en la escalera
     */
    public boolean subiendo;
         /**
     * Determina si el personaje esta bajando en la escalera
     */
    public boolean bajando;
         /**
     * Determina si el personaje se encuentra en el tope de la subida
     */
    public boolean onTop = false;
         /**
     * Determina que se bloquean algunas funciones del personaje
     */
    public boolean block = false;
         /**
     * Determina si el persinaje se encuentra columpiandoce
     */
    public boolean lianing = false;
         /**
     * Determina si el personaje esta saltando de la liana
     */
    public boolean jumpingLianing = false;
         /**
     * Determina si el personaje esta tocando el agua
     */
    public boolean inWater = false;
         /**
     * Determina si el personaje esta sangreando
     */
    public boolean bloading = false;
         /**
     * Determina si el esta en la escalera de tal manera que puede bajar
     */
    public boolean onClian2 = false;

     /**
     * Clase kunai 
     * @see Items
     */
    public Kunai kunai;
    
     /**
     * CONTADOR RESERVADO PARA UNA DE LAS ANIMACIONES
     */
    public int contador;
        /**
     * timer RESERVADO PARA UNA DE LAS ANIMACIONES
     */
    public Timer timer;
    
    public boolean notfound = true;
        /**
     * se encuentra de tal manera en la escalera que podria bajar
     */
    public boolean puedeBajar = false;
        /**
     * esta tocando un coin ( el no lo desaparece)
     */
    public boolean Coining = false;
    public boolean livi = false;

     /**
     * CONTADOR RESERVADO PARA UNA DE LAS ANIMACIONES
     */
    int contador4;
        /**
     * CONTADOR RESERVADO PARA UNA DE LAS ANIMACIONES
     */
    int contador3;
    /**
     * 1 si mira a la derecha -1 a la izquierda
     */
    public int orientation;

    int to;
        /**
     * CONTADOR RESERVADO PARA UNA DE LAS ANIMACIONES
     */
    int contador2;
        /**
     * CONTADOR RESERVADO PARA UNA DE LAS ANIMACIONES
     */
    int contadorLianing = 1;
        /**
     * puede subir la escalera parcialmente
     */
    public boolean onClian;
    int cont = 12;
        /**
     * @see Items
     * sangre del personaje
     */
    public Blood sangre;

    // sonido 
      /**
     * @see AudioSystem
     * sonido para la animacion caminar
     */
    Clip caminar;
      /**
     * @see AudioSystem
     * sonido para la animacion hurt
     */
    public Clip hurt;
          /**
     * @see AudioSystem
     * sonido para la animacion saltar
     */
    Clip jumpSound;
          /**
     * @see AudioSystem
     * sonido para la animacion dead
     */
    public Clip deadSound;
    
    Clip Kunai[];
    
    int soundKstate = 0;
     /**
     * CONTADOR RESERVADO PARA UNA DE LAS ANIMACIONES
     */
    int contador5;
              /**
     * @see AudioSystem
     * sonido para la animacion slice
     */
    Clip bookFlip;

     /**
     * 
     * publico, Constructor del personaje por defecto No usado, no se puede usar
     *  
     */
    public Personaje() {
        super();
    }
     /**
     * 
     * publico, Constructor  parametrico del personaje
     * @param  xx coordenada en x no necesariamente del view
     * @param yy coordenada en y no necesariamente del view
     * @param ww ancho
     * @param hh alto
     *  
     */
    public Personaje(double xx, double yy, double ww, double hh) {

        Kunai = new Clip[3];

        try {
            Kunai[0] = AudioSystem.getClip();
            Kunai[1] = AudioSystem.getClip();
            Kunai[2] = AudioSystem.getClip();
            Kunai[0].open(AudioSystem.getAudioInputStream(new File("src/sonidos/drawKnife3.wav")));
            Kunai[1].open(AudioSystem.getAudioInputStream(new File("src/sonidos/drawKnife2.wav")));
            Kunai[2].open(AudioSystem.getAudioInputStream(new File("src/sonidos/drawKnife1.wav")));
            caminar = AudioSystem.getClip();
            caminar.open(AudioSystem.getAudioInputStream(new File("src/sonidos/footstep09.wav")));
            bookFlip = AudioSystem.getClip();
            bookFlip.open(AudioSystem.getAudioInputStream(new File("src/sonidos/bookFlip2.wav")));
            
            hurt = AudioSystem.getClip();
            jumpSound = AudioSystem.getClip();
            deadSound = AudioSystem.getClip();
            
            hurt.open(AudioSystem.getAudioInputStream(new File("src/sonidos/hurt.wav")));
            jumpSound.open(AudioSystem.getAudioInputStream(new File("src/sonidos/jump.wav")));
            deadSound.open(AudioSystem.getAudioInputStream(new File("src/sonidos/dead.wav")));;
            
           

        } catch (LineUnavailableException ex) {
            Logger.getLogger(Personaje.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Personaje.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Personaje.class.getName()).log(Level.SEVERE, null, ex);
        }

        sangre = new Blood((int) xx, (int) yy);
        kunai = new Kunai();
        kunai.h = 11;
        kunai.w = 56;

        IDLE = new Image[10];
        RUN = new Image[10];
        Climb = new Image[10];
        Dead = new Image[10];
        Glide = new Image[10];
        JUMP = new Image[10];
        SLIDE = new Image[10];
        THROW = new Image[10];
        JUMPINGTHROW = new Image[10];

        jumpingThwow = 0;
        throwState = 0;
        run = 0;
        idle = 0;
        climb = 0;
        dead = 0;
        glide = 0;
        jump = 0;
        slide = 0;

        contador = 1;
        contador3 = 1;
        to = 1;
        contador2 = 1;
        contador4 = 1;
        contador5 = 1;

        orientation = 1;

        onClian = false;
        jumpingThrowing = false;
        instantiate = false;
        throwing = false;
        ground = false;
        saliendo_liana = false;
        runing = false;
        idling = true;
        liana = false;
        jumping = false;
        climbing = false;
        deading = false;
        gliding = false;
        sliding = false;
        gameOver = false;
        subiendo = false;
        bajando = false;

        this.x = xx;
        this.y = yy;
        this.w = ww;
        this.h = hh;

        for (int i = 0; i < 10; i++) {
            try {
                THROW[i] = ImageIO.read(new File("src/Entities/NINJA/lanzando/Throw" + i + ".png"));
            } catch (IOException ex) {
                System.out.println("Error al cargar el lanzando coso");
            }
        }

        for (int i = 0; i < 10; i++) {
            try {
                JUMPINGTHROW[i] = ImageIO.read(new File("src/Entities/NINJA/lanzando/JumpThrow" + i + ".png"));
            } catch (IOException ex) {
                System.out.println("Error al cargar el lanzando coso de jumping");
            }
        }

        for (int i = 0; i < 10; i++) {
            try {
                IDLE[i] = ImageIO.read(new File("src/Entities/NINJA/IDLE/IDLE" + i + ".png"));
            } catch (IOException ex) {
                System.out.println("Eror al cargar imagen idle" + (i) + ".png");
            }
        }
        for (int i = 0; i < 10; i++) {
            try {
                RUN[i] = ImageIO.read(new File("src/Entities/NINJA/RUN/RUN" + i + ".png"));
            } catch (IOException ex) {
                System.out.println("Eror al cargar imagen RUN" + (i) + ".png");
            }
        }

        for (int i = 0; i < 10; i++) {
            try {
                Climb[i] = ImageIO.read(new File("src/Entities/NINJA/Climb/Climb" + i + ".png"));
            } catch (IOException ex) {
                System.out.println("Eror al cargar imagen Climb" + (i) + ".png");
            }
        }

        for (int i = 0; i < 10; i++) {
            try {
                Dead[i] = ImageIO.read(new File("src/Entities/NINJA/Dead/Dead" + i + ".png"));
            } catch (IOException ex) {
                System.out.println("Eror al cargar imagen Dead" + (i) + ".png");
            }
        }

        for (int i = 0; i < 10; i++) {
            try {
                Glide[i] = ImageIO.read(new File("src/Entities/NINJA/Glide/Glide" + i + ".png"));
            } catch (IOException ex) {
                System.out.println("Eror al cargar imagen Glide" + (i) + ".png");
            }
        }

        for (int i = 0; i < 10; i++) {
            try {
                JUMP[i] = ImageIO.read(new File("src/Entities/NINJA/JUMP/JUMP" + i + ".png"));
            } catch (IOException ex) {
                System.out.println("Eror al cargar imagen JUMP" + (i) + ".png");
            }
        }

        for (int i = 0; i < 10; i++) {
            try {
                SLIDE[i] = ImageIO.read(new File("src/Entities/NINJA/SLIDE/SLIDE" + i + ".png"));
            } catch (IOException ex) {
                System.out.println("Eror al cargar imagen SLIDE" + (i) + ".png");
            }
        }

        timer = new Timer(25, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // ANIMACIONES
                // relentiza acomodar!    

                // sinido debe estar primero 
                if ( jumping && gliding == false ) {
                    if ( jumpSound.isRunning() == false){
                        jumpSound.setMicrosecondPosition(0);
                        jumpSound.loop(Clip.LOOP_CONTINUOUSLY);
                    }
                } else{
                    jumpSound.stop();
                }
                
                if ( sliding ) {
                    if (bookFlip.isRunning() == false) {
                        if (bookFlip.isRunning() == true) {
                            bookFlip.stop();
                            bookFlip.setMicrosecondPosition(0);
                        }
                        bookFlip.setMicrosecondPosition(0);
                        bookFlip.loop(Clip.LOOP_CONTINUOUSLY);
                    }
                }else{
                    bookFlip.stop();
                }
                if (runing && jumping == false && gliding == false && sliding == false) {
                    if (caminar.isRunning() == false) {
//                        caminar.loop(Clip.LOOP_CONTINUOUSLY);
                    }
                } else {
                    caminar.stop();
                }

                if (throwing) {
                    if ( Kunai[soundKstate].isRunning() == false) {
                        Kunai[soundKstate].setMicrosecondPosition(0);
                        Kunai[soundKstate].loop(Clip.LOOP_CONTINUOUSLY);
                    }
                } else {
                    Kunai[soundKstate].stop();
                    if (soundKstate + 1 < 3) {
                        soundKstate++;
                    } else {
                        soundKstate = 0;
                    }
                }

                // Animation states! no movimientos!
                if (!bloading) {
                    sangre.State = 0;
                }

                if (bloading && inWater == false) {
//                    sangre.x = (int) x*orientation;
//                    sangre.y = (int)y;

                    if (sangre.State + 1 < 6) {
                        sangre.State += 1;
                    } else {
                        sangre.State = 0;
                        bloading = false;
                    }
                }
                if ((climbing && subiendo) || (climbing && bajando)) {
                    if (climb + 1 <= 9) {
                        climb += 1;
                    } else {
                        climb = 0;
                    }
                }
                
                if (instantiate) {
                    contador2++;
                    kunai.x += 10 * kunai.orientation;
                    if (contador2 % 10 == 0) {
                        kunai.y = -10000;
                        instantiate = false;
                        contador2 = 1;
                    }
                }

                if ((jumpingThrowing)) {
                    if (contador4 == 1) {
                        jumpingThwow = 0;
                        kunai.orientation = orientation;
                        kunai.y = (int) getRectangle().getCenterY();
                        kunai.x = (int) (getRectangle().getCenterX() + (50 * kunai.orientation));
                    }
                    if (contador4 % 4 == 0) {
                        if (jumpingThwow + 1 <= 9) {
                            jumpingThwow += 1;
                            if (jumpingThwow == 3) {
                                instantiate = true;
                            }
                        } else {
                            jumpingThwow = 9;
                            jumpingThrowing = false;
                            contador4 = 1;
                        }

                    } else {
                        contador4++;
                    }
                }
                if (throwing && jumping == false) {
                    contador2 = 0;
                    if (contador == 1) {
                        throwState = 0;
                        kunai.orientation = orientation;
                        kunai.y = (int) getRectangle().getCenterY();
                        kunai.x = (int) (getRectangle().getCenterX() + (50 * kunai.orientation));
                    }
                    if (contador % 3 == 0) {
                        if (throwState + 1 <= 9) {
                            throwState += 1;
                            if (throwState == 3) {
                                instantiate = true;
                            }
                        } else {
                            throwState = 0;
                            throwing = false;
                            contador = 1;
                        }
                    } else {
                        contador++;
                    }
                }

                if (sliding) {
                    idling = false;
                    if (slide + 1 <= 9) {
                        slide += 1;
                    } else {
                        slide = 0;
                    }
                    contador += 1;
                    if (contador % 10 == 0) {
                        contador = 0;
                        sliding = false;
                    }
                }

                if (deading) {
                    idling = false;
                    runing = false;
                    gliding = false;

                    if (dead + 1 <= 9) {
                        dead += 1;
                        gameOver = true;
                    }
                }

                if (runing) {
                    idling = false;
                    if (run + 1 <= 9) {
                        run += 1;
                    } else {
                        run = 0;
                    }
                }
                if (gliding && climbing == false && subiendo == false && bajando == false && block == false) {
                    idling = false;
                    if (glide + 1 <= 9) {
                        glide += 1;
                    } else {
                        glide = 0;
                    }
                }
                if (jumping && jumpingThrowing == false) {
                    contador2++;

                    if (contador2 % 4 == 0) {
                        idling = false;
                        if (jump + 1 <= 9) {
                            jump += 1;
                        } else {
                            jump = 0;
                        }
                        contador2 = 0;
                    }

                }
                // MOVIMIENTO
                if ((climbing && subiendo)) {
                    y -= 8;
                }
                if ((climbing && bajando) && notfound == false) {
                    y += 8;
                }

                if (runing && jumping == false) {
                    if (block) {
                        x += (orientation * 8);
                    } else {
                        x += (orientation * 5);
                    }

                }

                if (runing && jumping && gliding == false) {
                    x += (orientation * desplazamiento);
                }
                if (block && jumping == false && ground == false) {
                    runing = false;
                }
                if (jumping == true) {
                    ground = true;
                    y -= 10;
                    contador++;
                    if (contador % 15 == 0) {
                        jumping = false;
                        ground = false;
                        contador = 1;
                        jump = 0;
                    }

                }
                if (ground == false) {
                    if (block) {
                        y += 5;
                    } else {
                        y += 2;
                    }

                    //AK
                    if (deading == false) {
                        if (block == false) {
                            gliding = true;
                            idling = false;
                        } else {

                            idling = true;

                        }

                    }
                }
                if (ground) {
                    gliding = false;
                    if (runing == false && jumping == false && deading == false && throwing == false) {
                        idling = true;
                    }
                }
                if (sliding) {
                    x += 3 * orientation;
                }

                if (jumpingLianing) {
                    x += 10 * orientation;
                    y -= 14;
                    if (contadorLianing % 10 == 0) {

                        jumpingLianing = false;
                        contadorLianing = 1;
                        block = !block;
                    }
                    contadorLianing++;
                }

            }

        }
        );
    }

     /**
     * 
     * Metodo que retorna solo la interseccion para el personaje para permitir interaccion en pantalla del view
     *  
     * @return return new Rectangle2D.Double(this.x + 35, this.y, this.w - 70, this.h);
     */
    public Rectangle2D getRectangle() {
        return new Rectangle2D.Double(this.x + 35, this.y, this.w - 70, this.h);
    }
}
