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
 * Entidad DetalleVentaTalla. Se relaciona con Talla y Venta.
 * @author Leonardo Flores Leyva - 252390
 */
@Entity
@Table(name = "DATALLES_VENTA_TALLA")
public class DetalleVentaTalla implements Serializable {
    /**
     * ID del detalle de venta de la talla.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Cantidad de tallas vendidas.
     */
    @Column(name = "CANTIDAD_VENDIDA", nullable = false, unique = false)
    private Integer cantidadVendida;
    /**
     * Subtotal de la talla vendida.
     */
    @Column(name = "SUBTOTAL_VENTA", nullable = false, unique = false)
    private Double subtotalVenta;
    /**
     * Talla asociada.
     */
    @ManyToOne
    @JoinColumn(name = "ID_TALLA", nullable = false)
    private Talla talla;
    /**
     * Venta asociada al detalle de venta de la talla.
     */
    @ManyToOne
    @JoinColumn(name = "ID_VENTA", nullable = false)    
    private Venta venta;
    /**
     * Constructor por defecto del detalle de venta de la talla.
     */
    public DetalleVentaTalla() {}
    /**
     * Constructor sin ID del detalle de venta de la talla.
     * @param cantidadVendida Cantidad de tallas vendidas.
     * @param talla Talla asociada.
     * @param venta Venta asociada al detalle de venta de la talla.
     */
    public DetalleVentaTalla(Integer cantidadVendida, Talla talla, Venta venta) {
        this.cantidadVendida = cantidadVendida;
        this.talla = talla;
        this.venta = venta;
        // Mantiene la relación bidireccional sincronizada, entre la Compra y su lista de DetalleCompraTalla.
        if(venta.verificarDetalleVentaTalla(this))
            venta.agregarTallaVendida(this);
    }
    /**
     * Constructor con ID incluido del detalle de venta de la talla.
     * @param id ID del detalle de venta de la talla.
     * @param cantidadVendida Cantidad de tallas vendidas.
     * @param talla Talla asociada.
     * @param venta Venta asociada al detalle de venta de la talla.
     */
    public DetalleVentaTalla(Long id, Integer cantidadVendida, Talla talla, Venta venta) {
        this.id = id;
        this.cantidadVendida = cantidadVendida;
        this.talla = talla;
        this.venta = venta;
        // Mantiene la relación bidireccional sincronizada, entre la Compra y su lista de DetalleCompraTalla.
        if(venta.verificarDetalleVentaTalla(this))
            venta.agregarTallaVendida(this);
    }
    /**
     * Retorna el ID del detalle de venta de la talla.
     * @return ID del detalle de venta de la talla.
     */
    public Long getId() {return id;}
    /**
     * Retorna la cantidad vendida de la talla.
     * @return Cantidad vendida de la talla.
     */
    public Integer getCantidadVendida() {return cantidadVendida;}
    /**
     * Retorna el subtotal de la talla vendida.
     * @return Subtotal de la talla vendida.
     */
    public Double getSubtotalVenta() {return subtotalVenta;}
    /**
     * Retorna la talla asociada.
     * @return Talla asociada.
     */
    public Talla getTalla() {return talla;}
    /**
     * Retorna la venta asociada al detalle de venta de la talla.
     * @return Venta asociada al detalle de venta de la talla.
     */
    public Venta getVenta() {return venta;}
    /**
     * Establece el ID del detalle de venta de la talla.
     * @param id Nuevo ID del detalle de venta de la talla.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Establece la cantidad vendida de la talla.
     * @param cantidadVendida Nueva cantidad vendida de la talla.
     */
    public void setCantidadVendida(Integer cantidadVendida) {this.cantidadVendida = cantidadVendida;}
    /**
     * Establece el subtotal de la talla vendida.
     * @param subtotalVenta Nuevo subtotal de la talla vendida.
     */
    public void setSubtotalVenta(Double subtotalVenta) {this.subtotalVenta = subtotalVenta;}
    /**
     * Establece la talla asociada.
     * @param talla Nueva talla asociada.
     */
    public void setTalla(Talla talla) {this.talla = talla;}
    /**
     * Establece la venta del detalle de venta de la talla.
     * Si la venta no tiene esta talla vendida en su lista
     * de tallas vendidas, la agrega, para mantener ambas
     * entidades sincronizadas.
     * @param venta Venta del detalle de venta de la talla.
     */
    public void setVenta(Venta venta) {
        this.venta = venta;
        if(venta.verificarDetalleVentaTalla(this))
            venta.agregarTallaVendida(this);
    }
    /**
     * Verifica si el detalle de venta de la talla
     * tiene una venta asociada.
     * @return VERDADERO si el detalle de venta de la talla tiene una venta asociada, FALSO en caso contrario.
     */
    public boolean verificarVenta(){return venta != null;}
    /**
     * Regresa una cadena con el detalle de venta de la talla.
     * @return Cadena con el detalle de venta de la talla.
     */
    @Override
    public String toString() {return cantidadVendida.toString();}
}