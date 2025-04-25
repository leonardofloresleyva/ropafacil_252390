package interfaces;

import entidades.Categoria;
import exception.PersistenciaException;

/**
 *
 * @author PC WHITE WOLF
 */
public interface iCategoriaDAO {
    
    public Categoria registrarCategoria(Categoria categoria) throws PersistenciaException;
    
    public Categoria verificarExistencia(String categoria) throws PersistenciaException;
    
}