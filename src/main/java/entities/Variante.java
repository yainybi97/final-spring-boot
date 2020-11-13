package entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Creado por @author: YainyBi
 * el 24/10/20
 **/

@Entity
@Table(name = "Variante")
public class Variante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Precio")
    private Integer precio;


    @OneToOne(mappedBy = "variante")
    Auto auto;

    public Variante(){
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

}
