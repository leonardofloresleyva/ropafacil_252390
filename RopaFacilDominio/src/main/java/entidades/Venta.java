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
import javax.persistence.OneToMany;

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
     * Total gastado de la venta.
     */
    @Column(name = "TOTAL_VENTA", nullable = false, unique = false)
    private Double totalVenta;
    /**
     * Detalle del producto asociado a la venta.
     */
    @OneToMany(mappedBy = "venta", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.EAGER)
    private DetalleVentaProducto productoVendido;
    /**
     * Lista de tallas compradas asociadas al producto.
     */
    @OneToMany(mappedBy = "venta", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<DetalleVentaTalla> tallasVendidas = new ArrayList<>();
    /**
     * Ontiene el ID de la venta.
     * @return ID de la venta.
     */
    public Long getId() {return id;}
    /**
     * Obtiene la fecha y hora de la venta.
     * @return Fecha y hora de la venta.
     */
    public LocalDateTime getFechaHora() {return fechaHora;}
    /**
     * Obtiene la recaudación total de la venta.
     * @return Recaudación total de la venta.
     */
    public Double getTotalVenta() {return totalVenta;}
    /**
     * Obtiene el detalle del producto asociado a la venta.
     * @return Detalle del producto asociado a la venta.
     */
    public DetalleVentaProducto getProductoVendido() {return productoVendido;}
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
     * Establece la recaudación total de la venta.
     * @param totalVenta Nueva recaudación total de la venta.
     */
    public void setTotalCompra(Double totalVenta) {this.totalVenta = totalVenta;}
    /**
     * Establece el detalle del producto asociado a la venta.
     * Si el detalle del producto asociado a la venta no 
     * tiene esta venta, lo añade, para mantener ambas
     * entidades sincronizadas.
     * @param productoVendido Nuevo detalle del producto asociado a la venta.
     */
    public void setProductoVendido(DetalleVentaProducto productoVendido) {
        this.productoVendido = productoVendido;
        if(!productoVendido.verificarVenta())
            productoVendido.setVenta(this);
    }
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
     * Regresa una cadena con la venta.
     * @return Cadena con la venta.
     */
    @Override
    public String toString() {return totalVenta.toString();}
}