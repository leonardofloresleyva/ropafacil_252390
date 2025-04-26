package control;

import BO.CompraBO;
import BO.ProductoBO;
import BO.TallaBO;
import Control.JTextFieldLimit;
import dtos.DetalleCompraTallaDTO;
import dtos.NuevoProductoDTO;
import dtos.ProductoDTO;
import dtos.ReposicionDTO;
import dtos.StockPorTallaDTO;
import dtos.TallaDTO;
import exception.NegocioException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author PC WHITE WOLF
 */
public class ControlOperaciones {
    
    public static boolean registrarTalla(TallaDTO tallaDTO) throws NegocioException{
        return TallaBO.getInstance().registrarTalla(tallaDTO);
    }
    
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
    
    public static List<ProductoDTO> buscarProductosPorNombre(String nombre) throws NegocioException {return ProductoBO.getInstance().buscarPorNombre(nombre);}
    
    public static List<ProductoDTO> buscarPorTipo(String tipo) throws NegocioException {return ProductoBO.getInstance().buscarPorTipo(tipo);}
    
    public static List<ProductoDTO> buscarPorCategoria(String categoria) throws NegocioException {return ProductoBO.getInstance().buscarPorCategoria(categoria);}
    
    public static List<ProductoDTO> buscarPorColor(String color) throws NegocioException {return ProductoBO.getInstance().buscarPorColor(color);}
    
    public static List<ProductoDTO> buscarPorTalla(String talla) throws NegocioException{return ProductoBO.getInstance().buscarPorTalla(talla);}
    
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
        return !campo.getText().trim().isEmpty() && Double.parseDouble(campo.getText()) > 0.0;
    }
    
    public static boolean validarCampoInvalidoCantidades(JTextField campo){
        return !campo.getText().trim().isEmpty() && Integer.parseInt(campo.getText()) > 0;
    }
    
    public static boolean validarCampoInvalidoComboBox(JComboBox comboBox){
        return !comboBox.getSelectedItem().equals("N/A");
    }
}