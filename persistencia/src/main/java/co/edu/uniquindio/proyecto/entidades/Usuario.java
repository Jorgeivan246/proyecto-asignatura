package co.edu.uniquindio.proyecto.entidades;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString(callSuper = true)
public class Usuario extends Persona implements Serializable {



    @Column(nullable = false,unique = true,length = 120)
    private String email;

    @ElementCollection
    @Column(nullable = false)
    private Map<String,String> numTelefonos;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudad;

    @OneToMany(mappedBy = "usuarioPrestamo")
    private List<Prestamo> prestamos;

    public Usuario(String email, Map<String, String> numTelefonos) {
        this.email = email;
        this.numTelefonos = numTelefonos;
    }

    public Usuario(String código, String nombre, LocalDate fechaNacimiento, GeneroPersona generoPersona, String email, Map<String, String> numTelefonos,Ciudad ciudad) {
        super(código, nombre, fechaNacimiento, generoPersona);
        this.email = email;
        this.numTelefonos = numTelefonos;
        this.ciudad=ciudad;
    }
}
