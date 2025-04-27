package mappers;

import dtos.DetalleVentaTallaDTO;
import dtos.VentaDTO;
import entidades.DetalleVentaTalla;
import entidades.Venta;

/**
 *
 * @author PC WHITE WOLF
 */
public class DetalleVentaTallaMapper {
    
    public static DetalleVentaTalla toEntityNuevo(DetalleVentaTallaDTO detalleVentaTallaDTO){
        DetalleVentaTalla detalleVentaTalla = new DetalleVentaTalla();
        detalleVentaTalla.setCantidadVendida(detalleVentaTallaDTO.getCantidadVendida());
        detalleVentaTalla.setSubtotalVenta(detalleVentaTallaDTO.getSubtotalVenta());
        detalleVentaTalla.setTalla(TallaMapper.toEntityViejo(detalleVentaTallaDTO.getTalla()));
        
        return detalleVentaTalla;
    }
    
    public static DetalleVentaTalla toEntityViejo(DetalleVentaTallaDTO detalleVentaTallaDTO){
        DetalleVentaTalla detalleVentaTalla = new DetalleVentaTalla();
        detalleVentaTalla.setId(detalleVentaTallaDTO.getId());
        detalleVentaTalla.setCantidadVendida(detalleVentaTallaDTO.getCantidadVendida());
        detalleVentaTalla.setSubtotalVenta(detalleVentaTallaDTO.getSubtotalVenta());
        detalleVentaTalla.setTalla(TallaMapper.toEntityViejo(detalleVentaTallaDTO.getTalla()));
        
        Venta venta = new Venta();
        venta.setId(detalleVentaTallaDTO.getVenta().getId());
        detalleVentaTalla.setVenta(venta);
        
        return detalleVentaTalla;
    }
    
    public static DetalleVentaTallaDTO toDTONuevo(DetalleVentaTalla detalleVentaTalla){
        DetalleVentaTallaDTO detalleVentaTallaDTO = new DetalleVentaTallaDTO();
        detalleVentaTallaDTO.setCantidadVendida(detalleVentaTalla.getCantidadVendida());
        detalleVentaTallaDTO.setSubtotalVenta(detalleVentaTalla.getSubtotalVenta());
        detalleVentaTallaDTO.setTalla(TallaMapper.toDTOViejo(detalleVentaTalla.getTalla()));
        
        return detalleVentaTallaDTO;
    }
    
    public static DetalleVentaTallaDTO toDTOViejo(DetalleVentaTalla detalleVentaTalla){
        DetalleVentaTallaDTO detalleVentaTallaDTO = new DetalleVentaTallaDTO();
        detalleVentaTallaDTO.setId(detalleVentaTalla.getId());
        detalleVentaTallaDTO.setCantidadVendida(detalleVentaTalla.getCantidadVendida());
        detalleVentaTallaDTO.setSubtotalVenta(detalleVentaTalla.getSubtotalVenta());
        detalleVentaTallaDTO.setTalla(TallaMapper.toDTOViejo(detalleVentaTalla.getTalla()));
        
        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setId(detalleVentaTalla.getVenta().getId());
        detalleVentaTallaDTO.setVenta(ventaDTO);
        
        return detalleVentaTallaDTO;
    }
}