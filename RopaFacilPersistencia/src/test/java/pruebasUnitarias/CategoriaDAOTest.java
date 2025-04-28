package pruebasUnitarias;


import DAO.CategoriaDAO;
import conexion.Conexion;
import entidades.Categoria;
import entidades.Color;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author PC WHITE WOLF
 */
public class CategoriaDAOTest {
    
    private static Categoria categoriaPrueba;
    
    @BeforeAll
    static void testRegistrarColor(){
        EntityManager em = Conexion.crearConexion();
        em.getTransaction().begin();
        categoriaPrueba = new Categoria("Camiseta");
        em.persist(categoriaPrueba);
        em.getTransaction().commit();
        
        assertNotNull(categoriaPrueba.getId());
        assertEquals(categoriaPrueba.getCategoria(), "Camiseta");
    }
    
    @Test
    void testVerificarExistencia() throws Exception{
        
        Categoria categoriaEncontrada = CategoriaDAO.getInstance().verificarExistencia(categoriaPrueba.getCategoria());
        assertNotNull(categoriaEncontrada);
        assertEquals(categoriaEncontrada.getId(), categoriaPrueba.getId());
        assertEquals(categoriaEncontrada.getCategoria(), categoriaPrueba.getCategoria());
        
    }
    
    @AfterAll
    static void testEliminarColor(){
        EntityManager em = Conexion.crearConexion();
        
        em.getTransaction().begin();
        Categoria categoriaElminar = em.find(Categoria.class, categoriaPrueba.getId());
        em.remove(categoriaElminar);
        em.getTransaction().commit();
        
        assertNull(em.find(Categoria.class, categoriaPrueba.getId()));
        em.close();
    }
}