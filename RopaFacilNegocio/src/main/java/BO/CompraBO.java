package BO;

import DAO.CompraDAO;
import dtos.DetalleCompraTallaDTO;
import dtos.NuevoProductoDTO;
import dtos.ProductoDTO;
import dtos.ReposicionDTO;
import dtos.StockPorTallaDTO;
import entidades.DetalleCompraTalla;
import entidades.NuevoProducto;
import entidades.Producto;
import entidades.Reposicion;
import entidades.StockPorTalla;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.iCompraBO;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.DetalleCompraTallaMapper;
import mappers.NuevoProductoMapper;
import mappers.ProductoMapper;
import mappers.ReposicionMapper;
import mappers.StockPorTallaMapper;

/**
 *
 * @author PC WHITE WOLF
 */
public class CompraBO implements iCompraBO{

    private static CompraBO instance;
    
    private CompraBO(){};
    
    public static CompraBO getInstance(){
        if(instance == null)
            instance = new CompraBO();
        return instance;
    }
    
    @Override
    public boolean registrarCompraNuevoProducto(ProductoDTO producto, List<StockPorTallaDTO> tallas, NuevoProductoDTO compra, List<DetalleCompraTallaDTO> detalleCompraTalla) throws NegocioException {
        Producto productoNuevo = ProductoMapper.toEntityNuevo(producto);
        List<StockPorTalla> tallasNuevas = tallas.stream().map(e -> StockPorTallaMapper.toEntityNuevo(e)).toList();
        NuevoProducto compraNueva = NuevoProductoMapper.toEntityNuevo(compra);
        List<DetalleCompraTalla> tallasCompradas = detalleCompraTalla.stream().map(e -> DetalleCompraTallaMapper.toEntityNuevo(e)).toList();
        try {
            compraNueva = CompraDAO.getInstance().registrarNuevoProducto(productoNuevo, tallasNuevas, compraNueva, tallasCompradas);
            return compraNueva.getId() != null;
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage(), ex);
        }
        
    }

    @Override
    public boolean registrarCompraReposicion(ProductoDTO producto, ReposicionDTO compra, List<DetalleCompraTallaDTO> detalleCompraTalla) throws NegocioException {
        Producto productoNuevo = ProductoMapper.toEntityNuevo(producto);
        Reposicion compraNueva = ReposicionMapper.toEntityNuevo(compra);
        List<DetalleCompraTalla> tallasCompradas = detalleCompraTalla.stream().map(e -> DetalleCompraTallaMapper.toEntityNuevo(e)).toList();
        return true;
    }

    @Override
    public List<NuevoProductoDTO> obtenerNuevosProductosFecha(LocalDate fechaInicial, LocalDate fechaFinal) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ReposicionDTO> obtenerReposicionesFecha(LocalDate fechaInicial, LocalDate fechaFinal) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NuevoProductoDTO> obtenerNuevosProductosNombre(String nombre) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ReposicionDTO> obtenerReposicionesNombre(String nombre) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NuevoProductoDTO> obtenerNuevosProductosProveedor(String proveedor) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ReposicionDTO> obtenerReposicionesProveedor(String proveedor) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}