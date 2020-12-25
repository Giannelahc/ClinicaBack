package medical.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.app.models.Cita;

@Repository
public interface CitaRepositorio extends JpaRepository<Cita, Long>{

}
