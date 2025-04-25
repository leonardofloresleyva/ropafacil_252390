package interfaces;

import dtos.DetalleCompraTallaDTO;
import dtos.NuevoProductoDTO;
import dtos.ProductoDTO;
import dtos.ReposicionDTO;
import dtos.StockPorTallaDTO;
import exception.NegocioException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author PC WHITE WOLF
 */
public interface iCompraBO {
    
    public boolean registrarCompraNuevoProducto(ProductoDTO producto, List<StockPorTallaDTO> tallas, NuevoProductoDTO compra, List<DetalleCompraTallaDTO> detalleCompraTalla) throws NegocioException;
    
    public boolean registrarCompraReposicion(ProductoDTO producto, ReposicionDTO compra, List<DetalleCompraTallaDTO> detalleCompraTalla) throws NegocioException;
    
    public List<NuevoProductoDTO> obtenerNuevosProductosFecha(LocalDate fechaInicial, LocalDate fechaFinal) throws NegocioException;
    
    public List<ReposicionDTO> obtenerReposicionesFecha(LocalDate fechaInicial, LocalDate fechaFinal) throws NegocioException;
    
    public List<NuevoProductoDTO> obtenerNuevosProductosNombre(String nombre) throws NegocioException;
    
    public List<ReposicionDTO> obtenerReposicionesNombre(String nombre) throws NegocioException;
    
    public List<NuevoProductoDTO> obtenerNuevosProductosProveedor(String proveedor) throws NegocioException;
    
    public List<ReposicionDTO> obtenerReposicionesProveedor(String proveedor) throws NegocioException;
}