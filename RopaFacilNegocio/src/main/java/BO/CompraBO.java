package BO;

import DAO.CompraDAO;
import dtos.DetalleCompraTallaDTO;
import dtos.NuevoProductoDTO;
import dtos.ProductoDTO;
import dtos.ReposicionDTO;
import dtos.StockPorTallaDTO;
import entidades.DetalleCompraTalla;
import entidades.NuevoProducto;
import entidades.Producto;
import entidades.Reposicion;
import entidades.StockPorTalla;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.iCompraBO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import mappers.DetalleCompraTallaMapper;
import mappers.NuevoProductoMapper;
import mappers.ProductoMapper;
import mappers.ReposicionMapper;
import mappers.StockPorTallaMapper;

/**
 *
 * @author PC WHITE WOLF
 */
public class CompraBO implements iCompraBO{

    private static CompraBO instance;
    
    private CompraBO(){};
    
    public static CompraBO getInstance(){
        if(instance == null)
            instance = new CompraBO();
        return instance;
    }
    
    @Override
    public boolean registrarCompraNuevoProducto(ProductoDTO producto, List<StockPorTallaDTO> tallas, NuevoProductoDTO compra, List<DetalleCompraTallaDTO> detalleCompraTalla) throws NegocioException {
        
        if(producto == null)
            throw new NegocioException("El producto no puede estar vacío");
        
        if(producto.getNombre() == null)
            throw new NegocioException("El nombre del producto no puede estar vacío");
        
        if(producto.getPrecio() == null)
            throw new NegocioException("El precio del producto no puede estar vacío");
        
        if(producto.getEstado() == null)
            throw new NegocioException("El estado del producto no puede estar vacío");
        
        if(producto.getColor() == null)
            throw new NegocioException("El color del producto no puede estar vacío");
        
        if(producto.getCategoria() == null)
            throw new NegocioException("La categoría del producto no puede estar vacía");
        
        if(producto.getTipo() == null)
            throw new NegocioException("El tipo del producto no puede estar vacío");
        
        if(producto.getTallas() == null)
            throw new NegocioException("Las tallas del producto no pueden estar vacías");
        
        if(tallas == null)
            throw new NegocioException("Las tallas no pueden estar vacías");
        
        if(compra == null)
            throw new NegocioException("La compra no puede estar vacía");
        
        if(detalleCompraTalla == null)
            throw new NegocioException("Las tallas a compras no pueden estar vacías");
        
        Producto productoNuevo = ProductoMapper.toEntityNuevo(producto);
        List<StockPorTalla> tallasNuevas = tallas.stream().map(e -> StockPorTallaMapper.toEntityNuevo(e)).toList();
        NuevoProducto compraNueva = NuevoProductoMapper.toEntityNuevo(compra);
        List<DetalleCompraTalla> tallasCompradas = detalleCompraTalla.stream().map(e -> DetalleCompraTallaMapper.toEntityNuevo(e)).toList();
        try {
            compraNueva = CompraDAO.getInstance().registrarNuevoProducto(productoNuevo, tallasNuevas, compraNueva, tallasCompradas);
            return compraNueva.getId() != null;
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage(), ex);
        }
        
    }

    @Override
    public boolean registrarCompraReposicion(ProductoDTO producto, ReposicionDTO compra, List<DetalleCompraTallaDTO> detalleCompraTalla) throws NegocioException {
        
        if(producto == null)
            throw new NegocioException("El producto no puede estar vacío");
        
        if(compra == null)
            throw new NegocioException("La reposición no puede estar vacía");
        
        if(detalleCompraTalla == null)
            throw new NegocioException("Las tallas a reponer no pueden estar vacías");
        
        Producto productoNuevo = ProductoMapper.toEntityViejo(producto);
        Reposicion compraNueva = ReposicionMapper.toEntityNuevo(compra);
        List<DetalleCompraTalla> tallasCompradas = detalleCompraTalla.stream().map(e -> DetalleCompraTallaMapper.toEntityNuevo(e)).toList();
        try {
            compraNueva = CompraDAO.getInstance().registrarReposicion(productoNuevo, compraNueva, tallasCompradas);
            return compraNueva.getId() != null;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @Override
    public List<NuevoProductoDTO> obtenerNuevosProductosFecha(LocalDate fechaInicial, LocalDate fechaFinal) throws NegocioException {
        try {
            List<NuevoProductoDTO> comprasDTO = new ArrayList<>();
            List<NuevoProducto> comprasEncontradas = CompraDAO.getInstance().obtenerNuevosProductosFecha(fechaInicial, fechaFinal);
            if(!comprasEncontradas.isEmpty())
                comprasDTO = comprasEncontradas.stream().map(e -> NuevoProductoMapper.toDTOViejo(e)).toList();
            return comprasDTO;
            
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @Override
    public List<ReposicionDTO> obtenerReposicionesFecha(LocalDate fechaInicial, LocalDate fechaFinal) throws NegocioException {
        try {
            List<ReposicionDTO> comprasDTO = new ArrayList<>();
            List<Reposicion> comprasEncontradas = CompraDAO.getInstance().obtenerReposicionesFecha(fechaInicial, fechaFinal);
            if(!comprasEncontradas.isEmpty())
                comprasDTO = comprasEncontradas.stream().map(e -> ReposicionMapper.toDTOViejo(e)).toList();
            return comprasDTO;
            
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @Override
    public List<NuevoProductoDTO> obtenerNuevosProductosNombre(String nombre) throws NegocioException {
        try {
            List<NuevoProductoDTO> comprasDTO = new ArrayList<>();
            List<NuevoProducto> comprasEncontradas = CompraDAO.getInstance().obtenerNuevosProductosNombre(nombre);
            if(!comprasEncontradas.isEmpty()){
                for(NuevoProducto compraEncontrada : comprasEncontradas){
                    comprasDTO.add(NuevoProductoMapper.toDTOViejo(compraEncontrada));
                }
            }
            return comprasDTO;
            
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @Override
    public List<ReposicionDTO> obtenerReposicionesNombre(String nombre) throws NegocioException {
        try {
            List<ReposicionDTO> comprasDTO = new ArrayList<>();
            List<Reposicion> comprasEncontradas = CompraDAO.getInstance().obtenerReposicionesNombre(nombre);
            if(!comprasEncontradas.isEmpty())
                comprasDTO = comprasEncontradas.stream().map(e -> ReposicionMapper.toDTOViejo(e)).toList();
            return comprasDTO;
            
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @Override
    public List<NuevoProductoDTO> obtenerNuevosProductosProveedor(String proveedor) throws NegocioException {
        try {
            List<NuevoProductoDTO> comprasDTO = new ArrayList<>();
            List<NuevoProducto> comprasEncontradas = CompraDAO.getInstance().obtenerNuevosProductosProveedor(proveedor);
            if(!comprasEncontradas.isEmpty())
                comprasDTO = comprasEncontradas.stream().map(e -> NuevoProductoMapper.toDTOViejo(e)).toList();
            return comprasDTO;
            
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @Override
    public List<ReposicionDTO> obtenerReposicionesProveedor(String proveedor) throws NegocioException {
        try {
            List<ReposicionDTO> comprasDTO = new ArrayList<>();
            List<Reposicion> comprasEncontradas = CompraDAO.getInstance().obtenerReposicionesProveedor(proveedor);
            if(!comprasEncontradas.isEmpty())
                comprasDTO = comprasEncontradas.stream().map(e -> ReposicionMapper.toDTOViejo(e)).toList();
            return comprasDTO;
            
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }
    
}