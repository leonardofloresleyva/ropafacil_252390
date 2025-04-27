package interfaces;

import dtos.DetalleVentaTallaDTO;
import dtos.ProductoDTO;
import dtos.VentaDTO;
import exception.NegocioException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author PC WHITE WOLF
 */
public interface iVentaBO {
    
    public boolean registarVenta(VentaDTO venta, List<DetalleVentaTallaDTO> tallasVendidas) throws NegocioException;
    
    public List<VentaDTO> obtenerVentasPorFecha(LocalDate fechaInicio, LocalDate fechaFinal) throws NegocioException;
    
    public List<VentaDTO> obtenerVentasPorNombre(String nombre) throws NegocioException;
    
    public List<VentaDTO> obtenerVentasPorColor(String color) throws NegocioException;
    
    public List<VentaDTO> obtenerVentasPorTalla(String talla) throws NegocioException;
    
}