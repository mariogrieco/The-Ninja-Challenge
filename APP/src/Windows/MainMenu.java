package Windows;

import Entities.SaveData;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Esta clase coordina las acciones de cargar y empezar o cargar partida
 * unicamente
 *
 * @author: Mario Josue Grieco Villamizar Universidad Nacional Experimental del
 * Tachira
 * @version: 0.1
 */
public class MainMenu extends JPanel {
    
    /**
     * setea las acciones con un timer que sirve como delay ya no se usa casi
     */
    Timer main;
    /**
     * world siendo un LevelController necesario por uno de los metodos
     */
    Make world;

    /**
     * contenedor del boton de carga
     */
    JLabel cargarBTN;
    /**
     * imagen del contenedor correspondiente
     */
    ImageIcon cargar;

    /**
     * contenedor del boton de iniciar
     */
    JLabel iniciarBTN;
    /**
     * imagen del contenedor correspondiente
     */
    ImageIcon iniciar;
    /**
     * contenedor del boton de cheats
     */
    JLabel cheatsBTN;
    /**
     * imagen del contenedor correspondiente
     */
    ImageIcon cheats;
    /**
     * contenedor del boton de ayuda
     */
    JLabel aiudaBTN;
    /**
     * imagen del contenedor correspondiente
     */
    ImageIcon aiuda;
    /**
     * contenedor del boton de salida
     */
    JLabel exitBTN;
    /**
     * imagen del contenedor correspondiente
     */
    ImageIcon exit;
    /**
     * utilizado para cargar partida
     */
    SaveData gameS;

    /**
     * bloquea la cantidad de click a uno solo
     */
    public boolean cargado = false;
    /**
     * contador reservado para el timer
     */
    int contador = 0;

    JLabel fonditoConteiner;
    ImageIcon fondito;
    /**
     * Constructor
     * @param world el controlador del momento
    */
    
    public MainMenu(Make world) {
        int x = 35;
        this.world = world;
        cargarBTN = new JLabel();
        iniciarBTN = new JLabel();
        cheatsBTN = new JLabel();
        aiudaBTN = new JLabel();
        exitBTN = new JLabel();
        fonditoConteiner = new JLabel();

        try {
            cargar = new ImageIcon(ImageIO.read(new File("src/inicio/charge0.png")));
            iniciar = new ImageIcon(ImageIO.read(new File("src/inicio/start0.png")));
            aiuda = new ImageIcon(ImageIO.read(new File("src/inicio/help0.png")));
            exit = new ImageIcon(ImageIO.read(new File("src/inicio/exit0.png")));
            fondito = new ImageIcon(ImageIO.read(new File("src/inicio/fondito.png")));

        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        fonditoConteiner.setIcon(fondito);
//        fonditoConteiner.setName("c");
        fonditoConteiner.setSize(fondito.getIconWidth(), fondito.getIconHeight());
        fonditoConteiner.setLocation(0,0);
        fonditoConteiner.setFocusable(false);
        fonditoConteiner.setVisible(true);
        
        cargarBTN.setIcon(cargar);
        cargarBTN.setName("c");
        cargarBTN.setSize(cargar.getIconWidth(), cargar.getIconHeight());
        cargarBTN.setLocation(Screem.width / 2 - cargar.getIconWidth() / 2-x, 200);
        cargarBTN.setFocusable(false);
        cargarBTN.setVisible(true);
        cargarBTN.addMouseListener(new MainAction());

        iniciarBTN.setIcon(iniciar);
        iniciarBTN.setName("i");
        iniciarBTN.setLocation(Screem.width / 2 - iniciar.getIconWidth() / 2 -x, 200 + cargar.getIconHeight() + 10);
        iniciarBTN.setSize(iniciar.getIconWidth(), iniciar.getIconHeight());
        iniciarBTN.setFocusable(false);
        iniciarBTN.setVisible(true);
        iniciarBTN.addMouseListener(new MainAction());

        aiudaBTN.setIcon(aiuda);
        aiudaBTN.setName("a");
        aiudaBTN.setLocation(Screem.width / 2 - aiuda.getIconWidth() / 2 -x, 200 + cargar.getIconHeight() + iniciar.getIconHeight() + 10 + 10);
        aiudaBTN.setSize(aiuda.getIconWidth(), aiuda.getIconHeight());
        aiudaBTN.setFocusable(false);
        aiudaBTN.setVisible(true);
        aiudaBTN.addMouseListener(new MainAction());

        exitBTN.setIcon(exit);
        exitBTN.setName("e");
        exitBTN.setLocation(Screem.width / 2 - exit.getIconWidth() / 2 -x, 200 + aiuda.getIconHeight() + cargar.getIconHeight() + iniciar.getIconHeight() + 10 + 10 + 10);
        exitBTN.setSize(exit.getIconWidth(), exit.getIconHeight());
        exitBTN.setFocusable(false);
        exitBTN.setVisible(true);
        exitBTN.addMouseListener(new MainAction());
        

       
        super.add(cargarBTN);
        super.add(iniciarBTN);
        super.add(aiudaBTN);
        super.add(exitBTN);
         super.add(fonditoConteiner);
         
        super.setLayout(null);
        super.setLocation(0, 0);
        super.setFocusable(false);
        super.setSize(Screem.width, Screem.heigth);
        super.setBackground(Color.WHITE);
        super.setVisible(true);

    }

    class MainAction implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("Windows.MainMenu.MainAction.mousePressed()");
            gameS = new SaveData();
            if (e.getComponent().getName().equals("c")) {
                gameS.readSaveData();
                int x = gameS.getScene();
                if (x > 1) {
                    world.cargar(x);
                } else if (x == 1) {
                    world.initGame(1);
                } else {
                    JOptionPane.showMessageDialog(null, "NO EXISTEN PARTIDAS GUARDADAS!");
                }

            }
            if (e.getComponent().getName().equals("i")) {

                if (cargado == false) {
                    world.initGame(7);
                    cargado = true;
                }
            }
            if (e.getComponent().getName().equals("a")) {
                JOptionPane.showMessageDialog(null, "Instrucciones de juego");
                JOptionPane.showMessageDialog(null, "Para caminar usa las flechas direccionales");
                JOptionPane.showMessageDialog(null, "Puedes tirar kunais con la tecla K ( tienes un limite)");
                JOptionPane.showMessageDialog(null, "Para deslizarte y escapar de las cierras presiona c mientras corres");
                JOptionPane.showMessageDialog(null, "Para saltar con espacio");
                JOptionPane.showMessageDialog(null, "para bajar de las escaleras mantener precionado la flecha para abajo y igual para subir");
                JOptionPane.showMessageDialog(null, "Tienes 2 niveles cada uno de 4 escenas");
                JOptionPane.showMessageDialog(null, "Juego Creado por mario grieco 2do semestre");
            }
            if (e.getComponent().getName().equals("e")) {
                System.exit(0);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

}
