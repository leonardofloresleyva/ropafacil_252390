package dtos;

/**
 * Entidad TipoPrendaDTO. Se relaciona con ProductoDTO.
 * Tipo de Dato de Transferencia.
 * @author Leonardo Flores Leyva - 252390
 */
public class TipoPrendaDTO {
    /**
     * ID del tipo.
     */
    private Long id;
    /**
     * Nombre del tipo.
     */
    private String tipo;
    /**
     * Constructor por defecto del tipo.
     */
    public TipoPrendaDTO() {}
    /**
     * Contructor sin ID que recibe el nombre del tipo.
     * @param tipo Nombre del tipo.
     */
    public TipoPrendaDTO(String tipo) {this.tipo = tipo;}
    /**
     * Contructor que recibe el ID y el nombre del tipo.
     * @param id ID del tipo.
     * @param tipo Nombre del tipo.
     */
    public TipoPrendaDTO(Long id, String tipo) {
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