package control;

import dtos.ProductoDTO;
import moduloVentas.SubmenuVentas;
import javax.swing.JPanel;
import menuPrincipal.MenuPrincipal;
import moduloCompras.HistorialCompras;
import moduloCompras.HistorialComprasNuevosProductos;
import moduloCompras.HistorialComprasReposiciones;
import moduloCompras.NuevoProducto;
import moduloCompras.Reposicion;
import moduloCompras.SubmenuCompras;
import moduloInventario.EditarProducto;
import moduloInventario.Inventario;
import moduloVentas.AgregarProducto;
import moduloVentas.HistorialVentas;
import moduloVentas.Vender;

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
    
    public static void mostrarEditarProducto(ProductoDTO producto){
        if(panelActual != null)
            panelActual.setVisible(false);
        EditarProducto.getInstance().setVisible(true);
        EditarProducto.getInstance().ingresarProducto(producto);
        panelActual = EditarProducto.getInstance();
    }
    
    public static void mostrarSubmenuVentas(){
        if(panelActual != null)
            panelActual.setVisible(false);
        SubmenuVentas.getInstance().setVisible(true);
        panelActual = SubmenuVentas.getInstance();
    }
    
    public static void mostrarVender(){
        if(panelActual != null)
            panelActual.setVisible(false);
        Vender.getInstance().setVisible(true);
        panelActual = Vender.getInstance();
    }
    
    public static void mostrarAgregarProducto(){
        if(panelActual != null)
            panelActual.setVisible(false);
        AgregarProducto.getInstance().setVisible(true);
        panelActual = AgregarProducto.getInstance();
    }
    
    public static void mostrarHistorialVentas(){
        if(panelActual != null)
            panelActual.setVisible(false);
        HistorialVentas.getInstance().setVisible(true);
        panelActual = HistorialVentas.getInstance();
    }
}