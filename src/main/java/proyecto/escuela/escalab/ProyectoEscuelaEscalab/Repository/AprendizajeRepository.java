package proyecto.escuela.escalab.ProyectoEscuelaEscalab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Aprendizaje;

@Repository
public interface AprendizajeRepository extends JpaRepository<Aprendizaje, Integer> {
}
