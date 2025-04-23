package dtos;

/**
 * Entidad CategoríaDTO. Se relaciona con ProductoDTO.
 * Tipo de Dato de Transferencia.
 * @author Leonardo Flores Leyva - 252390
 */
public class CategoriaDTO {
    /**
     * ID de la categoría.
     */
    private Long id;
    /**
     * Nombre de la categoría.
     */
    private String categoria;
    /**
     * Constructor por defecto de la categoría.
     */
    public CategoriaDTO() {}
    /**
     * Contructor sin ID que recibe el nombre de la categoría.
     * @param categoria Nombre de la categoría.
     */
    public CategoriaDTO(String categoria) {this.categoria = categoria;}
    /**
     * Contructor que recibe el ID y el nombre de la categoría.
     * @param id ID de la categoría.
     * @param categoria Nombre de la categoría.
     */
    public CategoriaDTO(Long id, String categoria) {
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