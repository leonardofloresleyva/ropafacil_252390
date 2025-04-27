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
        EntityManager em = Conexion.crearConexion();
        try {
            Query query = em.createQuery("SELECT v FROM Venta v WHERE v.fechaHora BETWEEN :fechaInicial AND :fechaFinal", Venta.class);
            query.setParameter("fechaInicial", LocalDateTime.of(fechaInicio.getYear(), fechaInicio.getMonth(), fechaInicio.getDayOfMonth(),0, 0, 0));
            query.setParameter("fechaFinal", LocalDateTime.of(fechaFinal.getYear(), fechaFinal.getMonth(), fechaFinal.getDayOfMonth(),0, 0, 0));
            return query.getResultList();
            
        } catch (Exception ex) {
            throw new PersistenciaException("Ha ocurrido un error al realizar la consulta por período.");
            
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Venta> obtenerVentasPorNombre(String nombre) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            Query query = em.createQuery("SELECT v FROM Venta v WHERE v.productoVendido.nombre LIKE :nombre", Venta.class);
            query.setParameter("nombre", "%" + nombre + "%");
            return query.getResultList();
            
        } catch (Exception ex) {
            throw new PersistenciaException("Ha ocurrido un error al realizar la consulta por nombre.");
            
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Venta> obtenerVentasPorColor(String color) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            Query query = em.createQuery("SELECT v FROM Venta v WHERE v.productoVendido.color.color LIKE :color", Venta.class);
            query.setParameter("color", "%" + color + "%");
            return query.getResultList();
            
        } catch (Exception ex) {
            throw new PersistenciaException("Ha ocurrido un error al realizar la consulta por color.");
            
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Venta> obtenerVentasPorTalla(String talla) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            Query query = em.createQuery(
                    "SELECT v FROM Venta v JOIN DetalleVentaTalla d ON v.id = d.venta.id WHERE d.talla.talla = :talla", 
                    Venta.class
            );
            query.setParameter("talla", talla);
            return query.getResultList();
            
        } catch (Exception ex) {
            throw new PersistenciaException("Ha ocurrido un error al realizar la consulta por talla.");
            
        } finally {
            em.close();
        }
    }
}