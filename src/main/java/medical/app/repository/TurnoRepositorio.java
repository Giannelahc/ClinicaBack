package medical.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.app.models.Turno;

@Repository
public interface TurnoRepositorio extends JpaRepository<Turno, Long>{

}
