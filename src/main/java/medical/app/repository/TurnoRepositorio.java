package medical.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.app.models.Horario;
import medical.app.models.Turno;

@Repository
public interface TurnoRepositorio extends JpaRepository<Turno, Long>{

	List<Turno> findByHorarioAndEstado(Horario horario, String estado);
}
