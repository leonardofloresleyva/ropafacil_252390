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
import java.util.ArrayList;
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
        
        if(venta == null)
            throw new NegocioException("La venta no puede estar vacía");
        
        if(venta.getProductoVendido() == null)
            throw new NegocioException("El producto no puede estar vacío");
        
        if(tallasVendidas == null)
            throw new NegocioException("Las tallas no pueden estar vacías");
        
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
        List<VentaDTO> ventas = new ArrayList<>();
        try {
            List<Venta> ventasObtenidas = VentaDAO.getInstance().obtenerVentasPorFecha(fechaInicio, fechaFinal);
            ventasObtenidas.stream().forEach(e -> ventas.add(VentaMapper.toDTOViejo(e)));
            return ventas;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @Override
    public List<VentaDTO> obtenerVentasPorNombre(String nombre) throws NegocioException {
        List<VentaDTO> ventas = new ArrayList<>();
        try {
            List<Venta> ventasObtenidas = VentaDAO.getInstance().obtenerVentasPorNombre(nombre);
            ventasObtenidas.stream().forEach(e -> ventas.add(VentaMapper.toDTOViejo(e)));
            return ventas;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @Override
    public List<VentaDTO> obtenerVentasPorColor(String color) throws NegocioException {
        List<VentaDTO> ventas = new ArrayList<>();
        try {
            List<Venta> ventasObtenidas = VentaDAO.getInstance().obtenerVentasPorColor(color);
            ventasObtenidas.stream().forEach(e -> ventas.add(VentaMapper.toDTOViejo(e)));
            return ventas;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @Override
    public List<VentaDTO> obtenerVentasPorTalla(String talla) throws NegocioException {
        List<VentaDTO> ventas = new ArrayList<>();
        try {
            List<Venta> ventasObtenidas = VentaDAO.getInstance().obtenerVentasPorTalla(talla);
            ventasObtenidas.stream().forEach(e -> ventas.add(VentaMapper.toDTOViejo(e)));
            return ventas;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }
    
}