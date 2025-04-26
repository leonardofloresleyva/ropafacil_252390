package interfaces;

import dtos.ProductoDTO;
import enums.EstadoProducto;
import exception.NegocioException;
import java.util.List;

/**
 *
 * @author PC WHITE WOLF
 */
public interface iProductoBO {
    
    public boolean actualizarProducto(ProductoDTO producto) throws NegocioException;
    
    public boolean cambiarEstado(ProductoDTO producto) throws NegocioException;
    
    public List<ProductoDTO> buscarPorNombre(String nombre) throws NegocioException;
    
    public List<ProductoDTO> buscarPorEstado(EstadoProducto estado) throws NegocioException;
    
    public List<ProductoDTO> buscarPorColor(String color) throws NegocioException;
    
    public List<ProductoDTO> buscarPorTipo(String tipo) throws NegocioException;
    
    public List<ProductoDTO> buscarPorCategoria(String categoria) throws NegocioException;
    
    public List<ProductoDTO> buscarPorTalla(String talla) throws NegocioException;
    
    public List<ProductoDTO> buscarPorCaja(Integer numeroCaja) throws NegocioException;
    
    
    
}