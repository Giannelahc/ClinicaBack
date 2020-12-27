package medical.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.app.models.Doctor;
import medical.app.models.Persona;

@Repository
public interface DoctorRepositorio extends JpaRepository<Doctor, Long>{

	Doctor findByPersona(Persona persona);
	List<Doctor> findByEstado(String estado);
}
