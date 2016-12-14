/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author mario
 */
public class MenuSecundario extends MenuController implements Screem {

    protected Make reinicio;
    protected JLabel salir;
    protected JLabel guardar;
    protected JLabel continuar;
    public JPanel panel;

    public JPanel sheeatsPanel;

    public JLabel labelMainSpeed;
    public JLabel labelMainGravity;
    public JLabel labelMainRunSpeed;
    public JLabel identifique;

    public JLabel labelWorldSpeed;
    public JLabel worldIdentifique;

    public Image BuferImage;
    public ImageIcon continuarBTN[];
    public ImageIcon salirBTN[];
    public ImageIcon guardarBTN[];
    
    public JLabel developer;
    int x;
    int y;

    public LevelsController controller;
    public GameView gameView;

    public MenuSecundario(LevelsController controller, GameView gameView, Make reinicio) {
        this.reinicio = reinicio;
        this.gameView = gameView;
        this.controller = controller;
        continuarBTN = new ImageIcon[2];
        salirBTN = new ImageIcon[2];
        guardarBTN = new ImageIcon[2];
        for (int i = 0; i < 2; i++) {
            try {
                continuarBTN[i] = new ImageIcon(ImageIO.read(new File("src/Pausa/continue" + (i + 1) + ".png")));
                salirBTN[i] = new ImageIcon(ImageIO.read(new File("src/Pausa/exit" + (i + 1) + ".png")));
                guardarBTN[i] = new ImageIcon(ImageIO.read(new File("src/Pausa/save" + (i + 1) + ".png")));
            } catch (IOException ex) {
                System.out.println("Windows.MenuSecundario.<init>()");
            }
        }

        developer = new JLabel("Modo Desarrollador");
        sheeatsPanel = new JPanel();
        labelMainSpeed = new JLabel("Main Animation Speed:");
        identifique = new JLabel("Main Player:");
        labelMainGravity = new JLabel("Gravity:");
        labelMainRunSpeed = new JLabel("Run Speed:");

        
        developer.setSize(500,50);
        developer.setLocation(width/2-120, 150);
        developer.setFont(new Font("tipe 2", Font.BOLD, 20));
        developer.setFocusable(false);
        developer.setBackground(Color.WHITE);
        developer.setForeground(Color.red);
        developer.setVisible(true); 
        developer.setName("develp");
        developer.addMouseListener(this);
                
        identifique.setSize(120, 25);
        identifique.setLocation(50, 50);
        identifique.setFocusable(false);
        identifique.setVisible(true);

        labelMainRunSpeed.setSize(100, 100);
        labelMainRunSpeed.setLocation(100, 70);
        labelMainRunSpeed.setFocusable(false);
        labelMainRunSpeed.setVisible(true);

        labelMainGravity.setSize(100, 100);
        labelMainGravity.setLocation(100, 60);
        labelMainGravity.setVisible(true);

        labelMainSpeed.setSize(200, 100);
        labelMainSpeed.setFocusable(false);
        labelMainSpeed.setLocation(100, 80);
        labelMainSpeed.setVisible(true);

        worldIdentifique = new JLabel("World Options");
        labelWorldSpeed = new JLabel("World Speed:");

        worldIdentifique.setSize(200, 100);
        worldIdentifique.setLocation(50, 100);
        worldIdentifique.setFocusable(false);
        worldIdentifique.setVisible(true);

        labelWorldSpeed.setSize(200, 100);
        labelWorldSpeed.setLocation(100, 110);
        labelWorldSpeed.setFocusable(false);
        labelWorldSpeed.setVisible(true);

        sheeatsPanel.setLocation(0, (heigth / 2) + (40));
        sheeatsPanel.setSize(width, heigth / 3);
        sheeatsPanel.setLayout(null);
        sheeatsPanel.setBackground(Color.red);
        sheeatsPanel.setFocusable(false);
        sheeatsPanel.add(labelMainSpeed);
        sheeatsPanel.add(labelMainRunSpeed);
        sheeatsPanel.add(labelMainGravity);
        sheeatsPanel.add(identifique);
        sheeatsPanel.add(labelWorldSpeed);
        sheeatsPanel.add(worldIdentifique);
        sheeatsPanel.setVisible(false);

        panel = new JPanel();
        continuar = new JLabel();
        guardar = new JLabel();
        salir = new JLabel();

        x = ((width) / 2) - continuarBTN[0].getIconWidth() / 2;
        y = (heigth / 2) - 110;
        //continuar.setText("CONTINUAR");
        continuar.setName("continuar");
        continuar.setIcon(continuarBTN[0]);
        continuar.setSize(continuarBTN[0].getIconWidth(), continuarBTN[0].getIconHeight());
        continuar.setFocusable(false);
        continuar.setLocation(x, y);
        continuar.setVisible(true);
        continuar.addMouseListener(this);

        //salir.setText("SALIR");
        salir.setName("salir");
        salir.setLocation(x, (y - 55));
        salir.setIcon(salirBTN[0]);
        salir.setSize(salirBTN[0].getIconWidth(), salirBTN[0].getIconHeight());
        salir.setFocusable(false);
        salir.setVisible(true);
        salir.addMouseListener(this);

        //guardar.setText("GUARDAR");
        guardar.setFocusable(false);
        guardar.setName("guardar");
        guardar.setLocation(x, y + 55);
        guardar.setIcon(guardarBTN[0]);
        guardar.setSize(guardarBTN[0].getIconWidth(), guardarBTN[0].getIconHeight());
        guardar.setVisible(true);
        guardar.addMouseListener(this);

        
        panel.setLocation(0, 0);
        panel.setSize(width, heigth);
        panel.setLayout(null);
        panel.setFocusable(false);
        panel.setBackground(new Color(12, 12, 12, 125));
        panel.add(developer);
        panel.add(salir);
        panel.add(guardar);
        panel.add(continuar);
        panel.add(sheeatsPanel);
        panel.setVisible(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        if (e.getComponent().getName() == continuar.getName()) {
            continuar.setIcon(continuarBTN[1]);

        }
        if (e.getComponent().getName() == salir.getName()) {
            salir.setIcon(salirBTN[1]);
        }
        if (e.getComponent().getName() == guardar.getName()) {
            guardar.setIcon(guardarBTN[1]);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getComponent().getName().equals("develp")) {
            if ( controller.developerMode == false) {
                JOptionPane.showMessageDialog(null, "Version de desarrollador Activada!");
                controller.developerMode = true;
            }
            else if ( controller.developerMode == true) {
                JOptionPane.showMessageDialog(null, "Version de desarrollador Desectivada!");
                controller.developerMode = false;
            }
            controller.tiempo.restart();

        }
                
        if (e.getComponent().getName() == continuar.getName()) {
            continuar.setIcon(continuarBTN[0]);
            panel.setVisible(false);
            controller.main.timer.start();
            controller.controllerTimer.start();
            controller.wordlPaint.start();

        }
        if (e.getComponent().getName() == salir.getName()) {
            salir.setIcon(salirBTN[0]);
            controller = null;
            System.exit(0);
        }
        if (e.getComponent().getName() == guardar.getName()) {
            gameView.saveOption.setSaveData();
            guardar.setIcon(guardarBTN[0]);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
