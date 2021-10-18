package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepo extends JpaRepository<Ciudad,Integer> {

}
