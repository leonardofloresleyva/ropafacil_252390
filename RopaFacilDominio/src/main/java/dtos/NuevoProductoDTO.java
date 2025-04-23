package dtos;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entidad NuevoProductoDTO. Hereda de CompraDTO.
 * Tipo de Dato de Transferencia.
 * @author Leonardo Flores Leyva - 252390
 */
public class NuevoProductoDTO extends CompraDTO {
    /**
     * Precio de venta sugerido de la compra de un nuevo producto.
     */
    private Double precioVentaSugerido;
    /**
     * Constructor por defecto de una compra de un nuevo producto.
     */
    public NuevoProductoDTO() {}
    /**
     * Constructor sin ID de la compra de un nuevo producto.
     * @param precioVentaSugerido Precio de venta sugerido de la compra de un nuevo producto.
     * @param fechaHora Fecha y hora de la compra de un nuevo producto.
     * @param totalCompra Total gastado de la compra de un nuevo producto.
     * @param productoComprado Detalle del producto asociado a la compra de un nuevo producto.
     * @param tallasCompradas Lista de tallas compradas asociadas al producto.
     */
    public NuevoProductoDTO(
            Double precioVentaSugerido, 
            LocalDateTime fechaHora, 
            Double totalCompra, 
            DetalleCompraProductoDTO productoComprado, 
            List<DetalleCompraTallaDTO> tallasCompradas
    ) {
        super(fechaHora, totalCompra, productoComprado, tallasCompradas);
        this.precioVentaSugerido = precioVentaSugerido;
    }
    /**
     * Constructor con ID incluido de la compra de un nuevo producto.
     * @param precioVentaSugerido Precio de venta sugerido de la compra de un nuevo producto.
     * @param id ID de la compra de un nuevo producto.
     * @param fechaHora Fecha y hora de la compra de un nuevo producto.
     * @param totalCompra Total gastado de la compra de un nuevo producto.
     * @param productoComprado Detalle del producto asociado a la compra de un nuevo producto.
     * @param tallasCompradas Lista de tallas compradas asociadas al producto.
     */
    public NuevoProductoDTO(
            Double precioVentaSugerido, 
            Long id, 
            LocalDateTime fechaHora, 
            Double totalCompra, 
            DetalleCompraProductoDTO productoComprado, 
            List<DetalleCompraTallaDTO> tallasCompradas
    ) {
        super(id, fechaHora, totalCompra, productoComprado, tallasCompradas);
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