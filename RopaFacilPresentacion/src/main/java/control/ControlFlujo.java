package control;

import javax.swing.JPanel;
import menu_principal.MenuPrincipal;
import modulo_compras.SubmenuCompras;

/**
 *
 * @author PC WHITE WOLF
 */
public class ControlFlujo {
    
//    private static ControlFlujo instance;
    private static JPanel panelActual;
    
//    public static ControlFlujo getInstance(){
//        if(instance == null)
//            instance = new ControlFlujo();
//        return instance;
//    }
    
    public static void mostrarMenuPrincipal(){
        if(panelActual != null)
            panelActual.setVisible(false);
        MenuPrincipal.getInstance().setVisible(true);
        panelActual = MenuPrincipal.getInstance();
    }
    
    public static void mostrarSubmenuCompras(){
        if(panelActual != null)
            panelActual.setVisible(false);
        SubmenuCompras.getInstance().setVisible(true);
        panelActual = SubmenuCompras.getInstance();
    }
}