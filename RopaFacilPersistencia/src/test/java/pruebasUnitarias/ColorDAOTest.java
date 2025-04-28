package pruebasUnitarias;

import DAO.ColorDAO;
import conexion.Conexion;
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
public class ColorDAOTest {
    
    private static Color colorPrueba;
    
    @BeforeAll
    static void testRegistrarColor(){
        EntityManager em = Conexion.crearConexion();
        em.getTransaction().begin();
        colorPrueba = new Color("Rojo");
        em.persist(colorPrueba);
        em.getTransaction().commit();
        
        assertNotNull(colorPrueba.getId());
        assertEquals(colorPrueba.getColor(), "Rojo");
    }
    
    @Test
    void testVerificarExistencia() throws Exception{
        
        Color colorEncontrado = ColorDAO.getInstance().verificarExistencia(colorPrueba.getColor());
        assertNotNull(colorEncontrado);
        assertEquals(colorEncontrado.getId(), colorPrueba.getId());
        assertEquals(colorEncontrado.getColor(), colorPrueba.getColor());
        
    }
    
    @AfterAll
    static void testEliminarColor(){
        EntityManager em = Conexion.crearConexion();
        
        em.getTransaction().begin();
        Color colorElminar = em.find(Color.class, colorPrueba.getId());
        em.remove(colorElminar);
        em.getTransaction().commit();
        
        assertNull(em.find(Color.class, colorPrueba.getId()));
        em.close();
    }
    
}