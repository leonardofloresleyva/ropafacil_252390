package BO;

import DAO.ProductoDAO;
import dtos.ProductoDTO;
import dtos.StockPorTallaDTO;
import entidades.Producto;
import enums.EstadoProducto;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.iProductoBO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.ProductoMapper;

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
        
        Producto productoActualizar = ProductoMapper.toEntityViejo(producto);
        try {
            return ProductoDAO.getInstance().actualizarProducto(productoActualizar);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage(), ex);
        }
    }

    @Override
    public boolean cambiarEstado(ProductoDTO producto) throws NegocioException {
        Producto productoEstado = ProductoMapper.toEntityViejo(producto);
        try {
            return ProductoDAO.getInstance().cambiarEstado(productoEstado);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage(), ex);
        }
    }

    @Override
    public List<ProductoDTO> buscarPorNombre(String nombre) throws NegocioException {
        try {
            
            List<ProductoDTO> productosEncontradosDTO = new ArrayList<>();
            
            List<Producto> productosEncontrados = ProductoDAO.getInstance().buscarPorNombre(nombre);
            if(!productosEncontrados.isEmpty()){
                for(Producto producto : productosEncontrados){
                    productosEncontradosDTO.add(ProductoMapper.toDTOViejo(producto));
                }
            }
            return productosEncontradosDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @Override
    public List<ProductoDTO> buscarPorEstado(EstadoProducto estado) throws NegocioException {
        try {
            
            List<ProductoDTO> productosEncontradosDTO = new ArrayList<>();
            
            List<Producto> productosEncontrados = ProductoDAO.getInstance().buscarPorEstado(estado);
            if(!productosEncontrados.isEmpty())
                productosEncontrados.stream().forEach(e -> {productosEncontradosDTO.add(ProductoMapper.toDTOViejo(e));});
            
            return productosEncontradosDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @Override
    public List<ProductoDTO> buscarPorColor(String color) throws NegocioException {
        try {
            
            List<ProductoDTO> productosEncontradosDTO = new ArrayList<>();
            
            List<Producto> productosEncontrados = ProductoDAO.getInstance().buscarPorColor(color);
            if(!productosEncontrados.isEmpty())
                productosEncontrados.stream().forEach(e -> {productosEncontradosDTO.add(ProductoMapper.toDTOViejo(e));});
            
            return productosEncontradosDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @Override
    public List<ProductoDTO> buscarPorTipo(String tipo) throws NegocioException {
        try {
            
            List<ProductoDTO> productosEncontradosDTO = new ArrayList<>();
            
            List<Producto> productosEncontrados = ProductoDAO.getInstance().buscarPorTipo(tipo);
            if(!productosEncontrados.isEmpty())
                productosEncontrados.stream().forEach(e -> {productosEncontradosDTO.add(ProductoMapper.toDTOViejo(e));});
            
            return productosEncontradosDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @Override
    public List<ProductoDTO> buscarPorCategoria(String categoria) throws NegocioException {
        try {
            
            List<ProductoDTO> productosEncontradosDTO = new ArrayList<>();
            
            List<Producto> productosEncontrados = ProductoDAO.getInstance().buscarPorCategoria(categoria);
            if(!productosEncontrados.isEmpty())
                productosEncontrados.stream().forEach(e -> {productosEncontradosDTO.add(ProductoMapper.toDTOViejo(e));});
            
            return productosEncontradosDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @Override
    public List<ProductoDTO> buscarPorTalla(String talla) throws NegocioException {
        try {
            
            List<ProductoDTO> productosEncontradosDTO = new ArrayList<>();
            
            List<Producto> productosEncontrados = ProductoDAO.getInstance().buscarPorTalla(talla);
            if(!productosEncontrados.isEmpty())
                productosEncontrados.stream().forEach(e -> {productosEncontradosDTO.add(ProductoMapper.toDTOViejo(e));});
            
            return productosEncontradosDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @Override
    public List<ProductoDTO> buscarPorCaja(Integer numeroCaja) throws NegocioException {
        try {
            
            List<ProductoDTO> productosEncontradosDTO = new ArrayList<>();
            
            List<Producto> productosEncontrados = ProductoDAO.getInstance().buscarPorCaja(numeroCaja);
            if(!productosEncontrados.isEmpty())
                productosEncontrados.stream().forEach(e -> {productosEncontradosDTO.add(ProductoMapper.toDTOViejo(e));});
            
            return productosEncontradosDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }
    
}