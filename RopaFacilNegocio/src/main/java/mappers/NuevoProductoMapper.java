package mappers;

import dtos.NuevoProductoDTO;
import entidades.NuevoProducto;

/**
 *
 * @author PC WHITE WOLF
 */
public class NuevoProductoMapper {
    
    public static NuevoProducto toEntityNuevo(NuevoProductoDTO nuevoProductoDTO){
        NuevoProducto nuevoProducto = new NuevoProducto();
        nuevoProducto.setPrecioVentaSugerido(nuevoProductoDTO.getPrecioVentaSugerido());
        
        if(nuevoProductoDTO.getFechaHora() != null)
            nuevoProducto.setFechaHora(nuevoProductoDTO.getFechaHora());
        
        if(nuevoProductoDTO.getTotalCompra() != null)
            nuevoProducto.setTotalCompra(nuevoProductoDTO.getTotalCompra());
        
        return nuevoProducto;
    }
    
    public static NuevoProducto toEntityViejo(NuevoProductoDTO nuevoProductoDTO){
        NuevoProducto nuevoProducto = new NuevoProducto();
        nuevoProducto.setId(nuevoProductoDTO.getId());
        nuevoProducto.setFechaHora(nuevoProductoDTO.getFechaHora());
        nuevoProducto.setPrecioVentaSugerido(nuevoProductoDTO.getPrecioVentaSugerido());
        
        nuevoProducto.setProductoComprado(DetalleCompraProductoMapper.toEntityViejo(nuevoProductoDTO.getProductoComprado()));
        nuevoProducto.setTallasCompradas(nuevoProductoDTO.getTallasCompradas().stream().map(e -> DetalleCompraTallaMapper.toEntityViejo(e)).toList());
        nuevoProducto.setTotalCompra(nuevoProductoDTO.getTotalCompra());
        
        return nuevoProducto;
    }
    
    public static NuevoProductoDTO toDTONuevo(NuevoProducto nuevoProducto){
        NuevoProductoDTO nuevoProductoDTO = new NuevoProductoDTO();
        nuevoProductoDTO.setPrecioVentaSugerido(nuevoProducto.getPrecioVentaSugerido());
        
        if(nuevoProducto.getFechaHora() != null)
            nuevoProductoDTO.setFechaHora(nuevoProducto.getFechaHora());
        
        if(nuevoProducto.getTotalCompra() != null)
            nuevoProductoDTO.setTotalCompra(nuevoProducto.getTotalCompra());
        
        return nuevoProductoDTO;
    }
    
    public static NuevoProductoDTO toDTOViejo(NuevoProducto nuevoProducto){
        NuevoProductoDTO nuevoProductoDTO = new NuevoProductoDTO();
        nuevoProductoDTO.setId(nuevoProducto.getId());
        nuevoProductoDTO.setFechaHora(nuevoProducto.getFechaHora());
        nuevoProductoDTO.setPrecioVentaSugerido(nuevoProducto.getPrecioVentaSugerido());
        
        nuevoProductoDTO.setProductoComprado(DetalleCompraProductoMapper.toDTOViejo(nuevoProducto.getProductoComprado()));
        nuevoProductoDTO.setTallasCompradas(nuevoProducto.getTallasCompradas().stream().map(e -> DetalleCompraTallaMapper.toDTOViejo(e)).toList());
        nuevoProductoDTO.setTotalCompra(nuevoProducto.getTotalCompra());
        
        return nuevoProductoDTO;
    }
}