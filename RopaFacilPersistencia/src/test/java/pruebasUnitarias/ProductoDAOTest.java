package pruebasUnitarias;

import DAO.ProductoDAO;
import conexion.Conexion;
import entidades.CajaAlmacenamiento;
import entidades.Categoria;
import entidades.Color;
import entidades.Producto;
import entidades.Proveedor;
import entidades.StockPorTalla;
import entidades.Talla;
import entidades.TipoPrenda;
import enums.EstadoProducto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author PC WHITE WOLF
 */
public class ProductoDAOTest {
    
    private static Producto producto;
    
    private static Color colorRojo;
    private static Color colorAzul;
    
    private static Categoria categoriaCaballero;
    private static Categoria categoriaDama;
    
    private static TipoPrenda tipoCamisa;
    private static TipoPrenda tipoChamarra;
    
    private static CajaAlmacenamiento cajaUno;
    private static CajaAlmacenamiento cajaNueve;
    
    private static Proveedor proveedorJecopaco;
    
    private static Talla tallaXS;
    private static Talla tallaS;    
    private static Talla tallaM;
    private static Talla tallaL;
    private static Talla tallaXL;
    
    @BeforeAll
    static void testRegistro() throws Exception{
        
        EntityManager em = Conexion.crearConexion();
        
        em.getTransaction().begin();
        colorRojo = new Color("Rojo");
        em.persist(colorRojo);
        em.getTransaction().commit();
        
        assertNotNull(colorRojo.getId());
        assertEquals(colorRojo.getColor(), "Rojo");
        
        em.getTransaction().begin();
        categoriaCaballero = new Categoria("CABALLERO");
        em.persist(categoriaCaballero);
        em.getTransaction().commit();
        
        assertNotNull(categoriaCaballero.getId());
        assertEquals(categoriaCaballero.getCategoria(), "CABALLERO");
        
        em.getTransaction().begin();
        tipoCamisa = new TipoPrenda("Camisa");
        em.persist(tipoCamisa);
        em.getTransaction().commit();
        
        assertNotNull(tipoCamisa.getId());
        assertEquals(tipoCamisa.getTipo(), "Camisa");
        
        em.getTransaction().begin();
        cajaUno = new CajaAlmacenamiento(1);
        em.persist(cajaUno);
        em.getTransaction().commit();
        
        assertNotNull(cajaUno.getId());
        assertEquals(cajaUno.getCaja(), 1);
        
        em.getTransaction().begin();
        proveedorJecopaco = new Proveedor("Jecopaco");
        em.persist(proveedorJecopaco);
        em.getTransaction().commit();
        
        assertNotNull(proveedorJecopaco.getId());
        assertEquals(proveedorJecopaco.getProveedor(), "Jecopaco");
        
        em.getTransaction().begin();
        tallaS = new Talla("S");
        tallaM = new Talla("M");
        tallaXL = new Talla("XL");
        
        em.persist(tallaS);
        em.persist(tallaM);
        em.persist(tallaXL);
        em.getTransaction().commit();
        
        assertNotNull(tallaS.getId());
        assertEquals(tallaS.getTalla(), "S");
        assertNotNull(tallaM.getId());
        assertEquals(tallaM.getTalla(), "M");
        assertNotNull(tallaXL.getId());
        assertEquals(tallaXL.getTalla(), "XL");
        
        em.getTransaction().begin();
        StockPorTalla stock1 = new StockPorTalla();
        stock1.setStock(4);
        stock1.setTalla(tallaM);
        
        StockPorTalla stock2 = new StockPorTalla();
        stock2.setStock(6);
        stock2.setTalla(tallaS);
        
        StockPorTalla stock3 = new StockPorTalla();
        stock3.setStock(2);
        stock3.setTalla(tallaXL);
        
        List<StockPorTalla> tallas = new ArrayList<>();
        tallas.add(stock1);
        tallas.add(stock2);
        tallas.add(stock3);
        
        producto = new Producto();
        producto.setNombre("Adidas Fight For Your Dreams");
        producto.setPrecio(1250.49);
        producto.setCaja(cajaUno);
        producto.setCategoria(categoriaCaballero);
        producto.setColor(colorRojo);
        producto.setTipo(tipoCamisa);
        producto.setProveedor(proveedorJecopaco);
        producto.setEstado(EstadoProducto.ACTIVO);
        
        producto.setTallas(tallas);
        
        em.persist(producto);
        em.getTransaction().commit();
        
        assertNotNull(producto.getId());
        assertEquals(producto.getCaja().getCaja(), 1);
        assertEquals(producto.getCategoria().getCategoria(), "CABALLERO");
        assertEquals(producto.getColor().getColor(), "Rojo");
        assertEquals(producto.getTipo().getTipo(), "Camisa");
        assertEquals(producto.getProveedor().getProveedor(), "Jecopaco");
        assertEquals(producto.getNombre(), "Adidas Fight For Your Dreams");
        assertEquals(producto.getPrecio(),  1250.49);
        assertEquals(producto.getEstado(), EstadoProducto.ACTIVO);
        
        assertTrue(producto.getTallas().contains(stock1));
        assertTrue(producto.getTallas().contains(stock2));
        assertTrue(producto.getTallas().contains(stock3));
        
        em.close();
    }
    
