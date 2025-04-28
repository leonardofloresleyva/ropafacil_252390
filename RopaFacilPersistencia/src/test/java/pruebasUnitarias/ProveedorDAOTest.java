package pruebasUnitarias;

import DAO.ProveedorDAO;
import conexion.Conexion;
import entidades.Proveedor;
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
public class ProveedorDAOTest {
    
    private static Proveedor proveedorPrueba;
    
    @BeforeAll
    static void testRegistrarColor(){
        EntityManager em = Conexion.crearConexion();
        em.getTransaction().begin();
        proveedorPrueba = new Proveedor("Navojoa");
        em.persist(proveedorPrueba);
        em.getTransaction().commit();
        
        assertNotNull(proveedorPrueba.getId());
        assertEquals(proveedorPrueba.getProveedor(), "Navojoa");
    }
    
    @Test
    void testVerificarExistencia() throws Exception{
        
        Proveedor proveedorEncontrado = ProveedorDAO.getInstance().verificarExistencia(proveedorPrueba.getProveedor());
        assertNotNull(proveedorEncontrado);
        assertEquals(proveedorEncontrado.getId(), proveedorPrueba.getId());
        assertEquals(proveedorEncontrado.getProveedor(), proveedorPrueba.getProveedor());
        
    }
    
    @AfterAll
    static void testEliminarColor(){
        EntityManager em = Conexion.crearConexion();
        
        em.getTransaction().begin();
        Proveedor proveedorElminar = em.find(Proveedor.class, proveedorPrueba.getId());
        em.remove(proveedorElminar);
        em.getTransaction().commit();
        
        assertNull(em.find(Proveedor.class, proveedorPrueba.getId()));
        em.close();
    }
}