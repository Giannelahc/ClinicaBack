package medical.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.app.models.Persona;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Long>{

}
