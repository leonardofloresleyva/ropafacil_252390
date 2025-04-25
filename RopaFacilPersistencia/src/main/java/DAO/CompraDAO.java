package DAO;

import conexion.Conexion;
import entidades.DetalleCompraTalla;
import entidades.NuevoProducto;
import entidades.Producto;
import entidades.StockPorTalla;
import entidades.Talla;
import exception.PersistenciaException;
import interfaces.iCompraDAO;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author PC WHITE WOLF
 */
public class CompraDAO implements iCompraDAO {
    
    private static CompraDAO instance;
    
    private CompraDAO (){}
    
    public static CompraDAO getInstance(){
        if(instance == null)
            instance = new CompraDAO();
        return instance;
    }
    
    @Override
    public NuevoProducto registrarNuevoProducto(
            Producto producto, 
            List<StockPorTalla> tallas, 
            NuevoProducto compra,
            List<DetalleCompraTalla> detalleCompraTalla
    ) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            
            tallas.stream().forEach((StockPorTalla e) -> {
                try {
                    Talla talla = TallaDAO.getInstance().buscarTalla(e.getTalla());
                    e.setTalla(talla);
                } catch (PersistenciaException ex) {}
            });
            producto.setTallas(tallas);
            em.persist(producto);
            
            compra.setFechaHora(LocalDateTime.now());
            int cantidadTotalTallas = 0;
            for(DetalleCompraTalla talla : detalleCompraTalla)
                cantidadTotalTallas += talla.getCantidadComprada();
            
            detalleCompraTalla.stream().forEach(e -> {
                try {
                    Talla talla = TallaDAO.getInstance().buscarTalla(e.getTalla());
                    e.setTalla(talla);
                } catch (PersistenciaException ex) {}
            });
            
            compra.setTotalCompra(cantidadTotalTallas * compra.getPrecioCompraUnitario());
            compra.setProductoComprado(producto);
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