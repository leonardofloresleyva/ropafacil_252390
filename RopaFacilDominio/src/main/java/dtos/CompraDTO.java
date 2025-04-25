package dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad CompraDTO. Se relaciona con DetalleCompraProductoDTO y DetalleCompraTallaDTO.
 * Tipo de Dato de Transferencia.
 * @author Leonardo Flores Leyva - 252390
 */
public abstract class CompraDTO {
    /**
     * ID de la compra.
     */
    private Long id;
    /**
     * Fecha y hora de la compra.
     */
    private LocalDateTime fechaHora;
    /**
     * Precio de compra unitario de la compra.
     */
    private Double precioCompraUnitario;
    /**
     * Total gastado de la compra.
     */
    private Double totalCompra;
    /**
     * Categoría del producto.
     */
    private ProductoDTO productoComprado;
    /**
     * Lista de tallas compradas asociadas al producto.
     */
    private List<DetalleCompraTallaDTO> tallasCompradas = new ArrayList<>();
    /**
     * Constructor por defecto de la compra.
     */
    public CompraDTO() {}
/**
 * Contructor sin ID de la compra.
 * @param fechaHora Fecha y hora de la compra.
 * @param totalCompra Total gastado de la compra.
 * @param precioCompraUnitario Precio de compra unitario de la compra.
 * @param productoComprado Detalle del producto asociado a la compra.
 * @param tallasCompradas Lista de tallas compradas asociadas al producto.
 */
    public CompraDTO(LocalDateTime fechaHora, Double precioCompraUnitario, Double totalCompra, ProductoDTO productoComprado, List<DetalleCompraTallaDTO> tallasCompradas) {
        this.fechaHora = fechaHora;
        this.precioCompraUnitario = precioCompraUnitario;
        this.totalCompra = totalCompra;
        this.productoComprado = productoComprado;
        this.tallasCompradas = tallasCompradas;
    }
    /**
     * Constructor con ID de la compra.
     * @param id ID de la compra.
     * @param fechaHora Fecha y hora de la compra.
     * @param totalCompra Total gastado de la compra.
     * @param precioCompraUnitario Precio de compra unitario de la compra.
     * @param productoComprado Detalle del producto asociado a la compra.
     * @param tallasCompradas Lista de tallas compradas asociadas al producto.
     */
    public CompraDTO(Long id, LocalDateTime fechaHora, Double precioCompraUnitario, Double totalCompra, ProductoDTO productoComprado, List<DetalleCompraTallaDTO> tallasCompradas) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.precioCompraUnitario = precioCompraUnitario;
        this.totalCompra = totalCompra;
        this.productoComprado = productoComprado;
        this.tallasCompradas = tallasCompradas;
    }
    /**
     * Retorna el ID de la compra.
     * @return ID de la compra.
     */
    public Long getId() {return id;}
    /**
     * Retorna la fecha y hora de la compra.
     * @return Fecha y hora de la compra.
     */
    public LocalDateTime getFechaHora() {return fechaHora;}
    /**
     * Retorna el precio de compra unitario de la compra.
     * @return Precio de compra unitario de la compra.
     */
    public Double getPrecioCompraUnitario() {return precioCompraUnitario;}
    /**
     * Retorna el gasto total de la compra.
     * @return Gasto total de la compra.
     */
    public Double getTotalCompra() {return totalCompra;}
    /**
     * Retorna el producto asociado a la compra.
     * @return Producto asociado a la compra.
     */
    public ProductoDTO getProductoComprado() {return productoComprado;}
    /**
     * Retorna la lista de tallas compradas asociadas al producto.
     * @return Lista de tallas compradas asociadas al producto.
     */
    public List<DetalleCompraTallaDTO> getTallasCompradas() {return tallasCompradas;}
    /**
     * Establece el ID de la compra.
     * @param id Nuevo ID de la compra.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Establece la fecha y hora de la compra.
     * @param fechaHora Nueva fecha y hora de la compra.
     */
    public void setFechaHora(LocalDateTime fechaHora) {this.fechaHora = fechaHora;}
    /**
     * Establece el precio de compra unitario de la compra.
     * @param precioCompraUnitario Nuevo precio de compra unitario de la compra.
     */
    public void setPrecioCompraUnitario(Double precioCompraUnitario) {this.precioCompraUnitario = precioCompraUnitario;}
    /**
     * Establece el gasto total de la compra.
     * @param totalCompra Nuevo gasto total de la compra.
     */
    public void setTotalCompra(Double totalCompra) {this.totalCompra = totalCompra;}
    /**
     * Establece el producto asociado a la compra.
     * @param productoComprado Nuevo producto asociado a la compra.
     */
    public void setProductoComprado(ProductoDTO productoComprado) {this.productoComprado = productoComprado;}
    /**
     * Establece la lista de tallas compradas a la compra.
     * Si alguna talla comprada no tiene asociada esta 
     * compra, la añade, para mantener ambas entidades 
     * sincronizadas.
     * @param tallasCompradas Lista de tallas compradas.
     */
    public void setTallasCompradas(List<DetalleCompraTallaDTO> tallasCompradas) {this.tallasCompradas = tallasCompradas;}
    /**
     * Agrega una talla comprada a la lista de tallas compradas.
     * Si el detalle de la compra de la talla no tiene
     * asociada esta compra, la asocia, para mantener
     * ambas entidades sincronizadas.
     * @param tallaComprada Talla a agregar.
     */
    public void agregarTallaComprada(DetalleCompraTallaDTO tallaComprada){tallasCompradas.add(tallaComprada);}
    /**
     * Regresa una cadena con la información de la compra.
     * @return Cadena con la información de la compra.
     */
    @Override
    public String toString() {
        return String.format(
                "%s, %s, %s", 
                productoComprado.getNombre(), fechaHora.toString(), totalCompra.toString()
        );
    }
}