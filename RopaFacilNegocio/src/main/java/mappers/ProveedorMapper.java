package mappers;

import dtos.ProveedorDTO;
import entidades.Proveedor;

/**
 *
 * @author PC WHITE WOLF
 */
public class ProveedorMapper {
    
    public static Proveedor toEntityNuevo(ProveedorDTO proveedorDTO){
        Proveedor proveedor = new Proveedor();
        proveedor.setProveedor(proveedorDTO.getProveedor());
        
        return proveedor;
    }
    
    public static Proveedor toEntityViejo(ProveedorDTO proveedorDTO){
        Proveedor proveedor = new Proveedor();
        proveedor.setId(proveedorDTO.getId());
        proveedor.setProveedor(proveedorDTO.getProveedor());
        
        return proveedor;
    }
    
    public static ProveedorDTO toDTONuevo(Proveedor proveedor){
        ProveedorDTO proveedorDTO = new ProveedorDTO();
        proveedorDTO.setProveedor(proveedor.getProveedor());
        
        return proveedorDTO;
    }
    
    public static ProveedorDTO toDTOViejo(Proveedor proveedor){
        ProveedorDTO proveedorDTO = new ProveedorDTO();
        proveedorDTO.setId(proveedor.getId());
        proveedorDTO.setProveedor(proveedor.getProveedor());
        
        return proveedorDTO;
    }
}