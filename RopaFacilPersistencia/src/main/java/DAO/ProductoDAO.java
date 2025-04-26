package DAO;

import conexion.Conexion;
import entidades.Producto;
import entidades.StockPorTalla;
import entidades.Talla;
import enums.EstadoProducto;
import exception.PersistenciaException;
import interfaces.iProductoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author PC WHITE WOLF
 */
public class ProductoDAO implements iProductoDAO {
    
    private static ProductoDAO instance;
    
    private ProductoDAO(){}
    
    public static ProductoDAO getInstance(){
        if(instance == null)
            instance = new ProductoDAO();
        return instance;
    }
    
    @Override
    public boolean actualizarProducto(Producto producto) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            Producto productoEncontrado = em.find(Producto.class, producto.getId());
            if(productoEncontrado == null)
                throw new PersistenciaException("El producto recibido no está registrado.");
            else
                em.merge(producto);
            
            em.getTransaction().commit();
            
            return true;
            
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Ha ocurrido un error al verificar la existencia del producto.");
            
        } finally {
            em.close();
        }
    }
    
    @Override
    public boolean actualizarStock(Producto producto, Talla talla, int cantidad) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            Producto productoActualizar = em.find(Producto.class, producto.getId());
            if(productoActualizar == null)
                throw new PersistenciaException("");
            
            boolean tieneTalla = false;
            List<StockPorTalla> tallas = productoActualizar.getTallas();
            for(StockPorTalla stockPorTalla : tallas){
                if(stockPorTalla.getTalla().getTalla().equals(talla.getTalla())){
                    tieneTalla = true;
                    stockPorTalla.setStock(stockPorTalla.getStock() + cantidad);
                    if(stockPorTalla.getStock() < 0)
                        throw new PersistenciaException("El stock resultante de la talla: " + talla.getTalla() + " es menor a cero.");
                }
            }
            if(!tieneTalla){
                
                StockPorTalla nuevaTalla = new StockPorTalla();
                nuevaTalla.setStock(cantidad);
                nuevaTalla.setTalla(talla);
                tallas.add(nuevaTalla);
            }
            productoActualizar.setTallas(tallas);
            em.merge(productoActualizar);
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
    public boolean verificarExistenciaProducto(String nombre, String color) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT p FROM Producto p WHERE p.nombre = :nombre AND p.color.color = :color", Producto.class);
            query.setParameter("nombre", nombre);
            query.setParameter("color", color);
            em.getTransaction().commit();
            List<Producto> productoEncontrado = query.getResultList();
            return !productoEncontrado.isEmpty();
            
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Ha ocurrido un error al verificar la existencia del producto.");
            
        } finally {
            em.close();
        }
    }
    
    @Override
    public boolean cambiarEstado(Producto producto, EstadoProducto nuevoEstado) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            
            Producto productoEncontrado = em.find(Producto.class, producto.getId());
            if(productoEncontrado == null)
                throw new PersistenciaException("El producto recibido no existe.");
            
            if(productoEncontrado.getEstado().equals(nuevoEstado))
                throw new PersistenciaException("EL producto ya tiene el mismo estado que el recibido.");
            else{
                productoEncontrado.setEstado(nuevoEstado);
                em.merge(productoEncontrado);
                em.getTransaction().commit();
            }
            return true;
            
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Ha ocurrido un error al registrar la talla.");
            
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Producto> buscarPorNombre(String nombre) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            Query query = em.createQuery("SELECT p FROM Producto p WHERE p.nombre LIKE :nombre", Producto.class);
            query.setParameter("nombre", "%" + nombre + "%");
            return query.getResultList();
            
        } catch (Exception ex) {
            throw new PersistenciaException("Ha ocurrido un error al realizar la consulta.");
            
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Producto> buscarPorEstado(EstadoProducto estado) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            Query query = em.createQuery("SELECT p FROM Producto p WHERE p.estado = :estado", Producto.class);
            query.setParameter("estado", estado);
            return query.getResultList();
            
        } catch (Exception ex) {
            throw new PersistenciaException("Ha ocurrido un error al realizar la consulta.");
            
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Producto> buscarPorColor(String color) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            Query query = em.createQuery("SELECT p FROM Producto p WHERE p.color.color LIKE :color", Producto.class);
            query.setParameter("color", "%" + color + "%");
            return query.getResultList();
            
        } catch (Exception ex) {
            throw new PersistenciaException("Ha ocurrido un error al realizar la consulta");
            
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Producto> buscarPorTipo(String tipo) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            Query query = em.createQuery("SELECT p FROM Producto p WHERE p.tipo.tipo LIKE :tipo", Producto.class);
            query.setParameter("tipo", "%" + tipo + "%");
            return query.getResultList();
            
        } catch (Exception ex) {
            throw new PersistenciaException("Ha ocurrido un error al realizar la consulta");
            
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Producto> buscarPorCategoria(String categoria) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            Query query = em.createQuery("SELECT p FROM Producto p WHERE p.categoria.categoria = :categoria", Producto.class);
            query.setParameter("categoria", categoria);
            return query.getResultList();
            
        } catch (Exception ex) {
            throw new PersistenciaException("Ha ocurrido un error al realizar la consulta");
            
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Producto> buscarPorTalla(String talla) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            Query query = em.createQuery("SELECT p FROM Producto p WHERE p.tallas.talla.talla LIKE :talla AND p.tallas.stock > 0", Producto.class);
            query.setParameter("talla", "%" + talla + "%");
            return query.getResultList();
            
        } catch (Exception ex) {
            throw new PersistenciaException("Ha ocurrido un error al realizar la consulta");
            
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Producto> buscarPorCaja(Integer numeroCaja) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            Query query = em.createQuery("SELECT p FROM Producto p WHERE p.caja.caja = :caja", Producto.class);
            query.setParameter("caja", numeroCaja);
            return query.getResultList();
            
        } catch (Exception ex) {
            throw new PersistenciaException("Ha ocurrido un error al realizar la consulta");
            
        } finally {
            em.close();
        }
    }
}