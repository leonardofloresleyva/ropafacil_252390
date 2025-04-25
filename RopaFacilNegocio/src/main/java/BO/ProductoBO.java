package BO;

import dtos.ProductoDTO;
import dtos.StockPorTallaDTO;
import enums.EstadoProducto;
import exception.NegocioException;
import interfaces.iProductoBO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC WHITE WOLF
 */
public class ProductoBO implements iProductoBO{
    
    private static ProductoBO instance;
    
    private ProductoBO(){};
    
    public static ProductoBO getInstance(){
        if(instance == null)
            instance = new ProductoBO();
        return instance;
    }
    
    @Override
    public boolean actualizarProducto(ProductoDTO producto) throws NegocioException {
        return true;
    }

    @Override
    public boolean cambiarEstado(EstadoProducto nuevoEstado) throws NegocioException {
        return true;
    }

    @Override
    public List<ProductoDTO> buscarPorNombre(String nombre) throws NegocioException {
        return new ArrayList<>();
    }

    @Override
    public List<ProductoDTO> buscarPorEstado(EstadoProducto estado) throws NegocioException {
        return new ArrayList<>();
    }

    @Override
    public List<ProductoDTO> buscarPorColor(String color) throws NegocioException {
        return new ArrayList<>();
    }

    @Override
    public List<ProductoDTO> buscarPorTipo(String tipo) throws NegocioException {
        return new ArrayList<>();
    }

    @Override
    public List<ProductoDTO> buscarPorCategoria(String categoria) throws NegocioException {
        return new ArrayList<>();
    }

    @Override
    public List<ProductoDTO> buscarPorTalla(String talla) throws NegocioException {
        return new ArrayList<>();
    }

    @Override
    public List<ProductoDTO> buscarPorCaja(Integer numeroCaja) throws NegocioException {
        return new ArrayList<>();
    }
    
}