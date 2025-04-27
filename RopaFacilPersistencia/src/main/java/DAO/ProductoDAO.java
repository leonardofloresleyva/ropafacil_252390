package DAO;

import conexion.Conexion;
import entidades.CajaAlmacenamiento;
import entidades.Categoria;
import entidades.Color;
import entidades.Producto;
import entidades.StockPorTalla;
import entidades.Talla;
import entidades.TipoPrenda;
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
            
            if(!productoEncontrado.getNombre().equals(producto.getNombre()))
                productoEncontrado.setNombre(producto.getNombre());
            
            if(productoEncontrado.getPrecio() != producto.getPrecio())
                productoEncontrado.setPrecio(producto.getPrecio());
            
            Color nuevoColor = producto.getColor();
            if(!productoEncontrado.getColor().getColor().equals(nuevoColor.getColor())){
                Color color = ColorDAO.getInstance().verificarExistencia(nuevoColor.getColor());
                if(color != null){
                    productoEncontrado.setColor(color);
                } else{
                    color = ColorDAO.getInstance().registrarColor(nuevoColor);
                    productoEncontrado.setColor(color);
                }
            }
            Categoria nuevaCategoria = producto.getCategoria();
            if(!productoEncontrado.getCategoria().getCategoria().equals(nuevaCategoria.getCategoria())){
                Categoria categoria = CategoriaDAO.getInstance().verificarExistencia(nuevaCategoria.getCategoria());
                if(categoria != null){
                    productoEncontrado.setCategoria(categoria);
                } else{
                    categoria = CategoriaDAO.getInstance().registrarCategoria(categoria);
                    productoEncontrado.setCategoria(categoria);
                }
            }
            
            TipoPrenda nuevoTipo = producto.getTipo();
            if(!productoEncontrado.getTipo().getTipo().equals(nuevoTipo.getTipo())){
                TipoPrenda tipo = TipoPrendaDAO.getInstance().verificarExistencia(nuevoTipo.getTipo());
                if(tipo != null){
                    productoEncontrado.setTipo(tipo);
                } else{
                    tipo = TipoPrendaDAO.getInstance().registrarTipo(nuevoTipo);
                    productoEncontrado.setTipo(tipo);
                }
            }
            
            CajaAlmacenamiento nuevaCaja = producto.getCaja();
            if(!productoEncontrado.getCaja().getCaja().equals(nuevaCaja.getCaja())){
                CajaAlmacenamiento caja = CajaAlmacenamientoDAO.getInstance().verificarExistencia(nuevaCaja.getCaja());
                if(caja != null){
                    productoEncontrado.setCaja(caja);
                } else{
                    caja = CajaAlmacenamientoDAO.getInstance().registrarCaja(nuevaCaja);
                    productoEncontrado.setCaja(caja);
                }
            }
            
            productoEncontrado.setTallas(producto.getTallas());
            
            em.merge(productoEncontrado);
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
    public boolean actualizarStock(Producto producto, Talla talla, int cantidad) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            Producto productoActualizar = em.find(Producto.class, producto.getId());
            if(productoActualizar == null)
                throw new PersistenciaException("EL producto cuyas talla de desea actualizar su stock no está registrado.");
            
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
    public boolean cambiarEstado(Producto producto) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            
            Producto productoEncontrado = em.find(Producto.class, producto.getId());
            if(productoEncontrado == null)
                throw new PersistenciaException("El producto recibido no existe.");
            
            if(productoEncontrado.getEstado().equals(EstadoProducto.ACTIVO))
                productoEncontrado.setEstado(EstadoProducto.INACTIVO);
            else
                productoEncontrado.setEstado(EstadoProducto.ACTIVO);

            em.merge(productoEncontrado);
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
    public List<Producto> buscarProductoActivoPorNombre(String nombre) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            Query query = em.createQuery("SELECT p FROM Producto p WHERE p.nombre LIKE :nombre AND p.estado = :estado", Producto.class);
            query.setParameter("nombre", "%" + nombre + "%");
            query.setParameter("estado", EstadoProducto.ACTIVO);
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
    public List<Producto> buscarProductoAcivoPorColor(String color) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            Query query = em.createQuery("SELECT p FROM Producto p WHERE p.color.color LIKE :color AND p.estado = :estado", Producto.class);
            query.setParameter("color", "%" + color + "%");
            query.setParameter("estado", EstadoProducto.ACTIVO);
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
    public List<Producto> buscarProductoActivoPorTipo(String tipo) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            Query query = em.createQuery("SELECT p FROM Producto p WHERE p.tipo.tipo LIKE :tipo AND p.estado = :estado", Producto.class);
            query.setParameter("tipo", "%" + tipo + "%");
            query.setParameter("estado", EstadoProducto.ACTIVO);
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
    public List<Producto> buscarProductoActivoPorCategoria(String categoria) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            Query query = em.createQuery("SELECT p FROM Producto p WHERE p.estado = :estado AND p.categoria.categoria = :categoria", Producto.class);
            query.setParameter("categoria", categoria);
            query.setParameter("estado", EstadoProducto.ACTIVO);
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
            Query query = em.createQuery(
                    "SELECT p FROM Producto p JOIN StockPorTalla s On p.id = s.producto.id WHERE s.talla.talla = :talla AND s.stock > 0", 
                    Producto.class
            );
            query.setParameter("talla", talla);
            return query.getResultList();
            
        } catch (Exception ex) {
            throw new PersistenciaException("Ha ocurrido un error al realizar la consulta");
            
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Producto> buscarProductoActivoPorTalla(String talla) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            Query query = em.createQuery(
                    "SELECT p FROM Producto p JOIN StockPorTalla s On p.id = s.producto.id WHERE s.talla.talla = :talla AND s.stock > 0 AND p.estado = :estado", 
                    Producto.class
            );
            query.setParameter("talla", talla);
            query.setParameter("estado", EstadoProducto.ACTIVO);
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