package interfaces;

import entidades.DetalleCompraTalla;
import entidades.NuevoProducto;
import entidades.Producto;
import entidades.Reposicion;
import entidades.StockPorTalla;
import exception.PersistenciaException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author PC WHITE WOLF
 */
public interface iCompraDAO {
    
    public NuevoProducto registrarNuevoProducto(
            Producto producto, 
            List<StockPorTalla> tallas, 
            NuevoProducto compra,
            List<DetalleCompraTalla> detalleCompraTalla
    ) throws PersistenciaException;
    
    public Reposicion registrarReposicion(
            Producto producto,
            Reposicion compra,
            List<DetalleCompraTalla> detalleCompraTalla
    ) throws PersistenciaException;
    
    public List<NuevoProducto> obtenerNuevosProductosFecha(LocalDate fechaInicial, LocalDate fechaFinal) throws PersistenciaException;
    
    public List<Reposicion> obtenerReposicionesFecha(LocalDate fechaInicial, LocalDate fechaFinal) throws PersistenciaException;
    
    public List<NuevoProducto> obtenerNuevosProductosNombre(String nombre) throws PersistenciaException;
    
    public List<Reposicion> obtenerReposicionesNombre(String nombre) throws PersistenciaException;
    
    public List<NuevoProducto> obtenerNuevosProductosProveedor(String proveedor) throws PersistenciaException;
    
    public List<Reposicion> obtenerReposicionesProveedor(String proveedor) throws PersistenciaException;
}