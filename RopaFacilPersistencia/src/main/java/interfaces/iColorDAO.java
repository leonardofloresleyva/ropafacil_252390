package interfaces;

import entidades.Color;
import exception.PersistenciaException;

/**
 *
 * @author PC WHITE WOLF
 */
public interface iColorDAO {
    
    public Color registrarColor(Color color) throws PersistenciaException;
    
    public Color verificarExistencia(String color) throws PersistenciaException;
    
    
}