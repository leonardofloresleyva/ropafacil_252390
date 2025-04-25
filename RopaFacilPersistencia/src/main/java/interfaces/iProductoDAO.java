package interfaces;

import entidades.Producto;
import entidades.StockPorTalla;
import entidades.Talla;
import enums.EstadoProducto;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author PC WHITE WOLF
 */
public interface iProductoDAO {
    
    public boolean verificarExistenciaProducto(String nombre, String color) throws PersistenciaException;
    
    public boolean actualizarProducto(Producto producto) throws PersistenciaException;
    
    public boolean actualizarStock(Producto producto, Talla talla, int cantidad) throws PersistenciaException;
    
    public boolean cambiarEstado(Producto producto, EstadoProducto nuevoEstado) throws PersistenciaException;
    
    public List<Producto> buscarPorNombre(String nombre) throws PersistenciaException;
    
    public List<Producto> buscarPorEstado(EstadoProducto estado) throws PersistenciaException;
    
    public List<Producto> buscarPorColor(String color) throws PersistenciaException;
    
    public List<Producto> buscarPorTipo(String tipo) throws PersistenciaException;
    
    public List<Producto> buscarPorCategoria(String categoria) throws PersistenciaException;
    
    public List<Producto> buscarPorTalla(String talla) throws PersistenciaException;
    
    public List<Producto> buscarPorCaja(Integer numeroCaja) throws PersistenciaException;
    
}