    @Test
    void testActualizarProducto() throws Exception{
        
        producto.setNombre("Nike Escape From Confort Zone");
        producto.setPrecio(5000.0);
        
        colorAzul = new Color("Azul");
        producto.setColor(colorAzul);
        assertNotNull(producto.getColor());
        assertEquals(producto.getColor().getColor(), "Azul");
        
        categoriaDama = new Categoria("DAMA");
        producto.setCategoria(categoriaDama);
        assertNotNull(producto.getCategoria());
        assertEquals(producto.getCategoria().getCategoria(), "DAMA");
        
        tipoChamarra = new TipoPrenda("Chamarra");
        producto.setTipo(tipoChamarra);
        assertNotNull(producto.getTipo());
        assertEquals(producto.getTipo().getTipo(), "Chamarra");
        
        cajaNueve = new CajaAlmacenamiento(9);
        producto.setCaja(cajaNueve);
        assertNotNull(producto.getCaja());
        assertEquals(producto.getCaja().getCaja(), 9);
        
        tallaXS = new Talla("XS");
        StockPorTalla stockXS = new StockPorTalla();
        stockXS.setStock(12);
        stockXS.setTalla(tallaXS);
        
        assertNotNull(stockXS.getStock());
        assertNotNull(stockXS.getTalla());
        assertEquals(stockXS.getStock(), 12);
        assertEquals(stockXS.getTalla().getTalla(), "XS");
        
        producto.agregarTalla(stockXS);
        
        assertTrue(producto.getTallas().contains(stockXS));
        
        tallaL = new Talla("L");
        StockPorTalla stockL = new StockPorTalla();
        stockL.setStock(8);
        stockL.setTalla(tallaL);
        
        assertNotNull(stockL.getStock());
        assertNotNull(stockL.getTalla());
        assertEquals(stockL.getStock(), 8);
        assertEquals(stockL.getTalla().getTalla(), "L");
        
        producto.agregarTalla(stockL);
        
        assertTrue(producto.getTallas().contains(stockL));
        
        assertTrue(ProductoDAO.getInstance().actualizarProducto(producto));
        
        EntityManager em = Conexion.crearConexion();
        
        Producto productoActualizado = em.find(Producto.class, producto.getId());
        
        assertEquals(productoActualizado.getId(), producto.getId());
        assertEquals(productoActualizado.getProveedor().getProveedor(), producto.getProveedor().getProveedor());
        
        assertEquals(productoActualizado.getNombre(), producto.getNombre());
        assertEquals(productoActualizado.getPrecio(), producto.getPrecio());
        
        boolean tieneXS = false;
        boolean tieneL = false;
        for(StockPorTalla stockPorTalla : productoActualizado.getTallas()){
            if(stockPorTalla.getTalla().getTalla().equals("XS")){
                tieneXS = true;
                tallaXS = stockPorTalla.getTalla();
                assertNotNull(tallaXS.getId());
                continue;
            }
            if(stockPorTalla.getTalla().getTalla().equals("L")){
                tieneL = true;
                tallaL = stockPorTalla.getTalla();
                assertNotNull(tallaL.getId());
            }
        }
        
        assertTrue(tieneXS);
        assertTrue(tieneL);
        
        assertEquals(productoActualizado.getColor().getColor(), producto.getColor().getColor());
        assertEquals(productoActualizado.getCategoria().getCategoria(), producto.getCategoria().getCategoria());
        assertEquals(productoActualizado.getCaja().getCaja(), producto.getCaja().getCaja());
        assertEquals(productoActualizado.getTipo().getTipo(), producto.getTipo().getTipo());
        
        Color colorCreadoAzul = em.find(Color.class, productoActualizado.getColor().getId());
        assertNotNull(colorCreadoAzul);
        assertEquals(colorCreadoAzul.getColor(), "Azul");
        
        Categoria categoriaCreadaDama = em.find(Categoria.class, productoActualizado.getCategoria().getId());
        assertNotNull(categoriaCreadaDama);
        assertEquals(categoriaCreadaDama.getCategoria(), "DAMA");
        
        CajaAlmacenamiento cajaCreadaNueve = em.find(CajaAlmacenamiento.class, productoActualizado.getCaja().getId());
        assertNotNull(cajaCreadaNueve);
        assertEquals(cajaCreadaNueve.getCaja(), 9);
        
        TipoPrenda tipoCreadoChamarra = em.find(TipoPrenda.class, productoActualizado.getTipo().getId());
        assertNotNull(tipoCreadoChamarra);
        assertEquals(tipoCreadoChamarra.getTipo(), "Chamarra");
        
        producto = productoActualizado;
        
        em.close();
        
    }
    
