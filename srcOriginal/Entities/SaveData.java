/**
 * Esta clase define los recursos necesarios para el guardado de la partida 
 * @author: Mario Josue Grieco Villamizar
 * Universidad Nacional Experimental del Tachira
 * @version: 0.1
 * @see Entities
 * @see LevelsController usado por la clase
 */
package Entities;
import Windows.LevelsController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class SaveData {
    
    BufferedReader filebBuferRead;
    FileReader     fileReader;
    
    PrintWriter    printWriter;
    FileWriter     fileWriter; 
    BufferedWriter fileBuferWriter;
    
    LevelsController object;
    boolean pass = true;
    boolean pass2 = true;
       String data = null;
       
    int sceneNumber = 1;
    int moneda = 1;
    int puntos = 1;
      
    /**
     * 
     * Constructor parametrico recibe como parametro a un levelcontroller
     * @see LevelsController
     *  @param object see LevelsController
     */
    public SaveData(LevelsController object){
        this.object=object;
    }
    

    public SaveData(){
        
    }
     /**
     * 
     * Metodo que retorna solo el numero de escena cargado del save data
     *  
     * @return  Rectangle2D.Double(w-50,h-100,100,100);
     */
    public int getScene(){
        return this.sceneNumber;
    }
    
     /**
     * 
     * Metodo lee el archivo de texto del save data
     *  
     */
    public void readSaveData(){
        try {
            fileReader = new FileReader("src/savegame.txt");
            filebBuferRead = new BufferedReader(fileReader);
        } catch (FileNotFoundException ex) {
            pass2 = false;
            sceneNumber = -1;
            JOptionPane.showMessageDialog(null, "NOt Files Found!");
        } catch (IOException ex) {
            sceneNumber = -1;
            JOptionPane.showMessageDialog(null, "ERROR archivos no encontrados!");
        }
        
        try {
            data = filebBuferRead.readLine();
        } catch (IOException ex) {
                Logger.getLogger(SaveData.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (sceneNumber != -1) {
            StringTokenizer save = new StringTokenizer(data,"-");
                sceneNumber = Integer.parseInt(save.nextToken());        }
        try {
            fileReader.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveData.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            filebBuferRead.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveData.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      
    }
    
     /**
     * 
     * Metodo que guarda la informacion del personaje y otras en un .txt
     */
    public void setSaveData(){
        String anterior = "";
        
        try {
            fileReader = new FileReader("src/savegame.txt");
            filebBuferRead = new BufferedReader(fileReader);
        } catch (FileNotFoundException ex) {
            pass2 = false;
        }
        if ( pass2 ) {
            try {
                anterior += filebBuferRead.readLine();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Algo pudo salir mal!");
            }
        }
        try {
            fileWriter = new FileWriter(new File("src/savegame.txt"));
            fileBuferWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(fileBuferWriter);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveData.class.getName()).log(Level.SEVERE, null, ex);
            pass = false;
        } catch (IOException ex) {
            Logger.getLogger(SaveData.class.getName()).log(Level.SEVERE, null, ex);
            pass = false;
        }
        
        printWriter.println(object.sceneNumber+"-"+object.viewLabel.monedasText.getText()+"-"+object.viewLabel.puntos.getText());
        printWriter.println("end");
        printWriter.close();
        try {
            fileBuferWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveData.class.getName()).log(Level.SEVERE, null, ex);
            pass = false;
        }
        try {
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveData.class.getName()).log(Level.SEVERE, null, ex);
            pass = false;
        }
        
        if ( pass ) {
            JOptionPane.showMessageDialog(null, "JUEGO GUARDADO EXITOSAMENTE!");
        }else{
            JOptionPane.showMessageDialog(null, "ERRORO AL GUARDAR EL JUEGO!");
        }
        
        pass = true;
        pass2 = true;
    }
     
    
    
}
