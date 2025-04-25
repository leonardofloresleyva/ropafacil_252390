package mappers;

import dtos.DetalleCompraProductoDTO;
import dtos.NuevoProductoDTO;
import dtos.ProductoDTO;
import dtos.ReposicionDTO;
import entidades.DetalleCompraProducto;
import entidades.NuevoProducto;
import entidades.Producto;
import entidades.Reposicion;

/**
 *
 * @author PC WHITE WOLF
 */
public class DetalleCompraProductoMapper {
    
    public static DetalleCompraProducto toEntityNuevo(DetalleCompraProductoDTO detalleCompraProductoDTO){
        DetalleCompraProducto detalleCompraProducto = new DetalleCompraProducto();
        detalleCompraProducto.setPrecioCompraUnitario(detalleCompraProductoDTO.getPrecioCompraUnitario());
        
        return detalleCompraProducto;
    }
    
    public static DetalleCompraProducto toEntityViejo(DetalleCompraProductoDTO detalleCompraProductoDTO){
        DetalleCompraProducto detalleCompraProducto = new DetalleCompraProducto();
        detalleCompraProducto.setId(detalleCompraProductoDTO.getId());
        detalleCompraProducto.setPrecioCompraUnitario(detalleCompraProductoDTO.getPrecioCompraUnitario());
        
        Producto producto = new Producto();
        producto.setId(detalleCompraProductoDTO.getProducto().getId());
        detalleCompraProducto.setProducto(producto);
        
        if(detalleCompraProductoDTO.getCompra() instanceof ReposicionDTO){
            Reposicion reposicion = new Reposicion();
            reposicion.setId(detalleCompraProductoDTO.getCompra().getId());
            detalleCompraProducto.setCompra(reposicion);
            
        } else if(detalleCompraProductoDTO.getCompra() instanceof NuevoProductoDTO){
            NuevoProducto nuevoProducto = new NuevoProducto();
            nuevoProducto.setId(detalleCompraProductoDTO.getCompra().getId());
            detalleCompraProducto.setCompra(nuevoProducto);
        }
        
        return detalleCompraProducto;
    }
    
    public static DetalleCompraProductoDTO toDTONuevo(DetalleCompraProducto detalleCompraProducto){
        DetalleCompraProductoDTO detalleCompraProductoDTO = new DetalleCompraProductoDTO();
        detalleCompraProductoDTO.setPrecioCompraUnitario(detalleCompraProducto.getPrecioCompraUnitario());
        
        return detalleCompraProductoDTO;
    }
    
    public static DetalleCompraProductoDTO toDTOViejo(DetalleCompraProducto detalleCompraProducto){
        DetalleCompraProductoDTO detalleCompraProductoDTO = new DetalleCompraProductoDTO();
        detalleCompraProductoDTO.setId(detalleCompraProducto.getId());
        detalleCompraProductoDTO.setPrecioCompraUnitario(detalleCompraProducto.getPrecioCompraUnitario());
        
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(detalleCompraProducto.getProducto().getId());
        detalleCompraProductoDTO.setProducto(productoDTO);
        
        if(detalleCompraProducto.getCompra() instanceof Reposicion){
            ReposicionDTO reposicionDTO = new ReposicionDTO();
            reposicionDTO.setId(detalleCompraProducto.getCompra().getId());
            detalleCompraProductoDTO.setCompra(reposicionDTO);
            
        } else if(detalleCompraProducto.getCompra() instanceof NuevoProducto){
            NuevoProductoDTO nuevoProductoDTO = new NuevoProductoDTO();
            nuevoProductoDTO.setId(detalleCompraProducto.getCompra().getId());
            detalleCompraProductoDTO.setCompra(nuevoProductoDTO);
        }
        
        return detalleCompraProductoDTO;
    }
}