package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad Proveedor. Se puede relacionar con Producto.
 * @author Leonardo Flores Leyva - 252390
 */
@Entity
@Table(name = "PROVEEDORES")
public class Proveedor implements Serializable {
    /**
     * ID del proveedor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Nombre del proveedor.
     */
    @Column(name = "PROVEEDOR", nullable = false, unique = true, length = 100)
    private String proveedor;
    /**
     * Constructor por defecto del proveedor.
     */
    public Proveedor() {}
    /**
     * Contructor que recibe el nombre del proveedor.
     * @param proveedor Nombre del proveedor.
     */
    public Proveedor(String proveedor) {this.proveedor = proveedor;}
    /**
     * Contructor que recibe el ID y el nombre del proveedor.
     * @param id ID del proveedor.
     * @param proveedor Nombre del proveedor.
     */
    public Proveedor(Long id, String proveedor) {
        this.id = id;
        this.proveedor = proveedor;
    }
    /**
     * Retorna el ID del proveedor.
     * @return ID del proveedor.
     */
    public Long getId() {return id;}
    /**
     * Retorna el nombre del proveedor.
     * @return Nombre del proveedor.
     */
    public String getProveedor() {return proveedor;}
    /**
     * Establece el ID del proveedor.
     * @param id ID del proveedor.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Establece el nombre del proveedor.
     * @param proveedor Nombre del proveedor.
     */
    public void setProveedor(String proveedor) {this.proveedor = proveedor;}
    /**
     * Regresa una cadena con el nombre del proveedor.
     * @return Cadena con el nombre del proveedor.
     */
    @Override
    public String toString() {return proveedor;}    
}