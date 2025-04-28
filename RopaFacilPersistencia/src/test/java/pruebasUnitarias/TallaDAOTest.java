package pruebasUnitarias;

import DAO.TallaDAO;
import conexion.Conexion;
import entidades.Talla;
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
public class TallaDAOTest {
    
    private static Talla tallaPrueba;
    
    @BeforeAll
    static void testRegistrarColor(){
        EntityManager em = Conexion.crearConexion();
        em.getTransaction().begin();
        tallaPrueba = new Talla("ZZZ");
        em.persist(tallaPrueba);
        em.getTransaction().commit();
        
        assertNotNull(tallaPrueba.getId());
        assertEquals(tallaPrueba.getTalla(), "ZZZ");
    }
    
    @Test
    void testBuscarTalla() throws Exception{
        
        Talla tallaEncontrada = TallaDAO.getInstance().buscarTalla(tallaPrueba);
        assertNotNull(tallaEncontrada);
        assertEquals(tallaEncontrada.getId(), tallaPrueba.getId());
        assertEquals(tallaEncontrada.getTalla(), tallaPrueba.getTalla());
        
    }
    
    @AfterAll
    static void testEliminarColor(){
        EntityManager em = Conexion.crearConexion();
        
        em.getTransaction().begin();
        Talla tallaElminar = em.find(Talla.class, tallaPrueba.getId());
        em.remove(tallaElminar);
        em.getTransaction().commit();
        
        assertNull(em.find(Talla.class, tallaPrueba.getId()));
        em.close();
    }
}