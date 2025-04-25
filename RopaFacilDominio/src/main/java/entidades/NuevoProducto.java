package entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entidad NuevoProducto. Hereda de Compra.
 * @author Leonardo Flores Leyva - 252390
 */
@Entity
@Table(name = "NUEVO_PRODUCTO")
@DiscriminatorValue("NP") // Discriminador de la tabla
public class NuevoProducto extends Compra implements Serializable {
    /**
     * Precio de venta sugerido de la compra de un nuevo producto.
     */
    @Column(name = "PRECIO_VENTA_SUGERIDO", nullable = false, unique = false)
    private Double precioVentaSugerido;
    /**
     * Constructor por defecto de una compra de un nuevo producto.
     */
    public NuevoProducto() {}
    /**
     * Constructor sin ID de la compra de un nuevo producto.
     * @param precioVentaSugerido Precio de venta sugerido de la compra de un nuevo producto.
     * @param fechaHora Fecha y hora de la compra de un nuevo producto.
     * @param precioCompraUnitario Precio de compra unitario de la compra.
     * @param totalCompra Total gastado de la compra de un nuevo producto.
     * @param productoComprado Detalle del producto asociado a la compra de un nuevo producto.
     * @param tallasCompradas Lista de tallas compradas asociadas al producto.
     */
    public NuevoProducto(
            Double precioVentaSugerido, 
            LocalDateTime fechaHora, 
            Double precioCompraUnitario, 
            Double totalCompra, 
            Producto productoComprado, 
            List<DetalleCompraTalla> tallasCompradas
    ) {
        super(fechaHora, precioCompraUnitario, totalCompra, productoComprado, tallasCompradas);
        this.precioVentaSugerido = precioVentaSugerido;
    }
    /**
     * Constructor con ID incluido de la compra de un nuevo producto.
     * @param precioVentaSugerido Precio de venta sugerido de la compra de un nuevo producto.
     * @param id ID de la compra de un nuevo producto.
     * @param fechaHora Fecha y hora de la compra de un nuevo producto.
     * @param precioCompraUnitario Precio de compra unitario de la compra.
     * @param totalCompra Total gastado de la compra de un nuevo producto.
     * @param productoComprado Detalle del producto asociado a la compra de un nuevo producto.
     * @param tallasCompradas Lista de tallas compradas asociadas al producto.
     */
    public NuevoProducto(
            Double precioVentaSugerido, 
            Long id, 
            LocalDateTime fechaHora, 
            Double precioCompraUnitario, 
            Double totalCompra, 
            Producto productoComprado, 
            List<DetalleCompraTalla> tallasCompradas
    ) {
        super(id, fechaHora, precioCompraUnitario, totalCompra, productoComprado, tallasCompradas);
        this.precioVentaSugerido = precioVentaSugerido;
    }
    /**
     * Retorna el precio de venta sugerido de la compra de un nuevo producto.
     * @return Precio de venta sugerido de la compra de un nuevo producto.
     */
    public Double getPrecioVentaSugerido() {return precioVentaSugerido;}
    /**
     * Establece el precio de venta sugerido de la compra de un nuevo producto.
     * @param precioVentaSugerido Nuevo precio de venta sugerido de la compra de un nuevo producto.
     */
    public void setPrecioVentaSugerido(Double precioVentaSugerido) {this.precioVentaSugerido = precioVentaSugerido;}
}