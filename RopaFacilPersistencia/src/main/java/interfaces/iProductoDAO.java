package interfaces;

import exception.PersistenciaException;

/**
 *
 * @author PC WHITE WOLF
 */
public interface iProductoDAO {
    
    public boolean verificarExistenciaProducto(String nombre, String color) throws PersistenciaException;
    
}