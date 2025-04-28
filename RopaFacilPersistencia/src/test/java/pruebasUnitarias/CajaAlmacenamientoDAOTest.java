package pruebasUnitarias;

import DAO.CajaAlmacenamientoDAO;
import conexion.Conexion;
import entidades.CajaAlmacenamiento;
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
public class CajaAlmacenamientoDAOTest {
    
    private static CajaAlmacenamiento cajaPrueba;
    
    @BeforeAll
    static void testRegistrarColor(){
        EntityManager em = Conexion.crearConexion();
        em.getTransaction().begin();
        cajaPrueba = new CajaAlmacenamiento(0);
        em.persist(cajaPrueba);
        em.getTransaction().commit();
        
        assertNotNull(cajaPrueba.getId());
        assertEquals(cajaPrueba.getCaja(), 0);
    }
    
    @Test
    void testVerificarExistencia() throws Exception{
        
        CajaAlmacenamiento cajaEncontrada = CajaAlmacenamientoDAO.getInstance().verificarExistencia(cajaPrueba.getCaja());
        assertNotNull(cajaEncontrada);
        assertEquals(cajaEncontrada.getId(), cajaPrueba.getId());
        assertEquals(cajaEncontrada.getCaja(), cajaPrueba.getCaja());
        
    }
    
    @AfterAll
    static void testEliminarColor(){
        EntityManager em = Conexion.crearConexion();
        
        em.getTransaction().begin();
        CajaAlmacenamiento cajaElminar = em.find(CajaAlmacenamiento.class, cajaPrueba.getId());
        em.remove(cajaElminar);
        em.getTransaction().commit();
        
        assertNull(em.find(CajaAlmacenamiento.class, cajaPrueba.getId()));
        em.close();
    }
}