    @Test
    void testActualizarStock() throws Exception{
        
        assertTrue(ProductoDAO.getInstance().actualizarStock(producto, tallaS, 4));
        assertTrue(ProductoDAO.getInstance().actualizarStock(producto, tallaM, -2));
        assertTrue(ProductoDAO.getInstance().actualizarStock(producto, tallaXL, 10));
        
        EntityManager em = Conexion.crearConexion();
        
        Producto productoActualizado = em.find(Producto.class, producto.getId());
        assertNotNull(productoActualizado.getId());
        producto = productoActualizado;
        
        for(StockPorTalla stockPorTalla: producto.getTallas()){
            if(stockPorTalla.getTalla().getTalla().equals(tallaS.getTalla())){
                assertNotNull(stockPorTalla.getStock());
                assertNotEquals(stockPorTalla.getStock(), 6);
                assertEquals(stockPorTalla.getStock(), 10);
                continue;
            }
            if(stockPorTalla.getTalla().getTalla().equals(tallaM.getTalla())){
                assertNotNull(stockPorTalla.getStock());
                assertNotEquals(stockPorTalla.getStock(), 4);
                assertEquals(stockPorTalla.getStock(), 2);
                continue;
            }
            if(stockPorTalla.getTalla().getTalla().equals(tallaXL.getTalla())){
                assertNotNull(stockPorTalla.getStock());
                assertNotEquals(stockPorTalla.getStock(), 2);
                assertEquals(stockPorTalla.getStock(), 12);
            }
        }
        
        em.close();
        
    }
    
    @Test
    void testVerificarExistenciaProducto() throws Exception{
        
        assertTrue(ProductoDAO.getInstance().verificarExistenciaProducto(producto.getNombre(), producto.getColor().getColor()));
        assertFalse(ProductoDAO.getInstance().verificarExistenciaProducto(producto.getNombre(), "Verde"));
        assertFalse(ProductoDAO.getInstance().verificarExistenciaProducto("American Eagle", producto.getColor().getColor()));
        assertFalse(ProductoDAO.getInstance().verificarExistenciaProducto("", ""));
        assertFalse(ProductoDAO.getInstance().verificarExistenciaProducto(null, null));
        
    }
    
    @Test
    void testCambiarEstado() throws Exception{
        
        assertTrue(ProductoDAO.getInstance().cambiarEstado(producto));
        
        EntityManager em = Conexion.crearConexion();
        Producto productoNuevoEstado = em.find(Producto.class, producto.getId());
        assertNotNull(productoNuevoEstado.getId());
        assertNotEquals(productoNuevoEstado.getEstado(), EstadoProducto.ACTIVO);
        assertEquals(productoNuevoEstado.getEstado(), EstadoProducto.INACTIVO);
        
        producto = productoNuevoEstado;
        
        em.close();
    }
    
    @Test
    void testBuscarPorNombre() throws Exception{
        List<Producto> productosEncontrados = ProductoDAO.getInstance().buscarPorNombre(producto.getNombre());
        assertNotNull(productosEncontrados);
        boolean productoEncontrado = false;
        for(Producto productoActual : productosEncontrados){
            if(productoActual.getId() == producto.getId())
                productoEncontrado = true;
        }
        assertTrue(productoEncontrado);
        
        productosEncontrados = ProductoDAO.getInstance().buscarPorNombre("Viva el capitalismo");
        assertTrue(productosEncontrados.isEmpty());
        
        productosEncontrados = ProductoDAO.getInstance().buscarPorNombre(null);
        assertTrue(productosEncontrados.isEmpty());
        
    }
    
