package DAO;

import conexion.Conexion;
import entidades.Proveedor;
import exception.PersistenciaException;
import interfaces.iProveedorDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author PC WHITE WOLF
 */
public class ProveedorDAO implements iProveedorDAO {
    
    private static ProveedorDAO instance;
    
    private ProveedorDAO(){}
    
    public static ProveedorDAO getInstance(){
        if(instance == null)
            instance = new ProveedorDAO();
        return instance;
    }
    
    @Override
    public Proveedor registrarProveedor(Proveedor proveedor) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(proveedor);
            em.getTransaction().commit();
            return proveedor;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Ha ocurrido en el registro del proveedor.");
            
        } finally {
            em.close();
        }
    }
    
    @Override
    public Proveedor verificarExistencia(String proveedor) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            Query query = em.createQuery("SELECT p FROM Proveedor p WHERE p.proveedor = :proveedor", Proveedor.class);
            query.setParameter("proveedor", proveedor);
            List<Proveedor> proveedorEncontrado = query.getResultList();
            if(!proveedorEncontrado.isEmpty())
                return proveedorEncontrado.getFirst();
            else
                return null;
            
        } catch (Exception ex) {
            throw new PersistenciaException("Ha ocurrido un error al realizar la consulta.");
            
        } finally {
            em.close();
        }
    }
    
}