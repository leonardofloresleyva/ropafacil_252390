package exception;

/**
 *
 * @author PC WHITE WOLF
 */
public class PresentacionException extends Exception {
    
    public PresentacionException(String mensaje) {super(mensaje);}

    public PresentacionException(String mensaje, Throwable causa) {super(mensaje, causa);}
}