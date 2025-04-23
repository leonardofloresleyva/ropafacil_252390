package dtos;

/**
 * Entidad DetalleCompraTallaDTO. Se relaciona con TallaDTO y CompraDTO.
 * Tipo de Dato de Transferencia.
 * @author Leonardo Flores Leyva - 252390
 */
public class DetalleCompraTallaDTO {
    /**
     * ID del detalle de compra de la talla.
     */
    private Long id;
    /**
     * Cantidad de tallas compradas.
     */
    private Integer cantidadComprada;
    /**
     * Talla asociada.
     */
    private TallaDTO talla;
    /**
     * Compra asociada al detalle de compra de la talla.
     */  
    private CompraDTO compra;
    /**
     * Constructor por defecto del detalle de compra de la talla.
     */
    public DetalleCompraTallaDTO() {}
    /**
     * Constructor sin ID del detalle de compra de la talla.
     * @param cantidadComprada Cantidad de tallas comprada.
     * @param talla Talla asociada.
     * @param compra Compra asociada al detalle de compra de la talla.
     */
    public DetalleCompraTallaDTO(Integer cantidadComprada, TallaDTO talla, CompraDTO compra) {
        this.cantidadComprada = cantidadComprada;
        this.talla = talla;
        this.compra = compra;
    }
    /**
     * Constructor con ID incluido del detalle de compra de la talla.
     * @param id ID del detalle de compra de la talla.
     * @param cantidadComprada Cantidad de tallas comprada.
     * @param talla Talla asociada.
     * @param compra Compra asociada al detalle de compra de la talla.
     */
    public DetalleCompraTallaDTO(Long id, Integer cantidadComprada, TallaDTO talla, CompraDTO compra) {
        this.id = id;
        this.cantidadComprada = cantidadComprada;
        this.talla = talla;
        this.compra = compra;
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
    public TallaDTO getTalla() {return talla;}
    /**
     * Retorna la compra asociada al detalle de compra de la talla.
     * @return Compra asociada al detalle de compra de la talla.
     */
    public CompraDTO getCompra() {return compra;}
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
    public void setTalla(TallaDTO talla) {this.talla = talla;}
    /**
     * Establece la compra del detalle de compra de la talla.
     * Si la compra no tiene esta talla comprada en su lista
     * de tallas compradas, la agrega, para mantener ambas
     * entidades sincronizadas.
     * @param compra Compra del detalle de compra de la talla.
     */
    public void setCompra(CompraDTO compra) {this.compra = compra;}
    /**
     * Regresa una cadena con la información del detalle de compra de la talla.
     * @return Cadena con la información del detalle de compra de la talla.
     */
    @Override
    public String toString() {return String.format("%s, %s, %s", compra.toString(), talla.toString(), cantidadComprada.toString());}
}