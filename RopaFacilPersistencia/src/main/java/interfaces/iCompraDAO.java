package interfaces;

import entidades.DetalleCompraTalla;
import entidades.NuevoProducto;
import entidades.Producto;
import entidades.Reposicion;
import entidades.StockPorTalla;
import exception.PersistenciaException;
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
}