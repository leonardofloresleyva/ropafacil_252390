package DAO;

import conexion.Conexion;
import entidades.Talla;
import exception.PersistenciaException;
import interfaces.iTallaDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author PC WHITE WOLF
 */
public class TallaDAO implements iTallaDAO {
    
    private static TallaDAO instance;
    
    private TallaDAO(){}
    
    public static TallaDAO getInstance(){
        if(instance == null)
            instance = new TallaDAO();
        return instance;
    }
    
    @Override
    public Talla registrarTalla(Talla talla) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(talla);
            em.getTransaction().commit();
            return talla;
            
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Ha ocurrido un error al registrar la talla.");
            
        } finally {
            em.close();
        }
    }
    
    @Override
    public Talla buscarTalla(Talla talla) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            
            Query query = em.createQuery("SELECT t FROM Talla t WHERE t.talla = :talla", Talla.class);
            query.setParameter("talla", talla.getTalla());
            List<Talla> tallaEncontrada = query.getResultList();
            em.getTransaction().commit();
            
            if(!tallaEncontrada.isEmpty())
                return tallaEncontrada.getFirst();
            else
                return null;
            
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Ha ocurrido un error al buscar la talla");
            
        } finally {
            em.close();
        }
    }
    
}