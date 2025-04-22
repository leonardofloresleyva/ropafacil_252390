package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad Categoría. Se relaciona con Producto.
 * @author Leonardo Flores Leyva - 252390
 */
@Entity
@Table(name = "CATEGORIAS")
public class Categoria implements Serializable {
    /**
     * ID de la categoría.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Nombre de la categoría.
     */
    @Column(name = "CATEGORIA", nullable = false, unique = true, length = 50)
    private String categoria;
    /**
     * Constructor por defecto de la categoría.
     */
    public Categoria() {}
    /**
     * Contructor sin ID que recibe el nombre de la categoría.
     * @param categoria Nombre de la categoría.
     */
    public Categoria(String categoria) {this.categoria = categoria;}
    /**
     * Contructor que recibe el ID y el nombre de la categoría.
     * @param id ID de la categoría.
     * @param categoria Nombre de la categoría.
     */
    public Categoria(Long id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }
    /**
     * Retorna el ID de la categoría.
     * @return ID de la categoría.
     */
    public Long getId() {return id;}
    /**
     * Retorna el nombre de la categoría.
     * @return Nombre de la categoría.
     */
    public String getCategoria() {return categoria;}
    /**
     * Establece el ID de la categoría.
     * @param id Nuevo ID de la categoría.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Establece el nombre de la categoría.
     * @param categoria Nuevo nombre de la categoría.
     */
    public void setCategoria(String categoria) {this.categoria = categoria;}
    /**
     * Regresa una cadena con el nombre de la categoría.
     * @return Cadena con el nombre de la categoría.
     */
    @Override
    public String toString() {return categoria;}
}