/**
 * Esta clase contiene los recursos necesarios para el sistema de audio
 * @see AudioSystem
 * @author: Mario Josue Grieco Villamizar
 * Universidad Nacional Experimental del Tachira
 * @version: 0.1
 * @see Entities
 */
package Entities;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sounds {
 /**
 * Sonido de captura de la moneda
 */
    public Clip coin;
     /**
 * Sonido de captura de la vida
 */
    public Clip live;
         /**
 * Sonido de ambiente1
 */
    public Clip ambiente;
         /**
 * Sonido de la cierra
 */
    public Clip cierra;
         /**
 * Sonido de ambiente 2
 */
    public Clip ambiente2;
         /**
 * Sonido del mundo del boos
 */
    public Clip boos;
    
         /**
 * Constructor de sounds 
 */
    public Sounds(){
        try {
            coin = AudioSystem.getClip();
            coin.open(AudioSystem.getAudioInputStream(new File("src/sonidos/coin.wav")));
            live = AudioSystem.getClip();
            live.open(AudioSystem.getAudioInputStream(new File("src/sonidos/live.wav")));
            ambiente = AudioSystem.getClip();
            ambiente.open(AudioSystem.getAudioInputStream(new File("src/sonidos/ambiente.wav")));
            ambiente2 = AudioSystem.getClip();
            ambiente2.open(AudioSystem.getAudioInputStream(new File("src/sonidos/ambiente2.wav")));
            cierra = AudioSystem.getClip();
            cierra.open(AudioSystem.getAudioInputStream(new File("src/sonidos/saw.wav")));
            boos = AudioSystem.getClip();
            boos.open(AudioSystem.getAudioInputStream(new File("src/sonidos/boos.wav")));
            
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Sounds.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Sounds.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sounds.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
