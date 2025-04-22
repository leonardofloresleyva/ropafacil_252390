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
 * Entidad DetalleCompraProducto. Se relaciona con Producto y Compra.
 * @author Leonardo Flores Leyva - 252390
 */
@Entity
@Table(name = "DETALLES_COMPRA_PRODUCTO")
public class DetalleCompraProducto implements Serializable {
    /**
     * ID del detalle de compra de producto.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Precio de compra unitario del detalle de compra de producto.
     */
    @Column(name = "PRECIO_COMPRA_UNITARIO", nullable = false, unique = false)
    private Double precioCompraUnitario;
    /**
     * Producto del detalle de compra de producto.
     */
    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO", nullable = false)
    private Producto producto;
    /**
     * Compra del detalle de compra de producto.
     */
    @ManyToOne
    @JoinColumn(name = "ID_COMPRA", nullable = false)
    private Compra compra;
    /**
     * Constructor por defecto del detalle de compra de producto.
     */
    public DetalleCompraProducto() {}
    /**
     * Contructor sin ID del detalle de compra de producto.
     * @param precioCompraUnitario Precio de compra unitario del detalle de compra de producto.
     * @param producto Producto del detalle de compra de producto.
     * @param compra Compra del detalle de compra de producto.
     */
    public DetalleCompraProducto(Double precioCompraUnitario, Producto producto, Compra compra) {
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
    public DetalleCompraProducto(Long id, Double precioCompraUnitario, Producto producto, Compra compra) {this.id = id;    
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
    public Producto getProducto() {return producto;}
    /**
     * Retorna el precio de compra unitario del detalle de compra de producto.
     * @return Precio de compra unitario del detalle de compra de producto.
     */
    public Double getPrecioCompraUnitario() {return precioCompraUnitario;}
    /**
     * Retorna la compra del detalle de compra de producto.
     * @return Compra del detalle de compra de producto.
     */
    public Compra getCompra() {return compra;}
    /**
     * Establece el ID del del detalle de compra de producto.
     * @param id Nuevo ID del detalle de compra de producto.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Establece el producto del detalle de compra de producto.
     * @param producto Nuevo producto del detalle de compra de producto.
     */
    public void setProducto(Producto producto) {this.producto = producto;}
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
    public void setCompra(Compra compra) {
        this.compra = compra;
        if(!compra.verificarDetalleCompraProducto())
            compra.setProductoComprado(this);
    }
    /**
     * Verifica que el detalle de compra de producto tenga una
     * compra asociada.
     * @return VERDADERO si el detalle de compra de producto tiene una compra asociada, FALSO en caso contrario.
     */
    public boolean verificarCompra(){return compra != null;}
    /**
     * Regresa una cadena con el detalle de compra de producto.
     * @return Cadena con el detalle de compra de producto.
     */
    @Override
    public String toString() {return precioCompraUnitario.toString();}
}