package medical.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.app.models.Direccion;

@Repository
public interface DireccionRepositorio extends JpaRepository<Direccion, Long>{

}
