package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.annotation.Inherited;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Persona implements Serializable {

    @Id
    @Column(length = 10)
    @EqualsAndHashCode.Include
    private String código;

    @Column(nullable = false,length = 100)
    private String nombre;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GeneroPersona generoPersona;

    private int estatura;


}
