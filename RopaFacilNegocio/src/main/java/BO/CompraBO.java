package BO;

import dtos.DetalleCompraTallaDTO;
import dtos.NuevoProductoDTO;
import dtos.ProductoDTO;
import dtos.ReposicionDTO;
import dtos.StockPorTallaDTO;
import exception.NegocioException;
import interfaces.iCompraBO;
import java.time.LocalDate;
import java.util.List;

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
        return true;
    }

    @Override
    public boolean registrarCompraReposicion(ProductoDTO producto, ReposicionDTO compra, List<DetalleCompraTallaDTO> detalleCompraTalla) throws NegocioException {
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