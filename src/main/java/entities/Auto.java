package entities;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Creado por @author: YainyBi
 * el 24/10/20
 **/

@Entity
@Table (name = "Auto")
public class Auto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "Precio")
    private Integer precioFinal;

    @OneToOne
    @JoinColumn(name = "IdVariante", referencedColumnName = "Id")
    private Variante variante;

    private List<Opcion> opcionales;

    @Column(name = "NroOpcionales")
    private Integer nroOpciones;


    public Auto() {
        this.opcionales = new ArrayList<>();
        this.precioFinal = 0;
    }

    public Integer getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Integer precioFinal) {

        this.precioFinal = precioFinal;
    }

    public Variante getVariante() {

        return variante;
    }

    public void setVariante(Variante variante) {
        this.variante = variante;
    }

    public Integer getId() {
        return id;
    }

    public Auto setId(Integer id) {
        this.id = id;
        return this;
    }

    public List<Opcion> getOpcionales() {
        return opcionales;
    }

    public void setOpcionales(List<Opcion> opcionales) {
        this.opcionales = opcionales;
    }

    public Integer getNroOpciones() {
        return nroOpciones;
    }

    public void setNroOpciones(Integer nroOpciones) {
        this.nroOpciones = nroOpciones;
    }


}
