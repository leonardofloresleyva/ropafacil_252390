package control;

import Control.JTextFieldLimit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author PC WHITE WOLF
 */
public class ControlOperaciones {
    
    
    
    public static void configurarCamposTexto(JTextField campo){
        for(KeyListener keyListener : Arrays.asList(campo.getKeyListeners()))
            campo.removeKeyListener(keyListener);
        
        campo.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char input = e.getKeyChar();
                if(!Character.isLetter(input) && input != KeyEvent.VK_BACK_SPACE &&  input != KeyEvent.VK_DELETE && input != KeyEvent.VK_SPACE)
                    e.consume();
                
            }
        });
    }
    
    public static void configurarCamposPrecios(JTextField campo){
        for(KeyListener keyListener : Arrays.asList(campo.getKeyListeners()))
            campo.removeKeyListener(keyListener);
        
        campo.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char input = e.getKeyChar();
                if(!Character.isDigit(input) && input != '.' && input != KeyEvent.VK_BACK_SPACE && input != KeyEvent.VK_DELETE)
                    e.consume();
                
                if (input == '.' && campo.getText().contains(".")) 
                    e.consume();
                
            }
        });
    }
    
    public static void configurarCamposCantidades(JTextField campo){
        for(KeyListener keyListener : Arrays.asList(campo.getKeyListeners()))
            campo.removeKeyListener(keyListener);
        
        campo.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char input = e.getKeyChar();
                if(!Character.isDigit(input) && input != KeyEvent.VK_BACK_SPACE &&  input != KeyEvent.VK_DELETE)
                    e.consume();
            }
        });
    }
    
    public static void limiteCaracteres(JTextField campo, int limite){
        if(limite >= 0)
            campo.setDocument(new JTextFieldLimit(limite));
    }
    
    public static boolean validarCampoInvalidoTexto(JTextField campo){
        return !campo.getText().trim().isEmpty();
    }
    
    public static boolean validarCampoInvalidoPrecios(JTextField campo){
        return !campo.getText().trim().isEmpty();
    }
    
    public static boolean validarCampoInvalidoComboBox(JComboBox comboBox){
        return !comboBox.getSelectedItem().equals("N/A");
    }
}