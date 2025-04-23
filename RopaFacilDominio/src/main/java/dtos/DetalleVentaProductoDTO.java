package dtos;

/**
 * Entidad DetalleVentaProductoDTO. Se relaciona con ProductoDTO y VentaDTO.
 * Tipo de Dato de Transferencia.
 * @author Leonardo Flores Leyva - 252390
 */
public class DetalleVentaProductoDTO {
    /**
     * ID del detalle de venta de producto.
     */
    private Long id;
    /**
     * Precio de venta del detalle de venta de producto.
     */
    private Double precioVenta;
    /**
     * Producto del detalle de venta de producto.
     */
    private ProductoDTO producto;
    /**
     * Venta del detalle de venta de producto.
     */
    private VentaDTO venta;
    /**
     * Constructor por defecto del detalle de venta de producto.
     */
    public DetalleVentaProductoDTO() {}
    /**
     * Contructor sin ID del detalle de venta de producto.
     * @param precioVenta Precio de venta del detalle de venta de producto.
     * @param producto Producto del detalle de venta de producto.
     * @param venta Venta del detalle de venta de producto.
     */
    public DetalleVentaProductoDTO(Double precioVenta, ProductoDTO producto, VentaDTO venta) {
        this.precioVenta = precioVenta;
        this.producto = producto;
        this.venta = venta;
    }
    /**
     * Contructor que recibe el ID del detalle de venta de producto.
     * @param id ID del detalle de venta de producto.
     * @param precioVenta Precio de venta del detalle de venta de producto.
     * @param producto Producto del detalle de venta de producto.
     * @param venta Venta del detalle de venta de producto.
     */
    public DetalleVentaProductoDTO(Long id, Double precioVenta, ProductoDTO producto, VentaDTO venta) {this.id = id;    
        this.precioVenta = precioVenta;
        this.producto = producto;
        this.venta = venta;
    }
    /**
     * Retorna el ID del detalle de venta de producto.
     * @return ID del detalle de venta de producto.
     */
    public Long getId() {return id;}
    /**
     * Retorna el producto del detalle de venta de producto.
     * @return Producto del detalle de venta de producto.
     */
    public ProductoDTO getProducto() {return producto;}
    /**
     * Retorna el precio de venta del detalle de venta de producto.
     * @return Precio de venta del detalle de venta de producto.
     */
    public Double getPrecioVenta() {return precioVenta;}
    /**
     * Retorna la venta del detalle de venta de producto.
     * @return Venta del detalle de venta de producto.
     */
    public VentaDTO getVenta() {return venta;}
    /**
     * Establece el ID del del detalle de venta de producto.
     * @param id Nuevo ID del detalle de venta de producto.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Establece el producto del detalle de venta de producto.
     * @param producto Nuevo producto del detalle de venta de producto.
     */
    public void setProducto(ProductoDTO producto) {this.producto = producto;}
    /**
     * Establece el precio de venta del detalle de venta de producto.
     * @param precioVenta Nuevo precio de venta del detalle de venta de producto.
     */
    public void setPrecioVenta(Double precioVenta) {this.precioVenta = precioVenta;}
    /**
     * Establece la venta del detalle de venta de producto.
     * Si la venta no tiene este detalle de venta de producto, 
     * lo añade, para mantener ambas entidades sincronizadas.
     * @param venta Nueva venta del detalle de venta de producto.
     */
    public void setVenta(VentaDTO venta) {this.venta = venta;}
    /**
     * Regresa una cadena con el detalle de venta de producto.
     * @return Cadena con el detalle de venta de producto.
     */
    @Override
    public String toString() {return String.format("%s, %s", venta.toString(), precioVenta.toString());}
}