package control;

import BO.CompraBO;
import BO.ProductoBO;
import BO.VentaBO;
import Control.JTextFieldLimit;
import com.github.lgooddatepicker.components.DatePicker;
import dtos.DetalleCompraTallaDTO;
import dtos.DetalleVentaTallaDTO;
import dtos.NuevoProductoDTO;
import dtos.ProductoDTO;
import dtos.ReposicionDTO;
import dtos.StockPorTallaDTO;
import dtos.VentaDTO;
import enums.EstadoProducto;
import exception.NegocioException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author PC WHITE WOLF
 */
public class ControlOperaciones {
    
    public static boolean registrarCompra(
            ProductoDTO producto, 
            List<StockPorTallaDTO> tallas, 
            NuevoProductoDTO compra,
            List<DetalleCompraTallaDTO> detalleCompraTalla
    ) throws NegocioException{
        return CompraBO.getInstance().registrarCompraNuevoProducto(producto, tallas, compra, detalleCompraTalla);
    }
    
    public static boolean registrarCompraReposicion(
            ProductoDTO producto, 
            ReposicionDTO compra, 
            List<DetalleCompraTallaDTO> detalleCompraTalla
    ) throws NegocioException{
        return CompraBO.getInstance().registrarCompraReposicion(producto, compra, detalleCompraTalla);
    }
    
    public static boolean registrarVenta(VentaDTO venta, List<DetalleVentaTallaDTO> tallasVender) throws NegocioException{return VentaBO.getInstance().registarVenta(venta, tallasVender);}
    
    public static List<NuevoProductoDTO> buscarNuevosProductosFecha(LocalDate fechaInicio, LocalDate fechaFinal) throws NegocioException{return CompraBO.getInstance().obtenerNuevosProductosFecha(fechaInicio, fechaFinal);}
    
    public static List<NuevoProductoDTO> buscarNuevosProductosNombre(String nombre) throws NegocioException{return CompraBO.getInstance().obtenerNuevosProductosNombre(nombre);}
    
    public static List<NuevoProductoDTO> buscarNuevosProductosProveedor(String proveedor) throws NegocioException{return CompraBO.getInstance().obtenerNuevosProductosProveedor(proveedor);}
    
    public static List<ReposicionDTO> buscarReposicionesFecha(LocalDate fechaInicio, LocalDate fechaFinal) throws NegocioException{return CompraBO.getInstance().obtenerReposicionesFecha(fechaInicio, fechaFinal);}
    
    public static List<ReposicionDTO> buscarReposicionesNombre(String nombre) throws NegocioException{return CompraBO.getInstance().obtenerReposicionesNombre(nombre);}
    
    public static List<ReposicionDTO> buscarReposicionesProveedor(String proveedor) throws NegocioException{return CompraBO.getInstance().obtenerReposicionesProveedor(proveedor);}
    
    public static List<VentaDTO> buscarVentasNombre(String nombre) throws NegocioException{return VentaBO.getInstance().obtenerVentasPorNombre(nombre);}
    
    public static List<VentaDTO> buscarVentasFecha(LocalDate fechaInicio, LocalDate fechaFinal) throws NegocioException{return VentaBO.getInstance().obtenerVentasPorFecha(fechaInicio, fechaFinal);}
    
    public static List<VentaDTO> buscarVentasColor(String color) throws NegocioException{return VentaBO.getInstance().obtenerVentasPorColor(color);}
    
    public static List<VentaDTO> buscarVentasTalla(String talla) throws NegocioException{return VentaBO.getInstance().obtenerVentasPorTalla(talla);}
    
    public static boolean actualizarProducto(ProductoDTO producto) throws NegocioException{return ProductoBO.getInstance().actualizarProducto(producto);}
    
    public static List<ProductoDTO> buscarProductosPorNombre(String nombre) throws NegocioException {return ProductoBO.getInstance().buscarPorNombre(nombre);}
    
    public static List<ProductoDTO> buscarProductoActivoPorNombre(String nombre) throws NegocioException {return ProductoBO.getInstance().buscarProductoActivoPorNombre(nombre);}
    
    public static List<ProductoDTO> buscarPorTipo(String tipo) throws NegocioException {return ProductoBO.getInstance().buscarPorTipo(tipo);}
    
    public static List<ProductoDTO> buscarProductoActivoPorTipo(String tipo) throws NegocioException {return ProductoBO.getInstance().buscarProductoActivoPorTipo(tipo);}
    
    public static List<ProductoDTO> buscarPorCategoria(String categoria) throws NegocioException {return ProductoBO.getInstance().buscarPorCategoria(categoria);}
    
    public static List<ProductoDTO> buscarProductoActivoPorCategoria(String categoria) throws NegocioException {return ProductoBO.getInstance().buscarProductoActivoPorCategoria(categoria);}
    
    public static List<ProductoDTO> buscarPorColor(String color) throws NegocioException {return ProductoBO.getInstance().buscarPorColor(color);}
    
    public static List<ProductoDTO> buscarProductoActivoPorColor(String color) throws NegocioException {return ProductoBO.getInstance().buscarProductoActivoPorColor(color);}
    
    public static List<ProductoDTO> buscarPorTalla(String talla) throws NegocioException{return ProductoBO.getInstance().buscarPorTalla(talla);}
    
    public static List<ProductoDTO> buscarProductoActivoPorTalla(String talla) throws NegocioException{return ProductoBO.getInstance().buscarProductoActivoPorTalla(talla);}
    
    public static List<ProductoDTO> buscarPorEstado(EstadoProducto estado) throws NegocioException{return ProductoBO.getInstance().buscarPorEstado(estado);}
    
    public static List<ProductoDTO> buscarPorCaja(Integer caja) throws NegocioException{return ProductoBO.getInstance().buscarPorCaja(caja);}
    
    public static boolean cambiarEstado(ProductoDTO producto) throws NegocioException{return ProductoBO.getInstance().cambiarEstado(producto);}
    
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
    
    public static boolean validarCampoInvalidoTexto(JTextField campo){return !campo.getText().trim().isEmpty();}
    
    public static boolean validarCampoInvalidoPrecios(JTextField campo){return !campo.getText().trim().isEmpty() && Double.parseDouble(campo.getText()) > 0.0;}
    
    public static boolean validarCampoInvalidoCantidades(JTextField campo){return !campo.getText().trim().isEmpty() && Integer.parseInt(campo.getText()) > 0;}
    
    public static boolean validarCampoInvalidoComboBox(JComboBox comboBox){return comboBox.getSelectedItem() != null && !comboBox.getSelectedItem().equals("N/A");}
    
    public static boolean validarFechaInvalida(DatePicker picker){return picker.getDate() != null;}
}