package dtos;

/**
 * Entidad DetalleCompraProductoDTO. Se relaciona con ProductoDTO y CompraDTO.
 * Tipo de Dato de Transferencia.
 * @author Leonardo Flores Leyva - 252390
 */
public class DetalleCompraProductoDTO {
    /**
     * ID del detalle de compra de producto.
     */
    private Long id;
    /**
     * Precio de compra unitario del detalle de compra de producto.
     */
    private Double precioCompraUnitario;
    /**
     * Producto del detalle de compra de producto.
     */
    private ProductoDTO producto;
    /**
     * Compra del detalle de compra de producto.
     */
    private CompraDTO compra;
    /**
     * Constructor por defecto del detalle de compra de producto.
     */
    public DetalleCompraProductoDTO() {}
    /**
     * Contructor sin ID del detalle de compra de producto.
     * @param precioCompraUnitario Precio de compra unitario del detalle de compra de producto.
     * @param producto Producto del detalle de compra de producto.
     * @param compra Compra del detalle de compra de producto.
     */
    public DetalleCompraProductoDTO(Double precioCompraUnitario, ProductoDTO producto, CompraDTO compra) {
        this.precioCompraUnitario = precioCompraUnitario;
        this.producto = producto;
        this.compra = compra;
    }
    /**
     * Contructor que recibe el ID del detalle de compra de producto.
     * @param id ID del detalle de compra de producto.
     * @param precioCompraUnitario Precio de compra unitario del detalle de compra de producto.
     * @param producto Producto del detalle de compra de producto.
     * @param compra Compra del detalle de compra de producto.
     */
    public DetalleCompraProductoDTO(Long id, Double precioCompraUnitario, ProductoDTO producto, CompraDTO compra) {this.id = id;    
        this.precioCompraUnitario = precioCompraUnitario;
        this.producto = producto;
        this.compra = compra;
    }

    /**
     * Retorna el ID del detalle de compra de producto.
     * @return ID del detalle de compra de producto.
     */
    public Long getId() {return id;}
    /**
     * Retorna el producto del detalle de compra de producto.
     * @return Producto del detalle de compra de producto.
     */
    public ProductoDTO getProducto() {return producto;}
    /**
     * Retorna el precio de compra unitario del detalle de compra de producto.
     * @return Precio de compra unitario del detalle de compra de producto.
     */
    public Double getPrecioCompraUnitario() {return precioCompraUnitario;}
    /**
     * Retorna la compra del detalle de compra de producto.
     * @return Compra del detalle de compra de producto.
     */
    public CompraDTO getCompra() {return compra;}
    /**
     * Establece el ID del del detalle de compra de producto.
     * @param id Nuevo ID del detalle de compra de producto.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Establece el producto del detalle de compra de producto.
     * @param producto Nuevo producto del detalle de compra de producto.
     */
    public void setProducto(ProductoDTO producto) {this.producto = producto;}
    /**
     * Establece el precio de compra unitario del detalle de compra de producto.
     * @param precioCompraUnitario Nuevo precio de compra unitario del detalle de compra de producto.
     */
    public void setPrecioCompraUnitario(Double precioCompraUnitario) {this.precioCompraUnitario = precioCompraUnitario;}
    /**
     * Establece la compra del detalle de compra de producto.
     * Si la compra no tiene este detalle de compra de producto, 
     * lo añade, para mantener ambas entidades sincronizadas.
     * @param compra Nueva compra del detalle de compra de producto.
     */
    public void setCompra(CompraDTO compra) {this.compra = compra;}
    /**
     * Regresa una cadena con la información del detalle de compra de producto.
     * @return Cadena con la información del detalle de compra de producto.
     */
    @Override
    public String toString() {return String.format("%s, %s", compra.toString(), precioCompraUnitario.toString());}
}