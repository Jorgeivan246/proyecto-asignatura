package co.edu.uniquindio.proyecto.entidades;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;


    @Column(length = 100,nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer anioNacimiento;

    public Autor(){
        super();
    }

    public Autor(@NonNull String nombre, Integer anioNacimiento) {
        this.nombre = nombre;

        this.anioNacimiento = anioNacimiento;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(codigo, autor.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
