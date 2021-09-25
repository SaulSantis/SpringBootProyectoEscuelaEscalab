package proyecto.escuela.escalab.ProyectoEscuelaEscalab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Role;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Usuario;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.UsuarioService;

import java.util.ArrayList;

@SpringBootApplication
public class ProyectoEscuelaEscalabApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoEscuelaEscalabApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UsuarioService usuarioService) {
        return args -> {

            usuarioService.saveRole(new Role(null, "ROLE_USER"));
            usuarioService.saveRole(new Role(null, "ROLE_ADMIN"));


            usuarioService.saveUser(new Usuario(null, "FRANCISCO", "123456", new ArrayList<>()));
            usuarioService.saveUser(new Usuario(null, "SAUL", "123456", new ArrayList<>()));


            usuarioService.addRolToUser("FRANCISCO", "ROLE_USER");
            usuarioService.addRolToUser("SAUL", "ROLE_ADMIN");

        };
    }

}
