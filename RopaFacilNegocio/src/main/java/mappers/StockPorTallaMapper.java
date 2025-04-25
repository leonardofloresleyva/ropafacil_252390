package mappers;

import dtos.ProductoDTO;
import dtos.StockPorTallaDTO;
import entidades.Producto;
import entidades.StockPorTalla;


/**
 *
 * @author PC WHITE WOLF
 */
public class StockPorTallaMapper {
    
    public static StockPorTalla toEntityNuevo(StockPorTallaDTO stockPorTallaDTO){
        StockPorTalla stockPorTalla = new StockPorTalla();
        stockPorTalla.setStock(stockPorTallaDTO.getStock());
        stockPorTalla.setTalla(TallaMapper.toEntityNuevo(stockPorTallaDTO.getTalla()));
        
        return stockPorTalla;
    }
    
    public static StockPorTalla toEntityViejo(StockPorTallaDTO stockPorTallaDTO){
        StockPorTalla stockPorTalla = new StockPorTalla();
        stockPorTalla.setStock(stockPorTallaDTO.getStock());
        stockPorTalla.setTalla(TallaMapper.toEntityViejo(stockPorTallaDTO.getTalla()));
        
        Producto producto = new Producto();
        producto.setId(stockPorTallaDTO.getProducto().getId());
        
        stockPorTalla.setProducto(producto);
        
        return stockPorTalla;
    }
    
    public static StockPorTallaDTO toDTONuevo(StockPorTalla stockPorTalla){
        StockPorTallaDTO stockPorTallaDTO = new StockPorTallaDTO();
        stockPorTallaDTO.setStock(stockPorTalla.getStock());
        stockPorTallaDTO.setTalla(TallaMapper.toDTONuevo(stockPorTalla.getTalla()));
        
        return stockPorTallaDTO;
    }
    
    public static StockPorTallaDTO toDTOViejo(StockPorTalla stockPorTalla){
        StockPorTallaDTO stockPorTallaDTO = new StockPorTallaDTO();
        stockPorTallaDTO.setStock(stockPorTalla.getStock());
        stockPorTallaDTO.setTalla(TallaMapper.toDTOViejo(stockPorTalla.getTalla()));
        
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(stockPorTalla.getProducto().getId());
        
        stockPorTallaDTO.setProducto(productoDTO);
        
        return stockPorTallaDTO;
    }
}