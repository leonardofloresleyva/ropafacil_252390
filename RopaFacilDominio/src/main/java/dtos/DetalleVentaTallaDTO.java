package dtos;

/**
 * Entidad DetalleVentaTallaDTO. Se relaciona con TallaDTO y VentaDTO.
 * Tipo de Dato de Transferencia.
 * @author Leonardo Flores Leyva - 252390
 */
public class DetalleVentaTallaDTO {
    /**
     * ID del detalle de venta de la talla.
     */
    private Long id;
    /**
     * Cantidad de tallas vendidas.
     */
    private Integer cantidadVendida;
    /**
     * Subtotal de la talla vendida.
     */
    private Double subtotalVenta;
    /**
     * Talla asociada.
     */
    private TallaDTO talla;
    /**
     * Venta asociada al detalle de venta de la talla.
     */    
    private VentaDTO venta;
    /**
     * Constructor por defecto del detalle de venta de la talla.
     */
    public DetalleVentaTallaDTO() {}
    /**
     * Constructor sin ID del detalle de venta de la talla.
     * @param cantidadVendida Cantidad de tallas vendidas.
     * @param talla Talla asociada.
     * @param venta Venta asociada al detalle de venta de la talla.
     */
    public DetalleVentaTallaDTO(Integer cantidadVendida, TallaDTO talla, VentaDTO venta) {
        this.cantidadVendida = cantidadVendida;
        this.talla = talla;
        this.venta = venta;
    }
    /**
     * Constructor con ID incluido del detalle de venta de la talla.
     * @param id ID del detalle de venta de la talla.
     * @param cantidadVendida Cantidad de tallas vendidas.
     * @param talla Talla asociada.
     * @param venta Venta asociada al detalle de venta de la talla.
     */
    public DetalleVentaTallaDTO(Long id, Integer cantidadVendida, TallaDTO talla, VentaDTO venta) {
        this.id = id;
        this.cantidadVendida = cantidadVendida;
        this.talla = talla;
        this.venta = venta;
    }
    /**
     * Retorna el ID del detalle de venta de la talla.
     * @return ID del detalle de venta de la talla.
     */
    public Long getId() {return id;}
    /**
     * Retorna la cantidad vendida de la talla.
     * @return Cantidad vendida de la talla.
     */
    public Integer getCantidadVendida() {return cantidadVendida;}
    /**
     * Retorna el subtotal de la talla vendida.
     * @return Subtotal de la talla vendida.
     */
    public Double getSubtotalVenta() {return subtotalVenta;}
    /**
     * Retorna la talla asociada.
     * @return Talla asociada.
     */
    public TallaDTO getTalla() {return talla;}
    /**
     * Retorna la venta asociada al detalle de venta de la talla.
     * @return Venta asociada al detalle de venta de la talla.
     */
    public VentaDTO getVenta() {return venta;}
    /**
     * Establece el ID del detalle de venta de la talla.
     * @param id Nuevo ID del detalle de venta de la talla.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Establece la cantidad vendida de la talla.
     * @param cantidadVendida Nueva cantidad vendida de la talla.
     */
    public void setCantidadVendida(Integer cantidadVendida) {this.cantidadVendida = cantidadVendida;}
    /**
     * Establece el subtotal de la talla vendida.
     * @param subtotalVenta Nuevo subtotal de la talla vendida.
     */
    public void setSubtotalVenta(Double subtotalVenta) {this.subtotalVenta = subtotalVenta;}
    /**
     * Establece la talla asociada.
     * @param talla Nueva talla asociada.
     */
    public void setTalla(TallaDTO talla) {this.talla = talla;}
    /**
     * Establece la venta del detalle de venta de la talla.
     * Si la venta no tiene esta talla vendida en su lista
     * de tallas vendidas, la agrega, para mantener ambas
     * entidades sincronizadas.
     * @param venta Venta del detalle de venta de la talla.
     */
    public void setVenta(VentaDTO venta) {this.venta = venta;}
    /**
     * Regresa una cadena con la información del detalle de venta de la talla.
     * @return Cadena con la información del detalle de venta de la talla.
     */
    @Override
    public String toString() {
        return String.format(
                "%s, %s, %s, %s", 
                venta.toString(), talla.toString(), cantidadVendida.toString(), subtotalVenta.toString()
        );
    }
}