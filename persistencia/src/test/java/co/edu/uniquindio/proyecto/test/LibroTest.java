package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.repositorios.LibroRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LibroTest {


    @Autowired
    private LibroRepo libroRepo;

    @Test
    @Sql("classpath:usuarios.sql")
    public void elimiarTestLibro()
    {

        libroRepo.deleteById("123");

    }



}
