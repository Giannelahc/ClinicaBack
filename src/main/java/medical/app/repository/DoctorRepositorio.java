package medical.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medical.app.models.Doctor;

@Repository
public interface DoctorRepositorio extends JpaRepository<Doctor, Long>{

}
