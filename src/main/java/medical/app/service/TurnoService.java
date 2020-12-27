package medical.app.service;

import java.util.List;

import medical.app.models.Turno;

public interface TurnoService {

	Turno modificar(Turno turno);
	List<Turno> listarPorHorarioYEstado(Long id, String estado);
}
