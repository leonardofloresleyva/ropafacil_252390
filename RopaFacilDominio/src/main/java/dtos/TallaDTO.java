package dtos;

/**
 * Entidad TallaDTO. Se relaciona con StockPorTallaDTO. DetalleVentaTallaDTO y DetalleCompraTallaDTO.
 * Tipo de Dato de Transferencia.
 * @author Leonardo Flores Leyva - 252390
 */
public class TallaDTO {
    /**
     * ID de la talla.
     */
    private Long id;
    /**
     * Nombre de la talla.
     */
    private String talla;
    /**
     * Constructor por defecto de la talla.
     */
    public TallaDTO() {}
    /**
     * Contructor sin ID que recibe el nombre de la talla.
     * @param talla Nombre de la talla.
     */
    public TallaDTO(String talla) {this.talla = talla;}
    /**
     * Contructor con ID y que recibe el nombre de la talla.
     * @param id ID de la talla.
     * @param talla Nombre de la talla.
     */
    public TallaDTO(Long id, String talla) {
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
     * @param id Nuevo ID de la talla.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Establece el nombre de la talla.
     * @param talla Nuevo nombre de la talla.
     */
    public void setTalla(String talla) {this.talla = talla;}
    /**
     * Regresa una cadena con el nombre de la talla.
     * @return Cadena con el nombre de la talla.
     */
    @Override
    public String toString() {return talla;}
}