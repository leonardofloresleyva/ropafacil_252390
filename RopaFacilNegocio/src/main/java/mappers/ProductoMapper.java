package mappers;

import dtos.ProductoDTO;
import dtos.StockPorTallaDTO;
import entidades.Producto;
import entidades.StockPorTalla;

/**
 *
 * @author PC WHITE WOLF
 */
public class ProductoMapper {
    
    public static Producto toEntityNuevo(ProductoDTO productoDTO){
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setEstado(productoDTO.getEstado());
        producto.setCategoria(CategoriaMapper.toEntityNuevo(productoDTO.getCategoria()));
        producto.setColor(ColorMapper.toEntityNuevo(productoDTO.getColor()));
        producto.setTipo(TipoPrendaMapper.toEntityNuevo(productoDTO.getTipo()));
        producto.setCaja(CajaAlmacenamientoMapper.toEntityNuevo(productoDTO.getCaja()));
        if(productoDTO.getProveedor() != null)
            producto.setProveedor(ProveedorMapper.toEntityNuevo(productoDTO.getProveedor()));
        producto.setTallas(productoDTO.getTallas().stream().map(e -> StockPorTallaMapper.toEntityNuevo(e)).toList());
        
        return producto;
    }
    
    public static Producto toEntityViejo(ProductoDTO productoDTO){
        Producto producto = new Producto();
        producto.setId(productoDTO.getId());
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setEstado(productoDTO.getEstado());
        producto.setCategoria(CategoriaMapper.toEntityViejo(productoDTO.getCategoria()));
        producto.setColor(ColorMapper.toEntityViejo(productoDTO.getColor()));
        producto.setTipo(TipoPrendaMapper.toEntityViejo(productoDTO.getTipo()));
        producto.setCaja(CajaAlmacenamientoMapper.toEntityViejo(productoDTO.getCaja()));
        if(productoDTO.getProveedor() != null)
            producto.setProveedor(ProveedorMapper.toEntityViejo(productoDTO.getProveedor()));
        producto.setTallas(productoDTO.getTallas().stream().map(e -> StockPorTallaMapper.toEntityViejo(e)).toList());
        
        return producto;
    }
    
    public static ProductoDTO toDTONuevo(Producto producto){
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setEstado(producto.getEstado());
        productoDTO.setCategoria(CategoriaMapper.toDTONuevo(producto.getCategoria()));
        productoDTO.setColor(ColorMapper.toDTONuevo(producto.getColor()));
        productoDTO.setTipo(TipoPrendaMapper.toDTONuevo(producto.getTipo()));
        productoDTO.setCaja(CajaAlmacenamientoMapper.toDTONuevo(producto.getCaja()));
        if(producto.getProveedor() != null)
            productoDTO.setProveedor(ProveedorMapper.toDTONuevo(producto.getProveedor()));
        
        productoDTO.setTallas(producto.getTallas().stream().map(e -> StockPorTallaMapper.toDTONuevo(e)).toList());
        
        return productoDTO;
    }
    
    public static ProductoDTO toDTOViejo(Producto producto){
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setEstado(producto.getEstado());
        productoDTO.setCategoria(CategoriaMapper.toDTOViejo(producto.getCategoria()));
        productoDTO.setColor(ColorMapper.toDTOViejo(producto.getColor()));
        productoDTO.setTipo(TipoPrendaMapper.toDTOViejo(producto.getTipo()));
        productoDTO.setCaja(CajaAlmacenamientoMapper.toDTOViejo(producto.getCaja()));
        if(producto.getProveedor() != null)
            productoDTO.setProveedor(ProveedorMapper.toDTOViejo(producto.getProveedor()));
        for(StockPorTalla stockPorTalla : producto.getTallas()){
            productoDTO.agregarTalla(StockPorTallaMapper.toDTOViejo(stockPorTalla));
        }
        productoDTO.setTallas(producto.getTallas().stream().map(e -> StockPorTallaMapper.toDTOViejo(e)).toList());
        
        return productoDTO;
    }
}