package medical.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.app.models.Administrador;

@Repository
public interface AdministradorRepositorio extends JpaRepository<Administrador, Long>{

}
