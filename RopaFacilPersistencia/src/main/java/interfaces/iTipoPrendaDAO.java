package interfaces;

import entidades.TipoPrenda;
import exception.PersistenciaException;

/**
 *
 * @author PC WHITE WOLF
 */
public interface iTipoPrendaDAO {
    
    public TipoPrenda registrarTipo(TipoPrenda tipoPrenda) throws PersistenciaException;
    
    public TipoPrenda verificarExistencia(String tipoPrenda) throws PersistenciaException;
    
}