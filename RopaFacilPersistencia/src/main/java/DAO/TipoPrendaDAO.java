package DAO;

import conexion.Conexion;
import entidades.TipoPrenda;
import exception.PersistenciaException;
import interfaces.iTipoPrendaDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author PC WHITE WOLF
 */
public class TipoPrendaDAO implements iTipoPrendaDAO {
    
    private static TipoPrendaDAO instance;
    
    private TipoPrendaDAO(){}
    
    public static TipoPrendaDAO getInstance(){
        if(instance == null)
            instance = new TipoPrendaDAO();
        return instance;
    }
    
     @Override
    public TipoPrenda registrarTipo(TipoPrenda tipoPrenda) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(tipoPrenda);
            em.getTransaction().commit();
            return tipoPrenda;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Ha ocurrido en el registro del tipo de prenda.");
            
        } finally {
            em.close();
        }
    }
    
    @Override
    public TipoPrenda verificarExistencia(String tipoPrenda) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            Query query = em.createQuery("SELECT t FROM TipoPrenda t WHERE t.tipo = :tipo", TipoPrenda.class);
            query.setParameter("tipo", tipoPrenda);
            List<TipoPrenda> tipoEncontrado = query.getResultList();
            if(!tipoEncontrado.isEmpty())
                return tipoEncontrado.getFirst();
            else
                return null;
            
        } catch (Exception ex) {
            throw new PersistenciaException("Ha ocurrido un error al realizar la consulta.");
            
        } finally {
            em.close();
        }
    }
    
}