package mappers;

import dtos.DetalleCompraTallaDTO;
import dtos.NuevoProductoDTO;
import dtos.ReposicionDTO;
import entidades.DetalleCompraTalla;
import entidades.NuevoProducto;
import entidades.Reposicion;

/**
 *
 * @author PC WHITE WOLF
 */
public class DetalleCompraTallaMapper {
    
    public static DetalleCompraTalla toEntityNuevo(DetalleCompraTallaDTO detalleCompraTallaDTO){
        DetalleCompraTalla detalleCompraTalla = new DetalleCompraTalla();
        detalleCompraTalla.setCantidadComprada(detalleCompraTallaDTO.getCantidadComprada());
        detalleCompraTalla.setTalla(TallaMapper.toEntityNuevo(detalleCompraTallaDTO.getTalla()));
        
        return detalleCompraTalla;
    }
    
    public static DetalleCompraTalla toEntityViejo(DetalleCompraTallaDTO detalleCompraTallaDTO){
        DetalleCompraTalla detalleCompraTalla = new DetalleCompraTalla();
        detalleCompraTalla.setId(detalleCompraTallaDTO.getId());
        detalleCompraTalla.setCantidadComprada(detalleCompraTallaDTO.getCantidadComprada());
        detalleCompraTalla.setTalla(TallaMapper.toEntityViejo(detalleCompraTallaDTO.getTalla()));
        
        if(detalleCompraTallaDTO.getCompra() instanceof ReposicionDTO){
            Reposicion reposicion = new Reposicion();
            reposicion.setId(detalleCompraTallaDTO.getCompra().getId());
            detalleCompraTalla.setCompra(reposicion);
            
        } else if(detalleCompraTallaDTO.getCompra() instanceof NuevoProductoDTO){
            NuevoProducto nuevoProducto = new NuevoProducto();
            nuevoProducto.setId(detalleCompraTallaDTO.getCompra().getId());
            detalleCompraTalla.setCompra(nuevoProducto);
        }
        
        return detalleCompraTalla;
    }
    
    public static DetalleCompraTallaDTO toDTONuevo(DetalleCompraTalla detalleCompraTalla){
        DetalleCompraTallaDTO detalleCompraTallaDTO = new DetalleCompraTallaDTO();
        detalleCompraTallaDTO.setCantidadComprada(detalleCompraTalla.getCantidadComprada());
        detalleCompraTallaDTO.setTalla(TallaMapper.toDTONuevo(detalleCompraTalla.getTalla()));
                
        return detalleCompraTallaDTO;
    }
    
    public static DetalleCompraTallaDTO toDTOViejo(DetalleCompraTalla detalleCompraTalla){
        DetalleCompraTallaDTO detalleCompraTallaDTO = new DetalleCompraTallaDTO();
        detalleCompraTallaDTO.setId(detalleCompraTalla.getId());
        detalleCompraTallaDTO.setCantidadComprada(detalleCompraTalla.getCantidadComprada());
        detalleCompraTallaDTO.setTalla(TallaMapper.toDTOViejo(detalleCompraTalla.getTalla()));
        
        if(detalleCompraTalla.getCompra() instanceof Reposicion){
            ReposicionDTO reposicionDTO = new ReposicionDTO();
            reposicionDTO.setId(detalleCompraTalla.getCompra().getId());
            detalleCompraTallaDTO.setCompra(reposicionDTO);
            
        } else if(detalleCompraTalla.getCompra() instanceof NuevoProducto){
            NuevoProductoDTO nuevoProductoDTO = new NuevoProductoDTO();
            nuevoProductoDTO.setId(detalleCompraTalla.getCompra().getId());
            detalleCompraTallaDTO.setCompra(nuevoProductoDTO);
        }
        
        return detalleCompraTallaDTO;
    }
}