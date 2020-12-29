package medical.app.service;

import medical.app.models.HistorialPaciente;

public interface HistorialPacienteService extends ICrud<HistorialPaciente>{

	HistorialPaciente obtenerPorPersona(Long id);
	boolean existePorId(Long id);
}
