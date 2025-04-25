package mappers;

import dtos.TipoPrendaDTO;
import entidades.TipoPrenda;

/**
 *
 * @author PC WHITE WOLF
 */
public class TipoPrendaMapper {
    
    public static TipoPrenda toEntityNuevo(TipoPrendaDTO tipoPrendaDTO){
        TipoPrenda tipoPrenda = new TipoPrenda();
        tipoPrenda.setTipo(tipoPrendaDTO.getTipo());
        
        return tipoPrenda;
    }
    
    public static TipoPrenda toEntityViejo(TipoPrendaDTO tipoPrendaDTO){
        TipoPrenda tipoPrenda = new TipoPrenda();
        tipoPrenda.setId(tipoPrendaDTO.getId());
        tipoPrenda.setTipo(tipoPrendaDTO.getTipo());
        
        return tipoPrenda;
    }
    
    public static TipoPrendaDTO toDTONuevo(TipoPrenda tipoPrenda){
        TipoPrendaDTO tipoPrendaDTO = new TipoPrendaDTO();
        tipoPrendaDTO.setTipo(tipoPrenda.getTipo());
        
        return tipoPrendaDTO;
    }
    
    public static TipoPrendaDTO toDTOViejo(TipoPrenda tipoPrenda){
        TipoPrendaDTO tipoPrendaDTO = new TipoPrendaDTO();
        tipoPrendaDTO.setId(tipoPrenda.getId());
        tipoPrendaDTO.setTipo(tipoPrenda.getTipo());
        
        return tipoPrendaDTO;
    }
}