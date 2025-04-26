package entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entidad Compra. Se relaciona con DetalleCompraProducto y DetalleCompraTalla.
 * @author Leonardo Flores Leyva - 252390
 */
@Entity
@Table(name = "COMPRAS")
@Inheritance(strategy = InheritanceType.JOINED) // Estrategia elegida para separar atributos únicos de clases hijas
@DiscriminatorColumn(name = "TIPO_COMPRA", discriminatorType = DiscriminatorType.STRING) // Discriminador STRING para especificar bien cada tipo de compra.
public abstract class Compra implements Serializable {
    /**
     * ID de la compra.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Fecha y hora de la compra.
     */
    @Column(name = "FECHA_HORA", nullable = false, unique = false)
    private LocalDateTime fechaHora;
    /**
     * Precio de compra unitario de la compra.
     */
    @Column(name = "PRECIO_COMPRA_UNITARIO", nullable = false, unique = false)
    private Double precioCompraUnitario;
    /**
     * Total gastado de la compra.
     */
    @Column(name = "TOTAL_COMPRA", nullable = false, unique = false)
    private Double totalCompra;
    /**
     * Categoría del producto.
     */
    @OneToOne()
    @JoinColumn(name = "ID_PRODUCTO", nullable = false)
    private Producto productoComprado;
    /**
     * Lista de tallas compradas asociadas al producto.
     */
    @OneToMany(mappedBy = "compra", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<DetalleCompraTalla> tallasCompradas = new ArrayList<>();
    /**
     * Constructor por defecto de la compra.
     */
    public Compra() {}
/**
 * Contructor sin ID de la compra.
 * @param fechaHora Fecha y hora de la compra.
 * @param precioCompraUnitario Precio de compra unitario de la compra.
 * @param totalCompra Total gastado de la compra.
 * @param productoComprado Detalle del producto asociado a la compra.
 * @param tallasCompradas Lista de tallas compradas asociadas al producto.
 */
    public Compra(LocalDateTime fechaHora, Double precioCompraUnitario, Double totalCompra, Producto productoComprado, List<DetalleCompraTalla> tallasCompradas) {
        this.fechaHora = fechaHora;
        this.precioCompraUnitario = precioCompraUnitario;
        this.totalCompra = totalCompra;
        this.productoComprado = productoComprado;
        this.tallasCompradas = tallasCompradas;
        // Mantiene sincronizada la relación bidireccional, entre la compra y su lista de DetalleCompraTalla.
        for(DetalleCompraTalla tallaComprada : tallasCompradas){
            if(!tallaComprada.verificarCompra())
                tallaComprada.setCompra(this);
        }
    }
    /**
     * Constructor con ID de la compra.
     * @param id ID de la compra.
     * @param fechaHora Fecha y hora de la compra.
     * @param totalCompra Total gastado de la compra.
     * @param productoComprado Detalle del producto asociado a la compra.
     * @param precioCompraUnitario Precio de compra unitario de la compra.
     * @param tallasCompradas Lista de tallas compradas asociadas al producto.
     */
    public Compra(Long id, LocalDateTime fechaHora, Double precioCompraUnitario, Double totalCompra, Producto productoComprado, List<DetalleCompraTalla> tallasCompradas) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.precioCompraUnitario = precioCompraUnitario;
        this.totalCompra = totalCompra;
        this.productoComprado = productoComprado;
        this.tallasCompradas = tallasCompradas;
        // Mantiene sincronizada la relación bidireccional, entre la compra y su lista de DetalleCompraTalla.
        for(DetalleCompraTalla tallaComprada : tallasCompradas){
            if(!tallaComprada.verificarCompra())
                tallaComprada.setCompra(this);
        }
    }
    /**
     * Retorna el ID de la compra.
     * @return ID de la compra.
     */
    public Long getId() {return id;}
    /**
     * Retorna la fecha y hora de la compra.
     * @return Fecha y hora de la compra.
     */
    public LocalDateTime getFechaHora() {return fechaHora;}
    /**
     * Retorna el precio de compra unitario de la compra.
     * @return Precio de compra unitario de la compra.
     */
    public Double getPrecioCompraUnitario() {return precioCompraUnitario;}
    /**
     * Retorna el gasto total de la compra.
     * @return Gasto total de la compra.
     */
    public Double getTotalCompra() {return totalCompra;}
    /**
     * Retorna el producto asociado a la compra.
     * @return Detalle del producto asociado a la compra.
     */
    public Producto getProductoComprado() {return productoComprado;}
    /**
     * Retorna la lista de tallas compradas asociadas al producto.
     * @return Lista de tallas compradas asociadas al producto.
     */
    public List<DetalleCompraTalla> getTallasCompradas() {return tallasCompradas;}
    /**
     * Establece el ID de la compra.
     * @param id Nuevo ID de la compra.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Establece la fecha y hora de la compra.
     * @param fechaHora Nueva fecha y hora de la compra.
     */
    public void setFechaHora(LocalDateTime fechaHora) {this.fechaHora = fechaHora;}
    /**
     * Establece el precio de compra unitario de la compra.
     * @param precioCompraUnitario Nuevo precio de compra unitario de la compra.
     */
    public void setPrecioCompraUnitario(Double precioCompraUnitario) {this.precioCompraUnitario = precioCompraUnitario;}
    /**
     * Establece el gasto total de la compra.
     * @param totalCompra Nuevo gasto total de la compra.
     */
    public void setTotalCompra(Double totalCompra) {this.totalCompra = totalCompra;}
    /**
     * Establece el producto asociado a la compra.
     * @param productoComprado Nuevo detalle del producto asociado a la compra.
     */
    public void setProductoComprado(Producto productoComprado) {this.productoComprado = productoComprado;}
    /**
     * Establece la lista de tallas compradas a la compra.
     * Si alguna talla comprada no tiene asociada esta 
     * compra, la añade, para mantener ambas entidades 
     * sincronizadas.
     * @param tallasCompradas Lista de tallas compradas.
     */
    public void setTallasCompradas(List<DetalleCompraTalla> tallasCompradas) {
        this.tallasCompradas = tallasCompradas;
        for(DetalleCompraTalla tallaComprada : tallasCompradas){
            if(!tallaComprada.verificarCompra())
                tallaComprada.setCompra(this);
        }
    }
    /**
     * Verifica si la compra tiene un
     * producto asociado.
     * @return VERDADERO si la compra tiene un producto asociado, FALSO en caso contrario.
     */
    public boolean verificarDetalleCompraProducto(){return productoComprado != null;}
    /**
     * Verifica si la lista de tallas compradas contiene la talla recibida.
     * @param tallaComprada Talla a verificar.
     * @return VERDADERO si la lista de tallas compradas contiene la talla recibida, FALSO en caso contrario.
     */
    public boolean verificarDetalleCompraTalla(DetalleCompraTalla tallaComprada){
        for(DetalleCompraTalla talla : tallasCompradas){
            if(talla.getTalla().getTalla().equals(tallaComprada.getTalla().getTalla()))
                return true;
        }
        return false;
    }
    /**
     * Agrega una talla comprada a la lista de tallas compradas.
     * Si el detalle de la compra de la talla no tiene
     * asociada esta compra, la asocia, para mantener
     * ambas entidades sincronizadas.
     * @param tallaComprada Talla a agregar.
     */
    public void agregarTallaComprada(DetalleCompraTalla tallaComprada){
        tallasCompradas.add(tallaComprada);
        if(!tallaComprada.verificarCompra())
            tallaComprada.setCompra(this);
    }
    /**
     * Regresa una cadena con la información de la compra.
     * @return Cadena con la información de la compra.
     */
    @Override
    public String toString() {
        return String.format(
                "%s, %s, %s", 
                productoComprado.getNombre(), fechaHora.toString(), totalCompra.toString()
        );
    }
}