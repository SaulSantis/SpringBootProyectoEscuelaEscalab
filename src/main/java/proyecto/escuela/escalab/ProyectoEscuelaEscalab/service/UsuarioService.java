package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service;

import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Role;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario saveUser(Usuario usuario);

    Role saveRole(Role role);

    void addRolToUser(String userName, String nombreRol);

    Usuario getUser(String userName);

    List<Usuario> getUsers();

}

