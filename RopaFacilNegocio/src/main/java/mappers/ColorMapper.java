package mappers;

import dtos.ColorDTO;
import entidades.Color;

/**
 *
 * @author PC WHITE WOLF
 */
public class ColorMapper {
    public static Color toEntityNuevo(ColorDTO colorDTO){
        Color color = new Color();
        color.setColor(colorDTO.getColor());
        
        return color;
    }
    
    public static Color toEntityViejo(ColorDTO colorDTO){
        Color color = new Color();
        color.setId(colorDTO.getId());
        color.setColor(colorDTO.getColor());
        
        return color;
    }
    
    public static ColorDTO toDTONuevo(Color color){
        ColorDTO colorDTO = new ColorDTO();
        colorDTO.setColor(color.getColor());
        
        return colorDTO;
    }
    
    public static ColorDTO toDTOViejo(Color color){
        ColorDTO colorDTO = new ColorDTO();
        colorDTO.setId(color.getId());
        colorDTO.setColor(color.getColor());
        
        return colorDTO;
    }
}