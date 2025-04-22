package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad Color. Se relaciona con Producto.
 * @author Leonardo Flores Leyva - 252390
 */
@Entity
@Table(name = "COLORES")
public class Color implements Serializable {
    /**
     * ID del color.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Nombre del color.
     */
    @Column(name = "COLOR", nullable = false, unique = true, length = 50)
    private String color;
    /**
     * Constructor por defecto del color.
     */
    public Color() {}
    /**
     * Contructor sin ID que recibe el nombre del color.
     * @param color Nombre del color.
     */
    public Color(String color) {this.color = color;}
    /**
     * Contructor que recibe el ID y el nombre del color.
     * @param id ID del color.
     * @param color Nombre del color.
     */
    public Color(Long id, String color) {
        this.id = id;
        this.color = color;
    }
    /**
     * Retorna el ID del color.
     * @return ID del color.
     */
    public Long getId() {return id;}
    /**
     * Retorna el nombre del color.
     * @return Nombre del color.
     */
    public String getColor() {return color;}
    /**
     * Establece el ID del color.
     * @param id Nuevo ID del color.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Establece el nombre del color.
     * @param color Nuevo nombre del color.
     */
    public void setColor(String color) {this.color = color;}
    /**
     * Regresa una cadena con el nombre del color.
     * @return Cadena con el nombre del color.
     */
    @Override
    public String toString() {return color;}   
}