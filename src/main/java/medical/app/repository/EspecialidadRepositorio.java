package medical.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.app.models.Especialidad;

@Repository
public interface EspecialidadRepositorio extends JpaRepository<Especialidad, Long>{

}
