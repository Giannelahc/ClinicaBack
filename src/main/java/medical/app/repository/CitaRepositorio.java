package medical.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.app.models.Cita;
import medical.app.models.Doctor;
import medical.app.models.HistorialPaciente;

@Repository
public interface CitaRepositorio extends JpaRepository<Cita, Long>{

	List<Cita> findByHistorialPaciente(HistorialPaciente historialPaciente);
	List<Cita> findByDoctor(Doctor doctor);
	List<Cita> findByEstado(String estado);
	List<Cita> findByFechaRegistro(Date fechaRegistro);
}
