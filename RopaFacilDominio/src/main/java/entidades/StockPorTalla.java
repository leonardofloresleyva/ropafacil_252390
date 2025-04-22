package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidad StockPorTalla. Se relaciona con Talla y Producto.
 * @author Leonardo Flores Leyva - 252390
 */
@Entity
@Table(name = "STOCK_POR_TALLA")
public class StockPorTalla implements Serializable {
    /**
     * ID del stock por talla.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Cantidad del stock por talla.
     */
    @Column(name = "STOCK", nullable = false, unique = false)
    private Integer stock;
    /**
     * Producto del stock por talla.
     */
    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO", nullable = false)
    private Producto producto;
    /**
     * Talla del stock por talla.
     */
    @ManyToOne
    @JoinColumn(name = "ID_TALLA", nullable = false)
    private Talla talla;
    /**
     * Constructor por defecto del stock por talla.
     */
    public StockPorTalla() {}
    /**
     * Contructor que recibe la cantidad del stock por talla.
     * @param stock Cantidad del stock por talla.
     * @param producto Producto del stock por talla.
     * @param talla Talla del stock por talla.
     */
    public StockPorTalla(Integer stock, Producto producto, Talla talla) {    
        this.stock = stock;
        this.producto = producto;
        // Sincroniza la relación bidireccional entre ambas entidades.
        if(!producto.tieneTalla(this))
            producto.agregarTalla(this);
        this.talla = talla;
    }
    /**
     * Contructor que recibe el ID y la cantidad del stock por talla.
     * @param id ID del stock por talla.
     * @param stock Cantidad del stock por talla.
     * @param producto Producto del stock por talla.
     * @param talla Talla del stock por talla.
     */
    public StockPorTalla(Long id, Integer stock, Producto producto, Talla talla) {
        this.id = id;    
        this.stock = stock;
        this.producto = producto;
        // Sincroniza la relación bidireccional entre ambas entidades.
        if(!producto.tieneTalla(this))
            producto.agregarTalla(this);
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
    public Producto getProducto() {return producto;}
    /**
     * Retorna la talla del stock por talla.
     * @return Talla del stock por talla.
     */
    public Talla getTalla() {return talla;}
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
     * Establece el el producto del stock por talla.
     * Si el producto no contiene este StockPorTalla, lo
     * añade, para mantener ambas entidades sincronizadas.
     * @param producto Nuevo producto del stock por talla.
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
        if(!producto.tieneTalla(this))
            producto.agregarTalla(this);
    }
    /**
     * Establece la la talla del stock por talla.
     * @param talla Nueva talla del stock por talla.
     */
    public void setTalla(Talla talla) {this.talla = talla;}
    /**
     * Verifica que el StockPorTalla tenga un
     * producto asociado.
     * @return VERDADERO si el StockPorTalla tiene un producto asociado, FALSO en caso contrario.
     */
    public boolean verificarProducto(){return producto != null;}
    /**
     * Regresa una cadena con la cantidad del stock por talla.
     * @return Cadena con la cantidad del stock por talla.
     */
    @Override
    public String toString() {return stock.toString();}
}