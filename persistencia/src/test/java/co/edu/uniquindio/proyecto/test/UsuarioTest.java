package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.GeneroPersona;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {


    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private CiudadRepo ciudadRepo;

    @Test
    public void  registrarTest()
    {
        Ciudad ciudad = new Ciudad("Armenia");

        ciudadRepo.save(ciudad);

        Map<String,String> telefonos = new HashMap<>();
        telefonos.put("casa","1717171");
        telefonos.put("celular","9828298");


        Usuario usuario = new Usuario("123","pepito",LocalDate.now(),GeneroPersona.MASCULINO,"pepito@email.com",telefonos,ciudad);



        Usuario usuarioGuardado = usuarioRepo.save(usuario);

        Assertions.assertNotNull(usuarioGuardado);



    }


    @Test
    public void elimiarTest()
    {

        Ciudad ciudad = new Ciudad("Armenia");

        ciudadRepo.save(ciudad);


        Map<String,String> telefonos = new HashMap<>();
        telefonos.put("casa","1717171");
        telefonos.put("celular","9828298");

        Usuario usuario = new Usuario("123","pepito",LocalDate.now(),GeneroPersona.MASCULINO,"pepito@email.com",telefonos,ciudad);

        usuario.setNumTelefonos(telefonos);

        usuarioRepo.save(usuario);

        usuarioRepo.deleteById("123");

        Usuario usuarioBuscado = usuarioRepo.findById("123").orElse(null);


        Assertions.assertNull(usuarioBuscado);
    }


    @Test
    public void actualizarTest()
    {
        Ciudad ciudad = new Ciudad("Armenia");

        ciudadRepo.save(ciudad);



        Map<String,String> telefonos = new HashMap<>();
        telefonos.put("casa","1717171");
        telefonos.put("celular","9828298");


        Usuario usuario = new Usuario("123","pepito",LocalDate.now(),GeneroPersona.MASCULINO,"pepito@email.com",telefonos,ciudad);
        usuario.setNumTelefonos(telefonos);

       Usuario guardado =  usuarioRepo.save(usuario);


       guardado.setEmail("pepe1@email.com");

       usuarioRepo.save(guardado);


       Usuario usuarioBuscado = usuarioRepo.findById("123").orElse(null);

       Assertions.assertEquals("pepe1@email.com",usuarioBuscado.getEmail());


    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarTest()
    {


        List<Usuario> usuarios=usuarioRepo.findAll();

        usuarios.forEach( u -> System.out.println(u));
    }
}
