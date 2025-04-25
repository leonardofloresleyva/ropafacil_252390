package DAO;

import conexion.Conexion;
import entidades.Color;
import exception.PersistenciaException;
import interfaces.iColorDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author PC WHITE WOLF
 */
public class ColorDAO implements iColorDAO{
    
    private static ColorDAO instance;
    
    private ColorDAO(){}
    
    public static ColorDAO getInstance(){
        if(instance == null)
            instance = new ColorDAO();
        return instance;
    }
    
    @Override
    public Color registrarColor(Color color) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(color);
            em.getTransaction().commit();
            return color;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Ha ocurrido un error en el registro del color.");
            
        } finally {
            em.close();
        }
    }
    
    @Override
    public Color verificarExistencia(String color) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            
            Query query = em.createQuery("SELECT c FROM Color c WHERE c.color = :color", Color.class);
            query.setParameter("color", color);
            List<Color> colorEncontrado = query.getResultList();
            
            if(!colorEncontrado.isEmpty())
                return colorEncontrado.getFirst();
            else
                return null;
            
        } catch (Exception ex) {
            throw new PersistenciaException("Ha ocurrido un error al realizar la consulta.");
            
        } finally {
            em.close();
        }
    }
    
}