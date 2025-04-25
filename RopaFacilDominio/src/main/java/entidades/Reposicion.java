package entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entidad Reposición. Hereda de Compra.
 * @author Leonardo Flores Leyva - 252390
 */
@Entity
@Table(name = "REPOSICION")
@DiscriminatorValue("R") // Discriminador de la tabla
public class Reposicion extends Compra implements Serializable {
    /**
     * Constructor por defecto de una reposición.
     */
    public Reposicion() {}
    /**
     * Constructor sin ID de la compra de de una reposición.
     * @param fechaHora Fecha y hora de la reposición.
     * @param precioCompraUnitario Precio de compra unitario de la compra.
     * @param totalCompra Total gastado de la reposición.
     * @param productoComprado Detalle del producto asociado a la reposición.
     * @param tallasCompradas Lista de tallas compradas asociadas al producto.
     */
    public Reposicion(
            LocalDateTime fechaHora, 
            Double precioCompraUnitario, 
            Double totalCompra, 
            Producto productoComprado, 
            List<DetalleCompraTalla> tallasCompradas
    ) {
        super(fechaHora, precioCompraUnitario, totalCompra, productoComprado, tallasCompradas);
    }
    /**
     * Constructor con ID incluido de la compra de una reposición.
     * @param id ID de la reposición.
     * @param fechaHora Fecha y hora de la reposición.
     * @param precioCompraUnitario Precio de compra unitario de la compra.
     * @param totalCompra Total gastado de la reposición.
     * @param productoComprado Detalle del producto asociado a la reposición.
     * @param tallasCompradas Lista de tallas compradas asociadas al producto.
     */
    public Reposicion( 
            Long id, 
            LocalDateTime fechaHora, 
            Double precioCompraUnitario, 
            Double totalCompra, 
            Producto productoComprado, 
            List<DetalleCompraTalla> tallasCompradas
    ) {
        super(id, fechaHora, precioCompraUnitario, totalCompra, productoComprado, tallasCompradas);
    }
}