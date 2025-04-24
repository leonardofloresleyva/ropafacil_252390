package control;

import javax.swing.JPanel;
import menu_principal.MenuPrincipal;
import modulo_compras.HistorialCompras;
import modulo_compras.HistorialComprasNuevosProductos;
import modulo_compras.HistorialComprasReposiciones;
import modulo_compras.NuevoProducto;
import modulo_compras.Reposicion;
import modulo_compras.SubmenuCompras;
import modulo_inventario.EditarProducto;
import modulo_inventario.Inventario;

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
    
    public static void mostrarReposicion(){
        if(panelActual != null)
            panelActual.setVisible(false);
        Reposicion.getInstance().setVisible(true);
        panelActual = Reposicion.getInstance();
    }
    
    public static void mostrarHistorialCompras(){
        if(panelActual != null)
            panelActual.setVisible(false);
        HistorialCompras.getInstance().setVisible(true);
        panelActual = HistorialCompras.getInstance();
    }
    
    public static void mostrarHistorialComprasNuevosProductos(){
        if(panelActual != null)
            panelActual.setVisible(false);
        HistorialComprasNuevosProductos.getInstance().setVisible(true);
        panelActual = HistorialComprasNuevosProductos.getInstance();
    }
    
    public static void mostrarHistorialComprasReposiciones(){
        if(panelActual != null)
            panelActual.setVisible(false);
        HistorialComprasReposiciones.getInstance().setVisible(true);
        panelActual = HistorialComprasReposiciones.getInstance();
    }
    
    public static void mostrarInventario(){
        if(panelActual != null)
            panelActual.setVisible(false);
        Inventario.getInstance().setVisible(true);
        panelActual = Inventario.getInstance();
    }
    
    public static void mostrarEditarProducto(){
        if(panelActual != null)
            panelActual.setVisible(false);
        EditarProducto.getInstance().setVisible(true);
        panelActual = EditarProducto.getInstance();
    }
}