    @Test
    void testBuscarProductoActivoPorNombre() throws Exception{
        EntityManager em = Conexion.crearConexion();
        em.getTransaction().begin();
        Producto productoPruebaActivo = new Producto();
        productoPruebaActivo.setNombre("Nike");
        productoPruebaActivo.setPrecio(producto.getPrecio());
        productoPruebaActivo.setEstado(EstadoProducto.ACTIVO);
        productoPruebaActivo.setCaja(producto.getCaja());
        productoPruebaActivo.setCategoria(producto.getCategoria());
        productoPruebaActivo.setColor(producto.getColor());
        productoPruebaActivo.setProveedor(producto.getProveedor());
        productoPruebaActivo.setTipo(producto.getTipo());
        productoPruebaActivo.setTallas(producto.getTallas());
        
        Producto productoPruebaInactivo = new Producto();
        productoPruebaInactivo.setNombre("Nike");
        productoPruebaInactivo.setPrecio(producto.getPrecio());
        productoPruebaInactivo.setEstado(EstadoProducto.INACTIVO);
        productoPruebaInactivo.setCaja(producto.getCaja());
        productoPruebaInactivo.setCategoria(producto.getCategoria());
        productoPruebaInactivo.setColor(producto.getColor());
        productoPruebaInactivo.setProveedor(producto.getProveedor());
        productoPruebaInactivo.setTipo(producto.getTipo());
        productoPruebaInactivo.setTallas(producto.getTallas());
        
        em.persist(productoPruebaActivo);
        em.persist(productoPruebaInactivo);
        
        em.getTransaction().commit();
        
        List<Producto> productosEncontrados = ProductoDAO.getInstance().buscarProductoActivoPorNombre(productoPruebaActivo.getNombre());
        assertNotNull(productosEncontrados);
        
        boolean productoActivoEncontrado = false;
        boolean productoInactivoEncontrado = false;
        for(Producto productoActual : productosEncontrados){
            if(productoActual.getId() == productoPruebaActivo.getId())
                productoActivoEncontrado = true;
            else if(productoActual.getId() == productoPruebaInactivo.getId())
                productoInactivoEncontrado = true;
        }
        assertTrue(productoActivoEncontrado);
        assertFalse(productoInactivoEncontrado);
        
        em.getTransaction().begin();
        Producto productoPruebaActivoEncontrado = em.find(Producto.class, productoPruebaActivo.getId());
        assertNotNull(productoPruebaActivoEncontrado.getId());
        em.remove(productoPruebaActivoEncontrado);
        em.getTransaction().commit();
        
        assertNull(em.find(Producto.class, productoPruebaActivo.getId()));
        
        em.getTransaction().begin();
        Producto productoPruebaInactivoEncontrado = em.find(Producto.class, productoPruebaInactivo.getId());
        assertNotNull(productoPruebaInactivoEncontrado.getId());
        em.remove(productoPruebaInactivoEncontrado);
        em.getTransaction().commit();
        
        assertNull(em.find(Producto.class, productoPruebaInactivo.getId()));
        
        em.close();
    }
    
    @Test
    void testBuscarPorEstado() throws Exception{
        List<Producto> productosEncontrados = ProductoDAO.getInstance().buscarPorEstado(producto.getEstado());
        assertNotNull(productosEncontrados);
        boolean productoEncontrado = false;
        for(Producto productoActual : productosEncontrados){
            if(productoActual.getId() == producto.getId())
                productoEncontrado = true;
        }
        assertTrue(productoEncontrado);
        
        productosEncontrados = ProductoDAO.getInstance().buscarPorNombre(null);
        assertTrue(productosEncontrados.isEmpty());
        
    }
    
    @Test
    void testBuscarPorColor() throws Exception{
        List<Producto> productosEncontrados = ProductoDAO.getInstance().buscarPorColor(producto.getColor().getColor());
        assertNotNull(productosEncontrados);
        boolean productoEncontrado = false;
        for(Producto productoActual : productosEncontrados){
            if(productoActual.getId() == producto.getId())
                productoEncontrado = true;
        }
        assertTrue(productoEncontrado);
        
        productosEncontrados = ProductoDAO.getInstance().buscarPorColor("Viva el capitalismo");
        assertTrue(productosEncontrados.isEmpty());
        
        productosEncontrados = ProductoDAO.getInstance().buscarPorColor(null);
        assertTrue(productosEncontrados.isEmpty());
        
    }
    
    @Test
    void testBuscarProductoActivoPorColor() throws Exception{
        EntityManager em = Conexion.crearConexion();
        em.getTransaction().begin();
        Color colorPrueba = new Color("Amarillo");
        em.persist(colorPrueba);
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        Producto productoPruebaActivo = new Producto();
        productoPruebaActivo.setNombre("Nike");
        productoPruebaActivo.setPrecio(producto.getPrecio());
        productoPruebaActivo.setEstado(EstadoProducto.ACTIVO);
        productoPruebaActivo.setCaja(producto.getCaja());
        productoPruebaActivo.setCategoria(producto.getCategoria());
        productoPruebaActivo.setColor(colorPrueba);
        productoPruebaActivo.setProveedor(producto.getProveedor());
        productoPruebaActivo.setTipo(producto.getTipo());
        productoPruebaActivo.setTallas(producto.getTallas());
        
        Producto productoPruebaInactivo = new Producto();
        productoPruebaInactivo.setNombre("Nike");
        productoPruebaInactivo.setPrecio(producto.getPrecio());
        productoPruebaInactivo.setEstado(EstadoProducto.INACTIVO);
        productoPruebaInactivo.setCaja(producto.getCaja());
        productoPruebaInactivo.setCategoria(producto.getCategoria());
        productoPruebaInactivo.setColor(colorPrueba);
        productoPruebaInactivo.setProveedor(producto.getProveedor());
        productoPruebaInactivo.setTipo(producto.getTipo());
        productoPruebaInactivo.setTallas(producto.getTallas());
        
        em.persist(productoPruebaActivo);
        em.persist(productoPruebaInactivo);
        
        em.getTransaction().commit();
        
        List<Producto> productosEncontrados = ProductoDAO.getInstance().buscarProductoAcivoPorColor(colorPrueba.getColor());
        assertNotNull(productosEncontrados);
        
        boolean productoActivoEncontrado = false;
        boolean productoInactivoEncontrado = false;
        for(Producto productoActual : productosEncontrados){
            if(productoActual.getId() == productoPruebaActivo.getId())
                productoActivoEncontrado = true;
            else if(productoActual.getId() == productoPruebaInactivo.getId())
                productoInactivoEncontrado = true;
        }
        assertTrue(productoActivoEncontrado);
        assertFalse(productoInactivoEncontrado);
        
        em.getTransaction().begin();
        Producto productoPruebaActivoEncontrado = em.find(Producto.class, productoPruebaActivo.getId());
        assertNotNull(productoPruebaActivoEncontrado.getId());
        em.remove(productoPruebaActivoEncontrado);
        em.getTransaction().commit();
        
        assertNull(em.find(Producto.class, productoPruebaActivo.getId()));
        
        em.getTransaction().begin();
        Producto productoPruebaInactivoEncontrado = em.find(Producto.class, productoPruebaInactivo.getId());
        assertNotNull(productoPruebaInactivoEncontrado.getId());
        em.remove(productoPruebaInactivoEncontrado);
        em.getTransaction().commit();
        
        assertNull(em.find(Producto.class, productoPruebaInactivo.getId()));
        
        em.getTransaction().begin();
        Color colorElminar = em.find(Color.class, colorPrueba.getId());
        em.remove(colorElminar);
        em.getTransaction().commit();
        
        assertNull(em.find(Color.class, colorPrueba.getId()));
        
        em.close();
    }
    
