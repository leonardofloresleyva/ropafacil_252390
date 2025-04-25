package interfaces;

import dtos.TallaDTO;
import exception.NegocioException;

/**
 *
 * @author PC WHITE WOLF
 */
public interface iTallaBO {
    public boolean registrarTalla(TallaDTO tallaDTO) throws NegocioException;
}