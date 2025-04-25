package DAO;

import conexion.Conexion;
import entidades.CajaAlmacenamiento;
import exception.PersistenciaException;
import interfaces.iCajaAlmacenamientoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author PC WHITE WOLF
 */
public class CajaAlmacenamientoDAO implements iCajaAlmacenamientoDAO {
    
    private static CajaAlmacenamientoDAO instance;
    
    private CajaAlmacenamientoDAO(){}
    
    public static CajaAlmacenamientoDAO getInstance(){
        if(instance == null)
            instance = new CajaAlmacenamientoDAO();
        return instance;
    }
    
    @Override
    public CajaAlmacenamiento verificarExistencia(Integer caja) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            Query query = em.createQuery("SELECT c FROM CajaAlmacenamiento c WHERE c.caja = :caja", CajaAlmacenamiento.class);
            query.setParameter("caja", caja);
            List<CajaAlmacenamiento> cajaEncontrada = query.getResultList();
            if(!cajaEncontrada.isEmpty())
                return cajaEncontrada.getFirst();
            else
                return null;
            
        } catch (Exception ex) {
            throw new PersistenciaException("Ha ocurrido un error al realizar la consulta.");
            
        } finally {
            em.close();
        }
    }

    @Override
    public CajaAlmacenamiento registrarCaja(CajaAlmacenamiento caja) throws PersistenciaException {
         EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(caja);
            em.getTransaction().commit();
            return caja;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Ha ocurrido en el registro del tipo de prenda.");
            
        } finally {
            em.close();
        }
    }
}