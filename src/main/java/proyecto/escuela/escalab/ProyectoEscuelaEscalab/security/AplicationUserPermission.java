package proyecto.escuela.escalab.ProyectoEscuelaEscalab.security;

public enum AplicationUserPermission {

    ALUMNO_READ("alumno:read"),
    ALUMNO_WRITE("alumno:write"),
    APODERADO_READ("apoderado:read"),
    APODERADO_WRITE("apoderado:write");

    private final String permission;

    AplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