    @Test
    void testBuscarPorCategoria() throws Exception{
        List<Producto> productosEncontrados = ProductoDAO.getInstance().buscarPorCategoria(producto.getCategoria().getCategoria());
        assertNotNull(productosEncontrados);
        boolean productoEncontrado = false;
        for(Producto productoActual : productosEncontrados){
            if(productoActual.getId() == producto.getId())
                productoEncontrado = true;
        }
        assertTrue(productoEncontrado);
        
        productosEncontrados = ProductoDAO.getInstance().buscarPorCategoria("Viva el capitalismo");
        assertTrue(productosEncontrados.isEmpty());
        
        productosEncontrados = ProductoDAO.getInstance().buscarPorCategoria(null);
        assertTrue(productosEncontrados.isEmpty());
        
    }
    
    @Test
    void testBuscarProductoActivoPorCategoria() throws Exception{
        EntityManager em = Conexion.crearConexion();
        em.getTransaction().begin();
        Categoria categoriaPrueba = new Categoria("Unisex");
        em.persist(categoriaPrueba);
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        Producto productoPruebaActivo = new Producto();
        productoPruebaActivo.setNombre("Nike");
        productoPruebaActivo.setPrecio(producto.getPrecio());
        productoPruebaActivo.setEstado(EstadoProducto.ACTIVO);
        productoPruebaActivo.setCaja(producto.getCaja());
        productoPruebaActivo.setCategoria(categoriaPrueba);
        productoPruebaActivo.setColor(producto.getColor());
        productoPruebaActivo.setProveedor(producto.getProveedor());
        productoPruebaActivo.setTipo(producto.getTipo());
        productoPruebaActivo.setTallas(producto.getTallas());
        
        Producto productoPruebaInactivo = new Producto();
        productoPruebaInactivo.setNombre("Nike");
        productoPruebaInactivo.setPrecio(producto.getPrecio());
        productoPruebaInactivo.setEstado(EstadoProducto.INACTIVO);
        productoPruebaInactivo.setCaja(producto.getCaja());
        productoPruebaInactivo.setCategoria(categoriaPrueba);
        productoPruebaInactivo.setColor(producto.getColor());
        productoPruebaInactivo.setProveedor(producto.getProveedor());
        productoPruebaInactivo.setTipo(producto.getTipo());
        productoPruebaInactivo.setTallas(producto.getTallas());
        
        em.persist(productoPruebaActivo);
        em.persist(productoPruebaInactivo);
        
        em.getTransaction().commit();
        
        List<Producto> productosEncontrados = ProductoDAO.getInstance().buscarProductoActivoPorCategoria(categoriaPrueba.getCategoria());
        assertNotNull(productosEncontrados);
        
        boolean productoActivoEncontrado = false;
        boolean productoInactivoEncontrado = false;
        for(Producto productoActual : productosEncontrados){
            if(productoActual.getId() == productoPruebaActivo.getId())
                productoActivoEncontrado = true;
            else if(productoActual.getId() == productoPruebaInactivo.getId())
                productoInactivoEncontrado = true;
        }
        assertTrue(productoActivoEncontrado);
        assertFalse(productoInactivoEncontrado);
        
        em.getTransaction().begin();
        Producto productoPruebaActivoEncontrado = em.find(Producto.class, productoPruebaActivo.getId());
        assertNotNull(productoPruebaActivoEncontrado.getId());
        em.remove(productoPruebaActivoEncontrado);
        em.getTransaction().commit();
        
        assertNull(em.find(Producto.class, productoPruebaActivo.getId()));
        
        em.getTransaction().begin();
        Producto productoPruebaInactivoEncontrado = em.find(Producto.class, productoPruebaInactivo.getId());
        assertNotNull(productoPruebaInactivoEncontrado.getId());
        em.remove(productoPruebaInactivoEncontrado);
        em.getTransaction().commit();
        
        assertNull(em.find(Producto.class, productoPruebaInactivo.getId()));
        
        em.getTransaction().begin();
        Categoria categoriaElminar = em.find(Categoria.class, categoriaPrueba.getId());
        em.remove(categoriaElminar);
        em.getTransaction().commit();
        
        assertNull(em.find(Color.class, categoriaPrueba.getId()));
        
        em.close();
    }
    
