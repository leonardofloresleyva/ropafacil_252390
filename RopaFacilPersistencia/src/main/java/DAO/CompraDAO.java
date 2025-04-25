package DAO;

import conexion.Conexion;
import entidades.DetalleCompraProducto;
import entidades.DetalleCompraTalla;
import entidades.NuevoProducto;
import entidades.Producto;
import entidades.StockPorTalla;
import exception.PersistenciaException;
import interfaces.iCompraDAO;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author PC WHITE WOLF
 */
public class CompraDAO implements iCompraDAO {

    @Override
    public NuevoProducto registrarNuevoProducto(
            Producto producto, 
            List<StockPorTalla> tallas, 
            NuevoProducto compra, 
            DetalleCompraProducto detalleCompraProducto, 
            List<DetalleCompraTalla> detalleCompraTalla
    ) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            
            producto.setTallas(tallas);
            em.persist(producto);
            
            detalleCompraProducto.setProducto(producto);
            
            compra.setFechaHora(LocalDateTime.now());
            int cantidadTotalTallas = 0;
            for(DetalleCompraTalla talla : detalleCompraTalla)
                cantidadTotalTallas += talla.getCantidadComprada();
            
            compra.setTotalCompra(cantidadTotalTallas * detalleCompraProducto.getPrecioCompraUnitario());
            compra.setProductoComprado(detalleCompraProducto);
            compra.setTallasCompradas(detalleCompraTalla);
            
            em.persist(compra);
            
            em.getTransaction().commit();
            return compra;
            
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Ha ocurrido un error al registrar el nuevo producto.");
        } finally {
            em.close();
        }
    }
    
}