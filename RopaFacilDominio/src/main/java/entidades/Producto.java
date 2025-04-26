package entidades;

import enums.EstadoProducto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entidad Producto. Se relaciona con StockPorTalla, DetalleCompraProducto, DetalleVentaProducto,
 * Categoría, Color, TipoPrenda, CajaAlmacenamiento y Proveedor (opcional).
 * @author Leonardo Flores Leyva - 252390
 */
@Entity
@Table(name = "PRODUCTOS")
public class Producto implements Serializable {
    /**
     * ID del producto.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Nombre del producto.
     */
    @Column(name = "NOMBRE", nullable = false, unique = false, length = 100)
    private String nombre;
    /**
     * Estado del producto.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO", nullable = false)
    private EstadoProducto estado;
    /**
     * Precio del producto.
     */
    @Column(name = "PRECIO", nullable = false, unique = false)
    private Double precio;
    /**
     * Categoría del producto.
     */
    @OneToOne()
    @JoinColumn(name = "ID_CATEGORIA", nullable = false)
    private Categoria categoria;
    /**
     * Color del producto.
     */
    @OneToOne()
    @JoinColumn(name = "ID_COLOR", nullable = false)
    private Color color;    
    /**
     * Tipo del producto.
     */
    @OneToOne()
    @JoinColumn(name = "ID_TIPO", nullable = false)
    private TipoPrenda tipo;
    /**
     * Caja de almacenamiento del producto.
     */
    @OneToOne()
    @JoinColumn(name = "ID_CAJA", nullable = false)
    private CajaAlmacenamiento caja;
    /**
     * Proveedor del producto.
     */
    @OneToOne()
    @JoinColumn(name = "ID_PROVEEDOR", nullable = true)
    private Proveedor proveedor;
    /**
     * Lista de stock de tallas del producto.
     */
    @OneToMany(mappedBy = "producto", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<StockPorTalla> tallas = new ArrayList<>();
    /**
     * Constructor por defecto del producto.
     */
    public Producto() {}
    /**
     * Constructor sin ID del producto.
     * @param nombre Nombre del producto.
     * @param estado Estado del producto.
     * @param precio Precio del producto.
     * @param categoria Categoría del producto.
     * @param color Color del producto.
     * @param tipo Tipo del producto.
     * @param caja Caja de almacenamiento del producto.
     * @param proveedor Proveedor del producto.
     * @param tallas Lista de stock de tallas del producto.
     */
    public Producto(
            String nombre, 
            EstadoProducto estado, 
            Double precio, 
            Categoria categoria, 
            Color color, 
            TipoPrenda tipo, 
            CajaAlmacenamiento caja, 
            Proveedor proveedor, 
            List<StockPorTalla> tallas
            
    ) {
        this.nombre = nombre;
        this.estado = estado;
        this.precio = precio;
        this.categoria = categoria;
        this.color = color;
        this.tipo = tipo;
        this.caja = caja;
        this.proveedor = proveedor;
        this.tallas = tallas;
        // Mantiene sincronizada la relación bidireccional, entre el producto y sus StockPorTalla.
        for(StockPorTalla talla: tallas){
            if(!talla.verificarProducto())
                talla.setProducto(this);
        }
    }
    /**
     * Constructor con ID incluido del producto.
     * @param id ID del producto.
     * @param nombre Nombre del producto.
     * @param estado Estado del producto.
     * @param precio Precio del producto.
     * @param categoria Categoría del producto.
     * @param color Color del producto.
     * @param tipo Tipo del producto.
     * @param caja Caja de almacenamiento del producto.
     * @param proveedor Proveedor del producto.
     * @param tallas Lista de stock de tallas del producto.
     */
    public Producto(
            Long id, 
            String nombre, 
            EstadoProducto estado, 
            Double precio, 
            Categoria categoria, 
            Color color, 
            TipoPrenda tipo, 
            CajaAlmacenamiento caja, 
            Proveedor proveedor, 
            List<StockPorTalla> tallas
    ) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.precio = precio;
        this.categoria = categoria;
        this.color = color;
        this.tipo = tipo;
        this.caja = caja;
        this.proveedor = proveedor;
        this.tallas = tallas;
        // Mantiene sincronizada la relación bidireccional, entre el producto y sus StockPorTalla.
        for(StockPorTalla talla: tallas){
            if(!talla.verificarProducto())
                talla.setProducto(this);
        }
    }
    /**
     * Retiorna el ID del producto.
     * @return ID del producto.
     */
    public Long getId() {return id;}
    /**
     * Retiorna el nombre del producto.
     * @return Nombre del producto.
     */
    public String getNombre() {return nombre;}
    /**
     * Retiorna el estado del producto.
     * @return Estado del producto.
     */
    public EstadoProducto getEstado() {return estado;}
    /**
     * Retiorna el precio del producto.
     * @return Precio del producto.
     */
    public Double getPrecio() {return precio;}
    /**
     * Retiorna la categoría del producto.
     * @return Categoría del producto.
     */
    public Categoria getCategoria() {return categoria;}
    /**
     * Retiorna el color del producto.
     * @return Color del producto.
     */
    public Color getColor() {return color;}
    /**
     * Retiorna el tipo del producto.
     * @return Tipo del producto.
     */
    public TipoPrenda getTipo() {return tipo;}
    /**
     * Retiorna la caja de almacenamiento del producto.
     * @return Caja de almacenamiento del producto.
     */
    public CajaAlmacenamiento getCaja() {return caja;}
    /**
     * Retiorna el proveedor del producto.
     * @return Proveedor del producto.
     */
    public Proveedor getProveedor() {return proveedor;}
    /**
     * Retiorna la lista de stock de tallas del producto.
     * @return Lista de stock de tallas del producto.
     */
    public List<StockPorTalla> getTallas() {return tallas;}
    /**
     * Establece el ID del producto.
     * @param id Nuevo ID del producto.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Establece el nombre del producto.
     * @param nombre Nuevo nombre del producto.
     */
    public void setNombre(String nombre) {this.nombre = nombre;}
    /**
     * Establece el estado del producto.
     * @param estado Nuevo estado del producto.
     */
    public void setEstado(EstadoProducto estado) {this.estado = estado;}
    /**
     * Establece el precio del producto.
     * @param precio Nuevo precio del producto.
     */
    public void setPrecio(Double precio) {this.precio = precio;}
    /**
     * Establece la categoría del producto.
     * @param categoria Nueva categoría del producto.
     */
    public void setCategoria(Categoria categoria) {this.categoria = categoria;}
    /**
     * Establece el color del producto.
     * @param color Color del producto.
     */
    public void setColor(Color color) {this.color = color;}
    /**
     * Establece el tipo del producto.
     * @param tipo Nuevo tipo del producto.
     */
    public void setTipo(TipoPrenda tipo) {this.tipo = tipo;}
    /**
     * Establece al caja de almacenamiento del producto.
     * @param caja Caja de almacenamiento del producto.
     */
    public void setCaja(CajaAlmacenamiento caja) {this.caja = caja;}
    /**
     * Establece el proveedor del producto.
     * @param proveedor Proveedor del producto.
     */
    public void setProveedor(Proveedor proveedor) {this.proveedor = proveedor;}
    /**
     * Establece la lista de stocks de talas del producto.
     * Si algún StockPorTalla no tiene asociado este producto,
     * lo asocia, para mantener ambas entidades sincronizadas.
     * @param tallas Nueva lista de stocks de tallas del producto.
     */
    public void setTallas(List<StockPorTalla> tallas) {
        this.tallas = tallas;
        for(StockPorTalla talla: tallas){
            if(!talla.verificarProducto())
                talla.setProducto(this);
        }
    }
    /**
     * Comprueba si el StockPorTalla recibido se 
     * encuentra en la lista de stocks de tallas.
     * @param stockPorTalla StockPorTalla a buscar.
     * @return VERDADERO si el StockPorTalla se encuentra en la lista de stocks de tallas.
     */
    public boolean tieneTalla(StockPorTalla stockPorTalla){
        for(StockPorTalla talla : tallas){
            if(talla.getTalla().getTalla().equals(stockPorTalla.getTalla().getTalla()))
                return true;
        }
        return false;
    }
    /**
     * Agrega un nuevo StockPorTalla a la lista de stocks de tallas.
     * Si el StockPorTalla no contiene este producto, lo
     * añade, para mantener ambas entidades sincronizadas.
     * @param stockPorTalla Nuevo StockPorTalla.
     */
    public void agregarTalla(StockPorTalla stockPorTalla){
        tallas.add(stockPorTalla);
        if(!stockPorTalla.verificarProducto())
            stockPorTalla.setProducto(this);
    }
    /**
     * Devuelve una cadena con la información del producto.
     * @return Cadena con la información del producto.
     */
    @Override
    public String toString() {
        return String.format(
                "%s, %s, %s, %s, %s, %s, %s", 
                nombre, precio, estado, color.toString(), categoria.toString(), tipo.toString(), caja.toString()
        );
    }
}