package medical.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.app.models.Auditoria;

@Repository
public interface AuditoriaRepositorio extends JpaRepository<Auditoria, Long>{

}
