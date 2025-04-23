package dtos;

/**
 * Entidad ColorDTO. Se relaciona con ProductoDTO.
 * Tipo de Dato de Transferencia.
 * @author Leonardo Flores Leyva - 252390
 */
public class ColorDTO {
    /**
     * ID del color.
     */
    private Long id;
    /**
     * Nombre del color.
     */
    private String color;
    /**
     * Constructor por defecto del color.
     */
    public ColorDTO() {}
    /**
     * Contructor sin ID que recibe el nombre del color.
     * @param color Nombre del color.
     */
    public ColorDTO(String color) {this.color = color;}
    /**
     * Contructor que recibe el ID y el nombre del color.
     * @param id ID del color.
     * @param color Nombre del color.
     */
    public ColorDTO(Long id, String color) {
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