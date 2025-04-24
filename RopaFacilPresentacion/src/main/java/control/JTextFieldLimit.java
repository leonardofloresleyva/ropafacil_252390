package Control;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Clase para establecer un límite de caracteres a un 
 * objeto JTextField.
 * Obtenido de:
 * https://www.tutorialspoint.com/how-can-we-limit-the-number-of-characters-inside-a-jtextfield-in-java#:~:text=A%20JTextFeld%20is%20one%20of,by%20using%20a%20PlainDocument%20class.
 * @author Leonardo Flores Leyva - 252390
 */
public class JTextFieldLimit extends PlainDocument {
    /**
     * Límite de caracteres.
     */
    private int limit;
    /**
     * Constructor que recibe el límite de caracteres.
     * @param limit Límite de caracteres.
     */
    public JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }
    /**
     * Constructor que recibe el límite de caracteres y 
     * el "upper".
     * @param limit Límite de caracteres.
     * @param upper La verdad no sé para qué se usa.
     */
    public JTextFieldLimit(int limit, boolean upper) {
        super();
        this.limit = limit;
    }
    /**
     * Restringe el límite de caracteres del texto ingresado a
     * un JTextField.
     * @param offset Offset
     * @param str Cadena
     * @param attr Atributos
     * @throws BadLocationException Errores del método.
     */
    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }
        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}