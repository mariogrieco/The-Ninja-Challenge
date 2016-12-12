/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Esta clase define los recursos necesarios para la animacion de la sangre del personaje se basa en  y usa los mismos metodos
 * @see Entities.Personaje
 * @author: Mario Josue Grieco Villamizar
 * Universidad Nacional Experimental del Tachira
 * @version: 0.1
 * @see Entities
 */
public class PersonajeEnemi implements MainController {

    public double x;
    public double y;

    public double w;
    public double h;

    protected int vida;

    public int speed = 25;
    public Image IDLE[];
    public Image RUN[];
    public Image Climb[];
    public Image Dead[];
    public Image Glide[];
    public Image JUMP[];
    public Image SLIDE[];
    public Image THROW[];
    public Image JUMPINGTHROW[];

    public int jumpingThwow;
    public int throwState;
    public int run;
    public int idle;
    public int climb;
    public int dead;
    public int glide;
    public int jump;
    public int slide;

    public boolean jumpingThrowing;
    public boolean throwing;
    public boolean climbing;
    public boolean deading;
    public boolean gliding;
    public boolean runing;
    public boolean idling;
    public boolean liana;
    public boolean jumping;
    public boolean saliendo_liana;
    public boolean ground;
    public boolean sliding;
    public boolean instantiate;
    public boolean gameOver;
    public boolean bloading = false;

    public Kunai kunai;
    public int contador;
    public Timer timer;

    int contador4;
    int contador3;
    int contador5 = 1;
    int contadorK = 1;

    public Blood sangre;

    public int orientation;

    int to;
    int contador2;

    public PersonajeEnemi() {
        super();
    }

    public PersonajeEnemi(double xx, double yy, double ww, double hh) {

        kunai = new Kunai();
        kunai.h = 11;
        kunai.w = 56;
        sangre = new Blood((int) xx, (int) yy);

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

        orientation = 1;

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

        this.x = xx;
        this.y = yy;
        this.w = ww;
        this.h = hh;

        for (int i = 0; i < 10; i++) {
            try {
                THROW[i] = ImageIO.read(new File("src/level1/s2/enemies/Throw/Throw" + i + ".png"));
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
                IDLE[i] = ImageIO.read(new File("src/level1/s2/enemies/idle/Idle__00" + i + ".png"));
            } catch (IOException ex) {
                System.out.println("Eror al cargar imagen idle" + (i) + ".png");
            }
        }
        for (int i = 0; i < 10; i++) {
            try {
                RUN[i] = ImageIO.read(new File("src/level1/s2/enemies/RUN/Run__00" + i + ".png"));
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
                Dead[i] = ImageIO.read(new File("src/level1/s2/enemies/Dead/Dead__00" + i + ".png"));
            } catch (IOException ex) {
                System.out.println("Eror al cargar imagen Dead" + (i) + ".png");
            }
        }

        for (int i = 0; i < 10; i++) {
            try {
                Glide[i] = ImageIO.read(new File("src/level1/s2/enemies/Glide/Glide_00" + i + ".png"));
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

        timer = new Timer(speed, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // ANIMACIONES
                // relentiza acomodar!    
                
                if (instantiate) {
                    kunai.x += 23 * kunai.orientation;
                    if (contadorK > 10 ) {
                        kunai.y = -10000;
                        instantiate = false;
                        contador5 = 1;
                         contadorK = 0;
                    }
                    contadorK++;
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
                if (throwing && jumping == false && instantiate == false) {
                    if (contador == 1) {
                        throwState = 0;
                        contador5 = 0;
                        kunai.orientation = orientation;
                        kunai.y = (int) getRectangle().getCenterY();
                        kunai.x = (int) (getRectangle().getCenterX() + (50 * kunai.orientation));
                    }
                    if (contador % 3 == 0) {
                        if (throwState + 1 <= 9) {
                            throwState += 1;
                            if (throwState == 1) {
                                instantiate = true;
                            }
                        } else {
                            throwState = 9;
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
                if (gliding) {
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
                if (runing && jumping == false) {
                    x += (orientation * 5);
                }

                if (runing && jumping && gliding == false) {
                    x += (orientation * 7);
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
                    y += 9;
                    //AK
                    if (deading == false) {
                        gliding = true;
                        idling = false;
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
                // Animation states! no movimientos!
                if (!bloading) {
                    sangre.State = 0;
                }

                if (bloading) {
//                    sangre.x = (int) x*orientation;
//                    sangre.y = (int)y;

                    if (sangre.State + 1 < 6) {
                        sangre.State += 1;
                    } else {
                        sangre.State = 0;
                        bloading = false;
                    }
                }
            }

        }
        );
    }

    public Rectangle2D getRectangle() {
        return new Rectangle2D.Double(this.x + 35, this.y, this.w - 70, this.h);
    }
}
