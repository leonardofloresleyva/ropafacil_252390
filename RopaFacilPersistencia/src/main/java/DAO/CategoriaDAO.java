package DAO;

import conexion.Conexion;
import entidades.Categoria;
import exception.PersistenciaException;
import interfaces.iCategoriaDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author PC WHITE WOLF
 */
public class CategoriaDAO implements iCategoriaDAO {
    
    private static CategoriaDAO instance;
    
    private CategoriaDAO(){}
    
    public static CategoriaDAO getInstance(){
        if(instance == null)
            instance = new CategoriaDAO();
        return instance;
    }
    
    @Override
    public Categoria registrarCategoria(Categoria categoria) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(categoria);
            em.getTransaction().commit();
            return categoria;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Ha ocurrido en el registro de la categoría.");
            
        } finally {
            em.close();
        }
    }
    
    @Override
    public Categoria verificarExistencia(String categoria) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            Query query = em.createQuery("SELECT c FROM Categoria c WHERE c.categoria = :categoria", Categoria.class);
            query.setParameter("categoria", categoria);
            List<Categoria> categoriaEncontrada = query.getResultList();
            if(!categoriaEncontrada.isEmpty())
                return categoriaEncontrada.getFirst();
            else
                return null;
            
        } catch (Exception ex) {
            throw new PersistenciaException("Ha ocurrido un error al realizar la consulta.");
            
        } finally {
            em.close();
        }
    }
    
}