package BO;

import DAO.VentaDAO;
import dtos.DetalleVentaTallaDTO;
import dtos.VentaDTO;
import entidades.DetalleVentaTalla;
import entidades.Venta;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.iVentaBO;
import java.time.LocalDate;
import java.util.List;
import mappers.DetalleVentaTallaMapper;
import mappers.VentaMapper;

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
    public boolean registarVenta(VentaDTO venta, List<DetalleVentaTallaDTO> tallasVendidas) throws NegocioException {
        Venta ventaNueva = VentaMapper.toEntityNuevo(venta);
        List<DetalleVentaTalla> tallasVender = tallasVendidas.stream().map(e -> DetalleVentaTallaMapper.toEntityNuevo(e)).toList();
        try {
            return VentaDAO.getInstance().registarVenta(ventaNueva, tallasVender);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
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