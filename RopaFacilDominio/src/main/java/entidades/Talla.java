package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad Talla. Se relaciona con StockPorTalla. DetalleVentaTalla y DetalleCompraTalla.
 * @author Leonardo Flores Leyva - 252390
 */
@Entity
@Table(name = "TALLAS")
public class Talla implements Serializable {
    /**
     * ID de la talla.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Nombre de la talla.
     */
    @Column(name = "TALLA", nullable = false, unique = true, length = 10)
    private String talla;
    /**
     * Constructor por defecto de la talla.
     */
    public Talla() {}
    /**
     * Contructor que recibe el nombre de la talla.
     * @param talla Nombre de la talla.
     */
    public Talla(String talla) {this.talla = talla;}
    /**
     * Contructor que recibe el ID y el nombre de la talla.
     * @param id ID de la talla.
     * @param talla Nombre de la talla.
     */
    public Talla(Long id, String talla) {
        this.id = id;
        this.talla = talla;
    }
    /**
     * Retorna el ID de la talla.
     * @return ID de la talla.
     */
    public Long getId() {return id;}
    /**
     * Retorna el nombre de la talla.
     * @return Nombre de la talla.
     */
    public String getTalla() {return talla;}
    /**
     * Establece el ID de la talla.
     * @param id ID de la talla.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Establece el nombre de la talla.
     * @param talla Nombre de la talla.
     */
    public void setTalla(String talla) {this.talla = talla;}
    /**
     * Regresa una cadena con el nombre de la talla.
     * @return Cadena con el nombre de la talla.
     */
    @Override
    public String toString() {return talla;}
}