package medical.app.service;

import java.util.List;

import medical.app.models.Doctor;

public interface DoctorService extends ICrud<Doctor>{

	Doctor obtenerPorPersona(Long id);
	List<Doctor> obtenerPorEstado(String estado);
}
