package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidad DetalleVentaProducto. Se relaciona con Producto y Venta.
 * @author Leonardo Flores Leyva - 252390
 */
@Entity
@Table(name = "DETALLES_VENTA_PRODUCTO")
public class DetalleVentaProducto implements Serializable {
    /**
     * ID del detalle de venta de producto.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Precio de venta del detalle de venta de producto.
     */
    @Column(name = "PRECIO_VENTA", nullable = false, unique = false)
    private Double precioVenta;
    /**
     * Producto del detalle de venta de producto.
     */
    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO", nullable = false)
    private Producto producto;
    /**
     * Venta del detalle de venta de producto.
     */
    @ManyToOne
    @JoinColumn(name = "ID_VENTA", nullable = false)
    private Venta venta;
    /**
     * Constructor por defecto del detalle de venta de producto.
     */
    public DetalleVentaProducto() {}
    /**
     * Contructor sin ID del detalle de venta de producto.
     * @param precioVenta Precio de venta del detalle de venta de producto.
     * @param producto Producto del detalle de venta de producto.
     * @param venta Venta del detalle de venta de producto.
     */
    public DetalleVentaProducto(Double precioVenta, Producto producto, Venta venta) {
        this.precioVenta = precioVenta;
        this.producto = producto;
        this.venta = venta;
        // Mantiene la relación bidireccional sincronizada, entre la Venta y su lista de DetalleVentaProducto.
        if(!venta.verificarDetalleVentaProducto())
            venta.setProductoVendido(this);
    }
    /**
     * Contructor que recibe el ID del detalle de venta de producto.
     * @param id ID del detalle de venta de producto.
     * @param precioVenta Precio de venta del detalle de venta de producto.
     * @param producto Producto del detalle de venta de producto.
     * @param venta Venta del detalle de venta de producto.
     */
    public DetalleVentaProducto(Long id, Double precioVenta, Producto producto, Venta venta) {this.id = id;    
        this.precioVenta = precioVenta;
        this.producto = producto;
        this.venta = venta;
        // Mantiene la relación bidireccional sincronizada, entre la Venta y su lista de DetalleVentaProducto.
        if(!venta.verificarDetalleVentaProducto())
            venta.setProductoVendido(this);
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
    public Producto getProducto() {return producto;}
    /**
     * Retorna el precio de venta del detalle de venta de producto.
     * @return Precio de venta del detalle de venta de producto.
     */
    public Double getPrecioVenta() {return precioVenta;}
    /**
     * Retorna la venta del detalle de venta de producto.
     * @return Venta del detalle de venta de producto.
     */
    public Venta getVenta() {return venta;}
    /**
     * Establece el ID del del detalle de venta de producto.
     * @param id Nuevo ID del detalle de venta de producto.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Establece el producto del detalle de venta de producto.
     * @param producto Nuevo producto del detalle de venta de producto.
     */
    public void setProducto(Producto producto) {this.producto = producto;}
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
    public void setVenta(Venta venta) {
        this.venta = venta;
        if(!venta.verificarDetalleVentaProducto())
            venta.setProductoVendido(this);
    }
    /**
     * Verifica que el detalle de venta de producto tenga una
     * venta asociada.
     * @return VERDADERO si el detalle de venta de producto tiene una venta asociada, FALSO en caso contrario.
     */
    public boolean verificarVenta(){return venta != null;}
    /**
     * Regresa una cadena con el detalle de venta de producto.
     * @return Cadena con el detalle de venta de producto.
     */
    @Override
    public String toString() {return precioVenta.toString();}
}