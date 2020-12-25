package medical.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.app.models.Horario;

@Repository
public interface HorarioRepositorio extends JpaRepository<Horario, Long>{

}
