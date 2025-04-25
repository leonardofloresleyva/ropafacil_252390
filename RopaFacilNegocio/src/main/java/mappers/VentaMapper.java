package mappers;

import dtos.VentaDTO;
import entidades.Venta;

/**
 *
 * @author PC WHITE WOLF
 */
public class VentaMapper {
    
    public static Venta toEntityNuevo(VentaDTO ventaDTO){
        Venta venta = new Venta();
        venta.setFechaHora(ventaDTO.getFechaHora());
        venta.setTotalVenta(ventaDTO.getTotalVenta());
        
        return venta;
    }
    
    public static Venta toEntityViejo(VentaDTO ventaDTO){
        Venta venta = new Venta();
        venta.setId(ventaDTO.getId());
        venta.setFechaHora(ventaDTO.getFechaHora());
        venta.setTotalVenta(ventaDTO.getTotalVenta());
        
        venta.setProductoVendido(DetalleVentaProductoMapper.toEntityViejo(ventaDTO.getProductoVendido()));
        venta.setTallasVendidas(ventaDTO.getTallasVendidas().stream().map(e -> DetalleVentaTallaMapper.toEntityViejo(e)).toList());
        
        return venta;
    }
    
    public static VentaDTO toDTONuevo(Venta venta){
        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setFechaHora(venta.getFechaHora());
        ventaDTO.setTotalVenta(venta.getTotalVenta());
        
        return ventaDTO;
    }
    
    public static VentaDTO toDTOViejo(Venta venta){
        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setId(venta.getId());
        ventaDTO.setFechaHora(venta.getFechaHora());
        ventaDTO.setTotalVenta(venta.getTotalVenta());
        
        ventaDTO.setProductoVendido(DetalleVentaProductoMapper.toDTOViejo(venta.getProductoVendido()));
        ventaDTO.setTallasVendidas(venta.getTallasVendidas().stream().map(e -> DetalleVentaTallaMapper.toDTOViejo(e)).toList());
        
        return ventaDTO;
    }
}