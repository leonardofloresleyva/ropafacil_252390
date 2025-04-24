package control;

import javax.swing.JPanel;
import menu_principal.MenuPrincipal;
import modulo_compras.NuevoProducto;
import modulo_compras.SubmenuCompras;

/**
 *
 * @author PC WHITE WOLF
 */
public class ControlFlujo {
    
    private static JPanel panelActual;
    
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
    
    public static void mostrarNuevoProducto(){
        if(panelActual != null)
            panelActual.setVisible(false);
        NuevoProducto.getInstance().setVisible(true);
        panelActual = NuevoProducto.getInstance();
    }
}