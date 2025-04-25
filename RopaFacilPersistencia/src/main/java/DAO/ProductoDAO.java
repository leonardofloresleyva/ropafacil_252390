package DAO;

import conexion.Conexion;
import entidades.Producto;
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
            throw new PersistenciaException("Ha ocurrido un error al registrar la talla.");
            
        } finally {
            em.close();
        }
    }
}