package mappers;

import dtos.DetalleVentaProductoDTO;
import dtos.ProductoDTO;
import dtos.VentaDTO;
import entidades.DetalleVentaProducto;
import entidades.Producto;
import entidades.Venta;

/**
 *
 * @author PC WHITE WOLF
 */
public class DetalleVentaProductoMapper {
    
    public static DetalleVentaProducto toEntityNuevo(DetalleVentaProductoDTO detalleVentaProductoDTO){
        DetalleVentaProducto detalleVentaProducto = new DetalleVentaProducto();
        detalleVentaProducto.setId(detalleVentaProductoDTO.getId());
        detalleVentaProducto.setPrecioVenta(detalleVentaProductoDTO.getPrecioVenta());
        
        return detalleVentaProducto;
    }
    
    public static DetalleVentaProducto toEntityViejo(DetalleVentaProductoDTO detalleVentaProductoDTO){
        DetalleVentaProducto detalleVentaProducto = new DetalleVentaProducto();
        detalleVentaProducto.setId(detalleVentaProductoDTO.getId());
        detalleVentaProducto.setPrecioVenta(detalleVentaProductoDTO.getPrecioVenta());
        
        detalleVentaProducto.setProducto(ProductoMapper.toEntityViejo(detalleVentaProductoDTO.getProducto()));
        
        Venta venta = new Venta();
        venta.setId(detalleVentaProductoDTO.getId());
        detalleVentaProducto.setVenta(venta);
        
        return detalleVentaProducto;
    }
    
    public static DetalleVentaProductoDTO toDTONuevo(DetalleVentaProducto detalleVentaProducto){
        DetalleVentaProductoDTO detalleVentaProductoDTO = new DetalleVentaProductoDTO();
        detalleVentaProductoDTO.setId(detalleVentaProducto.getId());
        detalleVentaProductoDTO.setPrecioVenta(detalleVentaProducto.getPrecioVenta());
        
        return detalleVentaProductoDTO;
    }
    
    public static DetalleVentaProductoDTO toDTOViejo(DetalleVentaProducto detalleVentaProducto){
        DetalleVentaProductoDTO detalleVentaProductoDTO = new DetalleVentaProductoDTO();
        detalleVentaProductoDTO.setId(detalleVentaProducto.getId());
        detalleVentaProductoDTO.setPrecioVenta(detalleVentaProducto.getPrecioVenta());
        
        detalleVentaProductoDTO.setProducto(ProductoMapper.toDTOViejo(detalleVentaProducto.getProducto()));
        
        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setId(detalleVentaProducto.getId());
        detalleVentaProductoDTO.setVenta(ventaDTO);
        
        return detalleVentaProductoDTO;
    }
}