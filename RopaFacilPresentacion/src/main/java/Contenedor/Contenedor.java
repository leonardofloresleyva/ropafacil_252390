package Contenedor;

import moduloVentas.SubmenuVentas;
import control.ControlFlujo;
import javax.swing.JFrame;
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
public class Contenedor extends javax.swing.JFrame {
    
    private static Contenedor instance;
    
    private MenuPrincipal menuPrincipal;
    private SubmenuCompras submenuCompras;
    private NuevoProducto nuevoProducto;
    private Reposicion reposicion;
    private HistorialCompras historialCompras;
    private HistorialComprasNuevosProductos historialComprasNuevosProductos;
    private HistorialComprasReposiciones historialComprasReposiciones;
    private Inventario inventario;
    private EditarProducto editarProducto;
    private SubmenuVentas submenuVentas;
    private Vender vender;
    private AgregarProducto agregarProducto;
    private HistorialVentas historialVentas;
    /**
     * Creates new form Contenedor
     */
    private Contenedor() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("RopaFacil");
        cargarPantallas();
    }
    /**
     * 
     * @return 
     */
    public static Contenedor getInstance(){
        if(instance == null)
            instance = new Contenedor();
        return instance;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));

        panelContenido.setMaximumSize(new java.awt.Dimension(1280, 720));
        panelContenido.setMinimumSize(new java.awt.Dimension(1280, 720));
        panelContenido.setPreferredSize(new java.awt.Dimension(1280, 720));
        panelContenido.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void cargarPantallas(){
        // Se crean las pantallas y se añaden a sus correspondientes atributos.
        menuPrincipal = MenuPrincipal.getInstance();
        submenuCompras = SubmenuCompras.getInstance();
        nuevoProducto = NuevoProducto.getInstance();
        reposicion = Reposicion.getInstance();
        historialCompras = HistorialCompras.getInstance();
        historialComprasNuevosProductos = HistorialComprasNuevosProductos.getInstance();
        historialComprasReposiciones = HistorialComprasReposiciones.getInstance();
        inventario = Inventario.getInstance();
        editarProducto = EditarProducto.getInstance();
        submenuVentas = SubmenuVentas.getInstance();
        vender = Vender.getInstance();
        agregarProducto = AgregarProducto.getInstance();
        historialVentas = HistorialVentas.getInstance();
        // Se añaden las pantallas al panel contenedor.
        panelContenido.add(menuPrincipal, "MenuPrincipal");
        panelContenido.add(submenuCompras, "SubmenuCompras");
        panelContenido.add(nuevoProducto, "NuevoProducto");
        panelContenido.add(reposicion, "Reposicion");
        panelContenido.add(historialCompras, "HistorialCompras");
        panelContenido.add(historialComprasNuevosProductos, "HistorialComprasNuevosProductos");
        panelContenido.add(historialComprasReposiciones, "HistorialComprasReposiciones");
        panelContenido.add(inventario, "Inventario");
        panelContenido.add(editarProducto, "EditarProducto");
        panelContenido.add(submenuVentas, "SubmenuVentas");
        panelContenido.add(vender, "Vender");
        panelContenido.add(agregarProducto, "AgregarProducto");
        panelContenido.add(historialVentas, "HistorialVentas");
        // Abre el menú principal
        ControlFlujo.mostrarMenuPrincipal();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Contenedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Contenedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Contenedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Contenedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Contenedor().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelContenido;
    // End of variables declaration//GEN-END:variables
}