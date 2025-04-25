package mappers;

import dtos.CategoriaDTO;
import entidades.Categoria;

/**
 *
 * @author PC WHITE WOLF
 */
public class CategoriaMapper {
    public static Categoria toEntityNuevo(CategoriaDTO categoriaDTO){
        Categoria categoria = new Categoria();
        categoria.setCategoria(categoriaDTO.getCategoria());
        
        return categoria;
    }
    
    public static Categoria toEntityViejo(CategoriaDTO categoriaDTO){
        Categoria categoria = new Categoria();
        categoria.setId(categoriaDTO.getId());
        categoria.setCategoria(categoriaDTO.getCategoria());
        
        return categoria;        
    }
    
    public static CategoriaDTO toDTONuevo(Categoria categoria){
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setCategoria(categoria.getCategoria());
        
        return categoriaDTO;
    }
    
    public static CategoriaDTO toDTOViejo(Categoria categoria){
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setCategoria(categoria.getCategoria());
        
        return categoriaDTO;
    }
}