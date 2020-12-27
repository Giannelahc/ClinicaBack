package medical.app.service;

import java.util.Date;
import java.util.List;

import medical.app.models.Cita;

public interface CitaService extends ICrud<Cita>{

	List<Cita> listarCitaPorPaciente(Long id);
	List<Cita> listarCitaPorDoctor(Long id);
	List<Cita> listarCitaPorEstado(String estado);
	List<Cita> listarCitaPorFechaRegistro(Date fechaRegistro);
}
