package interfaces;

import entidades.Proveedor;
import exception.PersistenciaException;

/**
 *
 * @author PC WHITE WOLF
 */
public interface iProveedorDAO {
    
    public Proveedor registrarProveedor(Proveedor proveedor) throws PersistenciaException;
    
    public Proveedor verificarExistencia(String proveedor) throws PersistenciaException;
    
}