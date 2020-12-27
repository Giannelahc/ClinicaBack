package medical.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.app.models.HistorialPaciente;
import medical.app.models.Persona;

@Repository
public interface HistorialPacienteRepositorio extends JpaRepository<HistorialPaciente, Long>{

	HistorialPaciente findByPersona(Persona persona);
}
