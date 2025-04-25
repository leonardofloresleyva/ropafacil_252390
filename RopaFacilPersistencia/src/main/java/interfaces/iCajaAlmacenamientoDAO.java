package interfaces;

import entidades.CajaAlmacenamiento;

import exception.PersistenciaException;

/**
 *
 * @author PC WHITE WOLF
 */
public interface iCajaAlmacenamientoDAO {
    
    public CajaAlmacenamiento registrarCaja(CajaAlmacenamiento caja) throws PersistenciaException;
    
    public CajaAlmacenamiento verificarExistencia(Integer caja) throws PersistenciaException;
    
}