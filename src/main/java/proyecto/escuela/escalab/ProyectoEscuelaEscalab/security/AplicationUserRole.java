package proyecto.escuela.escalab.ProyectoEscuelaEscalab.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static proyecto.escuela.escalab.ProyectoEscuelaEscalab.security.AplicationUserPermission.*;

public enum AplicationUserRole {

    ROLE_ADMIN(Sets.newHashSet(
            ALUMNO_READ,
            ALUMNO_WRITE,
            APODERADO_READ,
            APODERADO_WRITE
    ));

    private final Set<AplicationUserPermission> permissions;


    AplicationUserRole(Set<AplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<AplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions()
                .stream()
                .map(permission ->
                        new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