    @Test
    void testBuscarPorTalla() throws Exception{
        List<Producto> productosEncontrados = ProductoDAO.getInstance().buscarPorTalla(tallaM.getTalla());
        assertNotNull(productosEncontrados);
        boolean productoEncontrado = false;
        for(Producto productoActual : productosEncontrados){
            if(productoActual.getId() == producto.getId())
                productoEncontrado = true;
        }
        assertTrue(productoEncontrado);
        
        productosEncontrados = ProductoDAO.getInstance().buscarPorCategoria("Viva el capitalismo");
        assertTrue(productosEncontrados.isEmpty());
        
        productosEncontrados = ProductoDAO.getInstance().buscarPorCategoria(null);
        assertTrue(productosEncontrados.isEmpty());
        
    }
    
    @Test
    void testBuscarProductoActivoPorTalla() throws Exception{
        EntityManager em = Conexion.crearConexion();
        
        em.getTransaction().begin();
        Talla tallaXXX = new Talla("XXX");
        em.persist(tallaXXX);
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        
        StockPorTalla stockXXX = new StockPorTalla();
        stockXXX.setStock(1);
        stockXXX.setTalla(tallaXXX);
        
        Producto productoPruebaActivo = new Producto();
        productoPruebaActivo.setNombre("Nike");
        productoPruebaActivo.setPrecio(producto.getPrecio());
        productoPruebaActivo.setEstado(EstadoProducto.ACTIVO);
        productoPruebaActivo.setCaja(producto.getCaja());
        productoPruebaActivo.setCategoria(producto.getCategoria());
        productoPruebaActivo.setColor(producto.getColor());
        productoPruebaActivo.setProveedor(producto.getProveedor());
        productoPruebaActivo.setTipo(producto.getTipo());
        productoPruebaActivo.agregarTalla(stockXXX);
        
        Producto productoPruebaInactivo = new Producto();
        productoPruebaInactivo.setNombre("Nike");
        productoPruebaInactivo.setPrecio(producto.getPrecio());
        productoPruebaInactivo.setEstado(EstadoProducto.INACTIVO);
        productoPruebaInactivo.setCaja(producto.getCaja());
        productoPruebaInactivo.setCategoria(producto.getCategoria());
        productoPruebaInactivo.setColor(producto.getColor());
        productoPruebaInactivo.setProveedor(producto.getProveedor());
        productoPruebaInactivo.setTipo(producto.getTipo());
        productoPruebaInactivo.agregarTalla(stockXXX);
        
        em.persist(productoPruebaActivo);
        em.persist(productoPruebaInactivo);
        
        em.getTransaction().commit();
        
        List<Producto> productosEncontrados = ProductoDAO.getInstance().buscarProductoActivoPorTalla(tallaXXX.getTalla());
        assertNotNull(productosEncontrados);
        
        boolean productoActivoEncontrado = false;
        boolean productoInactivoEncontrado = false;
        for(Producto productoActual : productosEncontrados){
            if(productoActual.getId() == productoPruebaActivo.getId())
                productoActivoEncontrado = true;
            else if(productoActual.getId() == productoPruebaInactivo.getId())
                productoInactivoEncontrado = true;
        }
        assertTrue(productoActivoEncontrado);
        assertFalse(productoInactivoEncontrado);
        
        em.getTransaction().begin();
        Producto productoPruebaActivoEncontrado = em.find(Producto.class, productoPruebaActivo.getId());
        assertNotNull(productoPruebaActivoEncontrado.getId());
        em.remove(productoPruebaActivoEncontrado);
        em.getTransaction().commit();
        
        assertNull(em.find(Producto.class, productoPruebaActivo.getId()));
        
        em.getTransaction().begin();
        Producto productoPruebaInactivoEncontrado = em.find(Producto.class, productoPruebaInactivo.getId());
        assertNotNull(productoPruebaInactivoEncontrado.getId());
        em.remove(productoPruebaInactivoEncontrado);
        em.getTransaction().commit();
        
        assertNull(em.find(Producto.class, productoPruebaInactivo.getId()));
        
        em.getTransaction().begin();
        Talla tallaEliminarXXX = em.find(Talla.class, tallaXXX.getId());
        em.remove(tallaEliminarXXX);
        em.getTransaction().commit();
        
        em.close();
    }
    
