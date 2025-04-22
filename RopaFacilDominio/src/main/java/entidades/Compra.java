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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entidad Compra. Se relaciona con DetalleCompraProducto y DetalleCompraTalla.
 * @author Leonardo Flores Leyva - 252390
 */
@Entity
@Table(name = "COMPRAS")
@Inheritance(strategy = InheritanceType.JOINED) // Estrategia elegida para separar atributos únicos de clases hijas
@DiscriminatorColumn(name = "TIPO_COMPRA", discriminatorType = DiscriminatorType.STRING) // Discriminador STRING para especificar bien cada tipo de compra.
public class Compra implements Serializable {
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
     * Total gastado de la compra.
     */
    @Column(name = "TOTAL_COMPRA", nullable = false, unique = false)
    private Double totalCompra;
    /**
     * Detalle del producto asociado a la compra.
     */
    @OneToMany(mappedBy = "compra", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.EAGER)
    private DetalleCompraProducto productoComprado;
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
 * @param totalCompra Total gastado de la compra.
 * @param productoComprado Detalle del producto asociado a la compra.
 * @param tallasCompradas Lista de tallas compradas asociadas al producto.
 */
    public Compra(LocalDateTime fechaHora, Double totalCompra, DetalleCompraProducto productoComprado, List<DetalleCompraTalla> tallasCompradas) {
        this.fechaHora = fechaHora;
        this.totalCompra = totalCompra;
        this.productoComprado = productoComprado;
        // Mantiene sincronizada la relación bidireccional, entre la compra y su DetalleCompraProducto.
        if(!productoComprado.verificarCompra())
            productoComprado.setCompra(this);
        this.tallasCompradas = tallasCompradas;
        // Mantiene sincronizada la relación bidireccional, entre la compra y su lista de DetalleCompraTalla.
        for(DetalleCompraTalla tallaComprada : tallasCompradas){
            if(!tallaComprada.verificarCompra())
                tallaComprada.setCompra(this);
        }
    }
    /**
     * Constructor con ID incluido de la compra.
     * @param id ID de la compra.
     * @param fechaHora Fecha y hora de la compra.
     * @param totalCompra Total gastado de la compra.
     * @param productoComprado Detalle del producto asociado a la compra.
     * @param tallasCompradas Lista de tallas compradas asociadas al producto.
     */
    public Compra(Long id, LocalDateTime fechaHora, Double totalCompra, DetalleCompraProducto productoComprado, List<DetalleCompraTalla> tallasCompradas) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.totalCompra = totalCompra;
        this.productoComprado = productoComprado;
        // Mantiene sincronizada la relación bidireccional, entre la compra y su DetalleCompraProducto.
        if(!productoComprado.verificarCompra())
            productoComprado.setCompra(this);
        this.tallasCompradas = tallasCompradas;
        // Mantiene sincronizada la relación bidireccional, entre la compra y su lista de DetalleCompraTalla.
        for(DetalleCompraTalla tallaComprada : tallasCompradas){
            if(!tallaComprada.verificarCompra())
                tallaComprada.setCompra(this);
        }
    }
    /**
     * Ontiene el ID de la compra.
     * @return ID de la compra.
     */
    public Long getId() {return id;}
    /**
     * Obtiene la fecha y hora de la compra.
     * @return Fecha y hora de la compra.
     */
    public LocalDateTime getFechaHora() {return fechaHora;}
    /**
     * Obtiene el gasto total de la compra.
     * @return Gasto total de la compra.
     */
    public Double getTotalCompra() {return totalCompra;}
    /**
     * Obtiene el detalle del producto asociado a la compra.
     * @return Detalle del producto asociado a la compra.
     */
    public DetalleCompraProducto getProductoComprado() {return productoComprado;}
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
     * Establece el gasto total de la compra.
     * @param totalCompra Nuevo gasto total de la compra.
     */
    public void setTotalCompra(Double totalCompra) {this.totalCompra = totalCompra;}
    /**
     * Establece el detalle del producto asociado a la compra.
     * Si el detalle del producto asociado a la compra no 
     * tiene esta compra, lo añade, para mantener ambas
     * entidades sincronizadas.
     * @param productoComprado Nuevo detalle del producto asociado a la compra.
     */
    public void setProductoComprado(DetalleCompraProducto productoComprado) {
        this.productoComprado = productoComprado;
        if(!productoComprado.verificarCompra())
            productoComprado.setCompra(this);
    }
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
            if(talla.getTalla().equals(tallaComprada.getTalla()))
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
     * Regresa una cadena con la compra.
     * @return Cadena con la compra.
     */
    @Override
    public String toString() {return totalCompra.toString();}
}