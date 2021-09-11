package proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Apoderado;

@Repository
public interface ApoderadoRepository extends JpaRepository<Apoderado, Integer> {

    Apoderado findApoderadoByDniAndNombres(String dni, String nombres);

    Apoderado findApoderadoByNombres(String nombres);

    Apoderado findApoderadoByDni(String dni);


}
