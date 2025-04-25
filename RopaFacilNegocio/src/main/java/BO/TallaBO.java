package BO;

import DAO.TallaDAO;
import dtos.TallaDTO;
import entidades.Talla;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.iTallaBO;
import mappers.TallaMapper;

/**
 *
 * @author PC WHITE WOLF
 */
public class TallaBO implements iTallaBO {
    
    private static TallaBO instance;
    
    private TallaBO(){}
    
    public static TallaBO getInstance(){
        if(instance == null)
            instance = new TallaBO();
        return instance;
    }
    
    @Override
    public boolean registrarTalla(TallaDTO tallaDTO) throws NegocioException {
        try {
            Talla talla = TallaMapper.toEntityNuevo(tallaDTO);
            if(TallaDAO.getInstance().buscarTalla(talla) != null)
                return false;
            else{
                Talla tallaRegistrada = TallaDAO.getInstance().registrarTalla(talla);
                return tallaRegistrada.getId() != null;
            }
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage(), ex);
        }
        
    }
    
}