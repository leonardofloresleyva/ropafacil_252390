package BO;

import dtos.DetalleVentaTallaDTO;
import dtos.ProductoDTO;
import dtos.VentaDTO;
import exception.NegocioException;
import interfaces.iVentaBO;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author PC WHITE WOLF
 */
public class VentaBO implements iVentaBO{
    
    private static VentaBO instance;
    
    private VentaBO(){};
    
    public static VentaBO getInstance(){
        if(instance == null)
            instance = new VentaBO();
        return instance;
    }
    
    @Override
    public boolean registarVenta(VentaDTO venta, ProductoDTO producto, List<DetalleVentaTallaDTO> tallasVendidas) throws NegocioException {
        return true;
    }

    @Override
    public List<VentaDTO> obtenerVentasPorFecha(LocalDate fechaInicio, LocalDate fechaFinal) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<VentaDTO> obtenerVentasPorNombre(String nombre) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<VentaDTO> obtenerVentasPorColor(String color) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<VentaDTO> obtenerVentasPorTalla(String talla) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}