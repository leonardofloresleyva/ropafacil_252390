package interfaces;

import entidades.Talla;
import exception.PersistenciaException;

/**
 *
 * @author PC WHITE WOLF
 */
public interface iTallaDAO {
    
    public Talla registrarTalla(Talla talla) throws PersistenciaException;
    
    public boolean buscarTalla(Talla talla) throws PersistenciaException;
    
}