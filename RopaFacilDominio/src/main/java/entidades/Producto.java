package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Leonardo Flores Leyva - 252390
 */
@Entity
public class Producto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "NOMBRE", nullable = false, unique = false, length = 100)
    private String nombre;
    
    
    
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    @Override
    public String toString() {
        return "entidades.Producto[ id=" + id + " ]";
    }
    
}