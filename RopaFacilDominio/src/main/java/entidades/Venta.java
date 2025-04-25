package entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Entidad Venta. Se relaciona con DetalleVentaProducto y DetalleVentaTalla.
 * @author Leonardo Flores Leyva - 252390
 */
@Entity
public class Venta implements Serializable {
    /**
     * ID de la venta.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Fecha y hora de la venta.
     */
    @Column(name = "FECHA_HORA", nullable = false, unique = false)
    private LocalDateTime fechaHora;
    /**
     * Precio de venta del producto.
     */
    @Column(name = "PRECIO_VENTA", nullable = false, unique = false)
    private Double precioVenta;
    /**
     * Total gastado de la venta.
     */
    @Column(name = "TOTAL_VENTA", nullable = false, unique = false)
    private Double totalVenta;
    /**
     * Producto vendido.
     */
    @OneToOne()
    @JoinColumn(name = "ID_PRODUCTO", nullable = false)
    private Producto productoVendido;
    /**
     * Lista de tallas compradas asociadas al producto.
     */
    @OneToMany(mappedBy = "venta", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<DetalleVentaTalla> tallasVendidas = new ArrayList<>();
    /**
     * Constructor por defecto de una venta.
     */
    public Venta() {}
    /**
     * Constructor sin ID de la venta.
     * @param fechaHora Fecha y hora de la venta.
     * @param precioVenta Precio de venta del producto.
     * @param totalVenta Total ganado de la venta.
     * @param productoVendido Producto vendido
     * @param tallasVendidas Lista de tallas compradas asociadas al producto.
     */
    public Venta(LocalDateTime fechaHora, Double precioVenta, Double totalVenta, Producto productoVendido, List<DetalleVentaTalla> tallasVendidas) {
        this.fechaHora = fechaHora;
        this.precioVenta = precioVenta;
        this.totalVenta = totalVenta;
        this.productoVendido = productoVendido;
        this.tallasVendidas = tallasVendidas;
        // Mantiene sincronizada la relación bidireccional, entre la venta y su lista de DetalleVentaTalla.
        for(DetalleVentaTalla tallaVendida : tallasVendidas){
            if(!tallaVendida.verificarVenta())
                tallaVendida.setVenta(this);
        }
    }
    /**
     * Constructor con ID de la venta.
     * @param id ID de la venta.
     * @param fechaHora Fecha y hora de la venta.
     * @param precioVenta Precio de venta del producto.
     * @param totalVenta Total ganado de la venta.
     * @param productoVendido Producto vendido
     * @param tallasVendidas Lista de tallas compradas asociadas al producto.
     */
    public Venta(Long id, LocalDateTime fechaHora, Double precioVenta, Double totalVenta, Producto productoVendido, List<DetalleVentaTalla> tallasVendidas) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.precioVenta = precioVenta;
        this.totalVenta = totalVenta;
        this.productoVendido = productoVendido;
        this.tallasVendidas = tallasVendidas;
        // Mantiene sincronizada la relación bidireccional, entre la venta y su lista de DetalleVentaTalla.
        for(DetalleVentaTalla tallaVendida : tallasVendidas){
            if(!tallaVendida.verificarVenta())
                tallaVendida.setVenta(this);
        }
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
    public Producto getProductoVendido() {return productoVendido;}
    /**
     * Retorna la lista de tallas vendidas asociadas al producto.
     * @return Lista de tallas vendidas asociadas al producto.
     */
    public List<DetalleVentaTalla> getTallasVendidas() {return tallasVendidas;}
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
    public void setProductoVendido(Producto productoVendido) {this.productoVendido = productoVendido;}
    /**
     * Establece la lista de tallas vendidas a la venta.
     * Si alguna talla vendida no tiene asociada esta 
     * venta, la añade, para mantener ambas entidades 
     * sincronizadas.
     * @param tallasVendidas Lista de tallas vendidas.
     */
    public void setTallasVendidas(List<DetalleVentaTalla> tallasVendidas) {
        this.tallasVendidas = tallasVendidas;
        for(DetalleVentaTalla tallaVendida : tallasVendidas){
            if(!tallaVendida.verificarVenta())
                tallaVendida.setVenta(this);
        }
    }
    /**
     * Verifica si la venta tiene un
     * producto asociado.
     * @return VERDADERO si la venta tiene un producto asociado, FALSO en caso contrario.
     */
    public boolean verificarDetalleVentaProducto(){return productoVendido != null;}
    /**
     * Verifica si la lista de tallas vendidas contiene la talla recibida.
     * @param tallaVendida Talla a verificar.
     * @return VERDADERO si la lista de tallas vendidas contiene la talla recibida, FALSO en caso contrario.
     */
    public boolean verificarDetalleVentaTalla(DetalleVentaTalla tallaVendida){
        for(DetalleVentaTalla talla : tallasVendidas){
            if(talla.getTalla().equals(tallaVendida.getTalla()))
                return true;
        }
        return false;
    }
    /**
     * Agrega una talla vendida a la lista de tallas vendidas.
     * Si el detalle de la venta de la talla no tiene
     * asociada esta venta, la asocia, para mantener
     * ambas entidades sincronizadas.
     * @param tallaVendida Talla a agregar.
     */
    public void agregarTallaVendida(DetalleVentaTalla tallaVendida){
        tallasVendidas.add(tallaVendida);
        if(!tallaVendida.verificarVenta())
            tallaVendida.setVenta(this);
    }
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