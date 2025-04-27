package interfaces;

import entidades.DetalleVentaTalla;
import entidades.Venta;
import exception.PersistenciaException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author PC WHITE WOLF
 */
public interface iVentaDAO {
    public boolean registarVenta(Venta venta, List<DetalleVentaTalla> tallasVendidas) throws PersistenciaException;
    
    public List<Venta> obtenerVentasPorFecha(LocalDate fechaInicio, LocalDate fechaFinal) throws PersistenciaException;
    
    public List<Venta> obtenerVentasPorNombre(String nombre) throws PersistenciaException;
    
    public List<Venta> obtenerVentasPorColor(String color) throws PersistenciaException;
    
    public List<Venta> obtenerVentasPorTalla(String talla) throws PersistenciaException;
    
}