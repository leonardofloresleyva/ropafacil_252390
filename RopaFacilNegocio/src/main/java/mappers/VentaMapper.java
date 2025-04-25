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
        venta.setPrecioVenta(ventaDTO.getPrecioVenta());
        
        return venta;
    }
    
    public static Venta toEntityViejo(VentaDTO ventaDTO){
        Venta venta = new Venta();
        venta.setId(ventaDTO.getId());
        venta.setFechaHora(ventaDTO.getFechaHora());
        venta.setTotalVenta(ventaDTO.getTotalVenta());
        venta.setPrecioVenta(ventaDTO.getPrecioVenta());
        
        venta.setProductoVendido(ProductoMapper.toEntityViejo(ventaDTO.getProductoVendido()));
        venta.setTallasVendidas(ventaDTO.getTallasVendidas().stream().map(e -> DetalleVentaTallaMapper.toEntityViejo(e)).toList());
        
        return venta;
    }
    
    public static VentaDTO toDTONuevo(Venta venta){
        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setPrecioVenta(venta.getPrecioVenta());
        
        return ventaDTO;
    }
    
    public static VentaDTO toDTOViejo(Venta venta){
        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setId(venta.getId());
        ventaDTO.setFechaHora(venta.getFechaHora());
        ventaDTO.setTotalVenta(venta.getTotalVenta());
        ventaDTO.setPrecioVenta(venta.getPrecioVenta());
        
        ventaDTO.setProductoVendido(ProductoMapper.toDTOViejo(venta.getProductoVendido()));
        ventaDTO.setTallasVendidas(venta.getTallasVendidas().stream().map(e -> DetalleVentaTallaMapper.toDTOViejo(e)).toList());
        
        return ventaDTO;
    }
}