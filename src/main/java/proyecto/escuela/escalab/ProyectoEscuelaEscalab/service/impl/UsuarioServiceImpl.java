package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Role;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Usuario;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository.RolRepository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository.UsuarioRepository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.UsuarioService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
//public class UsuarioServiceImpl  implements UserDetailsService, UsuarioService {
    public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private  final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findOneByUserName(userName);
        if (usuario == null) {
            log.error("El usuario no se encuentra en la base de datos");
            throw new UsernameNotFoundException("El usuario no se encuentra en la base de datos");
        } else {
            log.info("Usuario encontrado en la base de datos: {}", userName);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        usuario.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getNombreRol()));
        });
        return new org.springframework.security.core.userdetails.User(usuario.getUserName(), usuario.getPassword(), authorities);
    }

    @Override
    public Usuario saveUser(Usuario usuario) {
        log.info("Guardando un nuevo Usuario {} en la base de datos", usuario.getUserName());
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Guardando un nuevo Rol {} en la base de datos", role.getNombreRol());
        return rolRepository.save(role);
    }

    @Override
    public void addRolToUser(String userName, String nombreRol) {
        log.info("Agregando un Rol {} al Usuario {}", nombreRol, userName);
        Usuario usuario = usuarioRepository.findByUserName(userName);
        Role role = rolRepository.findByNombreRol(nombreRol);
        usuario.getRoles().add(role);
    }

    @Override
    public Usuario getUser(String userName) {
        log.info("Buscar al Usuario {} ", userName);
        return usuarioRepository.findByUserName(userName);
    }

    @Override
    public List<Usuario> getUsers() {
        log.info("Buscar rodos los Usuarios");
        return usuarioRepository.findAll();
    }


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Usuario usuario = usuarioRepository.findOneByUserName(username);
//        if(usuario == null) {
//            throw new UsernameNotFoundException(String.format("Usuario no existe", username));
//        }
//        List<GrantedAuthority> roles = new ArrayList<>();
//        usuario.getRoles().forEach(rol -> {
//            roles.add(new SimpleGrantedAuthority(rol.getNombreRol()));
//        });
//        UserDetails ud = new User(usuario.getUserName(), usuario.getPassword(), roles);
//        return ud;
//    }


//    @Override
//    public Usuario save(Usuario obj) {
//        return usuarioRepository.save(obj);
//    }
//
//    @Override
//    public Usuario update(Usuario obj) {
//        return usuarioRepository.save(obj);
//    }
//
//    @Override
//    public List<Usuario> findAll() {
//        return usuarioRepository.findAll();
//    }
//
//    @Override
//    public Usuario findById(Integer id) {
//        Optional<Usuario> op = usuarioRepository.findById(id);
//        return op.isPresent() ? op.get() : new Usuario();
//    }
//
//    @Override
//    public boolean deleteById(Integer id) {
//        usuarioRepository.deleteById(id);
//        return true;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Usuario usuario = usuarioRepository.findOneByNombreUsuario(username);
//        if(usuario == null) {
//            throw new UsernameNotFoundException(String.format("Usuario no existe", username));
//        }
//        List<GrantedAuthority> roles = new ArrayList<>();
//        usuario.getRoles().forEach(rol -> {
//            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
//        });
//        UserDetails ud = new User(usuario.getNombreUsuario(), usuario.getPassword(), roles);
//        return ud;
//    }

}
