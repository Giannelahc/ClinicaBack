package medical.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.app.models.RegistroMedico;

@Repository
public interface RegistroMedicoRepositorio extends JpaRepository<RegistroMedico, Long>{

}
