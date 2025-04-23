package dtos;

import enums.EstadoProducto;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad ProductoDTO. Se relaciona con StockPorTallaDTO, DetalleCompraProductoDTO, DetalleVentaProductoDTO,
 * CategoríaDTO, ColorDTO, TipoPrendaDTO, CajaAlmacenamientoDTO y ProveedorDTO (opcional).
 * Tipo de Dato de Transferencia.
 * @author Leonardo Flores Leyva - 252390
 */
public class ProductoDTO {
    /**
     * ID del producto.
     */
    private Long id;
    /**
     * Nombre del producto.
     */
    private String nombre;
    /**
     * Estado del producto.
     */
    private EstadoProducto estado;
    /**
     * Precio del producto.
     */
    private Double precio;
    /**
     * Categoría del producto.
     */
    private CategoriaDTO categoria;
    /**
     * Color del producto.
     */
    private ColorDTO color;    
    /**
     * Tipo del producto.
     */
    private TipoPrendaDTO tipo;
    /**
     * Caja de almacenamiento del producto.
     */
    private CajaAlmacenamientoDTO caja;
    /**
     * Proveedor del producto.
     */
    private ProveedorDTO proveedor;
    /**
     * Lista de stock de tallas del producto.
     */
    private List<StockPorTallaDTO> tallas = new ArrayList<>();
    /**
     * Constructor por defecto del producto.
     */
    public ProductoDTO() {}
    /**
     * Constructor sin ID del producto.
     * @param nombre Nombre del producto.
     * @param estado Estado del producto.
     * @param precio Precio del producto.
     * @param categoria Categoría del producto.
     * @param color Color del producto.
     * @param tipo Tipo del producto.
     * @param caja Caja de almacenamiento del producto.
     * @param proveedor Proveedor del producto.
     * @param tallas Lista de stock de tallas del producto.
     */
    public ProductoDTO(
            String nombre, 
            EstadoProducto estado, 
            Double precio, 
            CategoriaDTO categoria, 
            ColorDTO color, 
            TipoPrendaDTO tipo, 
            CajaAlmacenamientoDTO caja, 
            ProveedorDTO proveedor, 
            List<StockPorTallaDTO> tallas
            
    ) {
        this.nombre = nombre;
        this.estado = estado;
        this.precio = precio;
        this.categoria = categoria;
        this.color = color;
        this.tipo = tipo;
        this.caja = caja;
        this.proveedor = proveedor;
        this.tallas = tallas;
    }
    /**
     * Constructor con ID incluido del producto.
     * @param id ID del producto.
     * @param nombre Nombre del producto.
     * @param estado Estado del producto.
     * @param precio Precio del producto.
     * @param categoria Categoría del producto.
     * @param color Color del producto.
     * @param tipo Tipo del producto.
     * @param caja Caja de almacenamiento del producto.
     * @param proveedor Proveedor del producto.
     * @param tallas Lista de stock de tallas del producto.
     */
    public ProductoDTO(
            Long id, 
            String nombre, 
            EstadoProducto estado, 
            Double precio, 
            CategoriaDTO categoria, 
            ColorDTO color, 
            TipoPrendaDTO tipo, 
            CajaAlmacenamientoDTO caja, 
            ProveedorDTO proveedor, 
            List<StockPorTallaDTO> tallas
    ) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.precio = precio;
        this.categoria = categoria;
        this.color = color;
        this.tipo = tipo;
        this.caja = caja;
        this.proveedor = proveedor;
        this.tallas = tallas;
    }
    /**
     * Retiorna el ID del producto.
     * @return ID del producto.
     */
    public Long getId() {return id;}
    /**
     * Retiorna el nombre del producto.
     * @return Nombre del producto.
     */
    public String getNombre() {return nombre;}
    /**
     * Retiorna el estado del producto.
     * @return Estado del producto.
     */
    public EstadoProducto getEstado() {return estado;}
    /**
     * Retiorna el precio del producto.
     * @return Precio del producto.
     */
    public Double getPrecio() {return precio;}
    /**
     * Retiorna la categoría del producto.
     * @return Categoría del producto.
     */
    public CategoriaDTO getCategoria() {return categoria;}
    /**
     * Retiorna el color del producto.
     * @return Color del producto.
     */
    public ColorDTO getColor() {return color;}
    /**
     * Retiorna el tipo del producto.
     * @return Tipo del producto.
     */
    public TipoPrendaDTO getTipo() {return tipo;}
    /**
     * Retiorna la caja de almacenamiento del producto.
     * @return Caja de almacenamiento del producto.
     */
    public CajaAlmacenamientoDTO getCaja() {return caja;}
    /**
     * Retiorna el proveedor del producto.
     * @return Proveedor del producto.
     */
    public ProveedorDTO getProveedor() {return proveedor;}
    /**
     * Retiorna la lista de stock de tallas del producto.
     * @return Lista de stock de tallas del producto.
     */
    public List<StockPorTallaDTO> getTallas() {return tallas;}
    /**
     * Establece el ID del producto.
     * @param id Nuevo ID del producto.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Establece el nombre del producto.
     * @param nombre Nuevo nombre del producto.
     */
    public void setNombre(String nombre) {this.nombre = nombre;}
    /**
     * Establece el estado del producto.
     * @param estado Nuevo estado del producto.
     */
    public void setEstado(EstadoProducto estado) {this.estado = estado;}
    /**
     * Establece el precio del producto.
     * @param precio Nuevo precio del producto.
     */
    public void setPrecio(Double precio) {this.precio = precio;}
    /**
     * Establece la categoría del producto.
     * @param categoria Nueva categoría del producto.
     */
    public void setCategoria(CategoriaDTO categoria) {this.categoria = categoria;}
    /**
     * Establece el color del producto.
     * @param color Color del producto.
     */
    public void setColor(ColorDTO color) {this.color = color;}
    /**
     * Establece el tipo del producto.
     * @param tipo Nuevo tipo del producto.
     */
    public void setTipo(TipoPrendaDTO tipo) {this.tipo = tipo;}
    /**
     * Establece al caja de almacenamiento del producto.
     * @param caja Caja de almacenamiento del producto.
     */
    public void setCaja(CajaAlmacenamientoDTO caja) {this.caja = caja;}
    /**
     * Establece el proveedor del producto.
     * @param proveedor Proveedor del producto.
     */
    public void setProveedor(ProveedorDTO proveedor) {this.proveedor = proveedor;}
    /**
     * Establece la lista de stocks de talas del producto.
     * Si algún StockPorTalla no tiene asociado este producto,
     * lo asocia, para mantener ambas entidades sincronizadas.
     * @param tallas Nueva lista de stocks de tallas del producto.
     */
    public void setTallas(List<StockPorTallaDTO> tallas) {this.tallas = tallas;}
    /**
     * Agrega un nuevo StockPorTalla a la lista de stocks de tallas.
     * Si el StockPorTalla no contiene este producto, lo
     * añade, para mantener ambas entidades sincronizadas.
     * @param stockPorTalla Nuevo StockPorTalla.
     */
    public void agregarTalla(StockPorTallaDTO stockPorTalla){tallas.add(stockPorTalla);}
    /**
     * Devuelve una cadena con la información del producto.
     * @return Cadena con la información del producto.
     */
    @Override
    public String toString() {
        return String.format(
                "%s, %s, %s, %s, %s, %s, %s", 
                nombre, precio, estado, color.toString(), categoria.toString(), tipo.toString(), caja.toString()
        );
    }
}