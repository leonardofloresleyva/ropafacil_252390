package dtos;

/**
 * Entidad StockPorTallaDTO. Se relaciona con Talla y ProductoDTO.
 * Tipo de Dato de Transferencia.
 * @author Leonardo Flores Leyva - 252390
 */
public class StockPorTallaDTO {
    /**
     * ID del stock por talla.
     */
    private Long id;
    /**
     * Cantidad del stock por talla.
     */
    private Integer stock;
    /**
     * Producto del stock por talla.
     */
    private ProductoDTO producto;
    /**
     * Talla del stock por talla.
     */
    private TallaDTO talla;
    /**
     * Constructor por defecto del stock por talla.
     */
    public StockPorTallaDTO() {}
    /**
     * Contructor sin ID que recibe la cantidad del stock por talla.
     * @param stock Cantidad del stock por talla.
     * @param producto Producto del stock por talla.
     * @param talla Talla del stock por talla.
     */
    public StockPorTallaDTO(Integer stock, ProductoDTO producto, TallaDTO talla) {    
        this.stock = stock;
        this.producto = producto;
        this.talla = talla;
    }
    /**
     * Contructor que recibe el ID y la cantidad del stock por talla.
     * @param id ID del stock por talla.
     * @param stock Cantidad del stock por talla.
     * @param producto Producto del stock por talla.
     * @param talla Talla del stock por talla.
     */
    public StockPorTallaDTO(Long id, Integer stock, ProductoDTO producto, TallaDTO talla) {
        this.id = id;    
        this.stock = stock;
        this.producto = producto;
        this.talla = talla;
    }
    /**
     * Retorna el ID del stock por talla.
     * @return ID del stock por talla.
     */
    public Long getId() {return id;}
    /**
     * Retorna la cantidad del stock por talla.
     * @return Cantidad del stock por talla.
     */
    public Integer getStock() {return stock;}
    /**
     * Retorna el producto del stock por talla.
     * @return Producto del stock por talla.
     */
    public ProductoDTO getProducto() {return producto;}
    /**
     * Retorna la talla del stock por talla.
     * @return Talla del stock por talla.
     */
    public TallaDTO getTalla() {return talla;}
    /**
     * Establece el ID del stock por talla.
     * @param id Nuevo ID del stock por talla.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Establece la cantidad del stock por talla.
     * @param stock Nueva cantidad del stock por talla.
     */
    public void setStock(Integer stock) {this.stock = stock;}
    /**
     * Establece el producto del stock por talla.
     * Si el producto no contiene este StockPorTalla, lo
     * añade, para mantener ambas entidades sincronizadas.
     * @param producto Nuevo producto del stock por talla.
     */
    public void setProducto(ProductoDTO producto) {this.producto = producto;}
    /**
     * Establece la talla del stock por talla.
     * @param talla Nueva talla del stock por talla.
     */
    public void setTalla(TallaDTO talla) {this.talla = talla;}
    /**
     * Regresa una cadena con la información del stock por talla.
     * @return Cadena con la información del stock por talla.
     */
    @Override
    public String toString() {return String.format("%s, %s, %s", producto.getNombre(), talla.toString(), stock);}
}