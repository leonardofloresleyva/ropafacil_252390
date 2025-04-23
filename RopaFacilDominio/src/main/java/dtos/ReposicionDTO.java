package dtos;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entidad ReposiciónDTO. Hereda de CompraDTO.
 * Tipo de Dato de Transferencia.
 * @author Leonardo Flores Leyva - 252390
 */
public class ReposicionDTO extends CompraDTO{
    /**
     * Constructor por defecto de una reposición.
     */
    public ReposicionDTO() {}
    /**
     * Constructor sin ID de la compra de de una reposición.
     * @param fechaHora Fecha y hora de la reposición.
     * @param totalCompra Total gastado de la reposición.
     * @param productoComprado Detalle del producto asociado a la reposición.
     * @param tallasCompradas Lista de tallas compradas asociadas al producto.
     */
    public ReposicionDTO(
            LocalDateTime fechaHora, 
            Double totalCompra, 
            DetalleCompraProductoDTO productoComprado, 
            List<DetalleCompraTallaDTO> tallasCompradas
    ) {
        super(fechaHora, totalCompra, productoComprado, tallasCompradas);
    }
    /**
     * Constructor con ID incluido de la compra de una reposición.
     * @param id ID de la reposición.
     * @param fechaHora Fecha y hora de la reposición.
     * @param totalCompra Total gastado de la reposición.
     * @param productoComprado Detalle del producto asociado a la reposición.
     * @param tallasCompradas Lista de tallas compradas asociadas al producto.
     */
    public ReposicionDTO( 
            Long id, 
            LocalDateTime fechaHora, 
            Double totalCompra, 
            DetalleCompraProductoDTO productoComprado, 
            List<DetalleCompraTallaDTO> tallasCompradas
    ) {
        super(id, fechaHora, totalCompra, productoComprado, tallasCompradas);
    }
}