    @Test
    void testBuscarPorTipo() throws Exception{
        List<Producto> productosEncontrados = ProductoDAO.getInstance().buscarPorTipo(producto.getTipo().getTipo());
        assertNotNull(productosEncontrados);
        boolean productoEncontrado = false;
        for(Producto productoActual : productosEncontrados){
            if(productoActual.getId() == producto.getId())
                productoEncontrado = true;
        }
        assertTrue(productoEncontrado);
        
        productosEncontrados = ProductoDAO.getInstance().buscarPorTipo("Viva el capitalismo");
        assertTrue(productosEncontrados.isEmpty());
        
        productosEncontrados = ProductoDAO.getInstance().buscarPorTipo(null);
        assertTrue(productosEncontrados.isEmpty());
        
    }
    
    @Test
    void testBuscarProductoActivoPorTipo() throws Exception{
        EntityManager em = Conexion.crearConexion();
        em.getTransaction().begin();
        TipoPrenda tipoPrueba = new TipoPrenda("Falda");
        em.persist(tipoPrueba);
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        Producto productoPruebaActivo = new Producto();
        productoPruebaActivo.setNombre("Nike");
        productoPruebaActivo.setPrecio(producto.getPrecio());
        productoPruebaActivo.setEstado(EstadoProducto.ACTIVO);
        productoPruebaActivo.setCaja(producto.getCaja());
        productoPruebaActivo.setCategoria(producto.getCategoria());
        productoPruebaActivo.setColor(producto.getColor());
        productoPruebaActivo.setProveedor(producto.getProveedor());
        productoPruebaActivo.setTipo(tipoPrueba);
        productoPruebaActivo.setTallas(producto.getTallas());
        
        Producto productoPruebaInactivo = new Producto();
        productoPruebaInactivo.setNombre("Nike");
        productoPruebaInactivo.setPrecio(producto.getPrecio());
        productoPruebaInactivo.setEstado(EstadoProducto.INACTIVO);
        productoPruebaInactivo.setCaja(producto.getCaja());
        productoPruebaInactivo.setCategoria(producto.getCategoria());
        productoPruebaInactivo.setColor(producto.getColor());
        productoPruebaInactivo.setProveedor(producto.getProveedor());
        productoPruebaInactivo.setTipo(tipoPrueba);
        productoPruebaInactivo.setTallas(producto.getTallas());
        
        em.persist(productoPruebaActivo);
        em.persist(productoPruebaInactivo);
        
        em.getTransaction().commit();
        
        List<Producto> productosEncontrados = ProductoDAO.getInstance().buscarProductoActivoPorTipo(tipoPrueba.getTipo());
        assertNotNull(productosEncontrados);
        
        boolean productoActivoEncontrado = false;
        boolean productoInactivoEncontrado = false;
        for(Producto productoActual : productosEncontrados){
            if(productoActual.getId() == productoPruebaActivo.getId())
                productoActivoEncontrado = true;
            else if(productoActual.getId() == productoPruebaInactivo.getId())
                productoInactivoEncontrado = true;
        }
        assertTrue(productoActivoEncontrado);
        assertFalse(productoInactivoEncontrado);
        
        em.getTransaction().begin();
        Producto productoPruebaActivoEncontrado = em.find(Producto.class, productoPruebaActivo.getId());
        assertNotNull(productoPruebaActivoEncontrado.getId());
        em.remove(productoPruebaActivoEncontrado);
        em.getTransaction().commit();
        
        assertNull(em.find(Producto.class, productoPruebaActivo.getId()));
        
        em.getTransaction().begin();
        Producto productoPruebaInactivoEncontrado = em.find(Producto.class, productoPruebaInactivo.getId());
        assertNotNull(productoPruebaInactivoEncontrado.getId());
        em.remove(productoPruebaInactivoEncontrado);
        em.getTransaction().commit();
        
        assertNull(em.find(Producto.class, productoPruebaInactivo.getId()));
        
        em.getTransaction().begin();
        TipoPrenda tipoElminar = em.find(TipoPrenda.class, tipoPrueba.getId());
        em.remove(tipoElminar);
        em.getTransaction().commit();
        
        assertNull(em.find(Color.class, tipoElminar.getId()));
        
        em.close();
    }
    
