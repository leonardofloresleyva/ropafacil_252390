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
 * Entidad DetalleCompraTalla. Se relaciona con Talla y Compra.
 * @author Leonardo Flores Leyva - 252390
 */
@Entity
@Table(name = "DATALLES_COMPRA_TALLA")
public class DetalleCompraTalla implements Serializable {
    /**
     * ID del detalle de compra de la talla.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Cantidad de tallas compradas.
     */
    @Column(name = "CANTIDAD_COMPRADA", nullable = false, unique = false)
    private Integer cantidadComprada;
    /**
     * Talla asociada.
     */
    @ManyToOne
    @JoinColumn(name = "ID_TALLA", nullable = false)
    private Talla talla;
    /**
     * Compra asociada al detalle de compra de la talla.
     */
    @ManyToOne
    @JoinColumn(name = "ID_COMPRA", nullable = false)    
    private Compra compra;
    /**
     * Constructor por defecto del detalle de compra de la talla.
     */
    public DetalleCompraTalla() {}
    /**
     * Constructor sin ID del detalle de compra de la talla.
     * @param cantidadComprada Cantidad de tallas comprada.
     * @param talla Talla asociada.
     * @param compra Compra asociada al detalle de compra de la talla.
     */
    public DetalleCompraTalla(Integer cantidadComprada, Talla talla, Compra compra) {
        this.cantidadComprada = cantidadComprada;
        this.talla = talla;
        this.compra = compra;
        // Mantiene la relación bidireccional sincronizada, entre la Compra y su lista de DetalleCompraTalla.
        if(!compra.verificarDetalleCompraTalla(this))
            compra.agregarTallaComprada(this);
    }
    /**
     * Constructor con ID incluido del detalle de compra de la talla.
     * @param id ID del detalle de compra de la talla.
     * @param cantidadComprada Cantidad de tallas comprada.
     * @param talla Talla asociada.
     * @param compra Compra asociada al detalle de compra de la talla.
     */
    public DetalleCompraTalla(Long id, Integer cantidadComprada, Talla talla, Compra compra) {
        this.id = id;
        this.cantidadComprada = cantidadComprada;
        this.talla = talla;
        this.compra = compra;
        // Mantiene la relación bidireccional sincronizada, entre la Compra y su lista de DetalleCompraTalla.
        if(!compra.verificarDetalleCompraTalla(this))
            compra.agregarTallaComprada(this);
    }
    /**
     * Obtiene el ID del detalle de compra de la talla.
     * @return ID del detalle de compra de la talla.
     */
    public Long getId() {return id;}
    /**
     * Retorna la cantidad comprada de la talla.
     * @return Cantidad comprada de la talla.
     */
    public Integer getCantidadComprada() {return cantidadComprada;}
    /**
     * Retorna la talla asociada.
     * @return Talla asociada.
     */
    public Talla getTalla() {return talla;}
    /**
     * Retorna la compra asociada al detalle de compra de la talla.
     * @return Compra asociada al detalle de compra de la talla.
     */
    public Compra getCompra() {return compra;}
    /**
     * Establece el ID del detalle de compra de la talla.
     * @param id Nuevo ID del detalle de compra de la talla.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Establece la cantidad comprada de la talla.
     * @param cantidadComprada Nueva cantidad comprada de la talla.
     */
    public void setCantidadComprada(Integer cantidadComprada) {this.cantidadComprada = cantidadComprada;}
    /**
     * Establece la talla asociada.
     * @param talla Nueva talla asociada.
     */
    public void setTalla(Talla talla) {this.talla = talla;}
    /**
     * Establece la compra del detalle de compra de la talla.
     * Si la compra no tiene esta talla comprada en su lista
     * de tallas compradas, la agrega, para mantener ambas
     * entidades sincronizadas.
     * @param compra Compra del detalle de compra de la talla.
     */
    public void setCompra(Compra compra) {
        this.compra = compra;
        if(!compra.verificarDetalleCompraTalla(this))
            compra.agregarTallaComprada(this);
    }
    /**
     * Verifica si el detalle de compra de la talla
     * tiene una compra asociada.
     * @return VERDADERO si el detalle de compra de la talla tiene una compra asociada, FALSO en caso contrario.
     */
    public boolean verificarCompra(){return compra != null;}
    /**
     * Regresa una cadena con la información del detalle de compra de la talla.
     * @return Cadena con la información del detalle de compra de la talla.
     */
    @Override
    public String toString() {return String.format("%s, %s, %s", compra.toString(), talla.toString(), cantidadComprada.toString());}
}