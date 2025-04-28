package pruebasUnitarias;

import DAO.TipoPrendaDAO;
import conexion.Conexion;
import entidades.TipoPrenda;
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
public class TipoPrendaDAOTest {
    
    private static TipoPrenda tipoPrueba;
    
    @BeforeAll
    static void testRegistrarColor(){
        EntityManager em = Conexion.crearConexion();
        em.getTransaction().begin();
        tipoPrueba = new TipoPrenda("Ropa");
        em.persist(tipoPrueba);
        em.getTransaction().commit();
        
        assertNotNull(tipoPrueba.getId());
        assertEquals(tipoPrueba.getTipo(), "Ropa");
    }
    
    @Test
    void testVerificarExistencia() throws Exception{
        
        TipoPrenda tipoEncontrado = TipoPrendaDAO.getInstance().verificarExistencia(tipoPrueba.getTipo());
        assertNotNull(tipoEncontrado);
        assertEquals(tipoEncontrado.getId(), tipoPrueba.getId());
        assertEquals(tipoEncontrado.getTipo(), tipoPrueba.getTipo());
        
    }
    
    @AfterAll
    static void testEliminarColor(){
        EntityManager em = Conexion.crearConexion();
        
        em.getTransaction().begin();
        TipoPrenda tipoElminar = em.find(TipoPrenda.class, tipoPrueba.getId());
        em.remove(tipoElminar);
        em.getTransaction().commit();
        
        assertNull(em.find(TipoPrenda.class, tipoPrueba.getId()));
        em.close();
    }
}