package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad CajaAlmacenamiento. Se relaciona con Producto.
 * @author Leonardo Flores Leyva - 252390
 */
@Entity
@Table(name = "CAJAS_ALMACENAMIENTO")
public class CajaAlmacenamiento implements Serializable {
    /**
     * ID de la caja de almacenamiento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Número de la caja de almacenamiento.
     */
    @Column(name = "CAJA", nullable = false, unique = true)
    private Integer caja;
    /**
     * Constructor por defecto de la caja de almacenamiento.
     */
    public CajaAlmacenamiento() {}
    /**
     * Contructor que recibe el número de la caja de almacenamiento.
     * @param caja Número de la caja de almacenamiento.
     */
    public CajaAlmacenamiento(Integer caja) {this.caja = caja;}
    /**
     * Contructor que recibe el ID y el número de la caja de almacenamiento.
     * @param id ID de la caja de almacenamiento.
     * @param caja Número de la caja de almacenamiento.
     */
    public CajaAlmacenamiento(Long id, Integer caja) {
        this.id = id;
        this.caja = caja;
    }
    /**
     * Retorna el ID de la caja de almacenamiento.
     * @return ID de la caja de almacenamiento.
     */
    public Long getId() {return id;}
    /**
     * Retorna el número de la caja de almacenamiento.
     * @return Número de la caja de almacenamiento.
     */
    public Integer getCaja() {return caja;}
    /**
     * Establece el ID de la caja de almacenamiento.
     * @param id Nuevo ID de la caja de almacenamiento.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Establece el número de la caja de almacenamiento.
     * @param caja Nuevo número de la caja de almacenamiento.
     */
    public void setCaja(Integer caja) {this.caja = caja;}
    /**
     * Regresa una cadena con el número de la caja de almacenamiento.
     * @return Cadena con el número de la caja de almacenamiento.
     */
    @Override
    public String toString() {return caja.toString();}    
}