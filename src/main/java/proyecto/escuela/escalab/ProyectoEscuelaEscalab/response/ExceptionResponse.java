package proyecto.escuela.escalab.ProyectoEscuelaEscalab.response;

import java.time.LocalDateTime;

public class ExceptionResponse {

    private LocalDateTime timesTamp;
    private String mensaje;
    private String detalles;

    public ExceptionResponse(LocalDateTime timesTamp, String mensaje, String detalles) {
        this.timesTamp = timesTamp;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

    public LocalDateTime getTimesTamp() {
        return timesTamp;
    }

    public void setTimesTamp(LocalDateTime timesTamp) {
        this.timesTamp = timesTamp;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
}
