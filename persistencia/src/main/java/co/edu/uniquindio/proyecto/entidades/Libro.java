package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
public class Libro implements Serializable {
    @Id
    public String isbn;


    private String nombre;


    private Integer unidades;

    private Integer anio;


    @Enumerated(EnumType.STRING)
    private GeneroLibro generoLibro;

    public Libro()
    {

    }

    public Libro(String isbn, String nombre, Integer unidades, Integer anio) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.unidades = unidades;
        this.anio = anio;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }
}
