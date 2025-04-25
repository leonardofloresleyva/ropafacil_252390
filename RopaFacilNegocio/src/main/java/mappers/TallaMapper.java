package mappers;

import dtos.TallaDTO;
import entidades.Talla;

/**
 *
 * @author PC WHITE WOLF
 */
public class TallaMapper {
    
    public static Talla toEntityNuevo(TallaDTO tallaDTO){
        Talla talla = new Talla();
        talla.setTalla(tallaDTO.getTalla());
        
        return talla;
    }
    
    public static Talla toEntityViejo(TallaDTO tallaDTO){
        Talla talla = new Talla();
        talla.setId(tallaDTO.getId());
        talla.setTalla(tallaDTO.getTalla());
        
        return talla;
    }
    
    public static TallaDTO toDTONuevo(Talla talla){
        TallaDTO tallaDTO = new TallaDTO();
        tallaDTO.setId(talla.getId());
        tallaDTO.setTalla(talla.getTalla());
        
        return tallaDTO;
    }
    
    public static TallaDTO toDTOViejo(Talla talla){
        TallaDTO tallaDTO = new TallaDTO();
        tallaDTO.setId(talla.getId());
        tallaDTO.setTalla(talla.getTalla());
        
        return tallaDTO;
    }
}