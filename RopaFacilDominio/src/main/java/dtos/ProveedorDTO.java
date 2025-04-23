package dtos;

/**
 * Entidad ProveedorDTO. Se puede relacionar con ProductoDTO.
 * Tipo de Dato de Transferencia.
 * @author Leonardo Flores Leyva - 252390
 */
public class ProveedorDTO {
    /**
     * ID del proveedor.
     */
    private Long id;
    /**
     * Nombre del proveedor.
     */
    private String proveedor;
    /**
     * Constructor por defecto del proveedor.
     */
    public ProveedorDTO() {}
    /**
     * Contructor sin ID que recibe el nombre del proveedor.
     * @param proveedor Nombre del proveedor.
     */
    public ProveedorDTO(String proveedor) {this.proveedor = proveedor;}
    /**
     * Contructor que recibe el ID y el nombre del proveedor.
     * @param id ID del proveedor.
     * @param proveedor Nombre del proveedor.
     */
    public ProveedorDTO(Long id, String proveedor) {
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
     * @param id Nuevo ID del proveedor.
     */
    public void setId(Long id) {this.id = id;}
    /**
     * Establece el nombre del proveedor.
     * @param proveedor Nuevo nombre del proveedor.
     */
    public void setProveedor(String proveedor) {this.proveedor = proveedor;}
    /**
     * Regresa una cadena con el nombre del proveedor.
     * @return Cadena con el nombre del proveedor.
     */
    @Override
    public String toString() {return proveedor;}    
}