package mappers;

import dtos.CajaAlmacenamientoDTO;
import entidades.CajaAlmacenamiento;

/**
 *
 * @author PC WHITE WOLF
 */
public class CajaAlmacenamientoMapper {
    
    public static CajaAlmacenamiento toEntityNuevo(CajaAlmacenamientoDTO cajaAlmacenamientoDTO){
        CajaAlmacenamiento cajaAlmacenamiento = new CajaAlmacenamiento();
        cajaAlmacenamiento.setCaja(cajaAlmacenamientoDTO.getCaja());
        
        return cajaAlmacenamiento;
    }
    
    public static CajaAlmacenamiento toEntityViejo(CajaAlmacenamientoDTO cajaAlmacenamientoDTO){
        CajaAlmacenamiento cajaAlmacenamiento = new CajaAlmacenamiento();
        cajaAlmacenamiento.setId(cajaAlmacenamientoDTO.getId());
        cajaAlmacenamiento.setCaja(cajaAlmacenamientoDTO.getCaja());
        
        return cajaAlmacenamiento;
    }
    
    public static CajaAlmacenamientoDTO toDTONuevo(CajaAlmacenamiento cajaAlmacenamiento){
        CajaAlmacenamientoDTO cajaAlmacenamientoDTO = new CajaAlmacenamientoDTO();
        cajaAlmacenamientoDTO.setCaja(cajaAlmacenamiento.getCaja());
        
        return cajaAlmacenamientoDTO;
    }
    
    public static CajaAlmacenamientoDTO toDTOViejo(CajaAlmacenamiento cajaAlmacenamiento){
        CajaAlmacenamientoDTO cajaAlmacenamientoDTO = new CajaAlmacenamientoDTO();
        cajaAlmacenamientoDTO.setId(cajaAlmacenamiento.getId());
        cajaAlmacenamientoDTO.setCaja(cajaAlmacenamiento.getCaja());
        
        return cajaAlmacenamientoDTO;
    }
}