    @Test
    void testBuscarPorCaja() throws Exception{
        List<Producto> productosEncontrados = ProductoDAO.getInstance().buscarPorCaja(producto.getCaja().getCaja());
        assertNotNull(productosEncontrados);
        boolean productoEncontrado = false;
        for(Producto productoActual : productosEncontrados){
            if(productoActual.getId() == producto.getId())
                productoEncontrado = true;
        }
        assertTrue(productoEncontrado);
        
        productosEncontrados = ProductoDAO.getInstance().buscarPorCaja(0);
        assertTrue(productosEncontrados.isEmpty());
        
        productosEncontrados = ProductoDAO.getInstance().buscarPorCaja(null);
        assertTrue(productosEncontrados.isEmpty());
        
    }
    
    @AfterAll
    static void testEliminarProducto() throws Exception{
        EntityManager em = Conexion.crearConexion();
        
        em.getTransaction().begin();
        Producto productoEliminar = em.find(Producto.class, producto.getId());
        em.remove(productoEliminar);
        em.getTransaction().commit();
        
        assertNull(em.find(Producto.class, producto.getId()));
        
        em.getTransaction().begin();
        Color colorElminarRojo = em.find(Color.class, colorRojo.getId());
        em.remove(colorElminarRojo);
        em.getTransaction().commit();
        
        assertNull(em.find(Color.class, colorRojo.getId()));
        
        em.getTransaction().begin();
        Color colorElminarAzul = em.find(Color.class, colorAzul.getId());
        em.remove(colorElminarAzul);
        em.getTransaction().commit();
        
        assertNull(em.find(Color.class, colorAzul.getId()));
        
        em.getTransaction().begin();
        Categoria categoriaEliminar = em.find(Categoria.class, categoriaCaballero.getId());
        em.remove(categoriaEliminar);
        em.getTransaction().commit();
        
        assertNull(em.find(Categoria.class, categoriaCaballero.getId()));
        
        em.getTransaction().begin();
        Categoria categoriaEliminarDama = em.find(Categoria.class, categoriaDama.getId());
        em.remove(categoriaEliminarDama);
        em.getTransaction().commit();
        
        assertNull(em.find(Categoria.class, categoriaDama.getId()));
        
        em.getTransaction().begin();
        TipoPrenda tipoEliminarCamisa = em.find(TipoPrenda.class, tipoCamisa.getId());
        em.remove(tipoEliminarCamisa);
        em.getTransaction().commit();
        
        assertNull(em.find(TipoPrenda.class, tipoCamisa.getId()));
        
        em.getTransaction().begin();
        TipoPrenda tipoEliminarChamarra = em.find(TipoPrenda.class, tipoChamarra.getId());
        em.remove(tipoEliminarChamarra);
        em.getTransaction().commit();
        
        assertNull(em.find(TipoPrenda.class, tipoChamarra.getId()));
        
        em.getTransaction().begin();
        CajaAlmacenamiento cajaEliminarUno = em.find(CajaAlmacenamiento.class, cajaUno.getId());
        em.remove(cajaEliminarUno);
        em.getTransaction().commit();
        
        assertNull(em.find(CajaAlmacenamiento.class, cajaUno.getId()));
        
        em.getTransaction().begin();
        CajaAlmacenamiento cajaEliminarNueve = em.find(CajaAlmacenamiento.class, cajaNueve.getId());
        em.remove(cajaEliminarNueve);
        em.getTransaction().commit();
        
        assertNull(em.find(CajaAlmacenamiento.class, cajaNueve.getId()));
        
        em.getTransaction().begin();
        Proveedor proveedorEliminar = em.find(Proveedor.class, proveedorJecopaco.getId());
        em.remove(proveedorEliminar);
        em.getTransaction().commit();
        
        assertNull(em.find(Proveedor.class, proveedorJecopaco.getId()));
        
        em.getTransaction().begin();
        Talla tallaEliminarXS = em.find(Talla.class, tallaXS.getId());
        em.remove(tallaEliminarXS);
        em.getTransaction().commit();
        
        assertNull(em.find(Talla.class, tallaXS.getId()));
        
        em.getTransaction().begin();
        Talla tallaEliminarS = em.find(Talla.class, tallaS.getId());
        em.remove(tallaEliminarS);
        em.getTransaction().commit();
        
        assertNull(em.find(Talla.class, tallaS.getId()));
        
        em.getTransaction().begin();
        Talla tallaEliminarM = em.find(Talla.class, tallaM.getId());
        em.remove(tallaEliminarM);
        em.getTransaction().commit();
        
        assertNull(em.find(Talla.class, tallaM.getId()));
        
        em.getTransaction().begin();
        Talla tallaEliminarL = em.find(Talla.class, tallaL.getId());
        em.remove(tallaEliminarL);
        em.getTransaction().commit();
        
        assertNull(em.find(Talla.class, tallaL.getId()));
        
        em.getTransaction().begin();
        Talla tallaEliminarXL = em.find(Talla.class, tallaXL.getId());
        em.remove(tallaEliminarXL);
        em.getTransaction().commit();
        
        assertNull(em.find(Talla.class, tallaXL.getId()));
        
        em.close();
    }
    
}