package DAO;

import conexion.Conexion;
import entidades.CajaAlmacenamiento;
import entidades.Categoria;
import entidades.Color;
import entidades.DetalleCompraTalla;
import entidades.NuevoProducto;
import entidades.Producto;
import entidades.Proveedor;
import entidades.Reposicion;
import entidades.StockPorTalla;
import entidades.Talla;
import entidades.TipoPrenda;
import exception.PersistenciaException;
import interfaces.iCompraDAO;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author PC WHITE WOLF
 */
public class CompraDAO implements iCompraDAO {
    
    private static CompraDAO instance;
    
    private CompraDAO (){}
    
    public static CompraDAO getInstance(){
        if(instance == null)
            instance = new CompraDAO();
        return instance;
    }
    
    @Override
    public NuevoProducto registrarNuevoProducto(
            Producto producto, 
            List<StockPorTalla> tallas, 
            NuevoProducto compra,
            List<DetalleCompraTalla> detalleCompraTalla
    ) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            
            if(ProductoDAO.getInstance().verificarExistenciaProducto(producto.getNombre(), producto.getColor().getColor()))
                throw new PersistenciaException("Ya existe un producto con el mismo nombre y color.");
            
            tallas.stream().forEach((StockPorTalla e) -> {
                try {
                    Talla talla = TallaDAO.getInstance().buscarTalla(e.getTalla());
                    if(talla != null)
                        e.setTalla(talla);
                    else
                        TallaDAO.getInstance().registrarTalla(e.getTalla());
                } catch (PersistenciaException ex) {}
            });
            producto.setTallas(tallas);
            
            Color colorEncontrado = ColorDAO.getInstance().verificarExistencia(producto.getColor().getColor());
            if(colorEncontrado != null)
                producto.setColor(colorEncontrado);
            else{
                Color nuevoColor = ColorDAO.getInstance().registrarColor(producto.getColor());
                producto.setColor(nuevoColor);
            }
            
            Categoria categoriaEncontrada = CategoriaDAO.getInstance().verificarExistencia(producto.getCategoria().getCategoria());
            if(categoriaEncontrada != null)
                producto.setCategoria(categoriaEncontrada);
            else{
                Categoria categoria = CategoriaDAO.getInstance().registrarCategoria(producto.getCategoria());
                producto.setCategoria(categoria);
            }
            
            TipoPrenda tipoEncontrado = TipoPrendaDAO.getInstance().verificarExistencia(producto.getTipo().getTipo());
            if(tipoEncontrado != null)
                producto.setTipo(tipoEncontrado);
            else{
                TipoPrenda nuevoTipo = TipoPrendaDAO.getInstance().registrarTipo(producto.getTipo());
                producto.setTipo(nuevoTipo);
            }
            
            CajaAlmacenamiento cajaEncontrada = CajaAlmacenamientoDAO.getInstance().verificarExistencia(producto.getCaja().getCaja());
            if(cajaEncontrada != null)
                producto.setCaja(cajaEncontrada);
            else{
                CajaAlmacenamiento nuevaCaja = CajaAlmacenamientoDAO.getInstance().registrarCaja(producto.getCaja());
                producto.setCaja(nuevaCaja);
            }
            
            if(producto.getProveedor() != null){
                Proveedor proveedorEncontrado = ProveedorDAO.getInstance().verificarExistencia(producto.getProveedor().getProveedor());
                if(proveedorEncontrado != null)
                    producto.setProveedor(proveedorEncontrado);
                else{
                    Proveedor nuevoProveedor = ProveedorDAO.getInstance().registrarProveedor(producto.getProveedor());
                    producto.setProveedor(nuevoProveedor);
                }
            }     
            em.persist(producto);
            
            compra.setFechaHora(LocalDateTime.now());
            int cantidadTotalTallas = 0;
            for(DetalleCompraTalla talla : detalleCompraTalla)
                cantidadTotalTallas += talla.getCantidadComprada();
            
            detalleCompraTalla.stream().forEach(e -> {
                try {
                    Talla talla = TallaDAO.getInstance().buscarTalla(e.getTalla());
                    e.setTalla(talla);
                } catch (PersistenciaException ex) {}
            });
            
            compra.setTotalCompra(cantidadTotalTallas * compra.getPrecioCompraUnitario());
            compra.setProductoComprado(producto);
            compra.setTallasCompradas(detalleCompraTalla);
            
            em.persist(compra);
            
            em.getTransaction().commit();
            return compra;
            
        } catch (PersistenciaException ex) {
            em.getTransaction().rollback();
            throw new PersistenciaException(ex.getMessage(), ex);
        } finally {
            em.close();
        }
    }

    @Override
    public Reposicion registrarReposicion(Producto producto, Reposicion compra, List<DetalleCompraTalla> detalleCompraTalla) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            
            Producto productoEncontrado = em.find(Producto.class, producto.getId());
            if(productoEncontrado == null)
                throw new PersistenciaException("El producto asociado no se encuentra registrado");
            
            compra.setFechaHora(LocalDateTime.now());
            int cantidadTotalTallas = 0;
            
            List<DetalleCompraTalla> tallasCompradas = detalleCompraTalla;
            
            for(DetalleCompraTalla tallaComprada : tallasCompradas){
                try {
                    cantidadTotalTallas += tallaComprada.getCantidadComprada();
                    Talla talla = TallaDAO.getInstance().buscarTalla(tallaComprada.getTalla());
                    if(talla == null){
                        talla = TallaDAO.getInstance().registrarTalla(tallaComprada.getTalla());
                        tallaComprada.setTalla(talla);
                    } else{
                        tallaComprada.setTalla(talla);
                    }
                    ProductoDAO.getInstance().actualizarStock(productoEncontrado, talla, tallaComprada.getCantidadComprada());
                } catch (PersistenciaException e) {
                    throw new PersistenciaException(e.getMessage(), e);
                }
            }
            
            compra.setTotalCompra(cantidadTotalTallas * compra.getPrecioCompraUnitario());
            compra.setProductoComprado(productoEncontrado);
            compra.setTallasCompradas(tallasCompradas);
            
            em.persist(compra);
            
            em.getTransaction().commit();
            return compra;
            
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new PersistenciaException(ex.getMessage(), ex);
        }finally {
            em.close();
        }
    }
    
}