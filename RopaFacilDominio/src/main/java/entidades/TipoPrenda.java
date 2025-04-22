package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad TipoPrenda. Se relaciona con Producto.
 * @author Leonardo Flores Leyva - 252390
 */
@Entity
@Table(name = "TIPOS_PRENDA")
public class TipoPrenda implements Serializable {
    /**
     * ID del tipo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Nombre del tipo.
     */
    @Column(name = "TIPO", nullable = false, unique = true, length = 50)
    private String tipo;
    /**
     * Constructor por defecto del tipo.
     */
    public TipoPrenda() {}
    /**
     * Contructor sin ID que recibe el nombre del tipo.
     * @param tipo Nombre del tipo.
     */
    public TipoPrenda(String tipo) {this.tipo = tipo;}
    /**
     * Contructor que recibe el ID y el nombre del tipo.
     * @param id ID del tipo.
     * @param tipo Nombre del tipo.
     */
    public TipoPrenda(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }
    /**
     * Retorna el ID del tipo.
     * @return ID del tipo.
     */
    public Long getId() {return id;}
    /**
     * Retorna el nombre del tipo.
     * @return Nombre del tipo.
     */
    public String getTipo() {return tipo;}
    /**
     * Establece el ID del tipo.
     * @param id Nuevo ID del tipo.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Establece el nombre del tipo.
     * @param tipo Nuevo nombre del tipo.
     */
    public void setTipo(String tipo) {this.tipo = tipo;}
    /**
     * Regresa una cadena con el nombre del tipo.
     * @return Cadena con el nombre del tipo.
     */
    @Override
    public String toString() {return tipo;}
}