package dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad VentaDTO. Se relaciona con DetalleVentaProductoDTO y DetalleVentaTallaDTO
 * Tipo de Dato de Transferencia.
 * @author Leonardo Flores Leyva - 252390
 */
public class VentaDTO {
    /**
     * ID de la venta.
     */
    private Long id;
    /**
     * Fecha y hora de la venta.
     */
    private LocalDateTime fechaHora;
    /**
     * Precio de venta del producto.
     */
    private Double precioVenta;
    /**
     * Total gastado de la venta.
     */
    private Double totalVenta;
    /**
     * Producto vendido.
     */
    private ProductoDTO productoVendido;
    /**
     * Lista de tallas compradas asociadas al producto.
     */
    private List<DetalleVentaTallaDTO> tallasVendidas = new ArrayList<>();
    /**
     * Constructor por defecto de una venta.
     */
    public VentaDTO() {}
    /**
     * Constructor sin ID de la venta.
     * @param fechaHora Fecha y hora de la venta.
     * @param precioVenta Precio de venta del producto.
     * @param totalVenta Total ganado de la venta.
     * @param productoVendido Detalles del producto asociado a la venta.
     * @param tallasVendidas Lista de tallas compradas asociadas al producto.
     */
    public VentaDTO(LocalDateTime fechaHora, Double precioVenta, Double totalVenta, ProductoDTO productoVendido, List<DetalleVentaTallaDTO> tallasVendidas) {
        this.fechaHora = fechaHora;
        this.precioVenta = precioVenta;
        this.totalVenta = totalVenta;
        this.productoVendido = productoVendido;
        this.tallasVendidas = tallasVendidas;
    }
    /**
     * Constructor con ID de la venta.
     * @param id ID de la venta.
     * @param fechaHora Fecha y hora de la venta.
     * @param precioVenta Precio de venta del producto.
     * @param totalVenta Total ganado de la venta.
     * @param productoVendido Detalles del producto asociado a la venta.
     * @param tallasVendidas Lista de tallas compradas asociadas al producto.
     */
    public VentaDTO(Long id, LocalDateTime fechaHora, Double precioVenta, Double totalVenta, ProductoDTO productoVendido, List<DetalleVentaTallaDTO> tallasVendidas) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.precioVenta = precioVenta;
        this.totalVenta = totalVenta;
        this.productoVendido = productoVendido;
        this.tallasVendidas = tallasVendidas;
    }
    /**
     * Retorna el ID de la venta.
     * @return ID de la venta.
     */
    public Long getId() {return id;}
    /**
     * Retorna la fecha y hora de la venta.
     * @return Fecha y hora de la venta.
     */
    public LocalDateTime getFechaHora() {return fechaHora;}
    /**
     * Retorna el precio de venta.
     * @return Precio de venta del producto.
     */
    public Double getPrecioVenta() {return precioVenta;}
    /**
     * Retorna la recaudación total de la venta.
     * @return Recaudación total de la venta.
     */
    public Double getTotalVenta() {return totalVenta;}
    /**
     * Retorna el producto asociado a la venta.
     * @return Producto asociado a la venta.
     */
    public ProductoDTO getProductoVendido() {return productoVendido;}
    /**
     * Retorna la lista de tallas vendidas asociadas al producto.
     * @return Lista de tallas vendidas asociadas al producto.
     */
    public List<DetalleVentaTallaDTO> getTallasVendidas() {return tallasVendidas;}
    /**
     * Establece el ID de la venta.
     * @param id Nuevo ID de la venta.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Establece la fecha y hora de la venta.
     * @param fechaHora Nueva fecha y hora de la venta.
     */
    public void setFechaHora(LocalDateTime fechaHora) {this.fechaHora = fechaHora;}
    /**
     * Establece el precio de venta del producto.
     * @param precioVenta Nuevo precio de venta del producto.
     */
    public void setPrecioVenta(Double precioVenta) {this.precioVenta = precioVenta;}
    /**
     * Establece la recaudación total de la venta.
     * @param totalVenta Nueva recaudación total de la venta.
     */
    public void setTotalVenta(Double totalVenta) {this.totalVenta = totalVenta;}
    /**
     * Establece el producto asociado a la venta.
     * @param productoVendido Nuevo producto asociado a la venta.
     */
    public void setProductoVendido(ProductoDTO productoVendido) {this.productoVendido = productoVendido;}
    /**
     * Establece la lista de tallas vendidas a la venta.
     * Si alguna talla vendida no tiene asociada esta 
     * venta, la añade, para mantener ambas entidades 
     * sincronizadas.
     * @param tallasVendidas Lista de tallas vendidas.
     */
    public void setTallasVendidas(List<DetalleVentaTallaDTO> tallasVendidas) {this.tallasVendidas = tallasVendidas;}
    /**
     * Agrega una talla vendida a la lista de tallas vendidas.
     * Si el detalle de la venta de la talla no tiene
     * asociada esta venta, la asocia, para mantener
     * ambas entidades sincronizadas.
     * @param tallaVendida Talla a agregar.
     */
    public void agregarTallaVendida(DetalleVentaTallaDTO tallaVendida){tallasVendidas.add(tallaVendida);}
    /**
     * Regresa una cadena con la información de la venta.
     * @return Cadena con la información de la venta.
     */
    @Override
    public String toString() {
        return String.format(
                "%s, %s, %s", 
                productoVendido.getNombre(), fechaHora.toString(), totalVenta.toString()
        );
    }
}