package DAO;

import conexion.Conexion;
import entidades.DetalleVentaTalla;
import entidades.Producto;
import entidades.Venta;
import enums.EstadoProducto;
import exception.PersistenciaException;
import interfaces.iVentaDAO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author PC WHITE WOLF
 */
public class VentaDAO implements iVentaDAO {
    
    private static VentaDAO instance;
    
    private VentaDAO(){}
    
    public static VentaDAO getInstance(){
        if(instance == null)
            instance = new VentaDAO();
        return instance;
    }
    
    @Override
    public boolean registarVenta(Venta venta, List<DetalleVentaTalla> tallasVendidas) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            
            Producto productoEncontrado = em.find(Producto.class, venta.getProductoVendido().getId());
            if(productoEncontrado == null)
                throw new PersistenciaException("El producto asociado a la venta no se encuentra registrado.");
            
            else if(productoEncontrado.getEstado().equals(EstadoProducto.INACTIVO))
                throw new PersistenciaException("El producto asociado a la venta está inactivo. Solo se permite la venta de productos inactivos.");
            
            venta.setFechaHora(LocalDateTime.now());
            venta.setPrecioVenta(productoEncontrado.getPrecio());
            venta.setProductoVendido(productoEncontrado);
            
            boolean tieneTotal = venta.getTotalVenta() != null;
            Double total = 0.0;
            for(DetalleVentaTalla tallaVender : tallasVendidas){
                try {
                    if(!tieneTotal)
                        total += tallaVender.getSubtotalVenta();
                    ProductoDAO.getInstance().actualizarStock(productoEncontrado, tallaVender.getTalla(), -(tallaVender.getCantidadVendida()));
                } catch (PersistenciaException e) {
                    throw new PersistenciaException(e.getMessage(), e);
                }
            }
            if(!tieneTotal)
                venta.setTotalVenta(total);
            venta.setTallasVendidas(tallasVendidas);
            
            em.persist(venta);
            
            em.getTransaction().commit();
            
            return true;
            
        } catch (PersistenciaException ex) {
            em.getTransaction().rollback();
            throw new PersistenciaException(ex.getMessage(), ex);
            
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Venta> obtenerVentasPorFecha(LocalDate fechaInicio, LocalDate fechaFinal) throws PersistenciaException{
        return null;
    }
    
    @Override
    public List<Venta> obtenerVentasPorNombre(String nombre) throws PersistenciaException{
        return null;
    }
    
    @Override
    public List<Venta> obtenerVentasPorColor(String color) throws PersistenciaException{
        return null;
    }
    
    @Override
    public List<Venta> obtenerVentasPorTalla(String talla) throws PersistenciaException{
        return null;
    }
}