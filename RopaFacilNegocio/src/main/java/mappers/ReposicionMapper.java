package mappers;

import dtos.ReposicionDTO;
import entidades.Reposicion;

/**
 *
 * @author PC WHITE WOLF
 */
public class ReposicionMapper {
    
    public static Reposicion toEntityNuevo(ReposicionDTO reposicionDTO){
        Reposicion reposicion = new Reposicion();
        reposicion.setPrecioCompraUnitario(reposicionDTO.getPrecioCompraUnitario());
        
        return reposicion;
    }
    
    public static Reposicion toEntityViejo(ReposicionDTO reposicionDTO){
        Reposicion reposicion = new Reposicion();
        reposicion.setId(reposicionDTO.getId());
        reposicion.setFechaHora(reposicionDTO.getFechaHora());
        reposicion.setPrecioCompraUnitario(reposicionDTO.getPrecioCompraUnitario());
        
        reposicion.setProductoComprado(ProductoMapper.toEntityViejo(reposicionDTO.getProductoComprado()));
        reposicion.setTallasCompradas(reposicionDTO.getTallasCompradas().stream().map(e -> DetalleCompraTallaMapper.toEntityViejo(e)).toList());
        reposicion.setTotalCompra(reposicionDTO.getTotalCompra());
        
        return reposicion;
    }
    
    public static ReposicionDTO toDTONuevo(Reposicion reposicion){
        ReposicionDTO reposicionDTO = new ReposicionDTO();
        reposicionDTO.setPrecioCompraUnitario(reposicion.getPrecioCompraUnitario());
        
        return reposicionDTO;
    }
    
    public static ReposicionDTO toDTOViejo(Reposicion reposicion){
        ReposicionDTO reposicionDTO = new ReposicionDTO();
        reposicionDTO.setId(reposicion.getId());
        reposicionDTO.setFechaHora(reposicion.getFechaHora());
        reposicionDTO.setPrecioCompraUnitario(reposicion.getPrecioCompraUnitario());
        
        reposicionDTO.setProductoComprado(ProductoMapper.toDTOViejo(reposicion.getProductoComprado()));
        reposicionDTO.setTallasCompradas(reposicion.getTallasCompradas().stream().map(e -> DetalleCompraTallaMapper.toDTOViejo(e)).toList());
        reposicionDTO.setTotalCompra(reposicion.getTotalCompra());
        
        return reposicionDTO;
    }
}