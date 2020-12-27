package medical.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.app.models.Doctor;
import medical.app.models.Especialidad;
import medical.app.models.Horario;

@Repository
public interface HorarioRepositorio extends JpaRepository<Horario, Long>{

	List<Horario> findByEspecialidad(Especialidad especialidad);
	List<Horario> findByDoctor(Doctor doctor);
	List<Horario> findByEspecialidadAndEstado(Especialidad especialidad, String estado);
}
